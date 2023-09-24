package com.cw.pinki.member.dao;

import com.cw.pinki.common.dto.MemberLoginInfoDto;
import com.cw.pinki.common.vo.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    /** 檢核信箱是否存在 */
    Integer checkMailExists(@Param("mail") String mail);

    /** 新增會員帳號 */
    Integer addAnMemberAccount(@Param("member") Member member);

    /** 會員登入 */
    Integer findMemberNoByMemberLoginInfoDto(@Param("dto") MemberLoginInfoDto dto);
}
