package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		//내 앱이 oracle과 대화하기 위해서 커넥션이 먼저 맺어져야 한다.
		Connection conn = null;
		//객체를 담고 있는 객체
		PreparedStatement stmt = null; 
		//relation을 담고 있는 객체
		ResultSet rs = null; 
		
		try {
			//oracle의 코드를 VM으로 수동으로 넘긴다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//오라클과 연결
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			//다음의 코드를 스테이트 먼트로 바꾸겠다.
			String query = "select user_id, user_name, reg_date from users"; 
			//이 스테이트 먼트를 커넥션을 통해 오라클로 보낸다.
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			// or 맵핑
			User user = null;
			while(rs.next()) {
				// 유저 아이디, 유저네임, 데이트
				user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3));   
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//역순으로 제거해준다.
				rs.close();
				stmt.close();
				conn.close();   
			} catch(Exception e) {}
		}
	}
}

/* sql과 자바 코드가 같이 사용하게 되면 하나를 고칠때 같이 
 * 수정해야 해서 유지보수가 힘들다.
이러한 소스를 스파게티 소스라고 부른다. */