package com.cw.pinki.brand.service;

import com.cw.pinki.common.dto.BrandLoginDto;
import com.cw.pinki.common.token.VerificationToken;
import com.cw.pinki.common.vo.Brand;


public interface BrandService {
    Brand register(Brand brand);

    void login(BrandLoginDto dto);

    boolean logout(String designerAccount);

    void createVerification(Brand brand, String token);

    VerificationToken getVerification(String verificationToken);

    Brand getDesigner(String verificationToken);

    void enableDesignerAccount(Brand brand);
}
