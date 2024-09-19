package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_1 {

//	crud기능 확인
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void 리파지토리객체를_가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	public void 데이터등록() {
		
		// 새로운 데이터
		// no에 0(반값)을 입력하면 auto increment로 자동 생성됨
		Memo memo = Memo
						.builder()
						.text("새글입니다")
						.build();
		
		// save: 테이블에 데이터를 추가 또는 수정하는 함수
		memoRepository.save(memo); //1번이 존재하는지 확인하고 insert 실행
	}
	@Test
	public void 데이터일관등록() {
		List<Memo> list = new ArrayList<>();
		
		// 메모장
		Memo memo1 = Memo
						.builder()
						.text("새글입니다.")
						.build();
		Memo memo2 = Memo
						.builder()
						.build();
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list);
	}
	
	@Test
	public void 데이터단건조회() {
		
		//  ☆★☆★☆★ 중요 ☆★☆★☆★ 
		// 결과값을 반환받을 때는 함수의 선언부를 확인 할 것
		// 그리고 그 타입을 대입연산자 앞부분에 변수로 선언
		
		// findById: 단건 데이터를 조회하는 함수
		Optional<Memo> optional = memoRepository.findById(1); // findBy(Id)의 Id는 해당 엔티티(table)의 key
		
		// optional 객체를 안에 값이 있는지 확인
		if (optional.isPresent() == true) {
			System.out.println(optional.get());
		} else {
			System.out.println("값이 없습니다.");
		}
		
		// find 함수를 사용하여 select sql이 생성됨
	}
	
	@Test
	public void 데이터수정() {
		
		Memo memo = Memo
					.builder()
					.no(1) // 대상 PK를 가르키는 위치 설정
					.text("새로 수정되는 글입니다.") // 변경할 내용
					.build();
					
		// save: 데이터를 추가 또는 수정하는 함수
		memoRepository.save(memo);
		
		// select > update sql이 생성됨
		// 조회 결과에 따라 (추가)insert 또는 (수정)update가 수행됨
	}
	
	@Test
	public void 데이터삭제() {
		
		// deleteById: 특정 데이터를 삭제하는 함수
		memoRepository.deleteById(9);
		// delete 함수를 실행하면 delete sql이 생성됨
		
	}
	
	@Test
	public void 데이터전체삭제() {
		
		// deleteAllById: 데이블에 있는 모든 데이터를 일괄 삭제하는 함수
		memoRepository.deleteAll();
		
		// select를 한 후, 데이터 갯수 만큼 delete sql이 생성됨
	}
}
