package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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


// @EntityListeners는 JPA (Java Persistence API)에서 엔티티의 변경 사항을 자동으로 감지하고 관리하는 기능을 제공하는 어노테이션
// 엔티티의 생성일자, 수정일자 등의 자동 기록을 관리할 수 있음
// AuditingEntityListener는 JPA의 Auditing 기능을 제공하여 엔티티의 특정 필드를 자동으로 업데이트
@EntityListeners(AuditingEntityListener.class) 

@Entity // 필수
@Table(name = "tbl_board") // 선택
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boarNo; // 카멜케이스로 작성시 JPA에서 스네이크케이스으로 자동변경됨
	
	@Column(length = 30, nullable = false) // length의 크기는 생략이 가능 (단 텍스트는 필수 작성)
	String title;
	
	@Column(length = 200) // nullable의 기본값은 true, 생략가능
	String content;
	
	// 인스턴스가 생성되는 것을 감지하여 현재시간을 저장
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	
	// 최초등록일(처음 = 1번만)
	LocalDateTime createdDate; // 날짜 포맷
	
	// 인스턴스가 생성 또는 수정되는 것을 감지하여 현재시간을 저장
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	
	// 최종수정일(마지막 = N번 발생 가능)
	LocalDateTime modifiedDate; // 날짜(Date) + 시간 =날짜시간(DateTime)
	
	
}


