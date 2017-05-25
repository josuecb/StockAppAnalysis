import bin.Helpers;
import bin.analysis.*;
import bin.download.YahooFileDownloader;
import bin.yahoo.YahooLinkGen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Created by Josue on 5/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        String testFileAbsolutePath = System.getProperty("user.dir") + File.separator + "test.csv";
        String[] comapnies = {
                "GOOG",
                "AAPL",
                "AMZN",
                "NFLX",
                "DIS",
                "NVDA",
                "WMT",
                "VZ",
                "NKE",
                "MCD"
        };

        ArrayList<Table> tables = new ArrayList<>();

        // Download data from all companies
        for (String company : comapnies) {
            System.out.println("Downloading " + company + " table...");
            YahooLinkGen y = new YahooLinkGen(company);
////        from interval
            y.setIntervalDate(3, 13, 2017, true);
////        to interval
            y.setIntervalDate(5, 24, 2017, false);
////
            YahooFileDownloader yd = new YahooFileDownloader(y);
            tables.add(new Table(company, yd.getString()));
        }

        String res = Helpers.getResults(tables, null, 15000, "");
        try {
            Files.write(Paths.get(testFileAbsolutePath), res.getBytes(), StandardOpenOption.CREATE);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
