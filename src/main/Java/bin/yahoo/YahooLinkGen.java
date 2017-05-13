package bin.yahoo;

/**
 * Created by Josue on 5/13/2017.
 */
public class YahooLinkGen {
    protected String yahooLinkChar = "https://ichart.yahoo.com/table.csv?s=";
    protected String companyName;
    protected String interval;
    protected String type;

    public YahooLinkGen(String companyName) {
        this.companyName = companyName;
        interval = "";
        type = "";
    }

    public void setIntervalDate(int dd, int mm, int yyyy, boolean from) {
        if (from) {
            if (this.interval.isEmpty())
                this.interval = "&a=" + dd + "&b=" + mm + "&c=" + yyyy;
            else
                this.interval += "&a=" + dd + "&b=" + mm + "&c=" + yyyy;
        } else {
            if (this.interval.isEmpty())
                this.interval = "&d=" + dd + "&e=" + mm + "&f=" + yyyy;
            else
                this.interval += "&d=" + dd + "&e=" + mm + "&f=" + yyyy;

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

        return yahooLinkChar + this.companyName + interval + this.type +  "&ignore=.csv";
    }
}