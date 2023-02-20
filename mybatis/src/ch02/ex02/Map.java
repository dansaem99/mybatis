package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

public interface Map {
	User selectUser(int userId);
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}
//interface Map에는 데이터 처리할 내용을 입력한다.