package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;
	
	//static이기 때문에 call하지 않아도 바이트 코딩 로딩 되자마자 실행된다.
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//InputStream stream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream,"hr");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 오토커밋 하겠다는 의미이다. sqlSessionFactory.openSession(true)
	 * 수동으로 커밋하고 싶으면 true 값을 false로 주면 된다.
	 */
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
	}
}