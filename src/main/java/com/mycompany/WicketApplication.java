package com.mycompany;

import com.github.sommeri.less4j.LessCompiler.Configuration;
import de.agilecoders.wicket.less.BootstrapLess;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();

        BootstrapLess.install(this, Configuration::new);
    }
}
