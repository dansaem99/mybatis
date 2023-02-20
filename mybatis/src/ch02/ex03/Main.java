package ch02.ex03;

import java.time.LocalDate;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		
		if(mapper.insertUser(new User(11, "abel", LocalDate.of(2023, 1, 27))) > 0)
		    System.out.println("성공11");
		
		
		if(mapper.insertUser(new User(12, null, null)) > 0)
			System.out.println("성공12"); 
			
		
		if(mapper.insertUser2(13, "kianu", LocalDate.of(2023, 1, 27)) > 0)
			System.out.println("성공13");
			
		
		if(mapper.insertUser3(14, "neo", LocalDate.of(2023, 1, 27)) > 0)
			System.out.println("성공14");
	}
}


/*데이터를 알아 보고 싶으면 명령프롬프트
 * sqlplus mybatis/mybatis 
 * select * from users;
 */
