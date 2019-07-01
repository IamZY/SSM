# SSM

## SSH项目配置

+ 导包 `Spring`、`Hibernate` `SpringMVC`		

+ 配置`jdbc.properties`

  ```xml
  jdbc.url=jdbc:mysql:///spring_mvc
  jdbc.driver_class=com.mysql.jdbc.Driver
  jdbc.user=root
  jdbc.password=123456
  ```

+ 配置连接池

  ```xml
  <!-- 创建c3p0连接池 -->
  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
      <property name="jdbcUrl" value="${jdbc.url}"/>
      <property name="driverClass" value="${jdbc.driver_class}"/>
      <property name="user" value="${jdbc.user}"/>
      <property name="password" value="${jdbc.password}"/>
  </bean>
  ```

+ 配置Spring整合Hibernate

  ```xml
  <!-- Spring整合Hibernate -->
  <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
      <property name="dataSource" ref="dataSource"/>
      <property name="hibernateProperties">
          <props>
              <!-- 是否输出sql语句 -->
              <prop key="hibernate.show_sql">true</prop>
              <!-- 自动维护表 -->
              <prop key="hibernate.hbm2ddl.auto">update</prop>
          </props>
      </property>
      <property name="packagesToScan">
          <!-- 扫描实体所在的包 -->
          <list>
              <value>com.ntuzy.domain</value>
          </list>
      </property>
  </bean>
  ```

+ 配置事务

  ```xml
  <!-- 开启Spring的事务管理 -->
  <tx:annotation-driven transaction-manager="transactionManager"/>
  <bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
      <property name="sessionFactory" ref="sessionFactory"/>
  </bean>
  ```

+ Spring注解扫描

  ```xml
  <!-- 开启Spring注解扫描 -->
  <contenxt:component-scan base-package="com.ntuzy.service,com.ntuzy.dao"/>
  ```

+ 配置web.xml(配置SpringMVC核心控制器 和 Spring监听器)

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
    <display-name>ch04.spring-mvc</display-name>
    <!-- 字符编码 -->
    <filter>
    	<filter-name>CharacterEncodingFilter</filter-name>
    	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    	<init-param>
    		<param-name>encoding</param-name>
    		<param-value>UTF-8</param-value>
    	</init-param>
    </filter>
    <filter-mapping>
    	<filter-name>CharacterEncodingFilter</filter-name>
    	<url-pattern>/*</url-pattern>
    </filter-mapping>
    
    <!-- 请求方法Restful的过滤器 -->
    <filter>
    	<filter-name>HiddenHttpMethodFilter</filter-name>
    	<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
    	<filter-name>HiddenHttpMethodFilter</filter-name>
    	<url-pattern>/*</url-pattern>
    </filter-mapping>
    
    
    <!-- SpringMVC的核心控制器 -->
    <servlet>
    	<servlet-name>DispatcherServlet</servlet-name>
    	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    	<init-param>
    		<param-name>contextConfigLocation</param-name>
    		<param-value>classpath:spring-mvc.xml</param-value>
    	</init-param>
    </servlet>
    <servlet-mapping>
    	<servlet-name>DispatcherServlet</servlet-name>
    	<url-pattern>*.action</url-pattern>
    </servlet-mapping>
    
    <!-- Spring启动监听器 -->
    <listener>
    	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
    	<param-name>contextConfigLocation</param-name>
    	<param-value>classpath:spring.xml</param-value>
    </context-param>
    
    
    <welcome-file-list>
      <welcome-file>index.html</welcome-file>
      <welcome-file>index.htm</welcome-file>
      <welcome-file>index.jsp</welcome-file>
      <welcome-file>default.html</welcome-file>
      <welcome-file>default.htm</welcome-file>
      <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>
  </web-app>
  ```

+ 配置Spring.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xmlns:tx="http://www.springframework.org/schema/tx"
      xmlns:contenxt="http://www.springframework.org/schema/context"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="
          http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd
          http://www.springframework.org/schema/context
          http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/tx
          http://www.springframework.org/schema/tx/spring-tx.xsd">
  	
  	<!-- 扫描Controller包 -->
  	<contenxt:component-scan base-package="com.ntuzy.controller"/>
  	
  	<!-- 开启注映射器和适配器 -->
  	<mvc:annotation-driven></mvc:annotation-driven>
  	
  	<!-- 视图解析器 -->
  	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  		<property name="prefix" value="/WEB-INF/jsp/"></property>
  		<property name="suffix" value=".jsp"></property>
  	</bean>
  </beans>
  ```

## SSM配置

底层向上层整合

+ 单独使用Mybatis

  + 导包

  + 建立数据库和表

  + 建立实体类

  + 建立Mapper接口

  + 建立sql映射文件

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!-- 该文件编写mybatis中的mapper接口里面的方法提供对应的sql语句 -->
    <mapper namespace="com.ntuzy.dao.CustomerMapper">
    
    	<!-- 添加客户 -->
    	<insert id="saveCustomer" parameterType="com.ntuzy.domain.Customer">
    		INSERT INTO ssm.t_customer 
    			(
    			NAME, 
    			gender, 
    			telephone, 
    			address
    			)
    			VALUES
    			( 
    			#{name}, 
    			#{gender}, 
    			#{telephone}, 
    			#{address}
    			)
    	</insert>
    
    </mapper>
    ```

  + 建立sqlMapConfig.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
    	<!-- 和spring整合后 environments配置将废除 -->
    	<environments default="development">
    		<environment id="development">
    			<!-- 使用jdbc事务管理 -->
    			<transactionManager type="JDBC" />
    			<!-- 数据库连接池 -->
    			<dataSource type="POOLED">
    				<property name="driver" value="com.mysql.jdbc.Driver" />
    				<property name="url"
    					value="jdbc:mysql://localhost:3306/ssm?characterEncoding=utf-8" />
    				<property name="username" value="root" />
    				<property name="password" value="123456" />
    			</dataSource>
    		</environment>
    	</environments>
    	
    	<!-- 查找sql映射文件 -->
    	<mappers>
    		<mapper resource="mapper/CustomerMapper.xml"/>
    	</mappers>
    </configuration>
    ```

  + log4j.propertoes

    ```properties
    ### direct log messages to stdout ###
    log4j.appender.stdout=org.apache.log4j.ConsoleAppender
    log4j.appender.stdout.Target=System.err
    log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
    log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
    
    ### direct messages to file mylog.log ###
    log4j.appender.file=org.apache.log4j.FileAppender
    log4j.appender.file.File=c\:mylog.log
    log4j.appender.file.layout=org.apache.log4j.PatternLayout
    log4j.appender.file.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
    
    ### set log levels - for more verbose logging change 'info' to 'debug' ###
    
    log4j.rootLogger=debug, stdout
    
    ```

    

  + 编写测试类

    ```java
    package com.ntuzy.test;
    
    import java.io.IOException;
    import java.io.InputStream;
    
    import org.apache.ibatis.io.Resources;
    import org.apache.ibatis.session.SqlSession;
    import org.apache.ibatis.session.SqlSessionFactory;
    import org.apache.ibatis.session.SqlSessionFactoryBuilder;
    import org.junit.Test;
    
    import com.ntuzy.dao.CustomerMapper;
    import com.ntuzy.domain.Customer;
    
    public class CustomerTest {
    
    	@Test
    	public void test() throws IOException {
    		// 创建SqlSessionFactoryBuilder
    		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    		// 加载sqlMapperConfig.xml
    		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    		// 创建sqlSessionFactory
    		SqlSessionFactory factory = builder.build(inputStream);
    		
    		SqlSession sqlSession = factory.openSession();
    		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
    		
    		Customer customer = new Customer();
    		customer.setName("张三");
    		customer.setAddress("nj");
    		customer.setGender("男");
    		customer.setTelephone("11111");
    		customerMapper.saveCustomer(customer );
    		sqlSession.commit();
    		sqlSession.close();
    	}
    	
    }
    
    ```

## 在刚才基础上整合Spring

+ （含有Mapper实现类）

+ 导包(mybatis-spring.jar)和Spring的包

+ 编写Mapper实现类

  ```java
  package com.ntuzy.dao.impl;
  
  import org.apache.ibatis.session.SqlSession;
  import org.mybatis.spring.support.SqlSessionDaoSupport;
  
  import com.ntuzy.dao.CustomerMapper;
  import com.ntuzy.domain.Customer;
  
  public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {
  
  	@Override
  	public void saveCustomer(Customer customer) {
  		SqlSession sqlSession = this.getSqlSession();
  		sqlSession.insert("saveCustomer", customer);
  	}
  
  }
  
  ```

  

+ 编写Spring'配置文件 applicationContext.xml  将jdbc单独拉出来

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  	xmlns:context="http://www.springframework.org/schema/context"
  	xmlns:aop="http://www.springframework.org/schema/aop" 
  	xmlns:tx="http://www.springframework.org/schema/tx"
  	xsi:schemaLocation="http://www.springframework.org/schema/beans 
  	http://www.springframework.org/schema/beans/spring-beans.xsd
  	http://www.springframework.org/schema/context
  	http://www.springframework.org/schema/context/spring-context.xsd
  	http://www.springframework.org/schema/aop
  	http://www.springframework.org/schema/aop/spring-aop.xsd
  	http://www.springframework.org/schema/tx 
  	http://www.springframework.org/schema/tx/spring-tx.xsd">
  	
  	<!-- 读取jdbc.properties -->
  	<context:property-placeholder location="classpath:jdbc.properties"/>
  
  	<!-- 创建DataSource -->
  	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
  		<property name="url" value="${jdbc.url}"/>
  		<property name="driverClassName" value="${jdbc.driverClass}"/>
  		<property name="username" value="${jdbc.user}"/>
  		<property name="password" value="${jdbc.password}"/>
  		<!-- 最大连接数 -->
  		<property name="maxActive" value="10"/>
  		<!-- 最大空闲数 -->
  		<property name="maxIdle" value="5"/>
  	</bean>	
  	
  	<!-- 创建SqlSessionFactory对象 -->
  	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  		<!-- 关联连接池 -->
  		<property name="dataSource" ref="dataSource"/>
  		<!-- 加载sql映射文件 -->
  		<property name="mapperLocations" value="classpath:mapper/*.xml"/>
  	</bean>
  	
  	<!-- 创建CustomerMapperImpl对象，注入SqlSessionFactory -->
  	<bean id="customerMapper" class="com.ntuzy.dao.impl.CustomerMapperImpl">
  		<!-- 关联sqlSessionFactory -->
  		<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
  	</bean>
  	
  </beans> 
  ```

  ```properties
  jdbc.url=jdbc:mysql://localhost:3306/ssm
  jdbc.driverClass=com.mysql.jdbc.Driver
  jdbc.user=root
  jdbc.password=123456
  ```

+ 编写测试类

+ 在刚才基础上整合Spring（没有Mapper实现类）

  + applicationContext.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    	xmlns:context="http://www.springframework.org/schema/context"
    	xmlns:aop="http://www.springframework.org/schema/aop" 
    	xmlns:tx="http://www.springframework.org/schema/tx"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans 
    	http://www.springframework.org/schema/beans/spring-beans.xsd
    	http://www.springframework.org/schema/context
    	http://www.springframework.org/schema/context/spring-context.xsd
    	http://www.springframework.org/schema/aop
    	http://www.springframework.org/schema/aop/spring-aop.xsd
    	http://www.springframework.org/schema/tx 
    	http://www.springframework.org/schema/tx/spring-tx.xsd">
    	
    	<!-- 读取jdbc.properties -->
    	<context:property-placeholder location="classpath:jdbc.properties"/>
    
    	<!-- 创建DataSource -->
    	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
    		<property name="url" value="${jdbc.url}"/>
    		<property name="driverClassName" value="${jdbc.driverClass}"/>
    		<property name="username" value="${jdbc.user}"/>
    		<property name="password" value="${jdbc.password}"/>
    		<!-- 最大连接数 -->
    		<property name="maxActive" value="10"/>
    		<!-- 最大空闲数 -->
    		<property name="maxIdle" value="5"/>
    	</bean>	
    	
    	<!-- 创建SqlSessionFactory对象 -->
    	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    		<!-- 关联连接池 -->
    		<property name="dataSource" ref="dataSource"/>
    		<!-- 加载sql映射文件 -->
    		<property name="mapperLocations" value="classpath:mapper/*.xml"/>
    	</bean>
    	
    	<!-- 配置Mapper接口 -->
    	<bean id="customerMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
    		<!-- 关联Mapper接口 -->
    		<property name="mapperInterface" value="com.ntuzy.dao.CustomerMapper"/>
    		<!-- 关联SqlSessionFactory -->
    		<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
    	</bean>
    	
    </beans>
    ```

+ mapper接口扫描（不需要mapper实现类）

  + 修改applicationContext.xml接口

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:context="http://www.springframework.org/schema/context"
    	xmlns:aop="http://www.springframework.org/schema/aop"
    	xmlns:tx="http://www.springframework.org/schema/tx"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans 
    	http://www.springframework.org/schema/beans/spring-beans.xsd
    	http://www.springframework.org/schema/context
    	http://www.springframework.org/schema/context/spring-context.xsd
    	http://www.springframework.org/schema/aop
    	http://www.springframework.org/schema/aop/spring-aop.xsd
    	http://www.springframework.org/schema/tx 
    	http://www.springframework.org/schema/tx/spring-tx.xsd">
    
    	<!-- 读取jdbc.properties -->
    	<context:property-placeholder
    		location="classpath:jdbc.properties" />
    
    	<!-- 创建DataSource -->
    	<bean id="dataSource"
    		class="org.apache.commons.dbcp.BasicDataSource">
    		<property name="url" value="${jdbc.url}" />
    		<property name="driverClassName" value="${jdbc.driverClass}" />
    		<property name="username" value="${jdbc.user}" />
    		<property name="password" value="${jdbc.password}" />
    		<!-- 最大连接数 -->
    		<property name="maxActive" value="10" />
    		<!-- 最大空闲数 -->
    		<property name="maxIdle" value="5" />
    	</bean>
    
    	<!-- 创建SqlSessionFactory对象 -->
    	<bean id="sqlSessionFactory"
    		class="org.mybatis.spring.SqlSessionFactoryBean">
    		<!-- 关联连接池 -->
    		<property name="dataSource" ref="dataSource" />
    		<!-- 加载sql映射文件 -->
    		<property name="mapperLocations"
    			value="classpath:mapper/*.xml" />
    	</bean>
    
    	<!-- Mapper接口的扫描 -->
    	<!-- 注意：如果使用Mapper接口包扫描，那么每个Mapper接口在Spring容器中的id名称为类名： 例如 CustomerMapper -> customerMapper -->
    	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    		<!-- 配置Mapper接口所在包路径 -->
    		<property name="basePackage" value="com.ntuzy.dao" />
    	</bean>
    
    </beans>
    ```

##  整合事务

+ 修改applicationContext.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  	xmlns:context="http://www.springframework.org/schema/context"
  	xmlns:aop="http://www.springframework.org/schema/aop"
  	xmlns:tx="http://www.springframework.org/schema/tx"
  	xsi:schemaLocation="http://www.springframework.org/schema/beans 
  	http://www.springframework.org/schema/beans/spring-beans.xsd
  	http://www.springframework.org/schema/context
  	http://www.springframework.org/schema/context/spring-context.xsd
  	http://www.springframework.org/schema/aop
  	http://www.springframework.org/schema/aop/spring-aop.xsd
  	http://www.springframework.org/schema/tx 
  	http://www.springframework.org/schema/tx/spring-tx.xsd">
  
  	<!-- 读取jdbc.properties -->
  	<context:property-placeholder
  		location="classpath:jdbc.properties" />
  
  	<!-- 创建DataSource -->
  	<bean id="dataSource"
  		class="org.apache.commons.dbcp.BasicDataSource">
  		<property name="url" value="${jdbc.url}" />
  		<property name="driverClassName" value="${jdbc.driverClass}" />
  		<property name="username" value="${jdbc.user}" />
  		<property name="password" value="${jdbc.password}" />
  		<!-- 最大连接数 -->
  		<property name="maxActive" value="10" />
  		<!-- 最大空闲数 -->
  		<property name="maxIdle" value="5" />
  	</bean>
  
  	<!-- 创建SqlSessionFactory对象 -->
  	<bean id="sqlSessionFactory"
  		class="org.mybatis.spring.SqlSessionFactoryBean">
  		<!-- 关联连接池 -->
  		<property name="dataSource" ref="dataSource" />
  		<!-- 加载sql映射文件 -->
  		<property name="mapperLocations"
  			value="classpath:mapper/*.xml" />
  	</bean>
  
  	<!-- Mapper接口的扫描 -->
  	<!-- 注意：如果使用Mapper接口包扫描，那么每个Mapper接口在Spring容器中的id名称为类名： 例如 CustomerMapper -> customerMapper -->
  	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  		<!-- 配置Mapper接口所在包路径 -->
  		<property name="basePackage" value="com.ntuzy.dao" />
  	</bean>
  
  	<!-- Spring Ioc的注解扫描 -->
  	<context:component-scan base-package="com.ntuzy" />
  	
  	<!-- 开启Spring的事务 -->
  	<!-- -事务管理器 -->
  	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  		<property name="dataSource" ref="dataSource"/>
  	</bean>
  	<!-- 启用Spring事务注解 -->
  	<tx:annotation-driven transaction-manager="transactionManager"/>
  	
  </beans> 
  ```

## 再整合SpringMVC

+ 导包

+ 配置web.xml

  + 启动Spring
  + 启动SpringMVC

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
    <display-name>01.mybatis</display-name>
  
  	<!-- 启动SpringMVC -->
  	<servlet>
  		<servlet-name>DispatcherServlet</servlet-name>
  		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  		<!-- 参数：读取spring-mvc.xml -->
  		<init-param>
  			<param-name>contextConfigLocation</param-name>
  			<param-value>classpath:spring-mvc.xml</param-value>
  		</init-param>
  	</servlet>
  	<servlet-mapping>
  		<servlet-name>DispatcherServlet</servlet-name>
  		<url-pattern>*.action</url-pattern>
  	</servlet-mapping>
  
    
    	<!-- 启动spring -->
  	<listener>
  		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  	</listener>
  	<!-- 修改路径 -->
  	<context-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>classpath:applicationContext.xml</param-value>
  	</context-param>
  
    
    <welcome-file-list>
      <welcome-file>index.html</welcome-file>
      <welcome-file>index.htm</welcome-file>
      <welcome-file>index.jsp</welcome-file>
      <welcome-file>default.html</welcome-file>
      <welcome-file>default.htm</welcome-file>
      <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>
  </web-app>
  ```

  

+ 配置spring-mvc.xml

  ```	xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xmlns:contenxt="http://www.springframework.org/schema/context"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="
          http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd
          http://www.springframework.org/schema/context
          http://www.springframework.org/schema/context/spring-context.xsd">
  
  	<!-- 扫描Controller所在的包 -->
  	<contenxt:component-scan base-package="com.ntuzy.controller"/>
  
  	<!-- 注解驱动 -->
  	<mvc:annotation-driven></mvc:annotation-driven>
  	
  	<!-- 视图解析器:简化在Controller类编写的视图路径 -->
  	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  		<!-- 前缀 -->
  		<property name="prefix" value="/WEB-INF/jsp/"/>
  		<!-- 后缀 -->
  		<property name="suffix" value=".jsp"/>
  	</bean>
  
  </beans>
  ```

  

+ 编写Controller

+ 解决中文乱码-web.xml中配置编码过滤器

  ```xml
  <!-- 配置SpringMVC编码过滤器 -->
  <filter>
      <filter-name>CharacterEncodingFilter</filter-name>
      <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
      <init-param>
          <param-name>encoding</param-name>
          <param-value>utf-8</param-value>
      </init-param>
  </filter>
  <filter-mapping>
      <filter-name>CharacterEncodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

  











