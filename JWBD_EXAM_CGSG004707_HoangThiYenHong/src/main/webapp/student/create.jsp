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
        <a href="home?action=home">List All Students</a>
    </h2>
</center>
<div  class="container" style="width: 50%">
    <form method="post">
        <table class="table caption-top" width="60%" >
            <caption>
                <h2>Add New Student</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.getName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Date of birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Class:</th>
                <td>
                    <input type="text" name="class" size="45"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
