package com.cw.pinki.brand.controller;

import com.cw.pinki.brand.service.ProdTypeService;
import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabelConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/prod")
@Tag(name = "product info management", description = "商品資訊管理")
public class ProdInfoController {
    @Autowired
    private ProdTypeService prodTypeService;

    @GetMapping("/category/list")
    @Operation(tags = "prod", description = "顯示所有商品類別")
    public List<ProdCategory> getAllProdCategory() {
        return prodTypeService.getAllProdCategory();
    }

    @PostMapping("/category/setting")
    @Operation(tags = "prod", description = "設置商品類別")
    public boolean setProdCategory(@RequestBody List<String> prodCategory) {
        return prodTypeService.addProdCategory(prodCategory);
    }

    @GetMapping("/category/updateName")
    @Operation(tags = "prod", description = "修改商品類別名稱")
    public boolean changeProdCategoryName(@RequestParam String prodCategoryName) {
        if (prodCategoryName == null || prodCategoryName.isEmpty()) {
            log.error("商品類別名稱不得為空");
            return false;
        }
        prodTypeService.changeProdCategoryName(prodCategoryName);
        log.info("商品類別名稱修改成功");
        return true;
    }

    @GetMapping("/label/list")
    @Operation(tags = "prod", description = "顯示所有商品標籤")
    public List<ProdLabelConfig> getAllProdLabel(HttpSession httpSession) {
        int brandNo = (Integer) httpSession.getAttribute("brandNo");
        return prodTypeService.getAllProdLabel(brandNo);
    }

    @PostMapping("/label/setting")
    @Operation(tags = "prod", description = "設定商品標籤")
    public boolean setProdLabel(HttpSession httpSession, @RequestBody List<String> prodLabel) {
        int brandNo = (Integer) httpSession.getAttribute("brandNo");
        return prodTypeService.addProdLabel(brandNo, prodLabel);
    }

    @GetMapping("/label/updateName")
    @Operation(tags = "prod", description = "修改商品標籤")
    public boolean changeProdLabelName(HttpSession httpSession, @RequestParam String prodLabelName) {
        int brandNo = (Integer) httpSession.getAttribute("brandNo");
        if (prodLabelName == null || prodLabelName.isEmpty()) {
            log.error("商品標籤不得為空");
            return false;
        }
        prodTypeService.changeProdLabelName(brandNo, prodLabelName);
        log.info("品牌編號:{}，修改商品標籤成功", brandNo);
        return true;
    }



    @PostMapping("/pic")
    public void addProdPic() {

    }

    @PostMapping("/info")
    public void addProd() {

    }

}
