package ua.kharin.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class CalculateTag extends SimpleTagSupport {
    private int first;
    private int second;
    private StringWriter writer = new StringWriter();
    @Override
    public void doTag() {
        try {
            getJspBody().invoke(writer);
            getJspContext().getOut().print(calc(writer.toString()));
        } catch (IOException | JspException e) {
            throw new RuntimeException(e);
        }
    }

    private double calc(String operation) {
        return switch (operation) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("unknown operation " + operation);
        };
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}