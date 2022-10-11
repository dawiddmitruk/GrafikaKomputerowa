module dd.grafikakomputerowa1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	
	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
//	requires eu.hansolo.tilesfx;
	requires lombok;
	requires org.eclipse.collections.api;
	requires org.eclipse.collections.impl;
	
	opens dd.grafikakomputerowa1 to javafx.fxml;
	exports dd.grafikakomputerowa1;
}