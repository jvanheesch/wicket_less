package com.mycompany;

import de.agilecoders.wicket.less.LessResourceReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
    private static final long serialVersionUID = -8896769873107976128L;

    /**
     * NOTE: THE ORDER IS OF IMPORTANCE HERE! (CASCADING Style Sheets)
     * <p>
     * Both css files seem to be compiled independently.
     * 02.less results in:
     * h1 {
     * color: #00ff00;
     * }
     * h2 {
     * color: #00ff00;
     * }
     * and 01.less results in:
     * h1 {
     * color: #ff0000;
     * }
     * In the response.render() calls are reverted, then 02.less's h2 specification will override 01.less's.
     */
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "02.less")));
        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "01.less")));
        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "03.less")));
        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "04.less")));
        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "arithmetic.less")));
    }
}
