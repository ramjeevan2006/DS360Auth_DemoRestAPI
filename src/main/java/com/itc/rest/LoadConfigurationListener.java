package com.itc.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.itc.bean.ActionitemVO;
import com.itc.bean.Activity;
import com.itc.bean.AppDataBuilder;
import com.itc.bean.ContactInfoVo;
import com.itc.bean.InteractionLog;
import com.itc.bean.RelationVO;
import com.itc.bean.ServiceVO;



public class LoadConfigurationListener implements ServletContextListener {
	private Map<Integer, Activity> dataSourceMap;
	private Map<Integer, RelationVO> reldataMap;
	private Map<Integer, ActionitemVO> actItemMap;
	private Map<Integer, ContactInfoVo> contactInfoMap;
	private Map<Integer, ServiceVO> serviceMap;
	private Map<Integer, InteractionLog> interactionLogMap;
	
    public void contextInitialized(ServletContextEvent sce) {
        // read file or rdbms
       // ...
        ServletContext sc = sce.getServletContext();
        // set attributes
       // ...
        dataSourceMap = AppDataBuilder.buildBasicData();
		sc.setAttribute("activityDataSource", dataSourceMap);
		
		reldataMap = AppDataBuilder.buildRelData();
		sc.setAttribute("relationData", reldataMap);
		
		actItemMap = AppDataBuilder.buildActionitemData();
		sc.setAttribute("actionItemdata", actItemMap);
		
		contactInfoMap = AppDataBuilder.buildContactInfoData();
		sc.setAttribute("contactInfoData", contactInfoMap);
		
		serviceMap = AppDataBuilder.buildServiceData();
		sc.setAttribute("servicedata", serviceMap);
		
		interactionLogMap = AppDataBuilder.buildInteractionLogData();
		sc.setAttribute("interactionLogdata", interactionLogMap);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // remove attributes
      ///  ...
    }

}