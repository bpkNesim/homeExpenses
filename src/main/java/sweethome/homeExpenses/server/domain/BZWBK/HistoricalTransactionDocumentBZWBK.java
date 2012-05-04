package sweethome.homeExpenses.server.domain.BZWBK;

import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 27.04.12
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class HistoricalTransactionDocumentBZWBK extends HistoricalTransactionDocument {

    private String accountNumber;
    private String personalData;
    private String currency;
    private double beginValue;
    private double endValue;
    private int numberOfTransactions;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBeginValue() {
        return beginValue;
    }

    public void setBeginValue(double beginValue) {
        this.beginValue = beginValue;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }
}
