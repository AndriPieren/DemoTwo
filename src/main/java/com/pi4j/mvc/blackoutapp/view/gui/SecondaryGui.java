package com.pi4j.mvc.blackoutapp.view.gui;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.util.mvcbase.ViewMixin;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SecondaryGui extends VBox implements ViewMixin<BlackoutModel, BlackoutController> {

    private ImageView icon;
    private BlackoutController controller;

    public SecondaryGui(BlackoutController controller) {
        this.controller = controller;
        init(controller);
    }

    @Override
    public void initializeParts() {
        try {
            var resource = getClass().getClassLoader().getResourceAsStream("Uganda Knuckles.png");
            var image = new Image(resource);
            icon = new ImageView(image);
            //icon.setPreserveRatio(true);
            icon.setFitHeight(32);
            icon.setFitWidth(32);
            icon.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void layoutParts() {
        var orderLabel1 = new Label("Das ist ein Beispiel Text!");
        orderLabel1.setFont(Font.font("Comic Code", FontWeight.BOLD, 40));
        var orderLabel2 = new Label("Das ist ein Beispiel Text!");
        orderLabel2.setFont(Font.font("Comic Code", FontWeight.BOLD, 30));
        var orderLabel3 = new Label("Das ist ein Beispiel Text!");
        orderLabel3.setFont(Font.font("Comic Code", FontWeight.BOLD, 20));
        var orderLabel4 = new Label("Das ist ein Beispiel Text!");
        orderLabel4.setFont(Font.font("Comic Code", FontWeight.BOLD, 10));
        var orderLabel5 = new Label("Das ist ein Beispiel Text!");
        orderLabel5.setFont(Font.font("Comic Code", FontWeight.BOLD, 7));
        var orderLabel6 = new Label("Das ist ein Beispiel Text!");
        orderLabel6.setFont(Font.font("Comic Code", FontWeight.BOLD, 5));

        var button = new Button("Toggle Big Chungus");
        button.setOnAction(e -> {
            System.out.println("Big Chungus Button hitted");
            this.controller.toggleBigChungus();
        });

        setMinSize(800, 600);
        getChildren().addAll(icon, button, orderLabel1, orderLabel2, orderLabel3, orderLabel4, orderLabel5, orderLabel6);
    }

    @Override
    public void setupModelToUiBindings(BlackoutModel model) {
        onChangeOf(model.isUgandaKnucklesEnabled).update(icon.visibleProperty());
    }
}
