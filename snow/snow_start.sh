rm /usr/local/tomcat/webapps/snow.war
cp chen/upload/snow.war /usr/local/tomcat/webapps/
sh /usr/local/tomcat/bin/shutdown.sh
sh /usr/local/tomcat/bin/startup.sh