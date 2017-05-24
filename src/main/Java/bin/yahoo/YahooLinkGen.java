package bin.yahoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Josue on 5/13/2017.
 */
public class YahooLinkGen {
    protected String companyName;
    protected String interval;
    protected String type;

    public YahooLinkGen(String companyName) {
        this.companyName = companyName;
        interval = "";
        type = "";
    }

    public void setIntervalDate(int mm, int dd, int yyyy, boolean from) {
//        switch (Yahoo.CURR_VERSION) {
//            case Yahoo.VERSION1:
//                this.setIntervalV1(mm, dd, yyyy, from);
//                break;
//            case Yahoo.VERSION2:
//                Date a = new Date(yyyy, mm, dd);
//
//        }
    }


    private void setIntervalV2(int mm, int dd, int yyyy, boolean from) throws ParseException {
        String someDate = mm + "-" + dd + "-" + yyyy;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = sdf.parse(someDate);
        System.out.println(date.getTime());

        if (from) {
            if (this.interval.isEmpty())
                this.interval = "&period1=" + date.getTime();
            else
                this.interval += "&period1=" + date.getTime();
        } else {
            if (this.interval.isEmpty())
                this.interval = "&period2=" + date.getTime();
            else
                this.interval += "&period2=" + date.getTime();
        }
//        c.setUrl("https://query1.finance.yahoo.com/v7/finance/download/AAPL?&period1=1274158800&period2=1495059477&interval=1d&events=history&crumb=" + res.body());


    }

    private void setIntervalV1(int mm, int dd, int yyyy, boolean from) {
        if (from) {
            if (this.interval.isEmpty())
                this.interval = "&a=" + mm + "&b=" + dd + "&c=" + yyyy;
            else
                this.interval += "&a=" + mm + "&b=" + dd + "&c=" + yyyy;
        } else {
            if (this.interval.isEmpty())
                this.interval = "&d=" + mm + "&e=" + dd + "&f=" + yyyy;
            else
                this.interval += "&d=" + mm + "&e=" + dd + "&f=" + yyyy;
        }
    }

    public void getType(int flag) {
        if (flag == OutputType.DAILY)
            this.type += "&g=d";
        else if (flag == OutputType.MONTHLY)
            this.type += "&g=m";
    }

    public String getLink() throws Exception {
        if (this.interval.isEmpty())
            throw new Exception("You must an interval.");

        if (this.type.isEmpty())
            this.type += "&g=d";

        return Yahoo.YAHOO_DOWNLOAD_LINK + this.companyName + interval + this.type + "&ignore=.csv";
    }
}
