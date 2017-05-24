package bin.analysis;

import java.util.ArrayList;

/**
 * Created by Josue on 5/24/2017.
 */
public class Row extends ArrayList<Element> {
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            r.append(this.get(i).getData()).append(",");
        }
        return String.valueOf(r);
    }

    @Override
    public Element get(int index) {
        return super.get(index);
    }

    public String get(QuoteRequest index) {
        return super.get(index.getTag()).getData();
    }
}
