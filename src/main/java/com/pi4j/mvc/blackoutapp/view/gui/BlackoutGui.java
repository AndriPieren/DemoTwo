package com.pi4j.mvc.blackoutapp.view.gui;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.util.mvcbase.ViewMixin;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class BlackoutGui extends BorderPane implements ViewMixin<BlackoutModel, BlackoutController> {
    private static final String SUN = "☀";
    private static final String WIND = "≋";
    private Label sunLabel;
    private Label windLabel;

    public BlackoutGui(BlackoutController controller) {
        init(controller);
    }

    @Override
    public void initializeSelf() {
        loadFonts("/fonts/Lato/Lato-Lig.ttf", "/fonts/fontawesome-webfont.ttf");
    }

    @Override
    public void initializeParts() {
        sunLabel = new Label("Energysource: " + SUN);
        sunLabel.setVisible(false);
        sunLabel.setFont(new Font(30));
        windLabel = new Label("Energysource: " + WIND);
        windLabel.setVisible(false);
        windLabel.setFont(new Font(30));
    }

    @Override
    public void layoutParts() {
        // create GridPane
        var gridPane = new GridPane();
        gridPane.add(sunLabel, 0, 0);
        gridPane.add(windLabel, 0, 1);

        setCenter(gridPane);
    }

    @Override
    public void setupModelToUiBindings(BlackoutModel model) {
        onChangeOf(model.sunEnabled).update(sunLabel.visibleProperty());
        onChangeOf(model.windEnabled).update(windLabel.visibleProperty());
    }
}