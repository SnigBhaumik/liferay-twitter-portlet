<p><input type="button" value="Back To Home" onclick="<portlet:namespace/>back('<%=viewURL%>')">


<%
	
    PagableResponseList<User> follwList=twitter.getFollowersStatuses();
	int pageNo=1;
	User flwrusr=null;
	List<User>subList=null;
	int startIndex=0;
	int lastIndex=10;

	 
	if(request.getAttribute("pageno")!=null)
	{
		pageNo=(Integer)request.getAttribute("pageno");
		startIndex=10*(pageNo-1);
		lastIndex=10*pageNo;
		
	 }
	 if(follwList.size()<lastIndex)
	 {
		lastIndex=follwList.size();

	 }
	 	
	if(follwList.size()>0)
	{
		subList=follwList.subList(startIndex,lastIndex);

%>
		<p><font size="2">Your <%=follwList.size()%> followers</font></p>
		<table cellspacing="10" cellpadding="10" width="100%">
<%
		for(int var=0;var<subList.size();var++)
		{
			
			flwrusr = subList.get(var);
			int flwrId=flwrusr.getId();
			String flwrSname=flwrusr.getScreenName();
			URL flwrImgURL=flwrusr.getProfileImageURL();
			String flwrName=flwrusr.getName();
			Boolean friendship=false;
			try{
				friendship=twitter.existsFriendship(twiUsrNam,flwrSname);
			}catch(Exception e){
			}
%>
			<tr>
				<td>
					<a href='http://twitter.com/<%=flwrSname%>'><img  src="<%=flwrImgURL%>"	height="50" width="50" style="padding:5px;"/></a>
				</td>
				<td valign="top" align="left">
					<a href='http://twitter.com/<%=flwrSname%>'><b><%=flwrSname%></b></a>&nbsp;&nbsp;<%=flwrName%>
<%					if(flwrusr.getDescription()!=null)
					{
%>						<p><%=flwrusr.getDescription()%></p>
<%					}
%>				</td>
				<td valign="bottom" align="left">
<%					if(friendship==true)
					{
%>						
						<input type="button" style="background-color:#41A317;" id="<portlet:namespace/>flwr<%=var%>" value="Following" onclick="<portlet:namespace/>set_field_fol_unfol('<%=actTwiURL%>','followers','unfollow','<%=flwrId%>')" onmouseover="<portlet:namespace/>chtxtonmover('<portlet:namespace/>flwr<%=var%>')"  onmouseout="<portlet:namespace/>chtxtonmoout('<portlet:namespace/>flwr<%=var%>')">
<%					}
					else{
%>
						<input type="button" id="<portlet:namespace/>flwr<%=var%>" value="Follow" onclick="<portlet:namespace/>set_field_fol_unfol('<%=actTwiURL%>','followers','follow','<%=flwrId%>')"> 
					
<%					}
%>				</td>
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
				<a href="#"		onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','pre','followers')">Previous</a>&nbsp;
<%			}
			out.println(lastIndex);
			if((subList.size()==10)&&(!(follwList.size()==lastIndex)))
			{
%>				
				<a href="#" onclick="<portlet:namespace/>paging('<%=actTwiURL%>','<%=pageNo%>','next','followers')">Next</a>
<%			}
%>
		</center>

<%	}
%>