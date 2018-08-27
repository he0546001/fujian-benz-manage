package fujian.benz.manage.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	/** 定义日志记录器对象 */
	private Logger logger =  LoggerFactory.getLogger(LogAdvice.class);
	 
	   @Pointcut("execution(* fujian.benz.manage.service.*.*(..))")
	   public void declearJoinPointExpression(){}
	
	/** 在调用业务层方法出现异常之后，进来该方法，记录异常信息 */
	   @AfterThrowing(value="declearJoinPointExpression()",throwing ="e")
	   public void error(JoinPoint joinPoint, Throwable e){
		logger.error("调用【"+ joinPoint.getSignature().getName() +"】方法出现了异常，异常信息为：" + e.getMessage());
		logger.error("异常跟踪栈信息为：", e);
		
	} 

     
	   
}
