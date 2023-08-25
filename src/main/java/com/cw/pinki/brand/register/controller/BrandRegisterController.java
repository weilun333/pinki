package com.cw.pinki.brand.register.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@Tag(name = "test1", description = "test2")
public class BrandRegisterController {
    @PostMapping("/post")
    @Operation(description = "post")
    public String post(){
        return "post";
    }

}
