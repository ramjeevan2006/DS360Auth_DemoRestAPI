package com.itc.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itc.annotations.Secured;
import com.itc.annotations.UserRole;
import com.itc.bean.ActionitemVO;
import com.itc.bean.Activity;
import com.itc.bean.AuthorisationVO;
import com.itc.bean.CardVo;
import com.itc.bean.ContactInfoVo;
import com.itc.bean.Customer;
import com.itc.bean.IncedentVO;
import com.itc.bean.InteractionLog;
import com.itc.bean.RelationVO;
import com.itc.bean.RequestVO;
import com.itc.bean.ServiceVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


@Path("/UserInfoService")
public class SampleRestws {
    @Context
    private ServletContext sc;
    
	private Map<Integer, Activity> dataSourceMap;
	private Map<Integer, RelationVO> relDataMap;
	private Map<Integer, ActionitemVO> actItemMap;
	private Map<Integer, ContactInfoVo> contactInfoMap;
	private Map<Integer, ServiceVO> servicedata;
	private Map<Integer, InteractionLog> interactionLogdata;
	
	List<Activity> activityList = new ArrayList<Activity>();
	List<RequestVO> reqList = new ArrayList<RequestVO>();
	List<AuthorisationVO> authList = new ArrayList<AuthorisationVO>();
	List<IncedentVO> incidentList = new ArrayList<IncedentVO>();
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public String userName(String jsonstr) {
		
		System.out.println("user name method....");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		//incedent = new ObjectMapper().readValue(jsonstr, IncedentVO.class);
		IncedentVO incedent= new IncedentVO(1, "","","","Stephen","","","UAE",strDate,strDate, false,"-","Low","02387675864405467");
		Gson gson = new Gson();
		String jsonInString = gson.toJson(incedent);
		
		System.out.println("get json object : "+jsonInString);
		return jsonInString;
		
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/customerData")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListValues(@Context HttpHeaders hh){
		System.out.println("getting dropdown values");
		System.out.println("GET Authorization "+hh.getRequestHeader("Authorization"));
		String[] thisIsAStringArray = {"Show all", "Person", "Organisation", "Policy", "Authorisation","Claim","Incident"};
		Customer customer = new  Customer("Aali Hussain", "Male", "06.12.1978 / 38 years","UAE","101-1234567",987-8347-8484-5,"UAE","aliimg",thisIsAStringArray,true,"aali.hussain@provider.ae","971-1-1234567","Khaleej Al arabi Street","-","Abu Dhabi","Abu Dhabi","Abu Dhabi","www.uaeconstructions.ae");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(customer);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@POST
	@Path("/addActivity")
	//@Consumes(MediaType.TEXT_PLAIN)
	public Response  getJsonData(String jsonstr,@Context HttpHeaders hh) {
		
		System.out.println("consuming data...");
		System.out.println("GET DATA "+jsonstr);
		System.out.println("GET Content-Type "+hh.getHeaderString("Content-Type"));
		System.out.println("GET Authorization "+hh.getRequestHeader("Authorization"));
		System.out.println("GET headers "+hh.getRequestHeaders());
		
//		 resp.addHeader("Access-Control-Allow-Origin","*");
//		    resp.addHeader("Access-Control-Allow-Methods","GET,POST");
//		    resp.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

		
		String result = jsonstr;
		Activity newActivity;
		try {
			newActivity = new ObjectMapper().readValue(jsonstr, Activity.class);
			System.out.println("get activity object"+newActivity.getId());

			dataSourceMap = (Map<Integer, Activity>)sc.getAttribute("activityDataSource");
			dataSourceMap.put(newActivity.getId(),newActivity);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
		Response r =  Response.status(201).entity(result).cacheControl( cc ).build();

	 return r;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/listAcitivity")
	@Produces(MediaType.APPLICATION_JSON)
	public String getActivityList(){
		dataSourceMap = (Map<Integer, Activity>)sc.getAttribute("activityDataSource");
		System.out.println("getting dropdown values"+dataSourceMap);
		Gson gson = new Gson();
		String jsonStr=gson.toJson(dataSourceMap.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	 
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@POST
	@Path("/getPaginationValue")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response  paginationData(String jsonstr) {
		System.out.println("consuming paginationData...");
		System.out.println("GET DATA "+jsonstr);
		String result = jsonstr;
		
		
		CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
		Response r =  Response.status(201).entity(result).cacheControl( cc ).build();

	 return r;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/listOfRequests")
	@Produces(MediaType.APPLICATION_JSON)
	public String getrequestList(){
		reqList.add(new RequestVO(1,"Inquiry","Hospital payment Int.","22.06.2016 09:48","stephen","draft"));
		reqList.add(new RequestVO(2,"Complaint","Lorem Ipsum","22.06.2016 09:18","stephen","draft"));
		reqList.add(new RequestVO(3,"Compliment","Lorem Ipsum","22.06.2016 09:15","stephen","draft"));
		reqList.add(new RequestVO(4,"Complaint","Lorem Ipsum","22.06.2016 09:03","stephen","draft"));
		reqList.add(new RequestVO(5,"Inquiry","Hospital payment Int.","22.06.2016 09:48","stephen","draft"));
		reqList.add(new RequestVO(6,"Complaint","Lorem Ipsum","22.06.2016 09:18","stephen","draft"));
		reqList.add(new RequestVO(7,"Compliment","Lorem Ipsum","22.06.2016 09:15","stephen","draft"));
		reqList.add(new RequestVO(8,"Complaint","Lorem Ipsum","22.06.2016 09:03","stephen","draft"));
		reqList.add(new RequestVO(9,"Inquiry","Hospital payment Int.","22.06.2016 09:48","stephen","draft"));
		reqList.add(new RequestVO(10,"Complaint","Lorem Ipsum","22.06.2016 09:18","stephen","draft"));
		reqList.add(new RequestVO(11,"Compliment","Lorem Ipsum","22.06.2016 09:15","stephen","draft"));
		reqList.add(new RequestVO(12,"Complaint","Lorem Ipsum","22.06.2016 09:03","stephen","draft"));
	
		Gson gson = new Gson();
		String jsonStr=gson.toJson(reqList);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/listOfAuth")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAuthorisationList(){	
		authList.add(new AuthorisationVO(1,"Authorisation 345837489570","Authorisation 345837489570","03.06.2016","Processed","H001 / Al Noor","23.06.2016"));
		authList.add(new AuthorisationVO(2,"Authorisation 345837489571","Authorisation 345837489571","03.06.2016","Processed","H001 / Al Noor","23.06.2016"));
		authList.add(new AuthorisationVO(3,"Authorisation 345837489572","Authorisation 345837489572","03.06.2016","Processed","H001 / Al Noor","23.06.2016"));
		authList.add(new AuthorisationVO(4,"Authorisation 345837489573","Authorisation 345837489573","03.06.2016","Processed","H001 / Al Noor","23.06.2016"));
		authList.add(new AuthorisationVO(5,"Authorisation 345837489574","Authorisation 345837489574","03.06.2016","Processed","H001 / Al Noor","23.06.2016"));
		Gson gson = new Gson();
		String jsonStr=gson.toJson(authList);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/listOfIncidents")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIncidentList(){	
		incidentList.add(new IncedentVO(1,"Inquiry","Incident 384638430","03.06.2016","Open","Authorisation","Europe Assistance","Not escalated","03.10.2016",null,false,null,"medium",""));
		incidentList.add(new IncedentVO(2,"Inquiry","Incident 384638430","03.06.2016","Open","Authorisation","Europe Assistance","Not escalated","03.10.2016",null,false,null,"medium",""));
		incidentList.add(new IncedentVO(3,"Inquiry","Incident 384638430","03.06.2016","Open","Authorisation","Europe Assistance","Not escalated","03.10.2016",null,false,null,"medium",""));
		incidentList.add(new IncedentVO(4,"Inquiry","Incident 384638430","03.06.2016","Open","Authorisation","Europe Assistance","Not escalated","03.10.2016",null,false,null,"medium",""));
		incidentList.add(new IncedentVO(5,"Inquiry","Incident 384638430","03.06.2016","Open","Authorisation","Europe Assistance","Not escalated","03.10.2016",null,false,null,"medium",""));
		Gson gson = new Gson();
		String jsonStr=gson.toJson(incidentList);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getAuthDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAuthorisationDetails(){	
		AuthorisationVO auth=new AuthorisationVO(1,"Authorisation 345837489570","Authorisation 345837489570","03.06.2016","Processed","H001 / Al Noor","23.06.2016");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(auth);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getIncedentDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getImcedentDetails(){	
		IncedentVO Incedent=new IncedentVO(1,"Inquiry","Incident 384638430","03.06.2016","Processed","Authorisation","Europe Assistance","Not escalated","02.10.2016",null,false,null,"medium","");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(Incedent);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getCardDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCardDetails(){	
		CardVo card=new CardVo(1,"759236","on hold","YEAR-MM-DD","YEAR-MM-DD","UAE Private","YEAR-MM-DD","Aali Hussain"," UAE Construction Inc","Dental","DN: 3500"," PC: 50","PC:20%  DN: 20%","PC: 50","NW UAE: Exclusive 1","Abroad: WW exc.  US CAN");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(card);
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getRelationLists")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRelationLists(){	
		relDataMap = (Map<Integer, RelationVO>)sc.getAttribute("relationData");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(relDataMap.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getActionItemLists")
	@Produces(MediaType.APPLICATION_JSON)
	public String getActionItemLists(){	
		actItemMap = (Map<Integer, ActionitemVO>)sc.getAttribute("actionItemdata");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(actItemMap.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getInfoLists")
	@Produces(MediaType.APPLICATION_JSON)
	public String getInfoLists(){	
		contactInfoMap = (Map<Integer, ContactInfoVo>)sc.getAttribute("contactInfoData");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(contactInfoMap.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@POST
	@Path("/getContactInformation")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response  getContactInformation(String jsonstr) {
		System.out.println("consuming getContactInformation...");
		System.out.println("GET DATA "+jsonstr);
		String result = jsonstr;
		
		
		CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
		Response r =  Response.status(201).entity(result).cacheControl( cc ).build();

	 return r;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getContactInfoLists")
	@Produces(MediaType.APPLICATION_JSON)
	public String getContactInfoLists(){	
		contactInfoMap = (Map<Integer, ContactInfoVo>)sc.getAttribute("contactInfoData");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(contactInfoMap.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getServiceDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getServiceDetails(){	
		servicedata = (Map<Integer, ServiceVO>)sc.getAttribute("servicedata");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(servicedata.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@POST
	@Path("/getAuthonticate")
	@Consumes(MediaType.TEXT_PLAIN)
	public String  getAuthonticate(String jsonstr) {
		System.out.println("consuming getAuthonticate...");
		System.out.println("GET DATA "+jsonstr);
		String result = jsonstr;
		
		
		CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
		Response r =  Response.status(201).entity(result).cacheControl( cc ).build();

	 return result;
	}
	
	@Secured({UserRole.ADMIN, UserRole.SUPERVISOR})
	@GET
	@Path("/getInteractionLogDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getInteractionLogDetails(){	
		interactionLogdata = (Map<Integer, InteractionLog>)sc.getAttribute("interactionLogdata");
		Gson gson = new Gson();
		String jsonStr=gson.toJson(interactionLogdata.values());
		//return "{'List': ['Show all', 'Person', 'Organisation', 'Policy', 'Authorisation','Claim','Incident']}";
		return jsonStr;
	}
}
