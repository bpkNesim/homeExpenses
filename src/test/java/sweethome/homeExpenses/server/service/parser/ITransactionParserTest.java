package sweethome.homeExpenses.server.service.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sweethome.homeExpenses.server.domain.HistoricalTransactionDocument;
import sweethome.homeExpenses.server.service.parser.csvTransactionParser.ITransactionParser;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 27.04.12
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../spring-config-tests.xml")
public class ITransactionParserTest {

    @Autowired
    ITransactionParser ITransactionParser;

    @Test
    public void testParseDocument() throws Exception {
        HistoricalTransactionDocument historicalTransactionDocument = ITransactionParser.parseDocument();
        assertNotNull(historicalTransactionDocument);
        assertFalse(historicalTransactionDocument.getHistoricalTransactions().isEmpty());
    }
}
