package sweethome.homeExpenses.server.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 27.04.12
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class HistoricalTransactionDocument {
    public List<Transaction> historicalTransactions;

    public HistoricalTransactionDocument() {
        historicalTransactions = new LinkedList<Transaction>();
    }

    public List<Transaction> getHistoricalTransactions() {
        return historicalTransactions;
    }

    public void setHistoricalTransactions(List<Transaction> historicalTransactions) {
        this.historicalTransactions = historicalTransactions;
    }
}
