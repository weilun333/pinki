package com.cw.pinki.activity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
@Tag(name = "test1", description = "test3")
public class TestController {
    @PostMapping("/post")
    @Operation(description = "post")
    public String post() {
        return "post";
    }


}
