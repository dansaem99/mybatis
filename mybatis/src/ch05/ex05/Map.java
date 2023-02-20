package ch05.ex05;

import ch05.domain.User;

public interface Map {
	User selectUser(String userName);
	//sql입장에서 파라미터 네임이 없는 상황이 된다.
}
