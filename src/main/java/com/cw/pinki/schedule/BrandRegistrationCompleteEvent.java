package com.cw.pinki.schedule;

import com.cw.pinki.common.vo.Brand;

import java.util.Locale;

public class BrandRegistrationCompleteEvent extends RegistrationCompleteEvent {
    private Brand brand;

    public BrandRegistrationCompleteEvent(Brand brand, String appUrl, Locale locale) {
        super(brand, appUrl, locale);
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
