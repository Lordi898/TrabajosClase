package org.example;

package com.misterfantasy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private Map<String, Integer> jugadores = new HashMap<>(); // Mapa para guardar las deudas de cada jugador.
    private ListView listViewJugadores;
    private TextField textFieldJugador1, textFieldJugador2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Iniciar los jugadores con cero deuda
        jugadores.put("Jugador 1", 0);
        jugadores.put("Jugador 2", 0);
        jugadores.put("Jugador 3", 0);
        jugadores.put("Jugador 4", 0);
        jugadores.put("Jugador 5", 0);

        // Crear elementos de la interfaz gráfica
        VBox root = new VBox(10);
        root.setPadding(new javafx.geometry.Insets(10));

        // Crear lista de jugadores
        listViewJugadores = new ListView<>();
        actualizarListaJugadores();

        // Crear campos de entrada para los jugadores con menos puntos
        textFieldJugador1 = new TextField();
        textFieldJugador1.setPromptText("Jugador 1 menos puntos");
        textFieldJugador2 = new TextField();
        textFieldJugador2.setPromptText("Jugador 2 menos puntos");

        // Botón para registrar el pago
        Button botonRegistrarPago = new Button("Registrar Pago");
        botonRegistrarPago.setOnAction(event -> registrarPago());

        // Agregar todo al layout
        root.getChildren().addAll(listViewJugadores, textFieldJugador1, textFieldJugador2, botonRegistrarPago);

        // Configuración de la escena
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Liga Mister Fantasy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void actualizarListaJugadores() {
        listViewJugadores.getAxis().clear();
        for (Map.Entry<String, Integer> entry : jugadores.entrySet()) {
            listViewJugadores.getAxis().add(entry.getKey() + ": " + entry.getValue() + "€");
        }
    }

    private void registrarPago() {
        String jugador1 = textFieldJugador1.getText().trim();
        String jugador2 = textFieldJugador2.getText().trim();

        if (jugador1.isEmpty() || jugador2.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Por favor, ingresa los nombres de los jugadores.");
            return;
        }

        if (!jugadores.containsKey(jugador1) || !jugadores.containsKey(jugador2)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Uno o ambos jugadores no existen.");
            return;
        }

        // Registrar el pago de 2 euros para ambos jugadores
        jugadores.put(jugador1, jugadores.get(jugador1) + 2);
        jugadores.put(jugador2, jugadores.get(jugador2) + 2);

        // Actualizar la lista de jugadores
        actualizarListaJugadores();

        // Limpiar campos de texto
        textFieldJugador1.clear();
        textFieldJugador2.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
