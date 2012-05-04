package sweethome.homeExpenses.server.service.parser.csvTransactionParser.BZWBK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sweethome.homeExpenses.server.domain.BZWBK.HistoricalTransactionDocumentBZWBK;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 30.04.12
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../../spring-config-tests.xml")
public class TransactionParserCsvBZWBKTest {

    @Autowired
    private TransactionParserCsvBZWBK transactionParserCsvBZWBK;

    @Test
    public void testParseDocument() throws Exception {
        HistoricalTransactionDocumentBZWBK historicalTransactionDocument 
                = (HistoricalTransactionDocumentBZWBK) transactionParserCsvBZWBK.parseDocument();
        assertNotNull(historicalTransactionDocument);
        assertFalse(historicalTransactionDocument.getHistoricalTransactions().isEmpty());
        assertEquals(historicalTransactionDocument.getAccountNumber(),"23 1090 2082 0000 0001 0610 0773");
        assertEquals(historicalTransactionDocument.getPersonalData(), "BARTŁOMIEJ PONIECKI-KLOTZ  UL. KAMIENNA 66/9 59-300 LUBIN DOLNOŚLĄSKIE");
        assertEquals(historicalTransactionDocument.getNumberOfTransactions(), historicalTransactionDocument.getHistoricalTransactions().size());
        assertEquals(historicalTransactionDocument.getCurrency(), "PLN");
    }
}
