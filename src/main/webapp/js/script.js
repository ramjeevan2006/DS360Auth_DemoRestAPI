var token;
var userName;
var userRole;

$(document).ready(function(){
	$('#content').load('login.html'); 
	
	window.onbeforeunload = function () {
		
		var r = confirm("Do you really want to exit?");
		if (r == true) {
			logOut();
		}
	   
	};
	
});
function getUserRole(param){
	   if(param=(new RegExp('[?&]'+encodeURIComponent(param)+'=([^&]*)')).exec(location.search))
	      return decodeURIComponent(param[1]);
}

function authenticateUser() {
	
	var credentials = new Object();
	credentials.userName = $("#username").val();
	credentials.password = $("#password").val();
	if(!credentials.userName){
		alert("Username cannot be Empty");
		return;
	}
	if(!credentials.password ){
		alert("Password cannot be Empty");
		return;
	}
	var url = "auth/authentication/authenticate";

	$.ajax({
		beforeSend : function(xhr) {
			//console.log("beforeSend");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
		},
		url : url,
		data : JSON.stringify(credentials),
		type : 'post',
		dataType : 'text'

	}).fail(function(response) {
		console.log("Authentication failed : "+response.statusText);
		 $("#status").text(response.statusText); 
	}).done(function(response) {
		initilize(response,true);
	});

}

function initilize(response,homeFlag){
	//userName=$("#username").val();
	response = response.toString().replace(/[\[\|&;$%@"<>()\]\+]/g, "").split(",");
	console.log("response = "+response);
	userName=response[0];
	userRole=response[1];
	token = response[2];
	if(homeFlag){
		$('#content').load('home.html'); 
	}
	
}


function logOut() {
	
	var url = "auth/authentication/logOut";
	$.ajax({
		beforeSend : function(xhr) {
			//console.log("beforeSend");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
		},
		url : url,
		type : 'post',
		dataType : 'text'

	}).fail(function(response) {
		console.log("logOut failed : "+response.statusText);
	}).done(function(response) {
		/*token = "";
		if(response === "LOGGED_OUT"){
			console.log("logOut response = "+response);
			$('#content').load('login.html'); 
		}*/
		
	});
	window.location.href = "index.html";
	
}

function accesWithToken() {

	var url = "rest/test/secured";

	$.ajax({
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Authorization", "Bearer " + token);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
			
		},
		url : url,
		type : 'get',
		dataType : 'json'

	}).fail(function(response) {
		executeOnError(response,userName);
		
		$("#resp").text(response.responseText);
	}).done(function(response) {
		$("#resp").html(response.responseText);
	});

}

function accessWithOutToken() {

	var url = "rest/test/secured";

	$.ajax({
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
			
		},
		url : url,
		type : 'get',
		dataType: "json"
	}).fail(function(response) {
		$("#resp").text(response.responseText);
		
	}).done(function(response) {
		$("#resp").text(response.responseText);
	});
}

function accesUnSecuredMehod() {

	var url = "rest/test/unsecured";

	$.ajax({
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
			
		},
		url : url,
		type : 'get',
		dataType : 'json'

	}).fail(function(response) {
		//$("#resp").html(response.responseText);
		$("#resp").text(response.responseText);
	}).done(function(response) {
		$("#resp").html(response.responseText);
	});

}

function accesService(endPoint) {

	var url = "rest/UserInfoService/"+endPoint;

	$.ajax({
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Authorization", "Bearer " + token);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
			
		},
		url : url,
		type : 'get',
		dataType : 'json'

	}).fail(function(response) {
		//$("#resp").html(response.responseText);
		$("#resp").text(response.responseText);
	}).done(function(response) {
		$("#resp").text(response);
	});

}

function executeOnError(response,userName){
	switch(response.responseText){
		case "TOKEN_EXPIRED":  refreshToken(userName); break;
		case "INVALID_TOKEN":   break; // need to write logic for this 
						
	}
}

function refreshToken(userName) {
	
	var url = "auth/authentication/refreshToken";

	$.ajax({
		beforeSend : function(xhr) {
			//console.log("beforeSend");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
		},
		url : url,
		data : JSON.stringify(userName),
		type : 'post',
		dataType : 'text'

	}).fail(function(response) {
		console.log("RefreshToken failed : "+response.statusText);
	}).done(function(response) {
		console.log("RefreshToken success : "+response.statusText);
		initilize(response,false);
	});

}

