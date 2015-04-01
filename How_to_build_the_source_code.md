# How to build the source code #

### Pre-requisites ###
  1. JDK 1.6
  1. Liferay Plugins SDK-5.2.3.
  1. Apache ANT.
  1. Liferay tomcat bundle version 5.2.3.


### Overview of Liferay Plugin SDK-5.2.3 ###
  1. Extract the zip file in your desired drive.  e.g. E:/project/plugins-5.2.3

> 2. Plugins SDK Configuration
    * You will notice that the Plugins SDK contains a file called build.properties.This file contains the settings for where you have Liferay installed and where your deployment folder is going to be. However, you should not customize this file. Instead, create a new file in the same folder called build.${user.name}.properties, where ${user.name} is your user ID on your machine. For example, if your user ID is "abc" then create a file with name build.${abc}.properties. Below is the example of setting:
> > _**Example for server settings**_
> > > app.server.type=tomcat<br />
> > > app.server.dir= E:/project/liferay-portal-5.2.3/tomcat-5.2.3<br />
> > > app.server.deploy.dir=${app.server.dir}/webapps<br />
> > > app.server.lib.global.dir=${app.server.dir}/lib/ext<br />
> > > app.server.portal.dir=${app.server.dir}/webapps/ROOT<br />
    * The main development options available in Liferay Plugins SDK-5.2.3 are portlets, themes, <br />layout templates, hooks. Each option in the Liferay Plugins SDK contains scripts for generating that type of plugin.New plugins are placed in their own subdirectory of the appropriate plugin directory.
> > > e.g. a new portlet called **"liferay-twitter-portlet"** would reside in **plugins-5.2.3/portlets/liferay-twitter-portlet**.
> > > Check out **"liferay-twitter-portlet"** using url          http://liferay-twitter-portlet.googlecode.com/svn/trunk/ and get inside the ${Your-check-out-project-home}/plugins-5.2.3/portlets e.g E:/test/portlet/plugins-5.2.3/portlets. Copy twitter folder to your plugins-5.2.3 portlets folder. Customize as per your requirement and deploy it.


> 3. All plugins are hot deployable means new version of particular plugin can be uploaded at run time.


### Deployment Steps ###
  1. Go inside portlets folder of your Plugin SDK-5.2.3. We now have folder twitter which we have checked out earlier,  inside it  there is build.xml
  1. Open console move till above build.xml path and give command
> > _**ant deploy**_
  1. Check whether your portlet is registered and ready for use once server is started.
  1. Login as admin and click on add application link provided in dock. Go to FKM category and drag the twitter portlet on your page.

Now you are ready to use the portlet.