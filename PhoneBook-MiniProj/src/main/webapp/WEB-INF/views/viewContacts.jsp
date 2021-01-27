<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>

<script type="text/javascript">
	function confirmDelete() {
			return cofirm("Are u sure!! u want to delete?");
			//onclick="return confirmDelete()"//we have to add thid code infront of 
			//link
	}
	function clearFilter() {
		return window.location = '/PhoneBook-MiniProj/getAllContacts';
	}
</script>


</head>
<body>
	<div align="center">
		<h1 style="text-align: center; color: black">Contacts Details</h1>
		 <a href="addContact">Create New Contact</a>
	</div>
	<div>&nbsp;</div>
		<div align="center">
			<form action="getFilterContacts">
			Filter:<input type="text" name="keyword" required="required">&nbsp;
				   <input type="submit" value="Search">&nbsp;
				   <input type="submit" value="Clear" onclick="clearFilter()">
			
			</form>
		</div>
	<div>&nbsp;</div>
	<c:choose>
		<c:when test="${!empty allContacts}">
		  <div>
			<table border="1" style="text-align: center;" bgcolor="cyan" align="center">
				<tr bgcolor="white">
					<th>Contact_Id</th>
					<th>Contact_Name</th>
					<th>Contact_Email</th>
					<th>Contact_Number</th>
					<th>Contact_IsActive</th>
				</tr>
				<c:forEach var="contact" items="${allContacts}">
					<tr background="red">
						<td>${contact.contactId}</td>
						<td>${contact.contactName}</td>
						<td>${contact.contactEmail}</td>
						<td>${contact.contactNumber}</td>
						<td>${contact.contactIsActive}</td>
						<td><a href="updateContact?contactId=${contact.contactId}"><img src="images/edit1.jpg" width="40" height="40" align="bottom">Edit</a>&nbsp; &nbsp;
						 	 <a href="deleteContact/${contact.contactId}" onclick="return confirm('Are u sure!! u want to delete?')"><img src="images/delete1.jpg" width="40" height="40" align="bottom"/>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table><br><br>
		  </div>
		  <div align="center">
		  		Total Items: ${totalElements} - Page ${currentPage} of &nbsp;${totalPages}&nbsp; - &nbsp;
		  		
		  		<c:if test="${currentPage > 1}">
        			<a href="${pageContext.request.contextPath}/page/1">First</a>&nbsp;
    			</c:if>
    			&nbsp;
    			<c:if test="${currentPage > 1}">
        			<a href="${pageContext.request.contextPath}/page/${currentPage - 1}">Previous</a>&nbsp;
    			</c:if>
    			&nbsp;
   			    <c:forEach begin="${currentPage}" end="${totalPages}" var="i">
    				 <c:choose>
			            <c:when test="${i!=currentPage}">
			            	
			               <a href="${pageContext.request.contextPath}/page/<c:out value="${i}"/>"><c:out value="${i}"/></a>&nbsp;&nbsp;
			            </c:when>
			            <c:otherwise>
			                <c:out value="${i}"/>
			            </c:otherwise>        
       				 </c:choose>       
				</c:forEach>
				&nbsp;
				<c:if test="${currentPage < totalPages}">
        			<a href="${pageContext.request.contextPath}/page/${currentPage + 1}">Next</a>&nbsp;
    			</c:if>
    			&nbsp;
    			<c:if test="${currentPage < totalPages}">
        			<a href="${pageContext.request.contextPath}/page/${totalPages}">Last</a>&nbsp;
    			</c:if>
		  </div>
		</c:when>
		
			<c:otherwise>
              <h1 style="color:red;text-align:center">Records not found </h1>
   		 	</c:otherwise>
		
	</c:choose><br><br><br>
	
	 <c:if test="${!empty deleteMsg}">
     	<p style="background:yellow;text-align:center;color:red;font-size:20px">${deleteMsg} </p>
     </c:if> 
	
  <center> <b><a href="home" align="center">Home</a></b>   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
  <b><a href="JavaScript:showPrint()">Print</a></b>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
 

  <script language="JavaScript">

  		function showPrint(){
  			frames.focus();
  			frames.print();
  		}
  </script>
	
	
</body>
</html>