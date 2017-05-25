package bin.analysis;


/**
 * Created by Josue on 5/15/2017.
 */
public class Stock {
    String stockName;
    double monOpen;
    double friOpen;
    double investment;

    private String monDate, friDate;

    public Stock(String name, double mon, double fri) {
        this.stockName = name;
//        this.monOpen = Math.floor(mon * 100) / 100;
        this.monOpen = mon;
        this.friOpen = fri;

        this.investment = 0;
//        System.out.println("MON OPEN: " + mon);
//        System.out.println("FRI OPEN: " + fri);
    }

    public String getMonDate() {
        return monDate;
    }

    public void setMonDate(String monDate) {
        this.monDate = monDate;
    }

    public String getFriDate() {
        return friDate;
    }

    public void setFriDate(String friDate) {
        this.friDate = friDate;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public double prof_loss() {
        return this.friOpen - this.monOpen;
    }

    public double pct_profit() {
        return (this.prof_loss() / this.monOpen) * 100;
    }

    public double actual_profit() {
        return (this.investment * this.pct_profit()) / 100;
    }

    public double remaining_balance() {
        return this.investment + actual_profit();
    }

    public void display() {
        System.out.println("----Company " + this.stockName + " results----");
        System.out.println("Profit Loss: " + this.prof_loss());
        System.out.println("Percentage Loss: " + this.pct_profit());
        System.out.println("Actual profit: " + this.actual_profit());
        System.out.println("Remaining balance: " + this.remaining_balance());
    }

}
