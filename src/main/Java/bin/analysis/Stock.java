package bin.analysis;

/**
 * Created by Josue on 5/15/2017.
 */
public class Stock {
    String stockName;
    double monOpen;
    double friClose;
    double investment;

    public Stock(String name, double mon, double fri) {
        this.stockName = name;
        this.monOpen = mon;
        this.friClose = fri;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public double prof_loss() {
        return this.monOpen - this.friClose;
    }

    public double pct_profit() {
        return (this.prof_loss() / this.monOpen) * 100;
    }

    public double actual_profit() {
        return (this.investment * this.pct_profit()) / 100;
    }

    public double remaining_balance() {
        return this.investment - (this.actual_profit() / this.prof_loss());
    }

    public void display() {
        System.out.println(this.prof_loss());
    }

}
