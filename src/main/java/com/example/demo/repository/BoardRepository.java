package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	// 리파지토리 만드는 방법
	// 1. JpaRepository를 상속받는다.
	// 2. 제네릭 타입에 엔티티와 pk를 설정한다.
}
