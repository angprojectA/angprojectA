package com.webapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.webapp.exception.AlreadyExsitingMemberException;
import com.webapp.exception.MemberUnRegisterEmptyException;
import com.webapp.model.Member;
import com.webapp.model.MemberList;

public class MemberUnRegsisterServiceTest {

	static Log log = LogFactory.getLog(MemberUnRegsisterServiceTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("oracle", "spring");
//		ctx.getEnvironment().setActiveProfiles("oracle", "mybatis");
//		ctx.getEnvironment().setActiveProfiles("mysql", "spring");
//		ctx.getEnvironment().setActiveProfiles("mysql", "mybatis");
		
		ctx.load("spring/beans_oracle.xml", "spring/beans_mysql.xml");
		ctx.refresh();
		
		MemberUnRegsisterService service = ctx.getBean(MemberUnRegsisterService.class);
		
		Member m = ctx.getBean(Member.class);
		m.setId(10100);
		m.setEmail("abc12");
		
		try {
//			service.unregister(m.getId());
			service.unregister(m.getEmail());
			
		} catch (MemberUnRegisterEmptyException e) {
			log.info("멤버가 존재합니당 " + e);
		}
		
		
//		Member info = infoService.getMember()
		
		}
		
		
		


}
