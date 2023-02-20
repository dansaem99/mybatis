package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		/* Class<ch02.ex01.Map> 에 x객체가 생성되고 이를 꺼내서 
		 * 데이터를 mapper 변수에 집어넣는다.*/
		Map mapper = Configuration.getMapper(Map.class);
		
		List<User> users = mapper.selectUsers();
		users.forEach(System.out::println);
	}
}