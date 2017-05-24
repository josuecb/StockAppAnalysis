import bin.analysis.Element;
import bin.analysis.Row;
import bin.analysis.Table;
import bin.download.YahooFileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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

        Table t = new Table();
        List<String> rows = Arrays.asList(yd.getString().split("\n"));
        for (String r : rows) {
            Row mr = new Row();
            for (String e : r.split(","))
                mr.add(new Element(e));

            t.add(mr);
        }
//        Stock a = new Stock("JPM", 91.309998, 90.68);
//
//        a.display();
    }
}
