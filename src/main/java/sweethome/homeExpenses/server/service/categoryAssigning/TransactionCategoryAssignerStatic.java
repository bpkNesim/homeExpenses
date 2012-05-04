package sweethome.homeExpenses.server.service.categoryAssigning;

import sweethome.homeExpenses.server.domain.SpendingCategory;
import sweethome.homeExpenses.server.domain.Transaction;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 14:07
 */
/*
    Categories are predefined and cant be changed.
 */
    //TODO tests for every method in class
public class TransactionCategoryAssignerStatic implements ITransactionCategoryAssigner{

    private static List<SpendingCategory> spendingCategories;

    static{
        spendingCategories = new LinkedList<SpendingCategory>();
        spendingCategories.add(new SpendingCategory("Categ1", 1000, false));
        spendingCategories.add(new SpendingCategory("Categ2", 1200, true));
        spendingCategories.add(new SpendingCategory("Categ3", 500, false));
    }

    @Override
    public boolean assignToCategory(Transaction transaction, SpendingCategory spendingCategory) {
        transaction.setSpendingCategory(spendingCategory);
        return transaction.getSpendingCategory() == spendingCategory;
    }

    @Override
    public boolean designFromCategory(Transaction transaction) {
        transaction.setSpendingCategory(null);
        return transaction.getSpendingCategory()==null;
    }

    @Override
    public boolean addCategory(SpendingCategory spendingCategory) {
        return spendingCategories.add(spendingCategory);
    }

    @Override
    public boolean deleteCategory(SpendingCategory spendingCategory) {
        return spendingCategories.remove(spendingCategory);
    }

    @Override
    public boolean editCategory(String categoryName, SpendingCategory spendingCategory) {
        for(int i=0;i<spendingCategories.size();i++){
            if(categoryName.equals(spendingCategories.get(i).getName())){
                spendingCategories.remove(spendingCategories.get(i));
                spendingCategories.add(spendingCategory);
                return true;
            }
        }
        return false;
    }
}
