<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact info</title>
<style type="text/css">
	.error{
		color: blue;
	}

</style>
</head>
<body>
<form:form action="addContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact" >
		<%-- <p style="color:red">
          <form:errors path="*"/>
       </p> <br> --%>
       <h3 style="color:red;text-align:center;"> ${successMsg} ${errorMsg}  </h3>
       
	<div align="center">
	 	<table class="center">
	 	    <tr>
                <td colspan="2" align="center"><h2>Contact-Info</h2></td>
            </tr>
       		<tr>
       			<%-- <form:hidden path="contactId"/> --%>
				<td>Contact Name::</td>
				<td><form:input path="contactName"/></td>
				<td><form:errors path="contactName" cssClass="error"/></td><br>
			</tr>
		   	<tr>
		     	<td>Contact Email::</td>
		     	<td><form:input path="contactEmail"/></td>
		     	<td><form:errors path="contactEmail" cssClass="error"/></td><br>
		  
		   	</tr>
			<tr>
				<td>Contact Number::</td>
				<td><form:input path="contactNumber"/></td>
				<td><form:errors path="contactNumber" cssClass="error"/></td><br>
			</tr>
		   	 <tr>
				<td><input type="submit" value="submit"></td>
				<td><b><a href="getAllContacts" style="color:red">View All Contacts</a></b></td>
				<td><b><a href="home" style="color:red">Home</a></b></td>
			</tr>	
     	 </table>
     </div>	 
  </form:form>
                
 
</body>
</html>