package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest

public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	
	@Test
	public void 리파지토리객체를_가져왔는지_확인() {
		System.out.println("memberRepository = " + memberRepository);
	}
	
	@Test
	public void 데이터등록() {
		Member member1 = Member
							.builder()
							.userID("admin")
							.grade("관리자")
							.password("1234")
							.build();
							
		memberRepository.save(member1);
	}
	
	@Test
	public void 데이터일관등록() {
		List<Member> list = new ArrayList<>();
		
		Member member2 = Member
							.builder()
							.userID("user1")
							.grade("사용자")
							.password("1234")
							.build();
		
		Member member3 = Member
							.builder()
							.userID("user2")
							.grade("사용자")
							.password("1234")
							.build();
		
		Member member4 = Member
							.builder()
							.userID("yoyt22")
							.grade("관리자")
							.password("1234")
							.build();
		
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		memberRepository.saveAll(list);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Member> optional = memberRepository.findById("admin");
		Member member = optional.get();
		member.setGrade("수정)관리자");
		
		memberRepository.save(member);
	}
	
	@Test
	public void 데이터_단건_조회() {
		Optional<Member> result = memberRepository.findById("admin");
		
		if (result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Member> members = memberRepository.findAll(); 
		
		for (Member member : members) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터단건삭제() {
		memberRepository.deleteById("수정)admin");
	}
	
	@Test
	public void 데이터전체삭제() {
		memberRepository.deleteAll();
	}
}
