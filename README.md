# Project Definition
Setup a Java Spring project with a dependency on another service (could be a database, a JMS queue,another public 
API, etc...). From there, create an endpoint where users can sign up for alerts about service outages. That signup will 
require a name and email address. Your project should monitor its dependencies and if it detects that the dependent 
service is unavailable, it should send an alert to allusers who have signed up.

# Technology & Components
  In this project I used the following technology and components
  
    1- Spring boot as Java framework.
    2- Reactjs as front-end and UI technology.
    3- Hibernate JPA as ORM technology.
    4- Actuator component for application health checking
    5- Java Mail Spring componet for sending email.
    6- Spring scheduling
    
# Installing Mysql Database
  Download and install version 5.6. Remember to write down mysql root user password.
  
  Open "pom.xml" file from project directory and search for "root". you find it in a xml code snipet like below. 
  Change the password to what you entered as mysql root password.
  
      <plugin>
          <!-- ( 1 ) plugin info -->
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>sql-maven-plugin</artifactId>
          <version>1.5</version>
    
          <!-- ( 2 ) jdbc dirver -->
          <dependencies>
              <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
                  <version>6.0.6</version>
                  <scope>runtime</scope>
              </dependency>
          </dependencies>
    
          <configuration>
              <driver>com.mysql.cj.jdbc.Driver</driver>
              <url>jdbc:mysql://localhost:3306/</url>
              <username>root</username>
              <password>1234</password>
          </configuration>

       

    
# Build 
  Open a command prompt or terminal and change directory to project directory. Run the following 
  command.
  
    mvn package
    
  This command build and compile project.It also create application database in MySql server.
  
# Runing and testing if it works  
  Open a command prompt or terminal and change directory to project directory. Run the following 
  command.   

    java -jar target\outage-0.0.1.jar 

  Enter http://localhost:8080 in your browser. You will see a sign up form in your browser that you can sign up 
  multiple names with corresponding email addresses.
  
  Now if you stop MySql database server the application sends an alert email to the emails that subscribed using sign
   up form. 
   
# Configuring mail server config   
  This application uses a default gmail account for sending email alerts. You can change this account by editing 
    src/main/resources/application.properties and then you need to rebuild and restart the applications.
    
# How its works
  The project uses Spring Actuator component to see if the database is up or not. The project periodically(every 5 
  seconds) check database availability.    
