package com.cw.pinki.member.service.Impl;

import com.cw.pinki.common.dto.MemberLoginInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cw.pinki.common.exception.DescribeException;
import com.cw.pinki.common.vo.Member;
import com.cw.pinki.member.dao.MemberMapper;
import com.cw.pinki.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberDao;

    /**檢核信箱是否存在
     * @param  mail
     * @return true:已存在, false:不存在
     */
    @Override
    public boolean checkMailExists(String mail) {
        if (mail.trim().isEmpty()) {
            throw new DescribeException("會員信箱不得為空", 0);
        }
        if (memberDao.checkMailExists(mail) != 0) {
            throw new DescribeException("此信箱已註冊", 0);
        }
        return false;
    }

    /**會員註冊
     * @param   member
     * @return  memberNo
     */
    @Override
	public Integer memberSignUp(Member member) {
        if (verifyInfo(member)) {
//            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//            member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
            member.setProcessUser(member.getName());
        }
        memberDao.addAnMemberAccount(member);
        return member.getMemberNo();
    }

    /**會員登入
     * @param dto mail, memberPassword
     * @return memberNo
     */
    public Integer memberSignIn(MemberLoginInfoDto dto){
        if (dto.getMail() != null && dto.getMemberPassword() != null) {
            return memberDao.findMemberNoByMemberLoginInfoDto(dto);
            // TODO: return token
        }
        return 0;
    }

    /**資料檢核
     * @param   member
     * @return  true:驗證成功
     */
    private boolean verifyInfo(Member member) {
        if (member == null) {
            throw new DescribeException("註冊資訊不得為空", 0);
        }
        if (memberDao.checkMailExists(member.getMail()) > 0) {
            throw new DescribeException("此信箱已註冊", 0);
        }
        return true;
    }
}
