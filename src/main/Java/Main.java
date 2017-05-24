import bin.Helpers;
import bin.analysis.QuoteRequest;
import bin.analysis.Row;
import bin.analysis.Table;
import bin.download.YahooFileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.File;
import java.text.ParseException;

/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        String testFileAbsolutePath = System.getProperty("user.dir") + File.separator + "test.csv";

        YahooLinkGen y = new YahooLinkGen("JPM");
////        from interval
        y.setIntervalDate(2, 1, 2017, true);
////        to interval
        y.setIntervalDate(4, 1, 2017, false);
//
        YahooFileDownloader yd = new YahooFileDownloader(y);

        Table t = new Table(yd.getString());
        Row dateData = t.getDataByDate(22, 3, 2017);
        dateData.get(QuoteRequest.CLOSE);

        System.out.println((t.getFirstMonday() == null ? "No found" : t.getFirstMonday().toString()));


//        Stock a = new Stock("JPM", 91.309998, 90.68);
//
//        a.display();
    }
}
