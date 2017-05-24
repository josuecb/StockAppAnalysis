package bin.download;

import bin.yahoo.Yahoo;
import org.jsoup.Connection;

public class YahooFileDownloader {
    protected HTTPConnection c;

    public YahooFileDownloader() {
        c = new HTTPConnection(Yahoo.YAHOO_LINK, Connection.Method.GET);
        try {
            Connection.Response r = c.connect();
            System.out.println(r.cookies().toString());
            c.setUrl(Yahoo.YAHOO_CRUMB_LINK);
            c.setCookies(r.cookies());
            Connection.Response res = c.connect();

            c.setUrl("https://query1.finance.yahoo.com/v7/finance/download/AAPL?&period1=1274158800&period2=1495059477&interval=1d&events=history&crumb=" + res.body());
            res = c.connect();
            System.out.println(res.body());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
