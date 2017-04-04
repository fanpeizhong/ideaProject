package converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 范培忠 on 2017/1/30.
 */
public class StringToDateConverter implements Converter<String, Date>{
    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        simpleDateFormat.setLenient(false);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    "日期输入错误.请按此格式输入：\""
                            + datePattern + "\"");
        }
    }
}
