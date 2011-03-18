<p><input type="button" value="Back To Home" onclick="<portlet:namespace/>back('<%=viewURL%>')">


<div align="left" style="height:300px;width:300px;overflow:scroll;">

<%
	Trends trnobj=twitter.getCurrentTrends();
	Trend[] trendArr=trnobj.getTrends();
%>
	<div style="font-weight:bold">
		Current Trends
	</div>
<%	for(int j=0;j<trendArr.length;j++)
	{
%>
		<br/><%=trendArr[j].getName()%>
<%	}
%>
</div>