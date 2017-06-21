package com.itc.bean;

import java.util.HashMap;
import java.util.Map;
import com.itc.bean.Activity;

public class AppDataBuilder {

	private static Map<Integer, Activity> dataSource = new HashMap<Integer, Activity>();
	private static Map<Integer, RelationVO> reldata = new HashMap<Integer, RelationVO>();
	private static Map<Integer, ActionitemVO> actItemdata = new HashMap<Integer, ActionitemVO>();
	private static Map<Integer, ContactInfoVo> contactInfodata = new HashMap<Integer, ContactInfoVo>();
	private static Map<Integer, ServiceVO> servicedata = new HashMap<Integer, ServiceVO>();
	private static Map<Integer, InteractionLog> interactionLogdata = new HashMap<Integer, InteractionLog>();
	
	public static Map<Integer, Activity> buildBasicData(){
		dataSource.put(1, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened","") );
		dataSource.put(2, new Activity(2,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened","") );
		dataSource.put(1, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened","") );
//		dataSource.put(4, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(5, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(7, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(8, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(9, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(10, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(11, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(12, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
//		dataSource.put(13, new Activity(1,"Interact wit Contact", "Interact wit Contact(inbound/initial)", "Finance","Person 1","2 Medium"," 03.10.2016","Opened","Activity opened") );
		return dataSource;
	}
	
	public static Map<Integer, RelationVO> buildRelData(){
		reldata.put(1, new RelationVO(1,"Achmed Hussain","Spouse","","98523147","u1017"));
		reldata.put(2, new RelationVO(2,"UAE Constructions Inc.","Sponsor","","","building"));
		reldata.put(3, new RelationVO(3,"Daud Hussain","Child","","98523148","relTwo"));
		return reldata;
	}
	
	public static Map<Integer, ActionitemVO> buildActionitemData(){
		actItemdata.put(1, new ActionitemVO(1,"card","Claim payment No: 7243674654545","99999999 ","7872633","Upcoming","22.06.2016"));
		actItemdata.put(2, new ActionitemVO(2,"phone","Sheduled call back overdue","-","","Overdue","22.06.2016"));
		actItemdata.put(3, new ActionitemVO(3,"timeicon","Claim was not reimbursed on time","99999999","7872633","Incident","18.06.2016"));
		return actItemdata;
	}
	
	public static Map<Integer, ContactInfoVo> buildContactInfoData(){
		contactInfodata.put(1, new ContactInfoVo(1,"Saab Hussain",+971-1-2348385,"saab@gmail.com","Saab handles the Issue for his father because Aali is on vacation. Hussain landline Monday to Friday, 08:00 till 16:30","Prio 1"));
		contactInfodata.put(2, new ContactInfoVo(2,"Aali Hussain",+971-1-1234567,"ali@gmail.com","","Prio 2"));
		contactInfodata.put(3, new ContactInfoVo(3,"Caution about the grandmother",+971-1-2348385,"","If the grandmother picks up the phone: She is not up to date at all. Ask for Saab and Aali.","Prio 1"));
		return contactInfodata;
	}
	
	public static Map<Integer, ServiceVO> buildServiceData(){
		servicedata.put(1, new ServiceVO(1,"345837489570","thumsup","Aali Hussain",""));
		servicedata.put(2, new ServiceVO(2,"12345678 / 759237","card","Aali Hussain",""));
		return servicedata;
	}
	
	public static Map<Integer, InteractionLog> buildInteractionLogData(){
		interactionLogdata.put(1, new InteractionLog(1,"Inbound call from 987 654 321","Aali Hussain","aliimg","Stephen Miller","u67","09.08.2016 15:23 (3:25 Minutes)",""));	
		return interactionLogdata;
	}

}
