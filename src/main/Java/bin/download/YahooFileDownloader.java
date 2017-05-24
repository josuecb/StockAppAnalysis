package bin.download;

import bin.yahoo.YahooLinks;
import org.jsoup.Connection;

public class YahooFileDownloader {
    protected HTTPConnection c;

    public YahooFileDownloader() {
        c = new HTTPConnection(YahooLinks.YAHOO_LINK, Connection.Method.GET);
        try {
            Connection.Response r = c.connect();
            System.out.println(r.cookies().toString());
            c.setUrl(YahooLinks.YAHOO_CRUM);
            c.setCookies(r.cookies());
            Connection.Response res = c.connect();
            System.out.println(res.body());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
