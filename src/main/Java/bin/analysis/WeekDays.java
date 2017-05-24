package bin.analysis;

/**
 * Created by Josue on 5/24/2017.
 */
public enum WeekDays {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int tag;

    WeekDays(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return this.tag;
    }
}
