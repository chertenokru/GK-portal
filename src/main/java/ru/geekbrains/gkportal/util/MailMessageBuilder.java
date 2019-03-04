package ru.geekbrains.gkportal.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static ru.geekbrains.gkportal.config.TemplateNameConst.REGISTRATION_MAIL;
import static ru.geekbrains.gkportal.config.TemplateNameConst.REGISTRATION_QUESTIONNAIRE_MAIL;

@Service
public class MailMessageBuilder {

    private static final Logger logger = Logger.getLogger(MailMessageBuilder.class);

    private static final String VARIABLE_REGISTRATION_USER = "user";
    private static final String VARIABLE_REGISTRATION_PASSWORD = "password";


    private TemplateEngine templateEngine;

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildRegistrationEmail() {
        Context context = new Context();
        context.setVariable(VARIABLE_REGISTRATION_USER, "Юрий");
        context.setVariable(VARIABLE_REGISTRATION_PASSWORD, "gccasjbc33j4b");
        return templateEngine.process(REGISTRATION_MAIL, context);
    }

    public String buildRegistrationEmail(String userName, String url) {
        Context context = new Context();
        context.setVariable(VARIABLE_REGISTRATION_USER, userName);
        context.setVariable(VARIABLE_REGISTRATION_PASSWORD, url);
        return templateEngine.process(REGISTRATION_MAIL, context);
    }

    public String buildRegistrationQuestionEmail(String userName, String url) {
        Context context = new Context();
        context.setVariable(VARIABLE_REGISTRATION_USER, userName);
        context.setVariable(VARIABLE_REGISTRATION_PASSWORD, url);
        return templateEngine.process(REGISTRATION_QUESTIONNAIRE_MAIL, context);
    }

    public String buildUserToUserMessage() {
        return "";
    }

}
