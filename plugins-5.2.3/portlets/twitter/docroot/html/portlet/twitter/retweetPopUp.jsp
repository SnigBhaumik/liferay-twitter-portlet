<%@ include file="/html/portlet/twitter/init.jsp"%>
<%@ include file="/html/portlet/twitter/javascript.jsp"%>

<% 
	String id = request.getParameter("id");
	actTwiURL.setParameter("id", id);
%>





<html>
<head><title></title></head>
<body>
	<form>
		<input type="hidden" name="<portlet:namespace/>fldname" id="<portlet:namespace/>fldname">
		Do YOu want to Retweet to your Friends
		<input type="button" value="ok" size="10" onclick="<portlet:namespace/>retweetMessages('<%=actTwiURL%>')" >
	</form>
 </body>
 </html>

