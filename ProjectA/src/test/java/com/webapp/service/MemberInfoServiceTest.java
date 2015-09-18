package com.webapp.service;

import java.util.List;

import oracle.net.aso.l;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.webapp.exception.MemberNotFoundException;
import com.webapp.model.Member;
import com.webapp.model.MemberList;

public class MemberInfoServiceTest {

	static Log log = LogFactory.getLog(MemberInfoServiceTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("oracle", "spring");
//		ctx.getEnvironment().setActiveProfiles("oracle", "mybatis");
//		ctx.getEnvironment().setActiveProfiles("mysql", "spring");
//		ctx.getEnvironment().setActiveProfiles("mysql", "mybatis");
		
		ctx.load("spring/beans_oracle.xml", "spring/beans_mysql.xml");
		ctx.refresh();
		
		MemberInfoService service = ctx.getBean(MemberInfoService.class);
		
		try {
//			Member m = service.getMember(0);
			Member m = service.getMember("xxx");
			
			log.info("member id = "+ m.getId());
//			log.info("member email = "+ m.getEmail());
		} catch (MemberNotFoundException e) {
			// TODO Auto-generated catch block
			log.info("로그인값이 없다아아아아" , e);
		}
	
		}
		
		
		
	
}
