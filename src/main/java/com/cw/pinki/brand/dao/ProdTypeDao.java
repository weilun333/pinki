package com.cw.pinki.brand.dao;

import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabel;

public interface ProdTypeDao {
    ProdCategory insertProdCategory(ProdCategory prodCategory);

    ProdCategory updateProdCategory(ProdCategory prodCategory);

    boolean deleteProdCategory(Integer prodCategoryNo);

    ProdLabel insertProdLabel(ProdLabel prodLabel);

    ProdLabel updateProdLabel(ProdLabel prodLabel);

    boolean deleteProdLabel(Integer prodLabelNo);

}
