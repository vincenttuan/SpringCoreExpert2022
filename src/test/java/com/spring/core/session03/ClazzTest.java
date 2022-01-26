package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Student;
import com.spring.core.session03.beans.Teacher;

public class ClazzTest {
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Clazz clazz = ctx.getBean("clazz1", Clazz.class);
		System.out.println(clazz);
		
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student1", Student.class);
		System.out.println(student1);
		System.out.println(student2);
		
		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		Teacher teacher2 = ctx.getBean("teacher2", Teacher.class);
		System.out.println(teacher1);
		System.out.println(teacher2);
	}
}
