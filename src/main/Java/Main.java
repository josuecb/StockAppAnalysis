import bin.FileDownloader;
import bin.download.YahooFileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        String testFileAbsolutePath = System.getProperty("user.dir") + File.separator + "test.csv";

//        YahooFileDownloader y = new YahooFileDownloader();
        String someDate = "10-29-2017";
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = null;
        try {
            date = sdf.parse(someDate);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
