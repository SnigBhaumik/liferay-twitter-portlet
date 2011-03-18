<p><input type="button" value="Back To Home" onclick="<portlet:namespace/>back('<%=viewURL%>')">
<p><font size="2">Retweets by me</font></p>

<%	
	int pageNo=1;
	Paging paging=null;
	if(request.getAttribute("pageno")!=null)
	{
		pageNo=(Integer)request.getAttribute("pageno");
	}
	paging = new Paging(pageNo, 10);
	rList=twitter.getRetweetedByMe(paging);
	if(rList.size()!=0)
	{
%>		
		
		<table cellspacing="10" cellpadding="10" width="100%" >




<%		for(int j=0;j<rList.size();j++)
		{
			
			Status tweetstatus=rList.get(j);
%>	
			<tr id="<portlet:namespace/>rowid<%=j%>" onmouseout="<portlet:namespace/>back_style('<portlet:namespace />showId<%=j%>',this.id)" onmouseover="<portlet:namespace/>change_style('<portlet:namespace />showId<%=j%>',this.id)">
				<td>
					<img  src="<%=tweetstatus.getUser().getProfileImageURL()%>" height="50" width="50" style="padding:5px;"/>  
				</td>
				<td  valign="top" >
					&nbsp;<b><a href='http://twitter.com/<%=tweetstatus.getUser().getScreenName()%>'>
					<%=tweetstatus.getUser().getScreenName()%></a></b>&nbsp;&nbsp;<%=tweetstatus.getUser().getName()%>
					<p><%=tweetstatus.getText()%></p>
					<p><%=tweetstatus.getCreatedAt()%></p>
				</td>
			</tr>
			<tr>					  
				<td colspan="6" align="left" width="100%">
					<hr/>
				</td>		
			</tr>
<%		}
%>		</table>
		
		
		<center>
<%			if(pageNo>1)
			{
%>				 
				<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','pre','retweets_by_me')">Previous</a>&nbsp;
<%			}
			if((rList.size()==10)&&(twitter.getRetweetedByMe(new Paging(pageNo+1)).size()>0))
			{
%>
				<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','next','retweets_by_me')">Next</a>
<%			}
%>
		</center>
<%	}
	else{
%>
		no retweet by you.............
<%}	%>
