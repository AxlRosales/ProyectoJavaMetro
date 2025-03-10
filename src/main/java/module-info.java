module com.example.demostracionpresentacion {
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.jfxtras.styles.jmetro;

    opens com.example.demostracionpresentacion to javafx.fxml;
    exports com.example.demostracionpresentacion;
}