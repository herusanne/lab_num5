package com.lesson5.lab_num5.classes;

import java.util.ArrayList;
import java.util.Calendar;

public class Currencies {
    private ArrayList<Currency> currencies;

    public Currencies() {
        this.currencies = new ArrayList<>();
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

    public void addCurrency(Currency currency) {
        this.currencies.add(currency);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Currencies [");
        result.append(Calendar.getInstance().getTime())
                .append("]")
                .append(System.lineSeparator());

        for (Currency c : this.currencies) {
            result.append(c).append(System.lineSeparator());
        }
        return result.toString();
    }
}
