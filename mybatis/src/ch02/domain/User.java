package ch02.domain;

import java.time.LocalDate;

public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	
	public User(int userId, String userName, LocalDate regDate) {
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	/*public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}*/
	
	
	@Override
	public String toString() {
		return String.format("%d %s %s", userId, userName,regDate);
	}
}