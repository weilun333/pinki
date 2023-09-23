package com.cw.pinki.schedule;

import com.cw.pinki.common.vo.Brand;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Locale;


public class BrandRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;

    private Locale locale;

    private Brand brand;

    public BrandRegistrationCompleteEvent(Brand brand, Locale locale, String appUrl) {
        super(brand);
        this.appUrl = appUrl;
        this.brand = brand;
        this.locale = locale;
    }

    public BrandRegistrationCompleteEvent(Object source, Clock clock) {
        super(source, clock);
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
