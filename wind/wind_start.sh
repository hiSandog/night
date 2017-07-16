rm /usr/local/tomcat/webapps/wind.war
cp chen/upload/wind.war /usr/local/tomcat/webapps/
sh /usr/local/tomcat/bin/shutdown.sh
sh /usr/local/tomcat/bin/startup.sh