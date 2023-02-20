package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Config {
   private static SqlSessionFactory sqlSessionFactory;
   
   static {
      try {
         Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public static <T> T getMapper(Class<T> arg) {
      return sqlSessionFactory.openSession(true).getMapper(arg);
   }
}