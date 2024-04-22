module com.example.classwork3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.classwork3 to javafx.fxml;
    exports com.example.classwork3;
}