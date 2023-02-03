module org.richrocksmy.facetracking {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencv;


  opens org.richrocksmy.facetracking to javafx.fxml;
  exports org.richrocksmy.facetracking;
}
