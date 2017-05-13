import bin.FileDownloader;
import bin.yahoo.YahooLinkGen;


/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        YahooLinkGen y = new YahooLinkGen("AAPL");
        // from interval
        y.setIntervalDate(1, 1, 2016, true);
        // to interval
        y.setIntervalDate(1, 1, 2017, false);
        FileDownloader d;
        try {
            System.out.println(y.getLink());

            d = new FileDownloader(y.getLink());
            d.start("C:\\Users\\Josue\\IdeaProjects\\StockAppAnalysis\\src\\main\\Java\\test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
