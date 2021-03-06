package bin.analysis;

/**
 * Created by Josue on 5/24/2017.
 */
public enum QuoteRequest {
    DATE(0),
    OPEN(1),
    HIGH(2),
    LOW(3),
    CLOSE(4),
    ADJ_CLOSE(5),
    VOL(6);

    private final int tag;

    QuoteRequest(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return this.tag;
    }
}
