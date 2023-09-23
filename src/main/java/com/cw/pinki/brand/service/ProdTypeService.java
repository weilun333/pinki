package com.cw.pinki.brand.service;

import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabel;

public interface ProdTypeService {
    ProdCategory addProdCategory(String prodCategoryName);

    ProdCategory changeProdCategoryName(String prodCategoryName);

    boolean deleteProdCategory(Integer prodCategoryNo);

    ProdLabel addProdLabel(ProdLabel prodLabel);

    ProdLabel changeProdLabelName(ProdLabel prodLabel);

    boolean deleteProdLabel(Integer prodLabelNo);
}
