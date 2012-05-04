package sweethome.homeExpenses.server.domain;

/**
 * Created by IntelliJ IDEA.
 * User: Barteus
 * Date: 01.05.12
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class SpendingCategory {
    private String name;
    private double monthLimit;
    private boolean strictLimit;

    public SpendingCategory(String name, double monthLimit, boolean strictLimit) {
        this.name = name;
        this.monthLimit = monthLimit;
        this.strictLimit = strictLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(double monthLimit) {
        this.monthLimit = monthLimit;
    }

    public boolean isStrictLimit() {
        return strictLimit;
    }

    public void setStrictLimit(boolean strictLimit) {
        this.strictLimit = strictLimit;
    }
}
