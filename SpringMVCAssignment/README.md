Login_App with two types of actorAdmin, user (customer, client, etc)
Create table as login with emailid(PK), password, typeofuser in mysql database.Then you need to create dynamic web project using tomcat server.
Then convert this project to maven projectPlease add dependency asSpring mvcMysql connectorSpring jdbcPlease refer maven plugin file for dependency
Then in web.xml file configure DispatchServlet as front controllerThen create jsp asLogin.jspEmailid, password and typeofuserSignup.jspEmailid,
password and typeofuser
The create Controller class which contains two method for signup and signinRecive the value from view as jsp. 
Then set the value for JavaBean(Login JavaBean class withemailid,password and typeofuser as property and setter and getter method) with @Component,
Inside signup and signin do the DI for httprequest as well as Login class. 
then create service layer and repository layer insider repository layer do the di for JdbcTemplate.Dispatcher-servlet.xml 
file container configuration details for DriverManagerDataSource andJdbcTemplate.
If admin do the logic open admin home pageIf customer do the login open the customer home page.
