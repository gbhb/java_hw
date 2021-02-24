package com.gmail.andrewchouhs.controllerAndView;

import java.util.Locale;
import com.gmail.andrewchouhs.storage.Storage;
import com.gmail.andrewchouhs.storage.Storage.Pref;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

public class SettingsPageController
{
	@FXML
	private ChoiceBox<Locale> localeChoiceBox;
	
	@FXML
	private void initialize()
	{
		ObservableList<Locale> localeList = FXCollections.observableArrayList();
    	localeList.addAll(Storage.getLocaleMap().values());
    	localeChoiceBox.setItems(localeList);
    	localeChoiceBox.setConverter(new StringConverter<Locale>()
    	{
    		//可能會造成 Bug。
			@Override
			public Locale fromString(String arg0)
			{
				return null;
			}

			@Override
			public String toString(Locale locale)
			{
				return locale.getDisplayName(locale);
			}
    	});
    	localeChoiceBox.getSelectionModel().selectFirst();
	}
	
	public void selectLocale()
	{
    	localeChoiceBox.getSelectionModel().select(Storage.getLocaleMap().get(Storage.getPref(Pref.Language)));
	}
	
	@FXML
	private void okButton()
	{
		Storage.setPref(Pref.Language, localeChoiceBox.getValue().toString());
		
    	Storage.savePrefs();
    	SettingsStage.closeStage();
	}
	
	@FXML
	private void cancelButton()
	{
		SettingsStage.closeStage();
	}
}
