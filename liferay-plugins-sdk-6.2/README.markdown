
## Quick Start


**MySQL 5.7.19 to 5.7.22**
https://dev.mysql.com/downloads/mysql/5.7.html#downloads

**JDK 1.7**
http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html

**Tomcat**
https://s3-ap-southeast-1.amazonaws.com/sambaash.platform/tomcat-7.0.42.zip

**DB Schema**
https://s3-ap-southeast-1.amazonaws.com/sambaash.platform/relc-m.sql.zip

**IDE Download**

**Windows**
https://sourceforge.net/projects/lportal/files/Liferay%20IDE/3.0.1%20GA2/liferay-ide-eclipse-windows-x64-3.0.1-ga2-201606151031.zip/download

**Mac**
https://sourceforge.net/projects/lportal/files/Liferay%20IDE/3.0.1%20GA2/liferay-ide-eclipse-macosx-x64-3.0.1-ga2-201606151031.tar.gz/download


**Latest jenkins build with binaries and tomcat**

https://drive.google.com/file/d/1C4u4Swbbto81elzEP0cwL4V4FCYiD_a5/view?usp=sharing


1. Download and install Liferay IDE, install JDK, install MySQL, download tomcat, download DB schema from above links.

2. Restore DB schema in MySQL database in local database instance.

3. Create the DB access credential for database access by application.

4. Unzip tomcat-7.0.42.zip in /Volume/Development/master/portalserver directory.

5. Fork the [sambaash.platform.005](https://github.com/gaurav-vijayvergia/sambaash.platform.005)
repository.

6. Clone your fork of the repository.

7. Make sure Liferay IDE is setup with JDK 1.7. (Note: Service Builder will fail with JDK 1.8. Source code must compile with JDK 1.7)

8. Create a `build.${username}.properties` file in the root directory of your
liferay-plugins-sdk repository clone. Be sure to replace `${username}` with your
user name.

	/Volume/Development/master/sambaash.platform.005/liferay-plugins-sdk-6.2/build.gauravvijayvergia.properties

	Note, to determine your user name, execute `echo %USERNAME%` on Windows or
	`whoami` on Unix/Linux.

9. In your `build.${username}.properties` file, specify the `app.server.parent.dir` property set to the parent path of your app server.

    app.server.parent.dir=/Volume/Development/master/portalserver
	app.server.zip.name = /Volumes/Development/master/portalserver/tomcat-7.0.42.zip

	Use your `build.${username}.properties` file to specify any additional
	properties you wish to override from the base `build.properties` file; do
	not modify the base file.
	
	
	
10. Update database properties in portal-ext.properties using liferay IDE

	Comment out this line jdbc.default.jndi.name=jdbc/SambaashPlatformPool
	and then point to your local database for development
	```
	   jdbc.default.driverClassName=com.mysql.jdbc.Driver
	   jdbc.default.url=jdbc:mysql://localhost/<replace with database schema name>?useSSL=false&useUnicode=yes&characterEncoding=UTF-8
	   jdbc.default.username=<replace with application db access username>
	   jdbc.default.password=<replace with application db access password>
	```
11	Configure Tomcat server to escape from Memory issue 
		Set Memory args to      -Xms1536m -Xmx1536m -XX:PermSize=1024m -XX:MaxPermSize=2048m


	

12. **Build complete platform for first time. It is mandatory to execute this step for clean setup**

		cd /Volume/Development/master/sambaash.platform.005/liferay-plugins-sdk-6.2
		ant build-sambaash-platform

13. Navigate to the directory of a plugin (e.g. *Generic Search Portlet*), build service and deploy
it using Ant.

		cd /Volume/Development/master/sambaash.platform.005/liferay-plugins-sdk-6.2/portlets/GenericSearch-portlet
		ant build-service-global
		ant deploy
	The build-service-global target will generate service jar file (interfaces) in tomcat global classloader (tomcat-7.0.42/lib/ext/). It will allow service to be called from any other portlet.
	The plugin compiles, its WAR file is built to the plugin's `dist` directory,
	the WAR file is copied to your *Hot Deploy* directory ({app.server.parent.dir}/deploy), and the
	plugin is deployed immediately upon starting tomcat.

14. If you get error while creating portlet plugin then replace cdn.repository.liferay.com with repository.liferay.com in sdk.gradle and build.gradle





