package com.ntuzy.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {

	private static SqlSessionFactoryBuilder builder;
	private static SqlSessionFactory factory;
	
	
	static {
		try {
			builder = new SqlSessionFactoryBuilder();
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			factory = builder.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
	
	
	
	
	
}
