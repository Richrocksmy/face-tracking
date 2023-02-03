package org.richrocksmy.facetracking;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FaceTrackingController {

  @FXML
  private ImageView webcamImageView;

  private VideoCapture capture;

  @FXML
  public void initialize() {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    capture = new VideoCapture(0);

    new AnimationTimer() {
      @Override
      public void handle(long now) {
        webcamImageView.setImage(getCameraImage());
      }
    };
  }

  private Image getCameraImage() {
    Mat mat = new Mat();
    capture.read(mat);
    return matrixToImage(mat);
  }

  private Image matrixToImage(Mat mat) {
    MatOfByte bytes = new MatOfByte();
    Imgcodecs.imencode("img", mat, bytes);
    InputStream inputStream = new ByteArrayInputStream(bytes.toArray());
    return new Image(inputStream);
  }

}
