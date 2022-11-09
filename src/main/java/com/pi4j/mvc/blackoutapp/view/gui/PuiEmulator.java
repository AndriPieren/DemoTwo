package com.pi4j.mvc.blackoutapp.view.gui;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.util.mvcbase.ViewMixin;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PuiEmulator extends BorderPane implements ViewMixin<BlackoutModel, BlackoutController> {
    private GridPane gridPane;
    private Button sunWireToggleButton;
    private Button windWireToggleButton;

    public PuiEmulator(BlackoutController controller) {
        init(controller);
    }

    @Override
    public void initializeParts() {
        sunWireToggleButton = new Button("Toggle Sun Wire");
        windWireToggleButton = new Button("Toggle Wind Wire");
        gridPane = new GridPane();
        gridPane.add(sunWireToggleButton, 0, 0);
        gridPane.add(windWireToggleButton, 0, 1);
    }

    @Override
    public void layoutParts() {
        setCenter(gridPane);
    }

    @Override
    public void setupUiToActionBindings(BlackoutController controller) {
        sunWireToggleButton.setOnAction(event -> controller.toggleSun());
        windWireToggleButton.setOnAction(event -> controller.toggleWind());
    }
}
