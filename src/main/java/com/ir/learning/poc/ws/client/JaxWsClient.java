package com.ir.learning.poc.ws.client;

import com.ir.learning.poc.generated.ws.model.ArrayOfError;
import com.ir.learning.poc.generated.ws.model.ArrayOfIdentifierVehicle;
import com.ir.learning.poc.generated.ws.model.ArrayOfMyTransicsUser;
import com.ir.learning.poc.generated.ws.model.ArrayOfPersonalCommunicationInsert;
import com.ir.learning.poc.generated.ws.model.ArrayOfString;
import com.ir.learning.poc.generated.ws.model.ArrayOfSubGroupInsert;
import com.ir.learning.poc.generated.ws.model.AssignGroupToDispatcher2;
import com.ir.learning.poc.generated.ws.model.AssignVehicleToGroup2;
import com.ir.learning.poc.generated.ws.model.EnumGenderType;
import com.ir.learning.poc.generated.ws.model.EnumGroupType;
import com.ir.learning.poc.generated.ws.model.EnumIdentifierMyTransicsUserType;
import com.ir.learning.poc.generated.ws.model.EnumIdentifierType;
import com.ir.learning.poc.generated.ws.model.EnumIdentifierVehicleType;
import com.ir.learning.poc.generated.ws.model.EnumRoleType;
import com.ir.learning.poc.generated.ws.model.ExecutionResult;
import com.ir.learning.poc.generated.ws.model.GetGroupResultV2;
import com.ir.learning.poc.generated.ws.model.GetRoleResult;
import com.ir.learning.poc.generated.ws.model.GetTrailerResultV6;
import com.ir.learning.poc.generated.ws.model.GetUserResult;
import com.ir.learning.poc.generated.ws.model.GetUsersResult;
import com.ir.learning.poc.generated.ws.model.GroupInsert;
import com.ir.learning.poc.generated.ws.model.GroupSelectionV2;
import com.ir.learning.poc.generated.ws.model.GroupToUpdate;
import com.ir.learning.poc.generated.ws.model.GroupTypeV2;
import com.ir.learning.poc.generated.ws.model.GroupUpdate;
import com.ir.learning.poc.generated.ws.model.Identifier;
import com.ir.learning.poc.generated.ws.model.IdentifierVehicle;
import com.ir.learning.poc.generated.ws.model.InterfaceTrailerInsert;
import com.ir.learning.poc.generated.ws.model.Login;
import com.ir.learning.poc.generated.ws.model.MyTransicsUser;
import com.ir.learning.poc.generated.ws.model.PersonalCommunicationInsert;
import com.ir.learning.poc.generated.ws.model.ResultInfo;
import com.ir.learning.poc.generated.ws.model.RightsProfile;
import com.ir.learning.poc.generated.ws.model.Roles;
import com.ir.learning.poc.generated.ws.model.Service;
import com.ir.learning.poc.generated.ws.model.SubGroupInsert;
import com.ir.learning.poc.generated.ws.model.TxConnectDispatcherDetails;
import com.ir.learning.poc.generated.ws.model.UpdateGroupResult;
import com.ir.learning.poc.generated.ws.model.UserDetails;
import com.ir.learning.poc.generated.ws.model.UserProfile;
import com.ir.learning.poc.generated.ws.model.UserSelection;
import com.ir.learning.poc.generated.ws.model.VehicleSelectionWithNextStopInfoWithoutDate;

public class JaxWsClient {

	//	Duplicated active trailers found: 84577, 84578 
	
//	<MyTransicsUserId>5e6a3c3cd1442609fb38cb82</MyTransicsUserId> this is user id in get user
//    <TxConnectDispatcherId>13181</TxConnectDispatcherId> this is transic id in assign to group
//	
//	Transics User ID: 5e6a4c03d1442609fb38cba3 (
//	Tx Connect Dispatcher ID: 13183

	public static void main(String[] args) {
		JaxWsClient client = new JaxWsClient();

//		client.buildVersion();
//		System.out.println("--------------------------");
//		client.getRoles();
//		System.out.println("--------------------------");
//		client.getUsers();
//
//		System.out.println("--------------------------");
//		client.insertUser();
//		System.out.println("--------------------------");
//		client.createGroup();
//		System.out.println("--------------------------");
		client.getGroups();
//		System.out.println("--------------------------");
//		client.updateGroup();
//		System.out.println("--------------------------");
//		client.insertVehicle();
//		System.out.println("--------------------------");
//		client.getTrailers();
//		System.out.println("--------------------------");
//		client.assignTrailerToGroup();
//		System.out.println("--------------------------");
//		client.assignGroupToDispatcher();
	}

	private void assignGroupToDispatcher() {
		Service service = new Service();
		Login login = getLogin();
		
		AssignGroupToDispatcher2 assignGroupToDispatcher = new AssignGroupToDispatcher2();
		assignGroupToDispatcher.setGroupCode("IBR");
		assignGroupToDispatcher.setSubGroupCode("SUBIBR");
		Identifier id = new Identifier();
		id.setIdentifierType(EnumIdentifierType.TRANSICS_ID);
		id.setId("13182");
		// transic id is dispatcher user id
		// id is person id
		assignGroupToDispatcher.setDispatcher(id);
		assignGroupToDispatcher.setGroupType(EnumGroupType.TRAILERS);
		System.out.println("Invoking the web services: assignGroupToDispatcher");
		ExecutionResult result = service.getServiceSoap().assignGroupToDispatcher(login, assignGroupToDispatcher);
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("Execution time: " + result.getExecutiontime());
		} else {
			printErrors(result.getErrors());
		}
	}

	private void assignTrailerToGroup() {
		Service service = new Service();
		Login login = getLogin();
		
		AssignVehicleToGroup2 assign = new AssignVehicleToGroup2();
		assign.setGroupCode("IBR3");
		assign.setSubGroupCode("SUBIBR3");
		IdentifierVehicle iv = new IdentifierVehicle();
		iv.setIdentifierVehicleType(EnumIdentifierVehicleType.TRANSICS_ID);
		iv.setId("84591");
		assign.setVehicle(iv);
		
		
		System.out.println("Invoking the web services: assignTrailerToGroup");
		ExecutionResult result = service.getServiceSoap().assignTrailerToGroup(login, assign);
		
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("Assignment done: " + result.getExecutiontime());
		} else {
			printErrors(result.getErrors());
		}
		
	}

	

	private void getTrailers() {
		Service service = new Service();
		Login login = getLogin();
		
		VehicleSelectionWithNextStopInfoWithoutDate vs = new VehicleSelectionWithNextStopInfoWithoutDate();
		ArrayOfIdentifierVehicle array = new ArrayOfIdentifierVehicle();
		
		IdentifierVehicle indentifier = new IdentifierVehicle();
		indentifier.setIdentifierVehicleType(EnumIdentifierVehicleType.TRANSICS_ID);
		indentifier.setId("84591");
		array.getIdentifierVehicle().add(indentifier);
		vs.setIdentifiers(array);
		vs.setShowInactive(false);
		vs.setIncludeNextStopInfo(false);
		
		System.out.println("Invoking the web services: getTrailers");
		GetTrailerResultV6 trailersV6 = service.getServiceSoap().getTrailersV6(login, vs);
		if(trailersV6.getErrors().getError().isEmpty()) {
			System.out.println("Transics Vehicle License plate: " + trailersV6.getTrailers().getTrailerResultV6().get(0).getLicensePlate());
		} else {
			printErrors(trailersV6.getErrors());
		}
	}

	private void insertVehicle() {
		Service service = new Service();
		Login login = getLogin();
		
		InterfaceTrailerInsert ti = new InterfaceTrailerInsert() ;
		ti.setVehicleID("2555789");
		ti.setVehicleExternalCode("2555789");
		ti.setLicensePlate("L11CCeSNC3");
		
		System.out.println("Invoking the web services: insertVehicle");
		ResultInfo result = service.getServiceSoap().insertTrailerV2(login, ti);
		
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("Transics Vehicle ID: " + result.getID());
		} else {
			printErrors(result.getErrors());
		}
	}

	private void updateGroup() {
		Service service = new Service();
		Login login = getLogin();
		
		GroupUpdate gu = new GroupUpdate();
		
		GroupToUpdate gtu = new GroupToUpdate();
		gtu.setGroupType(GroupTypeV2.TRAILERS);
		gtu.setGroupCodeToUpdate("IBR2");
		gtu.setSubGroupCodeToUpdate("SUBIBR2");
		
		gu.setGroupToUpdate(gtu);
		gu.setDescription("Test sub group 2 for Ibrahim:update");
		
		System.out.println("Invoking the web services: updateGroup");
		UpdateGroupResult result = service.getServiceSoap().updateGroup(login, gu);
		
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("updated group code: " + result.getUpdatedGroupCode());
		} else {
			printErrors(result.getErrors());
		}
		
		System.out.println("Deleting a group......");
		
		gu = new GroupUpdate();
		
		gtu = new GroupToUpdate();
		
		gtu.setGroupType(GroupTypeV2.TRAILERS);
		gtu.setGroupCodeToUpdate("IBR4");
		gtu.setSubGroupCodeToUpdate("SUBIBR4");
		
		gu.setGroupToUpdate(gtu);
		gu.setDelete(true);
		
		result = service.getServiceSoap().updateGroup(login, gu);
		
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("deleted group code: " + result.getUpdatedGroupCode());
		} else {
			printErrors(result.getErrors());
		}
	}

	private void createGroup() {
		Service service = new Service();
		Login login = getLogin();
		System.out.println("Invoking the web services: createGroup");
		GroupInsert groupInsert = new GroupInsert();
		groupInsert.setCode("IBR4");
		groupInsert.setDescription("Test group 4 for Ibrahim");
		groupInsert.setType(GroupTypeV2.TRAILERS);

		ArrayOfSubGroupInsert array = new ArrayOfSubGroupInsert();
		SubGroupInsert sg = new SubGroupInsert();
		sg.setCode("SUBIBR4");
		sg.setDescription("Test group 4 for Ibrahim");
		array.getSubGroupInsert().add(sg);
		groupInsert.setSubGroups(array);
		ExecutionResult result = service.getServiceSoap().insertGroup(login, groupInsert);
		if(result.getErrors().getError().isEmpty()) {
			System.out.println("Execution time: " + result.getExecutiontime());
		} else {
			printErrors(result.getErrors());
		}

	}

	private void getGroups() {
		Service service = new Service();
		Login login = getLogin();
		GroupSelectionV2 gs = new GroupSelectionV2();
		gs.setGroupType(GroupTypeV2.TRAILERS);
		GetGroupResultV2 groupsResult = service.getServiceSoap().getGroupsV2(login, gs);
		System.out.println("Invoking the web services: getGroups");
		if(groupsResult.getErrors().getError().isEmpty()) {
			System.out.println("Transics Users count: " + groupsResult.getGroups().getGroupResultV2().size());
			groupsResult.getGroups().getGroupResultV2().forEach(group -> {
				System.out.println("Group name: " + group.getDescription());
				System.out.println("Sub group count: " + group.getSubGroups().getSubGroupResultV2().size());
			});
		} else {
			printErrors(groupsResult.getErrors());
		}
	}

	private void buildVersion() {
		Service service = new Service();
		System.out.println("Invoking the web services: buildVersion");
		String buildVersion = service.getServiceSoap().getBuildVersion();
		System.out.println("Version: " + buildVersion);
	}

	private void getRoles() {
		Service service = new Service();
		Login login = getLogin();
		Roles roleType = new Roles();
		roleType.setEnumRoleType(EnumRoleType.MY_TRANSICS_ROLES);
		System.out.println("Invoking the web services: getRoles");
		GetRoleResult rulesResult = service.getServiceSoap().getRoles(login, roleType);
		if(rulesResult.getErrors().getError().isEmpty()) {
			rulesResult.getRoles().getRoleResult().forEach(role -> {
				System.out.println("Role ID: " + role.getRoleId());
				System.out.println("Role Name" + role.getRoleName());
			});
		} else {
			printErrors(rulesResult.getErrors());
		}

	}

	private void getUsers() {
		Service service = new Service();
		Login login = getLogin();

		UserSelection us = new UserSelection();

		ArrayOfMyTransicsUser array = new ArrayOfMyTransicsUser();
		MyTransicsUser tu = new MyTransicsUser();
		tu.setIdentifierType(EnumIdentifierMyTransicsUserType.USER_ID);
		//tu.setId("5d7b4d76aa1b4242766b8af5");
		tu.setId("5e6a4c03d1442609fb38cba3");
		array.getMyTransicsUser().add(tu);
		us.setIdentifiers(array);

		us.setIncludeInactive(false); 
		System.out.println("Invoking the web services: getUsers");
		GetUsersResult userResult = service.getServiceSoap().getUsers(login, us);
		if(userResult.getErrors().getError().isEmpty()) {
			System.out.println("Transics Users count: " + userResult.getMyTransicsUsers().getGetUserDetailsResult().size());
		} else {
			printErrors(userResult.getErrors());
		}
	}

	private void insertUser() {
		Service service = new Service();

		Login login = getLogin();

		UserDetails userDetails = new UserDetails();
		userDetails.setInactive(false);
		userDetails.setDisplayName("jgh");
		userDetails.setJobTitle("jhj");
		userDetails.setFirstName("jghj");
		userDetails.setLastName("jhgjg");
		ArrayOfString array = new ArrayOfString();
		array.getString().add("test@zzzz.com");
		userDetails.setEmails(array);
		userDetails.setGender(EnumGenderType.MALE);
		userDetails.setLanguage("EN");
		userDetails.setTimeZone("Europe/Amsterdam");
		ArrayOfString arrayRoles = new ArrayOfString();
		arrayRoles.getString().add("5a0018c4d606b9501d31e741");
//		arrayRoles.getString().add("5a0018c4d606b9501d31e741");
		userDetails.setRoleIds(arrayRoles);
		userDetails.setDomainLogin(true);
		userDetails.setSendInvitation(true);
		userDetails.setTwoStepAuthentication(false);

		TxConnectDispatcherDetails dd = new TxConnectDispatcherDetails();
		ArrayOfPersonalCommunicationInsert array1 = new ArrayOfPersonalCommunicationInsert();
		PersonalCommunicationInsert pic = new PersonalCommunicationInsert();
		pic.setDescription("jjj");
		pic.setNumber("4342");
		pic.setType("Tel");
		array1.getPersonalCommunicationInsert().add(pic);
		dd.setPersonalCommunication(array1);
		dd.setPersonID("944344");
		dd.setPersonExternalCode("944344");
//		dd.setInactive(false);
		dd.setLanguage("EN");
		dd.setEmail("test@zzzz.com");
		dd.setPassword("abc123");
		UserProfile up = new UserProfile();
//		up.setId(3769);
		up.setId(17);
//		up.setName("Default profile");
		dd.setUserProfile(up);
		RightsProfile rp = new RightsProfile();
		rp.setId(269);
//		rp.setId(80486);
//		rp.setName("Administrator");
		dd.setRightsProfile(rp);
		userDetails.setDispatcherStrategy(dd);

		System.out.println("Invoking the web services: insertUser");
		GetUserResult userResult = service.getServiceSoap().insertUser(login, userDetails);

		if(userResult.getErrors().getError().isEmpty()) {
			System.out.println("Transics User ID: " + userResult.getMyTransicsUserId());
			System.out.println("Tx Connect Dispatcher ID: " +userResult.getTxConnectDispatcherId());
		} else {
			printErrors(userResult.getErrors());
		}

	}	

	//	private Login getLogin() {
	//		Login login = new Login();
	//		login.setDispatcher("WAM_API");
	//		login.setPassword("WAM_API_7206002006");
	//		login.setIntegrator("WAM_API");
	//		login.setSystemNr(2006);
	//		login.setVersion(0);
	//		login.setLanguage("EN");
	//		return login;
	//	}

	private Login getLogin() {
		Login login = new Login();
		login.setDispatcher("WAM_API");
		login.setPassword("WAM_API_1316800048");
		login.setIntegrator("WAM_API");
		login.setSystemNr(48);
		login.setVersion(0);
		login.setLanguage("EN");
		return login;
	}
	
	private void printErrors(ArrayOfError errors) {
		errors.getError().forEach(err -> {
			System.out.println("Error code: " + err.getErrorCode());
			System.out.println("Error code cxplanation: " + err.getErrorCodeExplanation());
			System.out.println("Field: " + err.getField());
			System.out.println("Value: " + err.getValue());
		});
		
	}

}
