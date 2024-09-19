package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 레파지토리: 엔티티를 사용하여 데이터를 처리(crud, 페이징, 정렬)

@Transactional // 롤백처리 해결
public interface MemoRepository extends JpaRepository<Memo, Integer> {

	// JpaRepository를 생성할 때는 엔티티와 해당엔티티의 PK 타입을 지정해야 한다.
	
	
		//	레파지토리 만드는 순서
		//	1. 인터페이스 만든다
		//	2. 'extends'로 설정한다
		//	3.<Entity표기, Entity의 프라이머리 키 타입 표기>
	
	
// ============================================================================================================	
	
	
//	Between
	
//	findByStartDateBetween
	
//	… where x.startDate between ?(파라미터)1(시작) and ?2(마지막)
	// 위에를 실제로 변경	-> 	… where no between ? and ?
			 
	
	// 메모 번호가 10에서 20사이인 데이터 검색
	// 검색에 필요한 파라미터는 매개 변수로 선언
	List<Memo> findByNoBetween(int from, int to); //findBy(조회)No(기준필드)Between(연산자)
	
	
	// 메모의 번호가 10보다 작은 데이터 검색
	// … where no < ?
	List<Memo> findByNoLessThan(int mno);
	
	// 메모의 내용이 없는 데이터 검색
	// … where text is not null
	List<Memo> findByTextIsNotNull();
	
	// 메모의 번호를 기준으로 역정렬
	// ... order by no desc
	List<Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	// delete from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
	
}
