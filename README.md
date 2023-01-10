# online-shop

Online shop web application written using Java EE and Tomcat 9  

The code is compiled with Java 8

##Command for compiling the source code - Windows
javac -cp "../lib/catalina.jar;../lib/servlet-api.jar" -d ../online-shop/WEB-INF/classes/ configuration/*.java filters/*.java servlets/*.java shop/*.java

##Command for packaging the war file for the webapps director Tomcat home directory, 
jar -cvf online-workshop.war WEB-INF
