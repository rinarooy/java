module com.example.task2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;



    opens com.example.task2 to javafx.fxml;
    exports com.example.task2;
}