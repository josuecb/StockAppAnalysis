package bin.analysis;

import bin.Helpers;

import java.text.ParseException;
import java.util.*;

/**
 * Created by Josue on 5/24/2017.
 */
public class Table extends ArrayList<Row> {
    private String companyName;

    public Table() {
        super();
    }

    public Table(String companyName, String tableString) {
        this.companyName = companyName;
        List<String> rows = Arrays.asList(tableString.split("\n"));
        for (String r : rows) {
            Row mr = new Row();
            for (String e : r.split(","))
                mr.add(new Element(e));

            this.add(mr);
        }
    }

    @Override
    public boolean add(Row elements) {
//        System.out.println(elements.toString());
        return super.add(elements);
    }


    public Row getDataByDate(int dd, int mm, int yyyy) {
        String someDate = yyyy + "-" + ((mm < 10) ? ("0" + mm) : mm) + "-" + ((dd < 10) ? ("0" + dd) : dd);

        for (int i = 1; i < this.size(); i++) {
            Row dateData = this.get(i);

            if (someDate.equals(dateData.get(QuoteRequest.DATE))) {
                return dateData;
            }
        }

        return null;
    }

    public Row getFirstMonday() {
        for (int i = 1; i < this.size(); i++) {
            Row dateData = this.get(i);

            try {
                int day = Helpers.dateToDayOfWeek(dateData.get(QuoteRequest.DATE));
//                System.out.println(day);
                if (day == WeekDays.MONDAY.getTag())
                    return dateData;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Row getDayAfter(WeekDays dayOfWeek, String someDate) {
        boolean flagStart = false;
        for (int i = 1; i < this.size(); i++) {
            Row dateData = this.get(i);

            if (dateData.get(QuoteRequest.DATE).equals(someDate))
                flagStart = true;

            if (flagStart) {
                try {
                    int day = Helpers.dateToDayOfWeek(dateData.get(QuoteRequest.DATE));
                    if (day == dayOfWeek.getTag())
                        return dateData;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
