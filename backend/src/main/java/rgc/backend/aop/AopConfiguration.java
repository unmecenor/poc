package rgc.backend.aop;

import java.time.LocalDate;
import java.time.Month;

import org.apache.commons.logging.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

	@Pointcut("execution(public String rgc.backend.aop.PersonService.getFullName(..))")
	public void monitor() {
	}

	@Bean
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		PerformanceMonitorInterceptor interceptor = new PerformanceMonitorInterceptor(true) {
			@Override
			protected boolean isLogEnabled(Log logger) {
				return true;
			}

			@Override
			protected void writeToLog(Log logger, String message, Throwable ex) {
				if (ex != null) {
					LOGGER.info(message, ex);
				} else {
					LOGGER.info(message);
				}
			}
		};
		return interceptor;
	}

	@Bean
	public Advisor performanceMonitorAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("rgc.backend.aop.AopConfiguration.monitor()");
		return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
	}

	@Bean
	public Person person() {
		return new Person("John", "Smith", LocalDate.of(1980, Month.JANUARY, 12));
	}

	@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
