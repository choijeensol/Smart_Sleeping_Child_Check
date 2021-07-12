package kr.or.dream.config.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.dream.config.DBConfig;

public class DBTest {
	public static void main(String args[]) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(DBConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		try(Connection conn = ds.getConnection()){
			if(conn!=null)System.out.println("접속성공^_^");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
