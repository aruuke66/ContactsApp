module com.example.contactsapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.contactsapp to javafx.fxml;
    exports com.example.contactsapp;
}