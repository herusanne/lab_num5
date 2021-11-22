module com.lesson5.lab_num5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.compiler;
    requires json.simple;


    opens com.lesson5.lab_num5 to javafx.fxml;
    exports com.lesson5.lab_num5;
    exports com.lesson5.lab_num5.controllers;
    opens com.lesson5.lab_num5.controllers to javafx.fxml;
}