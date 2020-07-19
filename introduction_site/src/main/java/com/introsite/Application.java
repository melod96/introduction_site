package com.introsite;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(value = {"com.introsite.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    // sqlSession을 생성할 sqlSessionFactory를 생성 및 Bean 등록
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        /* DataSource 
        : Connection Pool을 구현하기 위한 스펙을 정해놓은 인터페이스.
        DB와의 연동을 위해 사용되는 객체이며, application.properties에 connection 관련 내용을 작성해두었다.
        */
        sessionFactory.setDataSource(dataSource);

        // 실제 쿼리가 들어갈 xml 패키지 경로를 입력
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
}