package com.pi4j.mvc.blackoutapp;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.blackoutapp.view.gui.BlackoutGui;
import com.pi4j.mvc.blackoutapp.view.gui.PuiEmulator;
import com.pi4j.mvc.blackoutapp.view.gui.SecondaryGui;
import com.pi4j.mvc.blackoutapp.view.pui.BlackoutPui;
import com.pi4j.mvc.util.Pi4JContext;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppStarter extends Application {
    private static final boolean IS_FULLSCREEN = true;
    private BlackoutController controller;
    private BlackoutPui pui;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        var model = new BlackoutModel();
        controller = new BlackoutController(model);
        pui = new BlackoutPui(controller, Pi4JContext.createContext());
        var gui = new BlackoutGui(controller);
        var scene = new Scene(gui);
        stage.setTitle("Blackout Demo Application");
        stage.setHeight(480);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.setFullScreen(IS_FULLSCREEN);
        stage.show();

        //startPuiEmulator(new PuiEmulator(controller));
        //startSecondaryWindow();
    }

    @Override
    public void stop() {
        controller.shutdown();
        pui.shutdown();
    }

    private void startPuiEmulator(PuiEmulator puiEmulator) {
        Scene emulatorScene = new Scene(puiEmulator);
        Stage emulatorStage = new Stage();
        emulatorStage.setTitle("Blackout PUI Emulator");
        emulatorStage.setWidth(800);
        emulatorStage.setHeight(600);
        emulatorStage.setScene(emulatorScene);
        emulatorStage.show();
    }

    private void startSecondaryWindow() {
        var gui = new SecondaryGui(controller);
        var secondaryScene = new Scene(gui);
        var secondaryStage = new Stage();
        secondaryStage.setTitle("Zweites Fenster");
        secondaryStage.setWidth(800);
        secondaryStage.setHeight(600);
        secondaryStage.setFullScreen(IS_FULLSCREEN);
        secondaryStage.setScene(secondaryScene);
        secondaryStage.show();

    }
}
