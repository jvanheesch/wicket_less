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
     * More.less results in:
     * h1 {
     * color: #00ff00;
     * }
     * h2 {
     * color: #00ff00;
     * }
     * and HomePage.less results in:
     * h1 {
     * color: #ff0000;
     * }
     * In the response.render() calls are reverted, then More.less's h2 specification will override HomePage.less's.
     */
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "More.less")));
        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "HomePage.less")));
    }
}
