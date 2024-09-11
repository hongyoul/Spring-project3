package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	LocalDate localDate1 = LocalDate.of(2023,7,1);
	LocalDate localDate2 = LocalDate.of(2023,7,2);
	LocalDate localDate3 = LocalDate.of(2023,7,3);
	
	@Test
	public void 리파지토리객체를_가져왔는지_확인() {
		System.out.println("orderRepository = " + orderRepository);
	}
	
	@Test
	public void 데이터등록() {
		
		Order order1 = Order
							.builder()
							.customerName("둘리")
							.orderDate(localDate1)
							.shipAddress("인천 구월동")
							.build();
							
		orderRepository.save(order1);
	}
	
	@Test
	public void 데이터일관등록() {
		List<Order> list = new ArrayList<>();
		
		
		Order order2 = Order
							.builder()
							.customerName("둘리")
							.orderDate(localDate2)
							.shipAddress("인천 구월동")
							.build();
		
		Order order3 = Order
							.builder()
							.customerName("둘리")
							.orderDate(localDate3)
							.shipAddress("인천 구월동")
							.build();

		Order order4 = Order
							.builder()
							.customerName("둘리")
							.orderDate(localDate1)
							.shipAddress("인천 구월동")
							.build();
		
		Order order5 = Order
							.builder()
							.customerName("둘리")
							.orderDate(localDate2)
							.shipAddress("인천 구월동")
							.build();
		
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		orderRepository.saveAll(list);
	}
	

	@Test
	public void 데이터_단건_조회() {
		Optional<Order> result = orderRepository.findById(1);
		
		if (result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Order> orders = orderRepository.findAll();
		
		for (Order order : orders) {
			System.out.println(order);
		}
	}
		

	@Test
	public void 데이터수정() {
		Optional<Order> optional = orderRepository.findById(2);
		Order order = optional.get();
		order.setOrderDate(localDate3);
		
		orderRepository.save(order);
	}
	
	@Test
	public void 데이터단건삭제() {
		orderRepository.deleteById(2);
	}
}
