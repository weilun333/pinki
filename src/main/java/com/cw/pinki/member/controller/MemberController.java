package com.cw.pinki.member.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import com.cw.pinki.common.dto.MemberLoginInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cw.pinki.common.vo.Member;
import com.cw.pinki.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
@Tag(name = "Member Info Management", description = "會員資訊管理")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signUp")
    @Operation(tags = "signUp", description = "會員帳號註冊")
    public Integer memberSignUp(HttpSession session, @Validated @RequestBody Member member) {
        return memberService.memberSignUp(member);
    }

    @PostMapping("/signIn")
    @Operation(tags = "signIn", description = "會員登入")
    public Integer memberSignIn(HttpSession session, @Validated @RequestBody MemberLoginInfoDto dto) {
        return memberService.memberSignIn(dto);
    }

    @PostMapping("/checkMailExists")
    @Operation(tags = "checkMailExists", description = "檢查信箱是否存在")
    public boolean checkMailExists(HttpSession session, @Validated @RequestBody String mail) {
        return memberService.checkMailExists(mail);
    }

}
