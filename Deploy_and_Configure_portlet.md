# How to deploy the war to configure the portlet #

## Pre-requisites ##
Up and running Liferay Portal bundled version 5.2.x with Tomcat.

### Steps To Follow ###

  1. Download the war file from below url http://code.google.com/p/liferay-twitter-portlet/downloads/detail?name=twitter-5.2.3.1.war.
  1. Once download is complete , move to your server's **auto.deploy.dir =${app.server.dir}/../deploy** folder and drop the war file there. Liferay is set to scan this directory for plugin war.
  1. Check on your server console you will get messages regarding portlet that portlet is registered successfully and ready to use. Once this message is displayed.Go to next step.
  1. Login as admin and click on add application link provided in dock.Go to **FKM** category and drag the twitter portlet on your page. Now you are ready to use the portlet.