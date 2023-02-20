package ch03.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("myUser")  //직접 별명 지정
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	//user has an address
	private Address address;
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, address);
	}
}
