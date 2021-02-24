package com.gmail.andrewchouhs.controllerAndView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import com.gmail.andrewchouhs.model.AbstractScheduleModel;
import com.gmail.andrewchouhs.storage.Storage;
import com.gmail.andrewchouhs.storage.Storage.Text;
import com.gmail.andrewchouhs.util.ScheduleLine;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class MainGridController
{
	@FXML
	private GridPane linePane;
	private ContextMenu currentContextMenu = new ContextMenu();
	
	@FXML
	private void initialize()
	{
		refreshGrid();
		Storage.getScheduleList().addListener
		((ListChangeListener<AbstractScheduleModel>)c->refreshGrid());
		Storage.getRowCountProperty()	.addListener
		((a,b,c)->refreshGrid());
		Storage.getNowTimeProperty().addListener((a,b,c)->refreshGrid());
	}
	private void refreshGrid()
	{
		Node node = linePane.getChildren().get(0);
		linePane.getChildren().clear();
		linePane.getChildren().add(0,node);
		
		linePane.getRowConstraints().clear();
		
		GridPane.setRowIndex(linePane, Storage.getRowCountProperty().get());
		RowConstraints lrc = 
		new RowConstraints(5, Region.USE_COMPUTED_SIZE, Double.MAX_VALUE, 
                Priority.ALWAYS, VPos.CENTER,true);

		for(int count = 0 ; count < Storage.getRowCountProperty().get() ; count++)
			linePane.getRowConstraints().add(lrc);
		
		LocalDateTime nowTime = Storage.getNowTimeProperty().get();
		if(nowTime.getDayOfWeek().getValue() < 7)
			nowTime = nowTime.minusDays(nowTime.getDayOfWeek().getValue());
		for(int row = 0 ; row < Storage.getRowCountProperty().get() ; row++)
		{
			LinkedHashMap<AbstractScheduleModel, Long> weekSchedule = new LinkedHashMap<>();
			for(AbstractScheduleModel model : Storage.getScheduleList())
			{
				long seconds = isScheduleInDays(model,nowTime,7);
				if(seconds != -1)
					weekSchedule.put(model, seconds);
			}
			
			weekSchedule = 
					weekSchedule.entrySet().stream().sorted
					((a,b) -> Long.compare(a.getValue(), b.getValue()))
					.collect(LinkedHashMap::new,  (map, item) -> map.put(item.getKey(), item.getValue()),Map::putAll); 
			
			LinkedHashMap<Integer, LinkedList<AbstractScheduleModel>> gridOrder = new LinkedHashMap<>();
//			System.out.println("Row: " + row);
//			weekSchedule.entrySet().stream().forEach((o)->System.out.println(o.getValue()));
			
			while(!weekSchedule.isEmpty())
			{
				Iterator<Map.Entry<AbstractScheduleModel, Long>> iter = weekSchedule.entrySet().iterator();
				while(iter.hasNext())
				{
					boolean ifAddList = true;
					Map.Entry<AbstractScheduleModel, Long> entry = iter.next();
					for(LinkedList<AbstractScheduleModel> models : gridOrder.values())
					{
						boolean conflicted = false;
						for(AbstractScheduleModel model : models)
						{
							// 可能會有問題，因為不同禮拜導致的問題
							if(isScheduleInDays(entry.getKey(), 
									model.getStartDateTimeProperty().get(), 
									model.getEndDateTimeProperty().get()) != -1)
							{
								conflicted = true;
								break;
							}
						}
						if(conflicted == false)
						{
							models.add(entry.getKey());
							ifAddList = false;
							break;
						}
					}
					if(ifAddList)
					{
						LinkedList<AbstractScheduleModel> orderList = new LinkedList<>();
						gridOrder.put(gridOrder.size(), orderList);
						orderList.add(entry.getKey());
					}
					iter.remove();
				}
			}
			// 或許不需要
//			gridOrder.entrySet().stream().sorted((a,b) -> Integer.compare(b.getKey(), a.getKey()));
			for(int column = 0 ; column < 7 ; column++)
			{
				GridPane gridPane = new GridPane();
				//	確認小格子排版狀態是否優良。
//				gridPane.setGridLinesVisible(true);
				
				Label dayLabel = new Label(String.valueOf(nowTime.getMonth().getValue()) + "/" +
						String.valueOf(nowTime.getDayOfMonth())
						);
				dayLabel.setId("dayLabel");
				gridPane.add(dayLabel, 0, 0);
				
				
				ColumnConstraints cc = 
						new ColumnConstraints(20, 20, Double.MAX_VALUE, 
				                Priority.ALWAYS, HPos.LEFT, false);
				gridPane.getColumnConstraints().addAll(cc);
				
				
				RowConstraints labelRC = 
						new RowConstraints(5, Region.USE_COMPUTED_SIZE, Double.MAX_VALUE, 
				                Priority.ALWAYS, VPos.TOP,true);
				RowConstraints rc = 
				new RowConstraints(5, Region.USE_COMPUTED_SIZE, Double.MAX_VALUE, 
		                Priority.ALWAYS, VPos.CENTER,false);
				gridPane.getRowConstraints().add(labelRC);
				for(int count = 0 ; count < gridOrder.size() ; count++)
					gridPane.getRowConstraints().add(rc);
				
				for(Map.Entry<Integer, LinkedList<AbstractScheduleModel>> entry : gridOrder.entrySet())
				{ 
					HBox hBox = new HBox();
					LinkedList<AbstractScheduleModel> todaySchedule = new LinkedList<>();
					for(AbstractScheduleModel model : entry.getValue())
					{
						if(isScheduleInDays(model, nowTime, 1) != -1)
							todaySchedule.add(model);
					}
					todaySchedule.sort((a, b)->
					{
						if(a.getEndDateTimeProperty().get().isBefore(b.getEndDateTimeProperty().get()))
							return -1;
						else
							return 1;
					});
//					todaySchedule.stream().forEach((o)->System.out.println(o.getEndDateTimeProperty().getValue().getHour()));
					
					LocalDateTime passedTime = LocalDateTime.of(nowTime.toLocalDate(), LocalTime.of(0, 0, 0));
					for(AbstractScheduleModel model : todaySchedule)
					{
						double offset = 0;
						if(!model.getStartDateTimeProperty().get().isBefore(passedTime))
						{
							offset = Duration.between(passedTime, model.getStartDateTimeProperty().get()).getSeconds();
							passedTime = passedTime.plusSeconds((long)offset);
							offset = offset / 86400d;
//							System.out.println(offset);
						}
						ScheduleLine offsetLine = drawLine(null, offset, Color.TRANSPARENT, 1);
						hBox.getChildren().add(offsetLine);
						
						double length = 0;
						length = isScheduleInDays(model, nowTime, 1);
						passedTime = passedTime.plusSeconds((long)length);
						length = length / 86400d;
						ScheduleLine lengthLine = drawLine(model, length, model.getColorProperty().get(), 
								2* (4 - model.getPriority()));
						hBox.getChildren().add(lengthLine);
					}
					gridPane.add(hBox , 0, entry.getKey() + 1);
				}

				linePane.add(gridPane, column, row);
				nowTime = nowTime.plusDays(1);
			}
		}
		DoubleProperty fontSize = new SimpleDoubleProperty(10);
		fontSize.bind(linePane.widthProperty().add(linePane.heightProperty()).divide(50));
		linePane.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
	}
	
	// 只給那天開始就好，不用再自己更改從0時開始
	private long isScheduleInDays(AbstractScheduleModel model, LocalDateTime startTime, int days)
	{
		LocalDateTime startDays = LocalDateTime.of(startTime.toLocalDate(), LocalTime.of(0, 0, 0));
		LocalDateTime endDays = startDays.plusDays(days);
		return isScheduleInDays(model, startDays, endDays);
	}
	
	private long isScheduleInDays(AbstractScheduleModel model, LocalDateTime startTime, LocalDateTime endTime)
	{
		LocalDateTime modelStart = model.getStartDateTimeProperty().get();
		LocalDateTime modelEnd = model.getEndDateTimeProperty().get();
		if(((modelStart.isAfter(startTime) || modelStart.isEqual(startTime)) && modelStart.isBefore(endTime)) 
				|| 
			(modelEnd.isAfter(startTime) && modelEnd.isBefore(endTime))
				||
			(modelStart.isBefore(startTime)&& modelEnd.isAfter(endTime)))
		{
			modelStart = modelStart.isAfter(startTime) ? modelStart : startTime;
			modelEnd = modelEnd.isBefore(endTime) ? modelEnd : endTime;
			return Duration.between(modelStart, modelEnd).getSeconds();
		}
		return -1;
	}
	private ScheduleLine drawLine(AbstractScheduleModel model, double length, Color color, double height)
	{
		ScheduleLine line = new ScheduleLine(model);
		
		line.setStrokeWidth(0);
		line.setHeight(height);
		line.setFill(color);
		
		line.widthProperty().bind(linePane.widthProperty().multiply(length / 7d));
		if(line.getModel() != null)
		{
			line.setOnMouseClicked((me)->
			{ 
				if(me.getButton() == MouseButton.SECONDARY)
					showContextMenu(me);
			});
	//		line.setOnMouseMoved((me) -> popScheduleName(me));
			Tooltip scheduleNameTip = new Tooltip();
			scheduleNameTip.setWrapText(true);
			scheduleNameTip.setShowDuration(javafx.util.Duration.INDEFINITE);
			scheduleNameTip.setShowDelay(javafx.util.Duration.ZERO);
			scheduleNameTip.setHideDelay(javafx.util.Duration.ZERO);
			scheduleNameTip.textProperty().bind(line.getModel().
					getNameProperty()
					.concat("\n")
					.concat(line.getModel().getStartDateTimeProperty().get().toString())
					.concat("\n")
					.concat(line.getModel().getEndDateTimeProperty().get().toString()));

			Tooltip.install(line, scheduleNameTip);
		}
		return line;
	}

	private void showContextMenu(MouseEvent me)
	{
		if(currentContextMenu.isShowing())
			currentContextMenu.hide();
		ScheduleLine line = (ScheduleLine) me.getSource();
		currentContextMenu = new ContextMenu();
		
		currentContextMenu.setAutoHide(true);
		MenuItem editMenuItem = new MenuItem(Storage.text(Text.MainGrid_ContextMenuItem_Edit));
		editMenuItem.setOnAction((e)->ScheduleEditingStage.callStage(line.getModel()));
		MenuItem deleteMenuItem = new MenuItem(Storage.text(Text.MainGrid_ContextMenuItem_Delete));
		deleteMenuItem.setOnAction((e)->popDeleteScheduleAlert(line.getModel()));
		currentContextMenu.getItems().addAll(editMenuItem, deleteMenuItem);
		currentContextMenu.show(line , me.getScreenX() + 3, me.getScreenY() + 3);
	}
	
	private void popDeleteScheduleAlert(AbstractScheduleModel model)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Storage.text(Text.MainGrid_DeleteAlert_Title));
		alert.setHeaderText("");
		alert.setContentText(Storage.text(Text.MainGrid_DeleteAlert_Text));
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK) 
			Storage.getScheduleList().remove(model);
	}
}
