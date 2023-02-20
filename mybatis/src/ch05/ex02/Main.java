package ch05.ex02;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		User user = mapper.selectUser(new Search("john", new Post(null, null)));
		user = mapper.selectUser(new Search("john", new Post("정의", null)));
		user = mapper.selectUser(new Search("john", new Post(null, "고리")));
		//content에 고리가 포함된 것들을 리턴한다.
		System.out.println(user);
	}
}
