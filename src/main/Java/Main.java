import bin.FileDownloader;
import bin.download.YahooFileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.File;


/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        String testFileAbsolutePath = System.getProperty("user.dir") + File.separator + "test.csv";

        YahooFileDownloader y = new YahooFileDownloader();
//        YahooLinkGen y = new YahooLinkGen("JPM");
////        from interval
//        y.setIntervalDate(2, 1, 2017, true);
////        to interval
//        y.setIntervalDate(4, 1, 2017, false);
//
//
//        FileDownloader d;
//        try {
//            System.out.println(y.getLink());
//
//            d = new FileDownloader(y.getLink());
//            d.start(testFileAbsolutePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        Stock a = new Stock("JPM", 91.309998, 90.68);
//
//        a.display();
    }
}
