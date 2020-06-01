<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page errorPage="error.jsp" %>  
 <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <style type="text/css">
            .errormsg {
                color: red;
            }
        </style>
    </head>

<html>
<head>
	<title>Contact Page</title>
	<style type="text/css">
	   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		
		 table.center {
    margin-left: auto;
    margin-right: auto;
    border:1px solid black;
}

html, body {
    width: 100%;
}

.errormsg {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
			
	</style>

</head>
<body>
<h1>
	<center> Contact Details Application </center>
</h1>

<c:url var="addAction" value="/contactApp/saveOrEdit" ></c:url>
<table  style="border:1px solid black;margin-left:auto;margin-right:auto;">
<form:form action="${addAction}" commandName="contact">
<h4><center> Add Contact Details </center></h4>

	<c:if test="${!empty contact.contactId}">
	<tr>
	        
		<td>
			<form:label path="contactId">
				<spring:message text="Contact ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="contactId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="contactId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" /></td>
			<td><form:errors path="firstName" cssClass="errormsg" />
			
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td>
		<td><form:errors path="lastName" cssClass="errormsg" /></td>
	</tr>
	<tr>
		<td>
			<form:label path="phoneNumber">
				<spring:message text="Phone Numer"/>
			</form:label>
		</td>
		<td>
			<form:input path="phoneNumber" /></td>
			<td><form:errors path="phoneNumber" cssClass="errormsg" /></td>
		
	</tr>
	<tr>
		<td>
			<form:label path="emailId">
				<spring:message text="Email Id"/>
			</form:label>
		</td>
		<td>
			<form:input path="emailId" />
		</td>
		<td><form:errors path="emailId" cssClass="errormsg" /></td>
		
	</tr>
	<tr>
		<td>
			<form:label path="status">
				<spring:message text="Status"/>
			</form:label>
		</td>
		<td>
			 <form:select path = "status">
               <form:options items = "${statusList}" />
             </form:select>  
		</td>
	</tr>
	<tr colspan="2">
		<td colspan="1">
			<c:if test="${!empty contact.contactId}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty contact.contactId}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
	
</form:form>

<br>

<c:if test="${!empty contacts}">
	<table class="tg" style="border:1px solid black;margin-left:auto;margin-right:auto;">
	  <h3><center>Contacts List </center></h3>
	<tr>
		<th width="80">Contact ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">Phone Number</th>
		<th width="120">Email Id</th>
		<th width="120">Status</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${contacts}" var="contact">
		<tr>
			<td>${contact.contactId}</td>
			<td>${contact.firstName}</td>
			<td>${contact.lastName}</td>
			<td>${contact.phoneNumber}</td>
			<td>${contact.emailId}</td>
			<td>${contact.status}</td>
			<td><a href="<c:url value='/contactApp/edit/${contact.contactId}' />" >Edit</a></td>
			<td><a href="<c:url value='/contactApp/remove/${contact.contactId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>