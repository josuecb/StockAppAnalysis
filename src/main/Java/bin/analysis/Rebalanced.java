package bin.analysis;

import java.util.ArrayList;

/**
 * Created by Josue on 5/24/2017.
 */
public class Rebalanced extends ArrayList<Stock> {
    public double getRebalancedInvestment() {
        double rebalanced = 0;
        for (Stock stock : this) rebalanced += stock.remaining_balance();

        return rebalanced / this.size();
    }

    public double getCumulativeActualProfitLost() {
        double rebalanced = 0;
        for (Stock stock : this) rebalanced += stock.actual_profit();

        return rebalanced;
    }

    public double getInvestment() {
        return this.get(0).investment;
    }

    public String getPeriod() {
        return "Period:, from:" + this.get(0).getMonDate() + ",to:" + this.get(0).getFriDate();
    }

    public String displayTable() {
        String headerLabels = "Name,Mon open,Fri Open,Prof/Loss,Pct Prof/Loss,Investment Amt,Actual Prof/Loss,Remaining Balance";
//        System.out.println(headerLabels);
        StringBuilder companyRow = new StringBuilder();
        for (Stock stock : this) {
            companyRow.append(stock.stockName).append(",").append(stock.monOpen).append(",").append(stock.friOpen).append(",").append(stock.prof_loss()).append(",").append(stock.pct_profit()).append(",").append(stock.investment).append(",").append(stock.actual_profit()).append(",").append(stock.remaining_balance()).append("\n");
//            System.out.println(companyRow);
        }

        String totalBalances = ",,,,Total," + this.getInvestment() + "," + this.getCumulativeActualProfitLost() + "," + this.getRebalancedInvestment();

//        System.out.println("Rebalances Investement: " + this.getRebalancedInvestment());
//        System.out.println("Actual Profit Amount Loss: " + this.getCumulativeActualProfitLost());
//        System.out.println("Investement: " + this.getInvestment());

        return this.getPeriod() + "\n" + headerLabels + "\n" + companyRow + totalBalances + "\n\n";
    }
}
