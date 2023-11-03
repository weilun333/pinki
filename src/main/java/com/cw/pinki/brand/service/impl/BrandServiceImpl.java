package com.cw.pinki.brand.service.impl;

import com.cw.pinki.brand.dao.BrandMapper;
import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.dto.BrandLoginDto;
import com.cw.pinki.common.exception.DescribeException;
import com.cw.pinki.common.token.VerificationToken;
import com.cw.pinki.common.token.VerificationTokenRepository;
import com.cw.pinki.common.vo.Brand;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.cw.pinki.common.exception.ExceptionEnum.*;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    // 品牌註冊
    @Override
    public Brand register(Brand brand) {
        if (verifyInfo(brand)) {
            brand.setBrandName(brand.getBrandName());
            brand.setDesignerAccount(brand.getDesignerAccount());
            brand.setTaxIdNo(brand.getTaxIdNo());
        }
        brand.setDesignerPassword(passwordEncoder.encode(brand.getDesignerPassword()));
        // TODO: 圖片插入
        brand.setBrandTel(brand.getBrandTel() == null ? null : brand.getBrandTel());
        brand.setBrandAddr(brand.getBrandAddr() == null ? null : brand.getBrandAddr());
        brand.setBankNo(brand.getBankNo());
        brand.setBankAccount(brand.getBankAccount());
        brand.setBrandStory(brand.getBrandStory());
        brand.setBrandLogo(brand.getBrandLogo() == null ? null : brand.getBrandLogo());
        brand.setCoverPic(brand.getCoverPic() == null ? null : brand.getCoverPic());
        brand.setProcessUser(brand.getBrandName());
        brandMapper.saveBrandInfo(brand);
        return brand;
    }

    @Override
    public void login(BrandLoginDto dto) {
        String account = dto.getDesignerAccount();
        if (brandMapper.findIfDesignerAccountExist(account) == 0) {
            log.error("輸入的帳號{}：不存在，請確認!", account);
            throw new DescribeException(INCORRECT_PASSWORD_ACCOUNT);
        } else if (!passwordEncoder.matches(dto.getDesignerPassword(), brandMapper.findPasswordByAccount(account))) {
            log.error("帳號{}：密碼輸入錯誤!", account);
            throw new DescribeException(INCORRECT_PASSWORD_ACCOUNT);
        }
    }

    @Override
    public boolean logout(String designerAccount) {
        return true;
    }

    @Override
    @Transactional
    public void createVerification(Brand brand, String token) {
        VerificationToken registerToken = new VerificationToken(token, brand);
        tokenRepository.save(registerToken);
    }


    @Override
    @Transactional
    public VerificationToken getVerification(String verificationToken) {
        return tokenRepository.findByToken(verificationToken);
    }

    @Override
    @Transactional
    public Brand getDesigner(String verificationToken) {
        return tokenRepository.findByToken(verificationToken).getBrand();
    }

    @Override
    @Transactional
    public void enableDesignerAccount(Brand brand) {
        brandMapper.updateAccountStatus(brand);
    }

    // 驗證註冊輸入內容
    private boolean verifyInfo(Brand brand) {
        if (brand == null) {
            log.error("註冊訊息不得為空");
            throw new DescribeException(INCOMPLETE_INFO);
        }
        if (brandMapper.findIfBrandNameExist(brand.getBrandName()) > 0) {
            log.error("品牌{}名稱重複，請更換", brand.getBrandName());
            throw new DescribeException(DUPLICATED_NAME);
        }
        if (brandMapper.findIfDesignerAccountExist(brand.getDesignerAccount()) > 0) {
            log.error("帳號{}已存在，請更換", brand.getDesignerAccount());
            throw new DescribeException(DUPLICATED_ACCOUNT);
        }
        if (!checkTaxId(brand.getTaxIdNo())) {
            log.error("統一編號不存在，請重新確認");
            throw new DescribeException(INCORRECT_INFO);
        }
        return true;
    }

    // 判斷統一編號格式
    private boolean checkTaxId(String taxIdNo) {
        int z1 = 0;
        int z2 = 0;
        for (int i = 0; i < taxIdNo.length(); i++) {
            int n = Character.getNumericValue(taxIdNo.charAt(i));
            if (i == 6) {
                if (n == 7) {
                    z1 += 1;
                    z2 += 0;
                } else {
                    z1 += addNum(n * 4);
                    z2 += addNum(n * 4);
                }
            } else if (i == 7 || i % 2 == 0) {
                z1 += n;
                z2 += n;
            } else {
                z1 += addNum(n * 2);
                z2 += addNum(n * 2);
            }
        }
        return z1 % 5 == 0 || z2 % 5 == 0;
    }

    private int addNum(int num) {
        int sum = 0;
        if (num > 9) {
            sum += num / 10;
            sum += num % 10;
        } else {
            sum += num;
        }
        return sum;
    }
}
