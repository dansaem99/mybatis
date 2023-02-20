package ch05.ex06;

import java.util.Arrays;
import java.util.List;

import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		List<User> users = mapper.selectUsers(new Search(new int[] {1,2}, null));
		users = mapper.selectUsers(new Search(null, Arrays.asList("john", "King")));
		
		users.forEach(System.out::println);
	}
}
//위에 king앞쪽이 대문자 됐다 ㅠㅠㅠ 수정해라 샘이야