package com.cw.pinki.brand.service.impl;

import com.cw.pinki.brand.dao.ProdTypeDao;
import com.cw.pinki.brand.service.ProdTypeService;
import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabelConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ProdTypeServiceImpl implements ProdTypeService {
    @Autowired
    private ProdTypeDao prodTypeDao;

    // 商品主類別 由admin設定
    @Override
    public List<ProdCategory> getAllProdCategory() {
        return prodTypeDao.getAllCategory();
    }

    @Override
    public boolean addProdCategory(List<String> categoryName) {
        if (categoryName.isEmpty()) return false;
        for (String name : categoryName) {
            if (prodTypeDao.findByProdCategoryName(name) == -1) {
                log.error("商品類別名稱已存在，新增失敗");
                return false;
            }
            ProdCategory prodCategory = new ProdCategory();
            prodCategory.setProdCategoryName(name);
            prodTypeDao.insertProdCategory(prodCategory);
        }
        log.info("商品類別新增成功");
        return true;
    }

    @Override
    public void changeProdCategoryName(String prodCategoryName) {
        int prodCategoryNo = prodTypeDao.findByProdCategoryName(prodCategoryName);
        if (prodCategoryNo != -1) {
            ProdCategory prodCategory = new ProdCategory();
            prodCategory.setProdCategoryName(prodCategoryName);
            prodCategory.setProdCategoryNo(prodCategoryNo);
            prodTypeDao.updateProdCategory(prodCategory);
        }
    }

    @Override
    public boolean deleteProdCategory(Integer prodCategoryNo) {
        // TODO: 查詢商品列表中無此分類才可刪除
        return prodTypeDao.deleteProdCategory(prodCategoryNo);
    }

    @Override
    public List<ProdLabelConfig> getAllProdLabel(Integer brandNo) {
        return prodTypeDao.getAllProdLabel(brandNo);
    }

    // 商品標籤 designer自訂
    @Override
    public boolean addProdLabel(Integer brandNo, List<String> prodLabel) {
        if (prodLabel == null || prodLabel.isEmpty()) return false;
        for (String labelName : prodLabel) {
            if(prodTypeDao.findByProdLabelName(labelName, brandNo) == -1){
                log.error("商品標籤已存在，新增失敗");
                return false;
            }
            ProdLabelConfig prodLabelConfig = new ProdLabelConfig();
            prodLabelConfig.setBrandNo(brandNo);
            prodLabelConfig.setProdLabelName(labelName);
            prodTypeDao.insertProdLabel(prodLabelConfig);
        }
        log.info("品牌編號{} 設定商品標籤成功", brandNo);
        return true;
    }

    @Override
    public void changeProdLabelName(Integer brandNo, String prodLabel) {
        int prodLabelConfigNo = prodTypeDao.findByProdLabelName(prodLabel,brandNo);
        if(prodLabelConfigNo != -1){
            ProdLabelConfig prodLabelConfig = new ProdLabelConfig();
            prodLabelConfig.setProdLabelName(prodLabel);
            prodLabelConfig.setBrandNo(brandNo);
            prodLabelConfig.setProdLabelConfigNo(prodLabelConfigNo);
            prodTypeDao.updateProdLabel(prodLabelConfig);
        }
    }

    @Override
    public boolean deleteProdLabel(Integer prodLabelNo) {
        // TODO: 查詢商品列表中無此分類才可刪除  or 刪除標籤時 商品有相關標籤要清除
        return prodTypeDao.deleteProdLabel(prodLabelNo);
    }

}
