package com.lesson5.lab_num5.classes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Comparator;

public class Currency {
    private StringProperty ccy;
    private StringProperty baseCcy;
    private DoubleProperty buy;
    private DoubleProperty sale;

    public Currency() {
    }

    /**
     * @param sale    исходная валюта
     * @param baseCcy валюта покупки
     * @param buy     курс покупки
     * @param ccy     курс продажи
     */

    public Currency(String ccy, String baseCcy, double buy, double sale) {
        this.ccy = new SimpleStringProperty(ccy);
        this.baseCcy = new SimpleStringProperty(baseCcy);
        this.buy = new SimpleDoubleProperty(buy);
        this.sale = new SimpleDoubleProperty(sale);
    }

    public String getCcy() {
        return ccy.get();
    }

    public StringProperty curCcyProp() {
        return this.ccy;
    }

    public void setCcy(String ccy) {
        this.ccy.set(ccy);
    }

    public String getBaseCcy() {
        return baseCcy.get();
    }

    public StringProperty curBaseCcyProp() {
        return this.baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy.set(baseCcy);
    }

    public double getBuy() {
        return buy.get();
    }

    public DoubleProperty curBuyProp() {
        return this.buy;
    }

    public void setBuy(double buy) {
        this.buy.set(buy);
    }

    public double getSale() {
        return sale.get();
    }

    public DoubleProperty curSaleProp() {
        return this.sale;
    }

    public void setSale(double sale) {
        this.sale.set(sale);
    }

    @Override
    public String toString() {
        return this.ccy.get() + " -> " + this.baseCcy.get() + " [buy: " + this.buy.get() + ", sale: " + this.sale.get() + "]";
    }

    public static Comparator<Currency> byNameAsc = (o1, o2) -> o1.ccy.get().compareTo(o2.ccy.get());
    public static Comparator<Currency> byNameDesc = (o1, o2) -> o2.ccy.get().compareTo(o1.ccy.get());
    public static Comparator<Currency> byValueAsc = (o1, o2) -> Double.compare(o1.buy.get(), o2.buy.get());
    public static Comparator<Currency> byValueDesc = (o1, o2) -> Double.compare(o2.buy.get(), o1.buy.get());
}
