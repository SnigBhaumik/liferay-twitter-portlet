<p><input type="button" value="Back To Home" onclick="<portlet:namespace/>back('<%=viewURL%>')">


<%   int pageNo=1; 
	 PagableResponseList<User> frndList=twitter.getFriendsStatuses();
	 List<User>subList=null;
	 User frndusr=null;
	 int startIndex=0;
	 int lastIndex=10;

	 
	 if(request.getAttribute("pageno")!=null)
	 {
		pageNo=(Integer)request.getAttribute("pageno");
		startIndex=10*(pageNo-1);
		lastIndex=10*pageNo;
	 }
	 if(frndList.size()<lastIndex)
	 {
		lastIndex=frndList.size();

	 }
     if(frndList.size()>0)
	 {

		subList=frndList.subList(startIndex,lastIndex);

%>		<p><font size="2">You follow <%=frndList.size()%> people</font></p>
		<table cellspacing="10" cellpadding="10" width="100%" >

<%		for(int j=0;j<subList.size();j++)
		{
			
			frndusr = subList.get(j);
			int frndId=frndusr.getId();
			String frndSname=frndusr.getScreenName();
			URL frndImgURL=frndusr.getProfileImageURL();
			String frndName=frndusr.getName();
			

%>			
			<tr id="<portlet:namespace/>rowid<%=j%>" onmouseout="<portlet:namespace/>back_style('<portlet:namespace />showId<%=j%>',this.id)" onmouseover="<portlet:namespace/>change_style('<portlet:namespace />showId<%=j%>',this.id)">
				<td>
					<a href='http://twitter.com/<%=frndSname%>'><img src="<%=frndImgURL%>" height="50" width="50" style="padding:5px;"/></a>
				</td>
				<td valign="top" align="left" >
					&nbsp;<a href='http://twitter.com/<%=frndSname%>'><b><%=frndSname%></b></a>&nbsp;&nbsp;<%=frndName%>
<%
					if(frndusr.getDescription()!=null)
					{
%>
						<p><%=frndusr.getDescription()%></p>
<%					}
%>
				 </td>
				 <td valign="bottom">
					<input type="button" style="background-color:#41A317;" id="<portlet:namespace/>frnd<%=j%>" value="Following" onclick="<portlet:namespace/>set_field_fol_unfol('<%=actTwiURL%>','following','unfollow','<%=frndId%>')" onmouseover="<portlet:namespace/>chtxtonmover('<portlet:namespace/>frnd<%=j%>')"  onmouseout="<portlet:namespace/>chtxtonmoout('<portlet:namespace/>frnd<%=j%>')">
				 </td>
			</tr>
			<tr>					  
				<td colspan="6" align="left" width="100%">
					<hr/>
				</td>		
			</tr>
<%		}
%>		</table>
		

<%		if((startIndex==0)&&(lastIndex-1==0))
		{
%>			Showing 1 Friend.
<%		}else
		{
%>			Showing <%=startIndex+1%> to <%=lastIndex%> Friends.
<%		}
%>
		
		<center>
<%			if(pageNo>1)
			{
%>				 
				<a href="#"		onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','pre','following')">Previous</a>&nbsp;
<%			}
			if((subList.size()==10)&&(!(frndList.size()==lastIndex)))
			{
%>				
				<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','next','following')">Next</a>
<%			}
%>
		</center>

<%	}

%>
	













