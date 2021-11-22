package com.lesson5.lab_num5.controllers;

import com.lesson5.lab_num5.util.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
    private final SceneLoader sceneLoader = new SceneLoader();

    @FXML
    private Button requestBtn;

    @FXML
    private AnchorPane mainAnchorPane;

    Stage stage;

    public void onExitButtonClick() {
        stage = (Stage) mainAnchorPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void changeWindowToTable() {
        requestBtn.getScene().getWindow().hide();
        sceneLoader.loadTableScene("table.fxml");
    }
}