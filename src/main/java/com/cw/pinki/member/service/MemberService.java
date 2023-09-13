package com.cw.pinki.member.service;

import com.cw.pinki.common.dto.MemberLoginInfoDto;
import com.cw.pinki.common.vo.Member;

public interface MemberService {

	boolean checkMailExists(String mail);

	Integer memberSignUp(Member member);

	Integer memberSignIn(MemberLoginInfoDto dto);

}