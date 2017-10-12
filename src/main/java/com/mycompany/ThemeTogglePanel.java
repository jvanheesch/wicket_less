package com.mycompany;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.ActiveThemeProvider;
import de.agilecoders.wicket.core.settings.ITheme;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import java.util.List;

public class ThemeTogglePanel extends GenericPanel<ITheme> {
    private static final long serialVersionUID = -6288147842675860023L;

    public ThemeTogglePanel(String id) {
        super(id, new ActiveThemeModel());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<?> form = new Form<Void>("form");
        this.add(form);
        RadioChoice<ITheme> radioChoice = new RadioChoice<>("radioChoice", this.getModel(), new ThemesModel());
        radioChoice.add(new AjaxFormSubmitBehavior("change") {
            private static final long serialVersionUID = -6950592584859423429L;

            @Override
            protected void onAfterSubmit(AjaxRequestTarget target) {
                super.onAfterSubmit(target);

                target.add(ThemeTogglePanel.this.getPage());
            }
        });
        form.add(radioChoice);
    }

    private static class ActiveThemeModel implements IModel<ITheme> {
        private static final long serialVersionUID = -1487977454645056263L;

        @Override
        public ITheme getObject() {
            return getActiveThemeProvider().getActiveTheme();
        }

        @Override
        public void setObject(ITheme theme) {
            getActiveThemeProvider().setActiveTheme(theme);
        }

        @Override
        public void detach() {
            // no-op
        }

        private static ActiveThemeProvider getActiveThemeProvider() {
            return Bootstrap.getSettings().getActiveThemeProvider();
        }
    }


    private static class ThemesModel extends AbstractReadOnlyModel<List<ITheme>> {
        @Override
        public List<ITheme> getObject() {
            return Bootstrap.getSettings().getThemeProvider().available();
        }
    }
}
