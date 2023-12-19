package org.spring.mapper;

import java.util.List;

import org.spring.model.MemberVO;

public interface MemberMapper {
	// 기능 구현 x
	public List<MemberVO> getAllMembers();
	
	public MemberVO getMember(MemberVO user);
	
}
