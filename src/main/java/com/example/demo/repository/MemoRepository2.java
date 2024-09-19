package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional
public interface MemoRepository2 extends JpaRepository<Memo, Integer>{

	// jpql 사용하기
	// 테이블 대신 엔티티 사용
	// 컬럼 대신 엔티티의 필드 사용

	
	// 메모의 번호가 3보다 작은 데이터 검색
	// select * from tbl_memo 로 변형됨 => (조건절 추가) select * from tbl_memo where no < ?
	// @Query("select m from Memo m where m.no < : 파라미터이름")

	@Query("select m from Memo m where m.no < : mno")
	
	//	List<Memo> get1(@Param("파라미터 이름") int mno);
	List<Memo> get1(@Param("mno") int mno);
	
	// 메모의 내용이 없는 데이터 검색
	// select * from (테이블명)tbl_memo => 테이블을 엔티티로 변경한다.
	// select * from tbl_memo where text is null
	// @Query("select m from (엔티티명)Memo m") 
	@Query("select m from Memo m where m.text is null") 
	List<Memo> get2();
	
	
	
	// 메모의 번호가 10에서 20사이인 데이터 검색
	//select * from tbl_memo where no between ? and ?
	@Query("select m from Memo m where m.no between :p1 and :p2") // :p1과 :p2는 파라미터 입니다.
	List<Memo> get3(@Param("p1") int from, @Param("p2") int to); // 매개변수선언   * int to의 to는 변수명이다
	
	// 순수한 SQL 사용하기
	@Query(value = "SELECT * FROM tbl_memo ORDER BY NO DESC", nativeQuery = true)
	List<Memo> get4();
	
	@Modifying // 데이터 수정(업데이트) 및 삭제 작업을 수행할 때는 커밋처리를 위한 @Modifying 어노테이션이 필요
	@Query(value = "DELETE FROM tbl_memo WHERE NO = :param", nativeQuery = true)
	void deletel1(@Param("param") int mno); // 반환값이 없으면 void 사용
	
	// 객체 파라미터
	@Modifying
	@Query(value = "UPDATE tbl_memo SET TEXT = :#{#params.text} WHERE NO = :#{#params.no}", nativeQuery = true)
	void update1(@Param("params") Memo memo);  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
