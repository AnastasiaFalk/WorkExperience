module com.example.workexperience_git {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.workexperience_git to javafx.fxml;
    exports com.example.workexperience_git;
}