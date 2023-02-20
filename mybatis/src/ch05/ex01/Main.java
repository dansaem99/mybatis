package ch05.ex01;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		User user = mapper.selectUser(new Search("john", null));
		//user = mapper.selectUser(new Search("john", new Post("정의", null)));
		user = mapper.selectUser(new Search("john", new Post("정의", "")));
		System.out.println(user);
	}
}

// 값이 없다를 "" 혹은 null로 정의할 수 있다.