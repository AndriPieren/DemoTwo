package com.pi4j.mvc.blackoutapp;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.blackoutapp.view.gui.BlackoutGui;
import com.pi4j.mvc.blackoutapp.view.gui.PuiEmulator;
import com.pi4j.mvc.blackoutapp.view.pui.BlackoutPui;
import com.pi4j.mvc.util.Pi4JContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {
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
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();

        // TODO implement emulator
        startPuiEmulator(new PuiEmulator(controller));
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
}
