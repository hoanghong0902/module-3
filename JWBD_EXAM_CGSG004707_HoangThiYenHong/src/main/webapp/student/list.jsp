<%--
  Created by IntelliJ IDEA.
  User: piiyk
  Date: 7/18/2023
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/home?action=create">Add New Student</a>
    </h2>
</center>
<div class="container" align="center" style="width: 70%">
    <table class="table table-striped caption-top">
        <caption><h2>List Students</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.getId()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
                <td><c:out value="${student.getDateOfBirth()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getAddress()}"/></td>
                <td>
                    <a href="/home?action=edit&id=${student.getId()}">Edit</a>
                    <a href="/home?action=delete&id=${student.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
