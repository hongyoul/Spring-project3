package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 엔티티(Entity): 데이터베이스의 데이블 구조를 정의하는 클래스

@Entity // 엔티티(Entity) 클래스 표시 (필수)
@Table(name = "tbl_memo") // 테이블 이름
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

	// primary key
	@Id // 최소 1개는 있어야함, 없으면 must 에러가 발생
	// auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue(strategy = 방식결정 부분)
	int no;
	
	// 일반컬럼
	// 컬럼의 크기와 제약사항
	@Column(length = 200, nullable = true)
	String text;
}
