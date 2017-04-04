package formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by 范培忠 on 2017/2/2.
 */
public class MyFormatterRegistrar implements org.springframework.format.FormatterRegistrar {
    private String datePattern;

    public MyFormatterRegistrar(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public void registerFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new DateFormatter(datePattern));
        //此处可以注册很多个formatter
    }
}
