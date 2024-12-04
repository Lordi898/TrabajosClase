import javafx.fxml.FXML;
import javafx.scene.Control.*;
import java.awt.*;

public class PasswordManagerController {

    @FXML
    private TextField siteField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private ListView<String> passwordList;

    /**
     * Método para guardar una nueva entrada de contraseña.
     */
    @FXML
    private void handleSavePassword() {
        // Obtiene los valores de los campos
        String site = siteField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Verifica si todos los campos están completos
        if (site.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showMessage("All fields are required!", "red");
            return;
        }

        // Formatea la información para la lista
        String entry = String.format("%s | %s | %s", site, username, password);

        // Agrega la entrada a la lista
        passwordList.getItems().add(entry);

        // Limpia los campos
        clearFields();

        // Muestra un mensaje de éxito
        showMessage("Password saved successfully!", "green");
    }

    /**
     * Limpia los campos de texto.
     */
    private void clearFields() {
        siteField.clear();
        usernameField.clear();
        passwordField.clear();
    }

    /**
     * Muestra un mensaje en el label `messageLabel` con el color especificado.
     *
     * @param message El mensaje a mostrar.
     * @param color El color del texto (por ejemplo, "red" o "green").
     */
    private void showMessage(String message, String color) {
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: " + color + ";");
    }

    /**
     * Método para eliminar una entrada seleccionada de la lista.
     */
    @FXML
    private void handleDeletePassword() {
        // Obtiene el elemento seleccionado
        String selectedItem = passwordList.getSelectionModel().getSelectedItem();

        // Verifica si hay un elemento seleccionado
        if (selectedItem == null) {
            showMessage("Please select an item to delete!", "red");
            return;
        }

        // Elimina el elemento seleccionado
        passwordList.getItems().remove(selectedItem);

        // Muestra un mensaje de éxito
        showMessage("Password deleted successfully!", "green");
    }

    /**
     * Método para inicializar la interfaz al cargar (opcional).
     */
    @FXML
    public void initialize() {
        // Configura la lista como editable (si lo deseas)
        passwordList.setEditable(false);
    }
}
