package com.webapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.webapp.exception.AlreadyExsitingMemberException;
import com.webapp.model.Member;
import com.webapp.model.MemberList;

public class MemberRegsisterServiceTest {

	static Log log = LogFactory.getLog(MemberRegsisterServiceTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("oracle", "spring");
//		ctx.getEnvironment().setActiveProfiles("oracle", "mybatis");
//		ctx.getEnvironment().setActiveProfiles("mysql", "spring");
//		ctx.getEnvironment().setActiveProfiles("mysql", "mybatis");
		
		ctx.load("spring/beans_oracle.xml", "spring/beans_mysql.xml");
		ctx.refresh();
		
		MemberRegsisterService service = ctx.getBean(MemberRegsisterService.class);
		MemberInfoService infoService = ctx.getBean(MemberInfoService.class);
		
		Member m = ctx.getBean(Member.class);
		m.setEmail("abc111");
		m.setPassword("1");
		try {
			service.register(m);
			
		} catch (AlreadyExsitingMemberException e) {
			// TODO Auto-generated catch block
			log.info("멤버가 존재합니당 " + e);
			
		}
		
		log.info("id = "+m.getId());
		log.info("email = "+m.getEmail());
		log.info("password = "+m.getPassword());
		
//		Member info = infoService.getMember()
		
		}
		
		
		


}
