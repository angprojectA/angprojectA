package com.webapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.webapp.exception.AlreadyExsitingMemberException;
import com.webapp.exception.MemberModifyEmptyException;
import com.webapp.model.Member;
import com.webapp.model.MemberList;

public class MemberModifyServiceTest {

	static Log log = LogFactory.getLog(MemberModifyServiceTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("oracle", "spring");
//		ctx.getEnvironment().setActiveProfiles("oracle", "mybatis");
//		ctx.getEnvironment().setActiveProfiles("mysql", "spring");
//		ctx.getEnvironment().setActiveProfiles("mysql", "mybatis");
		
		ctx.load("spring/beans_oracle.xml", "spring/beans_mysql.xml");
		ctx.refresh();
		
		MemberModifyService service = ctx.getBean(MemberModifyService.class);
		
		Member m = ctx.getBean(Member.class);
		
		m.setId(10100);
		m.setEmail("abc123323");
		
		m.setPassword(null);
		m.setName(null);
		
		log.info(m.toString());
		
		try {
			service.modify(m);
		} catch (MemberModifyEmptyException e) {
			// TODO Auto-generated catch block
			log.info("멤버가 없거나 잘못되었당 " + e);
			
		}
		
		
//		Member info = infoService.getMember()
		
		}
		
		
		


}
