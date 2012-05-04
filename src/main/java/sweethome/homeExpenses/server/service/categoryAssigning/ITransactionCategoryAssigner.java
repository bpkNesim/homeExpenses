package sweethome.homeExpenses.server.service.categoryAssigning;

import org.springframework.stereotype.Service;
import sweethome.homeExpenses.server.domain.SpendingCategory;
import sweethome.homeExpenses.server.domain.Transaction;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */

public interface ITransactionCategoryAssigner {

    public boolean assignToCategory(Transaction transaction, SpendingCategory spendingCategory);

    public boolean designFromCategory(Transaction transaction);

    public boolean addCategory(SpendingCategory spendingCategory);

    public boolean deleteCategory(SpendingCategory spendingCategory);

    public boolean editCategory(String categoryName, SpendingCategory spendingCategory);
}
