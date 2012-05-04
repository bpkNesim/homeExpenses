package sweethome.homeExpenses.server.service.parser.csvTransactionParser;

import sweethome.homeExpenses.server.domain.BankAccount;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 22.04.12
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */

public interface ITransactionParser {

    public HistoricalTransactionDocument parseDocument();
}
