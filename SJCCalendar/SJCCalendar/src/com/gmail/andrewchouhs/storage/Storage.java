package com.gmail.andrewchouhs.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import com.gmail.andrewchouhs.model.LongTermSchedule;
import com.gmail.andrewchouhs.model.RoutineSchedule;
import com.gmail.andrewchouhs.model.SerializableSchedulePOJO;
import com.gmail.andrewchouhs.model.TrivialSchedule;
import com.gmail.andrewchouhs.model.UrgentSchedule;
import com.gmail.andrewchouhs.storage.Storage.Pref;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Storage
{
	private static ObservableList<AbstractScheduleModel> scheduleList = FXCollections.observableArrayList();
	private static final String rootPath = System.getenv("APPDATA") + "\\SJCCalendar\\"; 
	private static final String schedulePath = rootPath + "SJCCalendar";
	private static final EnumMap<Text , String> textMap = new EnumMap<Text , String>(Text.class);
	private static final LinkedHashMap<String , Locale> localeMap = new LinkedHashMap<String , Locale>();
	private static final String prefsPath = rootPath + "Preferences.properties";
	private static final Properties prefs = new Properties();
	private static final EnumMap<Pref , String> prefKeyMap = new EnumMap<Pref , String>(Pref.class);
	private static final IntegerProperty rowCountProperty = new SimpleIntegerProperty();
	private static final ObjectProperty<LocalDateTime> nowTimeProperty = new SimpleObjectProperty<LocalDateTime>();
	private static int adjustNowTime = 0;
	private static ResourceBundle bundle;

	static
	{
		adjustNowTime(0);
		prefKeyMap.put(Pref.Language , "Language");
		prefKeyMap.put(Pref.RowCount , "RowCount");
		
		localeMap.put("zh_TW" , Locale.TRADITIONAL_CHINESE);
		localeMap.put("en" , Locale.ENGLISH);
		localeMap.put("zh_CN", Locale.SIMPLIFIED_CHINESE);
		
		new File(rootPath).mkdirs();
		loadSchedules();
		loadPrefs();
		
		bundle = ResourceBundle.getBundle("com.gmail.andrewchouhs.i18n.text" , 
				localeMap.get(getPref(Pref.Language)));
		
		textMap.put(Text.MainGrid_ContextMenuItem_Edit, bundle.getString("MainGrid.ContextMenuItem.Edit"));
		textMap.put(Text.MainGrid_ContextMenuItem_Delete, bundle.getString("MainGrid.ContextMenuItem.Delete"));
		textMap.put(Text.MainGrid_DeleteAlert_Title, bundle.getString("MainGrid.DeleteAlert.Title"));
		textMap.put(Text.MainGrid_DeleteAlert_Text, bundle.getString("MainGrid.DeleteAlert.Text"));
		textMap.put(Text.UrgentSchedule, bundle.getString("UrgentSchedule"));
		textMap.put(Text.RoutineSchedule, bundle.getString("RoutineSchedule"));
		textMap.put(Text.LongTermSchedule, bundle.getString("LongTermSchedule"));
		textMap.put(Text.TrivialSchedule, bundle.getString("TrivialSchedule")); 
		textMap.put(Text.Schedule, bundle.getString("Schedule"));

		Storage.getScheduleList().addListener
		((ListChangeListener<AbstractScheduleModel>)c->Storage.saveSchedules());
	}
	
	public enum Text
	{
		MainGrid_ContextMenuItem_Edit, MainGrid_ContextMenuItem_Delete,
		MainGrid_DeleteAlert_Title, MainGrid_DeleteAlert_Text,
		UrgentSchedule,RoutineSchedule,LongTermSchedule,TrivialSchedule,Schedule
	}
	
	public enum Pref
	{
		RowCount, Language
	}
	
	public static void setRowCount(int count)
	{
		if(count >= 1 && count <= 6)
		{
			rowCountProperty.set(count);
			setPref(Pref.RowCount, String.valueOf(count));
	    	savePrefs();
		}
	}
	
	////////////
	public static String getPref(Pref key)
	{
		return prefs.getProperty(prefKeyMap.get(key));
	}
	
	public static String getPrefKey(Pref key)
	{
		return prefKeyMap.get(key);
	}
	public static void setPref(Pref key , String value)
	{
		prefs.setProperty(prefKeyMap.get(key) , value);
	}
	
	public static void savePrefs()
	{
		try
		{
			prefs.store(new FileOutputStream(new File(prefsPath)), null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadPrefs()
	{
		File prefsFile = new File(prefsPath);
		Properties samplePrefs = new Properties();
		samplePrefs.setProperty(prefKeyMap.get(Pref.Language) , Locale.getDefault().toString());
		samplePrefs.setProperty(prefKeyMap.get(Pref.RowCount) , "4");
		if(!prefsFile.exists())
		{
			for(Map.Entry<Object , Object> entry : samplePrefs.entrySet())
				prefs.setProperty((String)entry.getKey(), (String)entry.getValue());
		}
		else
		{
			prefs.clear();
			try
			{	
				prefs.load(new FileInputStream(prefsFile));
				for(Object key : samplePrefs.keySet())
				{
					if(!prefs.containsKey(key))
						prefs.setProperty((String)key , (String)samplePrefs.get(key));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		if(!localeMap.containsKey(prefs.getProperty(prefKeyMap.get(Pref.Language))))
			setPref(Pref.Language , "en");
		setRowCount(Integer.valueOf(getPref(Pref.RowCount)));
		savePrefs();
	}
	/////////////
	public static String text(Text text)
	{
		return textMap.get(text);
	}
	
	public static ResourceBundle getBundle()
	{
		return bundle;
	}
	
	public static void loadSchedules()
	{
    	try(FileInputStream fIn = new FileInputStream(new File(schedulePath));
    			ObjectInputStream oIn = new ObjectInputStream(fIn))
    	{
    		scheduleList.clear();
        	LinkedList<SerializableSchedulePOJO> pojoList = (LinkedList<SerializableSchedulePOJO>)oIn.readObject();
        	for(SerializableSchedulePOJO pojo : pojoList)
        	{
        		AbstractScheduleModel model;
	        	switch(pojo.priority)
				{
					case 0:
						model = new UrgentSchedule();
						break;
					case 1:
						model = new RoutineSchedule();
						break;
					case 2:
						model = new LongTermSchedule();
						break;
					case 3:
						model = new TrivialSchedule();
						break;
					default:
						model = new UrgentSchedule();
						break;
				}
	        	model.getStartDateTimeProperty().set(pojo.startDateTime);
				model.getEndDateTimeProperty().set(pojo.endDateTime);
				model.getNameProperty().set(pojo.name);
				model.getIsDoneProperty().set(pojo.isDone);
				model.getColorProperty().set(Color.color(pojo.colorR, pojo.colorG, pojo.colorB));
				scheduleList.add(model);
        	}
        } 
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	public static void saveSchedules()
	{
    	try(FileOutputStream fOut = new FileOutputStream(new File(schedulePath)); 
    			ObjectOutputStream oOut = new ObjectOutputStream(fOut))
    	{     
    		LinkedList<SerializableSchedulePOJO> pojoList = new LinkedList<>();
    		for(AbstractScheduleModel model : scheduleList)
    		{
    			SerializableSchedulePOJO pojo = new SerializableSchedulePOJO();
    			pojo.startDateTime = model.getStartDateTimeProperty().get();
    			pojo.endDateTime = model.getEndDateTimeProperty().get();
    			pojo.name = model.getNameProperty().get();
    			pojo.isDone = model.getIsDoneProperty().get();
    			pojo.colorR = model.getColorProperty().get().getRed();
    			pojo.colorG = model.getColorProperty().get().getGreen();
    			pojo.colorB = model.getColorProperty().get().getBlue();
    			pojo.priority = model.getPriority();
    			pojoList.add(pojo);
    		}
			oOut.writeObject(pojoList);
    	} 
    	catch(Exception e) 
    	{ 
    		e.printStackTrace(); 
    	}
	}
	
	public static void adjustNowTime(int signum)
	{
		adjustNowTime += signum;
		LocalDateTime localDateTime = LocalDateTime.now();
		nowTimeProperty.set(localDateTime.plusWeeks(adjustNowTime));
	}
	
	public static ObservableList<AbstractScheduleModel> getScheduleList()
	{
		return scheduleList;
	}
	public static LinkedHashMap<String , Locale> getLocaleMap()
	{
		return localeMap;
	}
	public static IntegerProperty getRowCountProperty()
	{
		return rowCountProperty;
	}
	public static ObjectProperty<LocalDateTime> getNowTimeProperty()
	{
		return nowTimeProperty;
	}
}
