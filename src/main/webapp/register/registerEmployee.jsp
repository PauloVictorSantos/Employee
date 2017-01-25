<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
	<portlet:actionURL var="registerLink" />
	<form action="<%=registerLink%>" method="post">
		<table width="100%">
			<tr width="60%">
				<td>Enter Employee Name:</td>
				<td><input name="<portlet:namespace />employeeName" /></td>
			</tr>
			<tr width="60%">
				<td>Enter Employee Job:</td>
				<td><input name="<portlet:namespace />employeeJob" /></td>
			</tr>
			<tr width="60%">
				<td>Enter Employee Salary:</td>
				<td><input name="<portlet:namespace />employeeSalary" /></td>
			</tr>
			<tr width="60%" align="center">
				<td colspan="2"><input type="submit" name="<portlet:namespace />Register"
					value="Register" /></td>
			</tr>
		</table>
	</form>
	<portlet:actionURL var="showregister">
        <portlet:param name="status" value="showall"/>
    </portlet:actionURL>
	<form action="<%=showregister %>" method="post">
		<input type="submit" name="<portlet:namespace />showEmployee" value="Show">
		<br>
	</form>
</body>
</html>