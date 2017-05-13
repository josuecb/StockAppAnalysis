import bin.FileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.IOException;

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

        try {
            System.out.println(y.getLink());
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileDownloader d = null;
        try {
            d = new FileDownloader(y.getLink());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            d.start("C:\\Users\\Josue\\IdeaProjects\\StockAppAnalysis\\src\\main\\Java\\test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
