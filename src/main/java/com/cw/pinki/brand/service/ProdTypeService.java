package com.cw.pinki.brand.service;

import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabelConfig;

import java.util.List;

public interface ProdTypeService {
    // 商品類別
    List<ProdCategory> getAllProdCategory();

    boolean addProdCategory(List<String> categoryName);

    void changeProdCategoryName(String prodCategoryName);

    boolean deleteProdCategory(Integer prodCategoryNo);

    // 商品標籤
    List<ProdLabelConfig> getAllProdLabel(Integer brandNo);

    boolean addProdLabel(Integer brandNo, List<String> prodLabel);

    void changeProdLabelName(Integer brandNo, String prodLabel);

    boolean deleteProdLabel(Integer prodLabelNo);
}
