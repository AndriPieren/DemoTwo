package com.pi4j.mvc.blackoutapp.view.gui;

import com.pi4j.mvc.blackoutapp.controller.BlackoutController;
import com.pi4j.mvc.blackoutapp.model.BlackoutModel;
import com.pi4j.mvc.util.mvcbase.ViewMixin;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlackoutGui extends StackPane implements ViewMixin<BlackoutModel, BlackoutController> {
    private static final String SUN = "☀";
    private static final String WIND = "≋";
    private Label sunLabel;
    private Label windLabel;
    private ImageView icon;
    private Timeline t;
    private BlackoutController controller;

    public BlackoutGui(BlackoutController controller) {
        this.controller = controller;
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
        try {
            var resource = getClass().getClassLoader().getResourceAsStream("Big Chungus.png");
            var image = new Image(resource);
            icon = new ImageView(image);
            //icon.setPreserveRatio(true);
            icon.setFitHeight(32);
            icon.setFitWidth(32);
            icon.setVisible(false);
        } catch(Exception e){
            System.out.println(e.toString());
        }

    }

    @Override
    public void layoutParts() {
        // create GridPane
        var gridPane = new GridPane();
        gridPane.add(sunLabel, 0, 0);
        gridPane.add(windLabel, 0, 1);

        /*if(icon == null) return;
        var stackPane = new StackPane();
        stackPane.getChildren().add(icon);
        var button = new Button("Gugus");
        button.setOnAction(e -> System.out.println("Gugus"));
        stackPane.getChildren().add(button);*/

        // Orderinfo
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

        var orderPane = new VBox();
        orderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        orderPane.setMinSize(400, 350);
        orderPane.getChildren().addAll(orderLabel1, orderLabel2, orderLabel3, orderLabel4, orderLabel5, orderLabel6);

        var energyLabel1 = new Label("Das ist ein Beispiel Text!");
        energyLabel1.setFont(Font.font("Comic Code", FontWeight.LIGHT, 40));
        var energyLabel2 = new Label("Das ist ein Beispiel Text!");
        energyLabel2.setFont(Font.font("Comic Code", FontWeight.LIGHT, 30));
        var energyLabel3 = new Label("Das ist ein Beispiel Text!");
        energyLabel3.setFont(Font.font("Comic Code", FontWeight.LIGHT, 20));
        var energyLabel4 = new Label("Das ist ein Beispiel Text!");
        energyLabel4.setFont(Font.font("Comic Code", FontWeight.LIGHT, 10));
        var energyLabel5 = new Label("Das ist ein Beispiel Text!");
        energyLabel5.setFont(Font.font("Comic Code", FontWeight.LIGHT, 7));
        var energyLabel6 = new Label("Das ist ein Beispiel Text!");
        energyLabel6.setFont(Font.font("Comic Code", FontWeight.LIGHT, 5));

        var button = new Button("Toggle Uganda Knuckles");
        button.setOnAction(e -> {
            System.out.println("Big Chungus Button hitted");
            this.controller.toggleUgandaKnuckles();
        });
        var iconBox = new VBox();
        iconBox.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        iconBox.setMinSize(350, 175);
        iconBox.setMaxSize(350, 175);
        iconBox.getChildren().addAll(icon, button);

        var energyPane = new VBox();
        energyPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        energyPane.setMinSize(350, 175);
        energyPane.setMaxSize(350, 175);
        energyPane.getChildren().addAll(energyLabel1, energyLabel2, energyLabel3, energyLabel4, energyLabel5, energyLabel6);
        var secondColumn = new VBox();
        secondColumn.getChildren().addAll(iconBox, energyPane);

        var pollutionGraph = new Rectangle();
        pollutionGraph.setWidth(50);
        pollutionGraph.setHeight(350);
        pollutionGraph.setStrokeWidth(0);

        t = new Timeline();
        var f1 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var stops = new ArrayList<Stop>();
                stops.add(new Stop(1, Color.RED));
                stops.add(new Stop(1, Color.GREEN));
                pollutionGraph.setFill(new LinearGradient(0,  0, 0, 1, true,CycleMethod.REPEAT, stops));
            }
        });
        var f2 = new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var stops = new ArrayList<Stop>();
                stops.add(new Stop(0.75, Color.RED));
                stops.add(new Stop(0.75, Color.GREEN));
                pollutionGraph.setFill(new LinearGradient(0,  0, 0, 1, true,CycleMethod.REPEAT, stops));
            }
        });
        var f3 = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var stops = new ArrayList<Stop>();
                stops.add(new Stop(0.3, Color.RED));
                stops.add(new Stop(0.3, Color.GREEN));
                pollutionGraph.setFill(new LinearGradient(0,  0, 0, 1, true,CycleMethod.REPEAT, stops));
            }
        });
        var f4 = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                var stops = new ArrayList<Stop>();
                stops.add(new Stop(0, Color.RED));
                stops.add(new Stop(0, Color.GREEN));
                pollutionGraph.setFill(new LinearGradient(0,  0, 0, 1, true,CycleMethod.REPEAT, stops));
            }
        });
        t.getKeyFrames().addAll(f1, f2, f3, f4);
        t.setCycleCount(Timeline.INDEFINITE);


        var infoPane = new HBox();
        infoPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        infoPane.setMinSize(800, 350);
        infoPane.setAlignment(Pos.BOTTOM_CENTER);
        infoPane.getChildren().addAll(orderPane, secondColumn, pollutionGraph);

        // Timeline
        var timeline = new Rectangle();
        timeline.setFill(Color.LIGHTGRAY);
        timeline.setStrokeWidth(0);
        timeline.setWidth(800);
        timeline.setHeight(60);

        var start = new Rectangle();
        start.setFill(Color.BLACK);
        start.setStrokeWidth(0);
        start.setWidth(10);
        start.setHeight(50);

        var end = new Rectangle();
        end.setFill(Color.BLACK);
        end.setStrokeWidth(0);
        end.setWidth(10);
        end.setHeight(50);

        var line = new Rectangle();
        line.setFill(Color.BLACK);
        line.setStrokeWidth(0);
        line.setWidth(800);
        line.setHeight(5);

        var blackoutIcon = new SVGPath();
        blackoutIcon.setContent("M 104.99979 0 C 47.010191 1.0026497e-14 8.02123e-14 47.010191 0 104.99979" +
                " C -5.0132487e-15 131.51368 51.950768 127.51731 54.514502 151.9654 C 59.521155 199.7095" +
                " 73.524048 210.0001 104.99979 210.0001 C 139.73727 210.0001 142.05932 194.02093 147.82405" +
                " 151.12049 C 150.70019 129.71675 210.0001 128.25195 210.0001 104.99979 C 210.0001 47.010191" +
                " 162.98939 8.02123e-14 104.99979 0 z M 67.499756 50.000049 A 17.5 20 0 0 1 84.99998 69.999862" +
                " A 17.5 20 0 0 1 67.499756 90.000191 A 17.5 20 0 0 1 50.000049 69.999862 A 17.5 20 0 0 1 67.499756" +
                " 50.000049 z M 142.49983 50.000049 A 17.5 20 0 0 1 160.00005 69.999862 A 17.5 20 0 0 1 142.49983" +
                " 90.000191 A 17.5 20 0 0 1 125.00012 69.999862 A 17.5 20 0 0 1 142.49983 50.000049 z M 73.661654" +
                " 134.10758 C 78.205457 134.11657 82.786322 135.56855 83.726672 138.43703 C 86.380818 146.53333" +
                " 86.659712 154.66789 83.726672 164.07526 L 63.81781 164.07526 C 62.046201 154.61662 61.66984 146.30519" +
                " 63.81781 138.43703 C 64.610713 135.53257 69.117851 134.09858 73.661654 134.10758 z M 101.51422 134.1453" +
                " C 106.05801 134.15429 110.63888 135.60679 111.57924 138.47527 C 114.23337 146.57156 114.51226 154.70562" +
                " 111.57924 164.11298 L 91.670374 164.11298 C 89.898765 154.65435 89.522406 146.34342 91.670374 138.47527" +
                " C 92.463275 135.57081 96.970418 134.13631 101.51422 134.1453 z M 127.94206 134.77472 C 132.48587 134.78371" +
                " 137.06673 136.23569 138.00708 139.10417 C 140.66123 147.20045 140.94012 155.33505 138.00708 164.7424" +
                " L 118.09873 164.7424 C 116.32715" +
                " 155.28378 115.95079 146.97231 118.09873 139.10417 C 118.89164 136.19971 123.39828 134.76573 127.94206 134.77472 z ");
        blackoutIcon.setScaleX(0.1);
        blackoutIcon.setScaleY(0.1);
        blackoutIcon.setFill(Color.BLACK);
        blackoutIcon.setStroke(Color.YELLOW);
        blackoutIcon.setTranslateY(-10);
        var eventLine = new Rectangle();
        eventLine.setFill(Color.BLACK);
        eventLine.setStrokeWidth(0);
        eventLine.setWidth(5);
        eventLine.setHeight(25);
        var label = new Label("1. Blackout");
        label.setFont(Font.font("Comic Code"));
        label.setRotate(-45);
        label.setMinWidth(250);
        label.setTranslateY(-105);
        label.setTranslateX(100);
        var blackoutEvent = new StackPane();
        //blackoutEvent.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        blackoutEvent.setMinSize(50, 50);
        blackoutEvent.setMaxSize(50, 50);
        blackoutEvent.getChildren().addAll(eventLine, blackoutIcon, label);
        StackPane.setAlignment(eventLine, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(blackoutIcon, Pos.CENTER);
        blackoutEvent.setTranslateX(-150);

        var timelinePane = new StackPane();
        timelinePane.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));
        timelinePane.setMinSize(800, 75);
        timelinePane.getChildren().addAll(timeline, start, end, line, blackoutEvent);
        StackPane.setAlignment(timeline, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(start, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(end, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(line, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(blackoutEvent, Pos.BOTTOM_CENTER);

        // Panel
        var mainPaine = new VBox();
        mainPaine.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainPaine.setMinSize(800, 480);
        mainPaine.setAlignment(Pos.CENTER);
        mainPaine.setSpacing(10);
        mainPaine.getChildren().addAll(infoPane, timelinePane);

        getChildren().add(mainPaine);
        t.play();
    }

    @Override
    public void setupModelToUiBindings(BlackoutModel model) {
        onChangeOf(model.sunEnabled).update(sunLabel.visibleProperty());
        onChangeOf(model.windEnabled).update(windLabel.visibleProperty());
        onChangeOf(model.isBigChungusEnabled).update(icon.visibleProperty());
    }
}