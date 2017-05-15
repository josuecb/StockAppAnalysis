import bin.FileDownloader;
import bin.analysis.Stock;
import bin.yahoo.YahooLinkGen;


/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
//        YahooLinkGen y = new YahooLinkGen("JPM");
//         from interval
//        y.setIntervalDate(2, 1, 2017, true);
//         to interval
//        y.setIntervalDate(4, 1, 2017, false);
//
//        FileDownloader d;
//        try {
//            System.out.println(y.getLink());
//
//            d = new FileDownloader(y.getLink());
//            d.start("C:\\Users\\Josue\\IdeaProjects\\StockAppAnalysis\\src\\main\\Java\\test");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Stock a = new Stock("JPM", 91.309998, 90.68);

        a.display();
    }
}
