package org.richrocksmy.facetracking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FaceTrackingApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(FaceTrackingApplication.class.getResource("main-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1280, 960);
    stage.setTitle("Face Tracking");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
