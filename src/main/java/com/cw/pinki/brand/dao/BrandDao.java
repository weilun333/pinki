package com.cw.pinki.brand.dao;

import com.cw.pinki.common.vo.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao {

    // 查詢品牌名稱是否重複
    int findIfBrandNameExist(@Param("brandName") String brandName);

    // 查詢品牌帳號是否重複
    int findIfDesignerAccountExist(@Param("designerAccount")String designerAccount);

    // 儲存註冊資料
    int saveBrandInfo(@Param("brand") Brand brand);

}
