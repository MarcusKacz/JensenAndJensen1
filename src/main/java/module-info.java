module com.example.jensenandjensen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.sql;
    requires junit;


    opens com.example.jensenandjensen to javafx.fxml;
    exports com.example.jensenandjensen;
    exports test.com.example.jensenandjensen;
}