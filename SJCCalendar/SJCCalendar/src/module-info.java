module com.gmail.andrewchouhs.SJCCalendar
{
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens com.gmail.andrewchouhs.controllerAndView to javafx.fxml;
	exports com.gmail.andrewchouhs;
}