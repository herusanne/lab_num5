package com.lesson5.lab_num5.util;

import com.lesson5.lab_num5.Main;
import com.lesson5.lab_num5.classes.Currencies;
import com.lesson5.lab_num5.classes.Currency;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;

public class SceneLoader {
    private double x, y;

    public void loadTableScene(String pathToFxml) {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(pathToFxml));
        try {
            loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        scene.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        stage.show();
    }

    public ArrayList<Currency> parseCurrency() {
        Requests requests = new Requests();
        Requests.url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        requests.start();

        System.out.println("[Waiting for data...]");
        String json = requests.jsonIn;

        Object obj = null;
        try {
            obj = new JSONParser().parse(json);
        } catch (org.json.simple.parser.ParseException ex) {
            ex.printStackTrace();
        }

        JSONArray jsonArray = (JSONArray) obj;
        Currencies currencies = new Currencies();

        assert jsonArray != null;
        for (Object jsonObject : jsonArray) {
            JSONObject current = (JSONObject) jsonObject;
            String ccy = (String) current.get("ccy");
            String base_ccy = (String) current.get("base_ccy");
            double buy = Double.parseDouble((String) current.get("buy"));
            double sale = Double.parseDouble((String) current.get("sale"));
            Currency currency = new Currency(ccy, base_ccy, buy, sale);
            currencies.addCurrency(currency);
        }

        return currencies.getCurrencies();
    }
}
