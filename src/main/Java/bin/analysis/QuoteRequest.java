package bin.analysis;

/**
 * Created by Josue on 5/24/2017.
 */
public enum QuoteRequest {
    DATE("Date"),
    OPEN("Open"),
    HIGH("High"),
    LOW("Low"),
    CLOSE("Close"),
    ADJ_CLOSE("Adj Close"),
    VOL("Volume");

    private final String tag;

    QuoteRequest(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }
}
