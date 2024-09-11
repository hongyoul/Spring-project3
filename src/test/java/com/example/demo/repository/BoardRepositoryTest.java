package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 리파지토리객체를_가져왔는지_확인() {
		
		// null 값이 나오면 주입 X, 주소값 나오면 정상으로 주입 O
		System.out.println("boardRepository = " + boardRepository);
		
	}
	
	@Test
	public void 데이터등록() {
		Board board1 = Board
							.builder()
							.title("2번글")
							.content("내용입니다.")
							.build();
							
		boardRepository.save(board1);
	}
	
	@Test
	public void 데이터_단건_조회() {
		Optional<Board> result = boardRepository.findById(1);
		
		if (result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		
		// findAll: 테이블에 있는 모든 데이터를 조회하는 함수
		List<Board> boards = boardRepository.findAll(); // find = 조회 이기때문에 반환값이 필요함
		
		// 람다식 포문으로 하나씩 출력
		for (Board board : boards) { // 변수 : 자료구조(리스트 or 배열)
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터수정() {
		
		// 게시물을 조회하고, 내용을 일부 변경
		Optional<Board> result = boardRepository.findById(2);
		Board board = result.get();
		board.setContent("내용이 수정되었습니다~");
		
		// save함수는 추가 도는 수정을 처리한다.
		// 변경한 내용을 저장
		boardRepository.save(board);
	}
	
	@Test
	public void 데이터단건삭제() {
		boardRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();
	}
}
