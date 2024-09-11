package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

// 레파지토리: 엔티티를 사용하여 데이터를 처리(crud, 페이징, 정렬)

public interface MemoRepository extends JpaRepository<Memo, Integer> {

	// JpaRepository를 생성할 때는 엔티티와 해당엔티티의 PK 타입을 지정해야 한다.
	
	
		//	레파지토리 만드는 순서
		//	1. 인터페이스 만든다
		//	2. 'extends'로 설정한다
		//	3.<Entity표기, Entity의 프라이머리 키 타입 표기>
			 
}
