package com.cw.pinki.brand.service.impl;

import com.cw.pinki.brand.dao.ProdTypeDao;
import com.cw.pinki.brand.service.ProdTypeService;
import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdTypeServiceImpl implements ProdTypeService {
    @Autowired
    private ProdTypeDao prodTypeDao;

    // 商品主類別 由admin設定
    @Override
    public ProdCategory addProdCategory(String prodCategoryName) {
        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setProdCategoryName(prodCategoryName);
        return prodTypeDao.insertProdCategory(prodCategory);
    }

    @Override
    public ProdCategory changeProdCategoryName(String prodCategoryName) {
        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setProdCategoryName(prodCategoryName);
        return prodTypeDao.updateProdCategory(prodCategory);
    }

    @Override
    public boolean deleteProdCategory(Integer prodCategoryNo) {
        // TODO: 查詢商品列表中無此分類才可刪除
        return prodTypeDao.deleteProdCategory(prodCategoryNo);
    }

    // 商品標籤 designer自訂
    @Override
    public ProdLabel addProdLabel(ProdLabel prodLabel) {
        return prodTypeDao.insertProdLabel(prodLabel);
    }

    @Override
    public ProdLabel changeProdLabelName(ProdLabel prodLabel) {
        return prodTypeDao.updateProdLabel(prodLabel);
    }

    @Override
    public boolean deleteProdLabel(Integer prodLabelNo) {
        // TODO: 查詢商品列表中無此分類才可刪除  or 刪除標籤時 商品有相關標籤要清除
        return prodTypeDao.deleteProdLabel(prodLabelNo);
    }

}
