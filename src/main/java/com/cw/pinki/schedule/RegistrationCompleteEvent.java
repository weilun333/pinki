package com.cw.pinki.schedule;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Locale;


public class RegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;

    public RegistrationCompleteEvent(Object source, String appUrl, Locale locale) {
        super(source);
        this.appUrl = appUrl;
        this.locale = locale;
    }

    public RegistrationCompleteEvent(Object source, Clock clock, String appUrl, Locale locale) {
        super(source, clock);
        this.appUrl = appUrl;
        this.locale = locale;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
