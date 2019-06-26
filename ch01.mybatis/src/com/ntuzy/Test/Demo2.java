package com.ntuzy.Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ntuzy.domain.Customer;
import com.ntuzy.utils.SessionUtils;

/**
 * �տ�ʼConfig ��Ҫ�һ� BuildPath=> use as source path
 * 
 * @author IamZY
 *
 */
public class Demo2 {

	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = SessionUtils.getSession();
		// ִ�в���
		Customer customer = new Customer();
		customer.setName("����");
		customer.setGender("��");
		customer.setTelephone("111111111");
		sqlSession.insert("insertCustomer", customer);
		// �������� ��Ҫ�ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

}
