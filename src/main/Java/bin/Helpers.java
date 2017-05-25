package bin;

import bin.analysis.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Josue on 5/24/2017.
 */
public class Helpers {
    public static int dateToDayOfWeek(int dd, int mm, int yyyy) throws ParseException {
        String someDate = mm + "-" + dd + "-" + yyyy;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = sdf.parse(someDate);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int dateToDayOfWeek(String someDate) throws ParseException {
//        System.out.println(someDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(someDate);

        return date.getDay();
    }

    public static String getResults(ArrayList<Table> tables, String someDate, double initialInvestment, String resultTable) {
        Row monday;
        Row friday = null;

        Rebalanced rebalanced = new Rebalanced();
        for (Table t : tables) {
            if (someDate == null)
                monday = t.getFirstMonday();
            else
                monday = t.getDayAfter(WeekDays.MONDAY, someDate);

            if (monday != null) {
                friday = t.getDayAfter(WeekDays.FRIDAY, monday.get(QuoteRequest.DATE));
                if (friday != null) {
                    Stock s = new Stock(t.getCompanyName(), Double.parseDouble(monday.get(QuoteRequest.OPEN)), Double.parseDouble(friday.get(QuoteRequest.OPEN)));
                    s.setMonDate(monday.get(QuoteRequest.DATE));
                    s.setFriDate(friday.get(QuoteRequest.DATE));

                    s.setInvestment(initialInvestment);
                    rebalanced.add(s);
                } else {
                    System.out.println("STOP LOOPING");
                    return resultTable;
                }
            } else {
                System.out.println("STOP LOOPING");
                return resultTable;
            }
        }

        resultTable += rebalanced.displayTable();

        if (tables.size() > 0)
            return Helpers.getResults(tables, friday.get(QuoteRequest.DATE), rebalanced.getRebalancedInvestment(), resultTable);

        return resultTable;
    }
}
