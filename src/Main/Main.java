package Main;

import Converter.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Converter myConverter = new Converter();

        primaryStage.setTitle("Hello World");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(
                "C:\\Users\\Hp\\Desktop\\Programming\\Java Fx\\Design Pattern\\Strategy (Text Converter)"));

        VBox vBox = new VBox();

        Label label = new Label("No files selected");

        Button button0 = new Button("Choose File");
        Button button1 = new Button("JSON");
        Button button2 = new Button("CSV");
        Button button3 = new Button("XML");

        EventHandler<ActionEvent> eventFileChoosing = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    label.setText("Selected File: " + file.getName());
                    myConverter.setFile(file);
                }
            }
        };

        EventHandler<ActionEvent> eventJson = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(myConverter.getMyStringArray() != null) {
                    myConverter.setMyStrategy(new JsonStrategy(myConverter.getMyStringArray()));
                    myConverter.convert();
                }
            }
        };

        EventHandler<ActionEvent> eventCsv = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(myConverter.getMyStringArray() != null) {
                    myConverter.setMyStrategy(new CsvStrategy(myConverter.getMyStringArray()));
                    myConverter.convert();
                }
            }
        };

        EventHandler<ActionEvent> eventXml = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(myConverter.getMyStringArray() != null) {
                    myConverter.setMyStrategy(new XmlStrategy(myConverter.getMyStringArray()));
                    myConverter.convert();
                }
            }
        };

        button0.setOnAction(eventFileChoosing);
        button1.setOnAction(eventJson);
        button2.setOnAction(eventCsv);
        button3.setOnAction(eventXml);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);

        vBox.getChildren().addAll(label, button0, button1, button2, button3);

        primaryStage.setScene(new Scene(vBox, 500, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //launch the application
        launch(args);
    }
}
