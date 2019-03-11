package com.project.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestProduct {
	private  static SqlSessionFactory factory;
	public static void init() throws IOException{
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	public static void main(String[] args) {
		
		try {
			init();
			SqlSession session=factory.openSession();
			List<Map<String,Object>>list=session.selectList("com.project.dao.ProductDao.findAll");
			System.out.println(list);
			//一行记录映射为一个map(映射(封装)过程底层实现)
			//多行记录映射为多个map
			//多个map再存储到list集合
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
