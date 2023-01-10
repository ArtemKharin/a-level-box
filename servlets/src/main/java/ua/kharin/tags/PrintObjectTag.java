package ua.kharin.tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PrintObjectTag extends SimpleTagSupport {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void doTag() {
        try {
            getJspContext().getOut().print(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}