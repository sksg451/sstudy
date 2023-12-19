package org.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.MemberMapper;
import org.spring.model.MemberVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/data.xml"})
@Log4j
public class MyBatisClient {
	@Inject // 개발자가 객체 생성을 하는것이 아닌 스프링이 객체 생성을 하게 만듬
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private MemberMapper memberMapper;
	
	@Test
	public void testFactory() {
		log.info(sqlFactory);
	}
	
	@Test
	public void testSession() {
		try(SqlSession session = sqlFactory.openSession()) {
			log.info(session);
			List<MemberVO> users = memberMapper.getAllMembers();
			
			System.out.println(users);
			
			MemberVO param = new MemberVO();
			param.setId("kim"); // 없는 회원일 경우 null값나옴
			param.setPwd("2222");
			
			MemberVO user = memberMapper.getMember(param);
			
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
