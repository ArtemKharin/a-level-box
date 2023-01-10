package ua.kharin.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.time.LocalDateTime;

public class CurrentDateTimeTag extends TagSupport {

    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.print(LocalDateTime.now());
        } catch (Exception e) {
            System.err.println(e);
        }
        return SKIP_BODY;
    }
}