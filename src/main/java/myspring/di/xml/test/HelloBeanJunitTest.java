package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import static org.junit.Assert.*;
public class HelloBeanJunitTest {

	ApplicationContext context;
	@Before
	public void init() {
		//1. IoC 컨테이너 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test
	public void test2() {
		//2. Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = (Hello) context.getBean("hello", Hello.class);
		
		assertSame(hello, hello2);
		
	}
	
	@Test @Ignore
	public void test1() {
		//2. Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();

		//3. StringPrinter Bean  가져오기
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("HelloSpring", printer.toString());
		
		Hello hello2 = (Hello) context.getBean("hello", Hello.class);
		
	}

}
