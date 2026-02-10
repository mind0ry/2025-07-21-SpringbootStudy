package com.sist.web.service;

import com.sist.web.dto.MemberDTO;

public interface MemberService {

	public MemberDTO memberLogin(String id,String pwd);
}
