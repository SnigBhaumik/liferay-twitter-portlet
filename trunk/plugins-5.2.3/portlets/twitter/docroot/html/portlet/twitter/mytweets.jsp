<p><input type="button" value="Back To Home" onclick="<portlet:namespace/>back('<%=viewURL%>')">


<%
	int pageNo=1;
	Paging paging=null;
	if(request.getAttribute("pageno")!=null)
	{
		pageNo=(Integer)request.getAttribute("pageno");
	}
	paging = new Paging(pageNo, 10);
	rList=twitter.getUserTimeline(paging);

	if(rList.size()>0)
	{

%>
		<table cellspacing="10" cellpadding="10" >

<%
		for(int j=0;j<rList.size();j++)
		{
			Status msgStatus=rList.get(j);
			Long msgId=msgStatus.getId();
			String msgtxt=msgStatus.getText();
			Date crtTim=msgStatus.getCreatedAt();
			User msgUsr=msgStatus.getUser();
			URL proImgURL=msgUsr.getProfileImageURL();
			String msgUsrSName=msgUsr.getScreenName();
			String msgUsrName=msgUsr.getName();
			int msgUsrId=msgUsr.getId();

%>		
			<tr id="<portlet:namespace/>rowid<%=j%>" onmouseout="<portlet:namespace/>back_style('<portlet:namespace />showId<%=j%>',this.id)" onmouseover="<portlet:namespace/>change_style('<portlet:namespace />showId<%=j%>',this.id)">
				<td>
					<a href='http://twitter.com/<%=msgUsrSName%>'><img src="<%=proImgURL%>" height="50" width="50" style="padding:5px;"/></a>  
				</td>
				<td  valign="top" >
					&nbsp;<b><a href='http://twitter.com/<%=msgUsrSName%>'><%=msgUsrSName%></a></b>&nbsp;&nbsp;<%=msgUsrName%><p><%=msgtxt%></p><p><%=crtTim%></p>
				</td>
				<td align="middle" valign="bottom" width="35%" id="<portlet:namespace/>showId<%=j%>" name="<portlet:namespace/>showId<%=j%>">
<%					if(twiUsrId==msgUsrId)
					{%>
						<a href="#"  onclick="<portlet:namespace/>deleteStatus('<%=actTwiURL%>','<%=msgId%>','<%=pageNo%>','mytweets')">
						<img src="/html/image/delete.png">delete</a>
					<%}
					else{
%>				
						<a href=#			onclick="<portlet:namespace/>updateStatus('<%=actTwiURL%>',true,'<%=msgUsrSName%>')">
							<img src="/html/image/reply.png">reply</a>
<%						if(!msgUsr.isProtected())
						{
%>	
							<%--<a href=#			onclick="<portlet:namespace/>retweetStatus('<%=retweetURL%>','<%=msgId%>')"><img src="/html/image/retweet.png">retweet</a>--%>		
<%						}
					}
%>
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
<%				if(pageNo>1)
				{
%>					
					<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','pre','mytweets')">
					Previous</a>&nbsp;
							
<%				}
				if((rList.size()==10)&&((twitter.getUserTimeline(new Paging(pageNo+1))).size()>0))
				{
%>
					<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','next','mytweets')">Next</a>
<%				}
%>
			</center>
<%	}
	else
	{
%>		You don't have any tweet!!!
<%	}
%>		












