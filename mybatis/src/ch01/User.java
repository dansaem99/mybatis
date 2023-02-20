package ch01;

import java.sql.Date;

public record User(int userId, String userName, Date regDate) {

}
