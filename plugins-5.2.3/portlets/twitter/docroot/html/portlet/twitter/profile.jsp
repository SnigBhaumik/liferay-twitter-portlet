


<table cellpadding="10" cellspacing="10">
	<tr>
		<td rowspan="2">
			<a href='http://twitter.com/<%=twiUsrNam%>'><img src="<%=twiUsrImgUrl%>" ALIGN="bottom" height="70" width="50" style="padding:5px;"/></a><br/><font style="font-weight:bold"><%=twiUsrNam%></font>
		</td>
		<td colspan="2">
			I have&nbsp;<a href=# onclick="<portlet:namespace />set_field('<%=actTwiURL%>','followers')"><b><%=followersCount%></b>&nbsp;Followers</a>.
			
			&nbsp;I am following&nbsp;<a href=# onclick="<portlet:namespace />set_field('<%=actTwiURL%>','following')"><b><%=friendsCount%></b>&nbsp;people</a>.

			<br/>
			<a href=# onclick="<portlet:namespace/>set_field('<%=actTwiURL%>','mytweets')">My Tweets</a>
			
			&nbsp;&nbsp;&nbsp;<a href=# onclick="<portlet:namespace/>set_field('<%=actTwiURL%>','retweets_by_me')">Retweets By Me</a>

			&nbsp;&nbsp;&nbsp;<a href=# onclick="<portlet:namespace/>set_field('<%=actTwiURL%>','mention')">@Mentions</a>
			
			&nbsp;&nbsp;&nbsp;<a href=# onclick="<portlet:namespace/>set_field('<%=actTwiURL%>','trends')">Twitter Trends</a><br/>
		</td>
	</tr>
	<tr>
		<td style="padding-left:10px;">
			<textarea onKeyUp=check_length(this.form); onKeyDown=check_length(this.form);
			rows="2" cols="50" name="tweet" wrap="physical" id="<portlet:namespace/>tweet"></textarea>
			<br/>
			<input readonly type="text" name="text_num" size="2" maxlength="3" value="140">
			
		</td>
		<td style="text-align: left; padding-left:10px; vertical-align: top">
			<input type="button" value="Tweet"  onclick="<portlet:namespace/>updateStatus('<%=actTwiURL%>',false,'')"><br/>
			<input type="submit" value="Sign In as a different User"><br/>
		</td>
	</tr>
</table>
<hr/>
				