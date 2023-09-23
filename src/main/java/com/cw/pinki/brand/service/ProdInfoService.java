package com.cw.pinki.brand.service;

import com.cw.pinki.common.vo.ProdInfo;
import com.cw.pinki.common.vo.ProdPic;

public interface ProdInfoService {


    int addProdPic(ProdPic prodPic);

    void addProdInfo(ProdInfo prodInfo);
}
