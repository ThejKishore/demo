# demo
Workspace for my reference

This is a spring boot application that has the following modules.

    1) Spring Rest : the ContactRSImpl in the com.kish.rs.service
    2) Spring JDBC Template:  the ContactJdbcTemplate in the com.kish.xdoc.dbo.template
    3) Spring Security: the WebSecurityConfig in the com.kish.xdoc.sec
    4) Spring MCV : the WelcomeController in the com.kish.xdoc.web.controller
    5) Jquery and Datatable : in welcome.jsp and in resources/static/js


This has simple demo that show the CRUD operations that are exposed by rest api and how JDBC Template is used.
Along with that it applies basic spring security and the Jquery library at the front end to get the data from the rest.


Application is hosted in pivotal the url is

 https://kishdemo.cfapps.io/contactUI
 guest/guest
 admin/admin
 admin1/password

 Rest API Documents using Swagger:
 ---------------------------------
 https://kishdemo.cfapps.io/swagger-ui.html

