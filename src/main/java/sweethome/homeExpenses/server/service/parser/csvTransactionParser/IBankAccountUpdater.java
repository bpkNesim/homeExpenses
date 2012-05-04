package sweethome.homeExpenses.server.service.parser.csvTransactionParser;

import sweethome.homeExpenses.server.domain.BankAccount;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 00:34
 * To change this template use File | Settings | File Templates.
 */


public interface IBankAccountUpdater {

    public BankAccount importHTDToBankAccount(BankAccount bankAccount, HistoricalTransactionDocument htd);
}
