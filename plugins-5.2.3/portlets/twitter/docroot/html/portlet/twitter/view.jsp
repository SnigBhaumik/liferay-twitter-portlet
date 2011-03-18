<%@ include file="/html/portlet/twitter/init.jsp" %>
<%@ include file="/html/portlet/twitter/javascript.jsp"%>



<form name="<portlet:namespace/>fm" action="<%=actTwiURL.toString()%>" method="post">
	
	<input type="hidden" name="<portlet:namespace/>callback" id="<portlet:namespace/>callback"			value='<%=actTwiURL.toString()%>'>	


<%	if(themeDisplay.isSignedIn())
	{
		List<TwitterUsr> userList=TwitterUsrLocalServiceUtil.findAll();
		Boolean lginTwitter=false;
		if(userList!=null && userList.size()>0)
		{
			for(int i=0;i<userList.size();i++)
			{
				if(userList.get(i).getUserid()==userid)
				{
					lginTwitter=true;
				
					Twitter twitter =TwitterUsrLocalServiceUtil.getTwitterObj(userid);
					String twiUsrNam=twitter.getScreenName();
					int twiUsrId=twitter.getId();
					User twiUsr=twitter.showUser(twiUsrId);
					URL twiUsrImgUrl=twiUsr.getProfileImageURL();
					int followersCount=twiUsr.getFollowersCount();
					int friendsCount=twiUsr.getFriendsCount();
					ResponseList<Status> rList=null;
			
%>
					<input type="hidden" name="<portlet:namespace/>fldname" id="<portlet:namespace/>fldname">
					<input type="hidden" name="<portlet:namespace/>pagingno" id="<portlet:namespace/>pagingno">
					<input type="hidden" name="<portlet:namespace/>prenext" id="<portlet:namespace/>prenext">
					<input type="hidden" name="<portlet:namespace/>statuId" id="<portlet:namespace/>statusId">
					<input type="hidden" name="<portlet:namespace/>uId" id="<portlet:namespace/>uId">
					<input type="hidden" name="<portlet:namespace/>fol_unfol" id="<portlet:namespace/>fol_unfol">
					<input type="hidden" name="<portlet:namespace/>pagingof" id="<portlet:namespace/>pagingof">
					<input type="hidden" name="<portlet:namespace/>delfrom" id="<portlet:namespace/>delfrom">
					
				
<%					if(Validator.isNotNull(request.getAttribute("followers")))		
					{
%>						<%@ include file="/html/portlet/twitter/follower.jsp"%>
<%					}
					else if(Validator.isNotNull(request.getAttribute("following")))		
					{
%>						<%@ include file="/html/portlet/twitter/following.jsp"%>
<%					}
					else if(Validator.isNotNull(request.getAttribute("retweets_by_me")))
					{
%>						<%@ include file="/html/portlet/twitter/retweets_by_me.jsp"%>
<%					}
					else if(Validator.isNotNull(request.getAttribute("curTrends")))
					{
%>						<%@ include file="/html/portlet/twitter/curtrends.jsp"%>
<%					}
					else if(Validator.isNotNull(request.getAttribute("mytweets")))
					{
%>						<%@ include file="/html/portlet/twitter/mytweets.jsp"%>
<%					}
					else if(Validator.isNotNull(request.getAttribute("mention")))
					{
%>						<%@ include file="/html/portlet/twitter/mention.jsp"%>
<%					}
					else
					{
%>						<%@ include file="/html/portlet/twitter/profile.jsp"%>
						<%@ include file="/html/portlet/twitter/dismsgs.jsp"%>
<%					}
				}
			}
			if(lginTwitter==false)
			{
%>				<!--<input type="image" src="/html/image/sign_in .gif" alt="Log in to twitter">-->
				<input type="submit" name="<portlet:namespace/>submit" value="Log in to twitter">
<%			}
		}
		else 
		{
%>			<!--<input type="image" src="/html/image/sign_in .gif" alt="Log in to twitter">-->
			<input type="submit" name="<portlet:namespace/>submit" value="Log in to twitter">
<%		}
	}else
	{
%>		<liferay-ui:message key="please-sign-in-to-access-this-application"/>
<%	}
%>

</form>






