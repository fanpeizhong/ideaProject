package formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 范培忠 on 2017/2/2.
 */
public class DateFormatter implements Formatter<Date>{
    private String datePattern;
    private SimpleDateFormat simpleDateFormat;

    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.simpleDateFormat = new SimpleDateFormat(datePattern);
        this.simpleDateFormat.setLenient(false);
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format.Please use the pattern \"" + datePattern + "\"");
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        return simpleDateFormat.format(date);
    }
}
