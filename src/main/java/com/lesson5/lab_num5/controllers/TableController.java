package com.lesson5.lab_num5.controllers;

import com.lesson5.lab_num5.util.SceneLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.lesson5.lab_num5.classes.Currency;

public class TableController implements Initializable {
    @FXML
    private TableView<Currency> tableView;
    @FXML
    private TableColumn<Currency, String> ccy;
    @FXML
    private TableColumn<Currency, String> baseCcy;
    @FXML
    private TableColumn<Currency, Number> buy;
    @FXML
    private TableColumn<Currency, Number> sale;
    @FXML
    private AnchorPane mainAnchorPane;

    Stage stage;

    public void initialize(URL location, ResourceBundle resources) {
        ccy.setCellValueFactory(ccy -> ccy.getValue().curCcyProp());
        baseCcy.setCellValueFactory(baseCcy -> baseCcy.getValue().curBaseCcyProp());
        buy.setCellValueFactory(buy -> buy.getValue().curBuyProp());
        sale.setCellValueFactory(sale -> sale.getValue().curSaleProp());

        tableView.getItems().setAll(parseList());
    }

    public void onExitButtonClick() {
        stage = (Stage) mainAnchorPane.getScene().getWindow();
        stage.close();
    }

    private List<Currency> parseList() {
        SceneLoader sceneLoader = new SceneLoader();
        return sceneLoader.parseCurrency();
    }
}
