# demo - Spring Boot Sample

This is a spring boot application is a good starting application that has below modules.

    1) Spring Rest : the ContactRSImpl in the com.kish.rs.service
    2) Spring JDBC Template:  the ContactJdbcTemplate in the com.kish.xdoc.dbo.template
    3) Spring Security: the WebSecurityConfig in the com.kish.xdoc.sec
    4) Spring MVC : the WelcomeController in the com.kish.xdoc.web.controller
    5) Jquery and Datatable : in welcome.jsp and in resources/static/js

CRUD Operations are done using JDBC Template using in Memory H2 Database

CRUD operations are exposed outside by Spring Rest Controller . The rest api document are exposed using Swagger 2.
 
Spring MVC Controller used for handling the navigation.
 
The Front end is developed using the JSP and Jquery,JqueryUI and JQuery.DataTables

    <!-- CSS -->
    <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css" rel="stylesheet"/>

    <!-- js -->
    <script language="JavaScript" type="text/javascript" src="/js/jquery-3.1.1.js"></script>
    <script language="JavaScript" type="text/javascript" src="/js/contacts.js"></script>
    <script language="JavaScript" type="text/javascript"
            src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script language="JavaScript" type="text/javascript"
            src="https://cdn.datatables.net/1.10.13/js/dataTables.jqueryui.min.js"></script>

The Front end does Add/Update/Delete/Get Contacts through UI.

 

Application is hosted in pivotal (using the trail period)the url below might be unavailable after few days.

 _https://kishdemo.cfapps.io  -- No Login required_

 _https://kishdemo.cfapps.io/contactUI  -- Login required (REST UI PAGE )_
 
 _https://kishdemo.cfapps.io/property?q= <<propertyName>>  -- Login required_
 
 One of the listed credentials could be used for testing purpose:
 
    1) guest/guest
    2) admin/admin
    3) admin1/password
 
 
 **Rest API Documents using Swagger:**
 ---------------------------------
 
 _https://kishdemo.cfapps.io/swagger-ui.html -- Login required (REST API DOC Page build using Swagger 2)_

