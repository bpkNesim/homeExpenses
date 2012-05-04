package sweethome.homeExpenses.server.domain;

import org.springframework.beans.factory.annotation.Required;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 27.04.12
 * Time: 17:19
 */
public class Transaction{

    private Date postingDate;
    private Date transactionDate;
    private String title;
    private double value;
    private double valueAfterOperation;
    private int transactionNumber;
    private SpendingCategory spendingCategory;

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValueAfterOperation() {
        return valueAfterOperation;
    }

    public void setValueAfterOperation(double valueAfterOperation) {
        this.valueAfterOperation = valueAfterOperation;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public SpendingCategory getSpendingCategory() {
        return spendingCategory;
    }

    public void setSpendingCategory(SpendingCategory spendingCategory) {
        this.spendingCategory = spendingCategory;
    }
}
