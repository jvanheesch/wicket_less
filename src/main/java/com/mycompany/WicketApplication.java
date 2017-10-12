package com.mycompany;

import com.github.sommeri.less4j.LessCompiler.Configuration;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.DefaultThemeProvider;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.Theme;
import de.agilecoders.wicket.less.BootstrapLess;
import de.agilecoders.wicket.less.LessResourceReference;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();

        IBootstrapSettings bootstrapSettings = this.getBootstrapSettings();
        Bootstrap.install(this, bootstrapSettings);
        BootstrapLess.install(this, Configuration::new);
    }

    private IBootstrapSettings getBootstrapSettings() {
        // BootstrapSettings constructor: this.activeThemeProvider = new SessionThemeProvider() --> nice !
        return new BootstrapSettings()
                .useCdnResources(false)
                .setThemeProvider(new DefaultThemeProvider()
                        .add(new Theme("theme1", new LessResourceReference(WicketApplication.class, "theme1.less")))
                        .add(new Theme("theme2", new LessResourceReference(WicketApplication.class, "theme2.less")))
                );
    }

    @Override
    public Session newSession(Request request, Response response) {
        Session session = super.newSession(request, response);
        session.setStyle("theme1");
        return session;
    }
}
