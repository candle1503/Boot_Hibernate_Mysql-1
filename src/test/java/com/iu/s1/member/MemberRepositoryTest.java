package com.iu.s1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	//@Test
	void loginTest() {
		MemberVO memberVO = new MemberVO();
		//memberVO.setId("iu3");
		memberVO.setPw("iu");
		memberVO = memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		System.out.println(memberVO.getMemberFileVO().getFileName());
		System.out.println(memberVO.getMemberFileVO().getOriName());
		assertNotNull(memberVO);
	}
	
	
	//@Test
	void idcheck() {
		MemberVO memberVO = new MemberVO();
	 	//boolean check = memberRepository.exists(example);
	 	//System.out.println(check);
	}
	
	//@Test
	void insertTest() {
		MemberVO memberVO = new MemberVO();
		//memberVO.setId("iu2");
		memberVO.setPw("iu2");
		memberVO.setName("iu");
		memberVO.setEmail("suji@naver.com");
		memberVO.setPhone("01022222222");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
		//Member Insert 성공
		//MemberFile 에 ID NULL 	
	}
	
	//@Test
	public void insertTest2() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu3");
		memberVO.setPw("iu");
		memberVO.setName("iu");
		memberVO.setEmail("suji@naver.com");
		memberVO.setPhone("01022222222");
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		
		memberVO.setMemberFileVO(memberFileVO);
		memberFileVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
	
	//@Test
	void selectTest() {
		 MemberVO memberVO = memberRepository.findById("suji2").get();
		 System.out.println(memberVO.getName());
	}
	//@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu3");
		memberVO.setEmail("iu@daum.net");
		
		memberRepository.save(memberVO);
		
		
		assertNotNull(memberVO);
	}
	
	//@Test
	void deleteTest() {
		memberRepository.deleteById("iu2");
		//hani, suji
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("choa");
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setId("suji");
//		List<MemberVO> ar = new ArrayList<>();
//		ar.add(memberVO);
//		ar.add(memberVO2);
//		memberRepository.deleteAll(ar);
	}
	

}
