package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 리파지토리객체를_가져왔는지_확인() {
		System.out.println("bookRepository = " + bookRepository);
	}
	
	
	@Test
	public void 데이터등록() {
		Book book = Book
						.builder()
						.price(20000)
						.publisher("한빛출판사")
						.title("자바프로그래밍입문")
						.build();
		
		bookRepository.save(book);
	}
	
	@Test
	public void 데이터일관등록() {
		List<Book> list = new ArrayList<>();
		
		
		Book book1 = Book
						.builder()
						.price(25000)
						.publisher("남가람북스")
						.title("스프링부트프로젝트")
						.build();
		
		Book book2 = Book
						.builder()
						.price(40000)
						.publisher("남가람북스")
						.title("실무로 끝내는 PHP")
						.build();

		Book book3 = Book
						.builder()
						.price(35000)
						.publisher("이지스퍼블리싱")
						.title("알고리즘코딩테스트")
						.build();
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		
		bookRepository.saveAll(list);
	}

	@Test
	public void 데이터_단건_조회() {
		Optional<Book> result =  bookRepository.findById(2);
		
		if(result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Book> books = bookRepository.findAll();
		
		for (Book book : books) {
			System.out.println(books);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Book> optional = bookRepository.findById(2);
		Book book = optional.get();
		book.setTitle("(수정)스프링부트프로젝트");
		
		bookRepository.save(book);
	}
	
	@Test
	public void 데이터단건삭제() {
		bookRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll();
	}
}
