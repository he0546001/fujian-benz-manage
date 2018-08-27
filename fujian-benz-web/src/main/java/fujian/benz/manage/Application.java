package fujian.benz.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fujian.benz.manage.filter.EncodingFilter;

@SpringBootApplication
/*事务注解 开启，已经在单表的基本方法加了注解，如果xml写增删改方法
可以自己权衡是否在业务层加注解*/
@EnableTransactionManagement 
@MapperScan("fujian.benz.manage.mapper")
public class Application {
  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
  }
	
	@Bean
	public FilterRegistrationBean myFilterBean(){
		
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new EncodingFilter());
		bean.addUrlPatterns("/*");
		return bean;
	} 
	
}
