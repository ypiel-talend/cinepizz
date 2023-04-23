package org.cinepizz;

import java.io.File;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cinepizz extends Application {

    private File[] imageFiles;
    private ImageView imageView;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {

        // Load images from the specified folder
        File imageFolder = new File("/tmp/images/");
        imageFiles = imageFolder.listFiles();

        // Create ImageView to display images
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);

        // Create button to display a random image
        Button button = new Button("Display Random Image");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get a random image file
                File randomImageFile = imageFiles[random.nextInt(imageFiles.length)];
                // Load the image and display it in the ImageView
                Image randomImage = new Image(randomImageFile.toURI().toString());
                imageView.setImage(randomImage);
            }
        });

        // Create VBox to hold the ImageView and the button
        VBox root = new VBox();
        root.getChildren().addAll(imageView, button);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(root, 400, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
