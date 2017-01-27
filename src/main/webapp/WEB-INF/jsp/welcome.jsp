<%--
  Created by IntelliJ IDEA.
  User: ThejKishore
  Date: 1/19/2017
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->


    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css" rel="stylesheet"/>

    <script language="JavaScript" type="text/javascript" src="/js/jquery-3.1.1.js"></script>
    <script language="JavaScript" type="text/javascript" src="/js/contacts.js"></script>
    <script language="JavaScript" type="text/javascript"
            src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script language="JavaScript" type="text/javascript"
            src="https://cdn.datatables.net/1.10.13/js/dataTables.jqueryui.min.js"></script>

    <%-- <script language="JavaScript"
             src="https://code.jquery.com/jquery-3.1.1.js" crossorigin="anonymous"/>--%>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>

<script language="JavaScript" type="text/javascript">
    $(document).ready(function () {
        getContacts();
    });

</script>
<div class="container">

    <div class="starter-template">
        <h4>Spring Boot Web JSP Example</h4>
        <h5>Message: ${message}</h5>
    </div>


</div>

<table id="employeesTable" class="display" cellspacing="0" align="right" width="100%">

    <!-- Header Table -->
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    </thead>
    <!-- Footer Table -->
    <tfoot>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    </tfoot>
</table>
<button id="selectBt">Select</button>
<button id="addBt">Add Contact</button>

<div id="contactDisplay" width="50%">
    <fieldset>
        <legend>Contact Details</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td><input type="text" id="contactId" class="text-input" disabled="true"></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" id="contactName" class="text-input"></td>
            </tr>
            <tr>
                <td>Phone :</td>
                <td><input type="text" id="contactPhone" class="text-input"></td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><input type="text" id="contactMail" class="text-input"></td>
            </tr>
            <tr>
                <td>Address :</td>
                <td><input type="text" id="contactAddress" class="text-input"></td>
            </tr>
            <tr>
                <td>
                    <button id="addRecord">AddContact</button>
                    <button id="updateRecord">UpdateContact</button>
                </td>
                <td>
                    <button id="deleteRecord">DeleteContact</button>
                    <button id="clearForm">Clear</button>
                </td>
            </tr>
        </table>
    </fieldset>
</div>
</body>

</html>
