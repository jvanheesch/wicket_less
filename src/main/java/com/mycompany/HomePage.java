package com.mycompany;

import de.agilecoders.wicket.less.LessResourceReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
    private static final long serialVersionUID = -8896769873107976128L;

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(new LessResourceReference(HomePage.class, "HomePage.less")));
    }
}
