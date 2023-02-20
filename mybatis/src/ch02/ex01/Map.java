package ch02.ex01;

import java.util.List;

import ch02.domain.User;

public interface Map {
	List<User> selectUsers();
}

/* mybatis가 자동으로 자바코드를 짜준다. 다만 sql 코드는 직접 짜야한다. 
 * sql 코드는 별도의 문서에 작성해줘야 한다.*/
