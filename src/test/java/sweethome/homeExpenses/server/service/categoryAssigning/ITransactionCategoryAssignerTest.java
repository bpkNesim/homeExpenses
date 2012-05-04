package sweethome.homeExpenses.server.service.categoryAssigning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sweethome.homeExpenses.server.domain.SpendingCategory;
import sweethome.homeExpenses.server.domain.Transaction;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Klotzu
 * Date: 02.05.12
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../spring-config-tests.xml")
public class ITransactionCategoryAssignerTest {

    @Autowired
    private ITransactionCategoryAssigner transactionCategoryAssigner;

    @Test
    public void testAssignToCategory() throws Exception {
         Transaction transaction = new Transaction();
        SpendingCategory spendingCategory = new SpendingCategory("categ1", 1000, false);
        assertTrue(transactionCategoryAssigner.assignToCategory(transaction, spendingCategory));
        assertEquals(transaction.getSpendingCategory(), spendingCategory);
        transaction.setSpendingCategory(null);
        assertNull(transaction.getSpendingCategory());
    }

    @Test
    public void testDesignFromCategory() throws Exception {

    }

    @Test
    public void testAddCategory() throws Exception {

    }

    @Test
    public void testDeleteCategory() throws Exception {

    }

    @Test
    public void testEditCategory() throws Exception {

    }
}
