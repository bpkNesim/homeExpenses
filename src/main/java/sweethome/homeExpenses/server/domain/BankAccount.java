package sweethome.homeExpenses.server.domain;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 00:06
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {

    private String accountNumber;
    private String name;
    private String street;
    private String streetNumber;
    private String cityCode;
    private String city;
    
    private double value;
    private String currency;

    private List<Transaction> history = new LinkedList<Transaction>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void setHistory(List<Transaction> history) {
        this.history = history;
    }
}
