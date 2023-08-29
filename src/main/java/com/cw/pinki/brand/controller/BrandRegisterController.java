package com.cw.pinki.brand.controller;

import com.cw.pinki.common.vo.Brand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/brand")
@Tag(name ="Brand Info Management", description = "品牌資訊管理")
public class BrandRegisterController {
    @PostMapping("/register")
    @Operation(tags = "register",description = "品牌帳號註冊")
    public void brandRegister(@RequestBody Brand brand){
        log.info("品牌註冊成功");
    }

}
