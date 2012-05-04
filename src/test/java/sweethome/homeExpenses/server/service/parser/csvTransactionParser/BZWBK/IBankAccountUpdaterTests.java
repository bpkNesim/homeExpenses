package sweethome.homeExpenses.server.service.parser.csvTransactionParser.BZWBK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sweethome.homeExpenses.server.domain.BankAccount;
import sweethome.homeExpenses.server.service.parser.csvTransactionParser.IBankAccountUpdater;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 09:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../../spring-config-tests.xml")
public class IBankAccountUpdaterTests {

    @Autowired
    private IBankAccountUpdater bankAccountUpdater;
    @Autowired
    private TransactionParserCsvBZWBK parserCsvBZWBK;

    private BankAccount bankAccount = new BankAccount();

    @Test
    public void testImportHTDToBankAccount() throws Exception {
        bankAccount = bankAccountUpdater.importHTDToBankAccount(bankAccount, parserCsvBZWBK.parseDocument());
        assertNotNull(bankAccount);
        assertTrue(bankAccount.getHistory().size() == 199);
        assertEquals(bankAccount.getValue(), 730.48);

        bankAccount = bankAccountUpdater.importHTDToBankAccount(bankAccount, parserCsvBZWBK.parseDocument());
        assertNotNull(bankAccount);
        assertTrue(bankAccount.getHistory().size() == 199);
        assertEquals(bankAccount.getValue(), 730.48);
    }
}
