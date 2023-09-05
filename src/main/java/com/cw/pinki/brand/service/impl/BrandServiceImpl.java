package com.cw.pinki.brand.service.impl;

import com.cw.pinki.brand.dao.BrandDao;
import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.exception.DescribeException;
import com.cw.pinki.common.vo.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    // 品牌註冊
    @Override
    public int register(Brand brand) {
        if (verifyInfo(brand)) {
            brand.setBrandName(brand.getBrandName());
            brand.setDesignerAccount(brand.getDesignerAccount());
            brand.setTaxIdNo(brand.getTaxIdNo());
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        brand.setDesignerPassword(passwordEncoder.encode(brand.getDesignerPassword()));
        brand.setBrandTel(brand.getBrandTel().isEmpty() ? null : brand.getBrandTel());
        brand.setBrandAddr(brand.getBrandAddr().isEmpty() ? null : brand.getBrandAddr());
        brand.setBankAccount(brand.getBankAccount());
        brand.setBrandStory(brand.getBrandStory());
        brand.setBrandLogo(brand.getBrandLogo());
        brand.setCoverPic(brand.getCoverPic());
        brand.setProcessUser(brand.getBrandName());
        return brandDao.saveBrandInfo(brand);
    }

    // 驗證註冊輸入內容
    private boolean verifyInfo(Brand brand) {
        if (brand == null) {
            throw new DescribeException("註冊訊息不得為空", 0);
        }
        if (brandDao.findIfBrandNameExist(brand.getBrandName()) > 0) {
            throw new DescribeException("品牌名稱重複，請更換", 0);
        }
        if (brandDao.findIfDesignerAccountExist(brand.getDesignerAccount()) > 0) {
            throw new DescribeException("帳號已存在，請更換", 0);
        }
        if (!checkTaxId(brand.getTaxIdNo())) {
            throw new DescribeException("統一編號不存在，請重新確認", 0);
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
