package com.cw.pinki.brand.dao;

import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabelConfig;

import java.util.List;

public interface ProdTypeDao {
    // 商品類別
    List<ProdCategory> getAllCategory();

    int findByProdCategoryName(String prodCategoryName);

    void insertProdCategory(ProdCategory prodCategory);

    void updateProdCategory(ProdCategory prodCategory);

    boolean deleteProdCategory(Integer prodCategoryNo);

    // 商品標籤
    List<ProdLabelConfig> getAllProdLabel(Integer brandNo);

    int findByProdLabelName(String prodLabelName, Integer brandNo);

    void insertProdLabel(ProdLabelConfig prodLabel);

    void updateProdLabel(ProdLabelConfig prodLabel);

    boolean deleteProdLabel(Integer prodLabelNo);

}
