<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#deleteEmployee").hide();
     $("#updateEmployee").hide();
    
    $("#update").click(function(){
        $("#updateEmployee").show();
        $("#deleteEmployee").hide();
    });
    $("#delete").click(function(){
        $("#deleteEmployee").show();
         $("#updateEmployee").hide();
    });
});
</script>
    </head>
    <body>
All Employees: <br> 
        <c:forEach var="emp" items="${employeeList}">
            Employee ID: ${emp.id} <br>
            Employee Name: ${emp.name} <br>
            Employee Job: ${emp.job}<br>
             Employee Salary: ${emp.salary}<br>
            -------------------------------------<br>
        </c:forEach>
	<portlet:actionURL var="registerLink" />
	<form action="<%=registerLink %>" method="post">
            Update: <input type="checkbox" id="update"> 
            Delete: <input type="checkbox" id="delete" onclick="document.getElementById('ename').disabled=this.checked;document.getElementById('enumberupdate').disabled=this.checked;"><br><br>
            <select name="<portlet:namespace />id">
                <c:forEach items="${employeeList}" var="employee">
                <option value="${employee.id}">${employee.id}</option>
                 </c:forEach>
            </select>
            
            <br>
            Update Name: <input id="ename" type="text" name="<portlet:namespace />employeeName"><br>
            Update Job: <input id="enumberupdate" type="text" name="<portlet:namespace />employeeJob"> <br>
            Update Salary: <input id="enumberupdate" type="text" name="<portlet:namespace />employeeSalary"> <br>
            <br>
            <button type="submit" id="updateEmployee" name="<portlet:namespace />updateEmployee"> Update</button> <br> <br>
            <button type="submit" id="deleteEmployee" name="<portlet:namespace />deleteEmployee"> Delete </button>
        </form>
    </body>
</html>