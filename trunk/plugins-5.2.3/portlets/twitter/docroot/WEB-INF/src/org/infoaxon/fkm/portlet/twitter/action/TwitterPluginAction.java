package org.infoaxon.fkm.portlet.twitter.action;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import twitter4j.http.RequestToken;
import twitter4j.http.AccessToken;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infoaxon.fkm.portlet.twitter.service.TwitterUsrLocalServiceUtil;
import twitter4j.User;
import twitter4j.Paging;

public class TwitterPluginAction extends Action {

	private static final Log log = LogFactory.getLog(TwitterPluginAction.class);
	private ThemeDisplay themeDisplay=null;
	private Long userid=null;
	private String Conskey="WRlarnk83xt6XK6aWkIwVg";
	private String ConsSecret="4PjxK7tuOzbxJobU2DtoIw5nn5oVazGVYo3UQHc";
	private Twitter twitter=null;
	private String oauth_verifier=null;
	private AccessToken accToken=null;
	private HttpSession session=null;
	private RequestToken requestToken=null;
	private List list = null;
	private User user=null;
	
	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest req,HttpServletResponse res)
		throws Exception {
		
		session = req.getSession();
		themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		userid=themeDisplay.getUserId();
		
		String callBkURL=null;
		String oauth_verifier=null;
				
		if((req.getParameter("oauth_verifier"))!=null)
		{
			oauth_verifier = req.getParameter("oauth_verifier");
						
			twitter = (Twitter) session.getAttribute("twitter");
			requestToken = (RequestToken)session.getAttribute("requestToken");
			AccessToken acsTokn = twitter.getOAuthAccessToken(requestToken,oauth_verifier);
			
						
			twitter.setOAuthAccessToken(acsTokn);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(twitter);
			oos.flush();
			oos.close();
			bos.close();
			byte[] data = bos.toByteArray();
			
			TwitterUsrLocalServiceUtil.setTwitterObj(userid, data);
		}
		
		else if(Validator.isNotNull(ParamUtil.getString(req,"fldname")))
		{
			twitter =TwitterUsrLocalServiceUtil.getTwitterObj(userid);
			
			if(ParamUtil.getString(req,"fldname").equals("paging"))
			{
				String pageno = ParamUtil.getString(req,"pagingno");
				int pNo=Integer.parseInt(pageno.trim());
			
				if(ParamUtil.getString(req,"prenext").equals("pre"))
				{
					pNo=pNo-1;
				}
				else if(ParamUtil.getString(req,"prenext").equals("next"))
				{
					pNo=pNo+1;
				}
							
				if(ParamUtil.getString(req,"pagingof").equals("mytweets"))
				{
					req.setAttribute("mytweets","mytweets");
				}
				else if(ParamUtil.getString(req,"pagingof").equals("retweets_by_me"))
				{
					req.setAttribute("retweets_by_me","retweets_by_me");
				}
				else if(ParamUtil.getString(req,"pagingof").equals("following"))
				{
					req.setAttribute("following","following");
				}
				else if(ParamUtil.getString(req,"pagingof").equals("followers"))
				{
					req.setAttribute("followers","followers");
				}
				else if(ParamUtil.getString(req,"pagingof").equals("mention"))
				{
					req.setAttribute("mention","mention");
				}
				req.setAttribute("pageno",pNo);
			}
			else if(ParamUtil.getString(req,"fldname").equals("delete"))
			{
				String pageno = ParamUtil.getString(req,"pagingno");
				twitter.destroyStatus(ParamUtil.getLong(req,"statuId"));
				if(ParamUtil.getString(req,"delfrom").equals("mytweets"))
				{
					req.setAttribute("mytweets","mytweets");
				}
				else if(ParamUtil.getString(req,"delfrom").equals("mention"))
				{
					req.setAttribute("mention","mention");
				}
						
				req.setAttribute("pageno",Integer.parseInt(pageno.trim()));
			}
			else if(ParamUtil.getString(req,"fldname").equals("tweets"))
			{
				if((req.getParameter("tweet")!=null)&&(!ParamUtil.getString(req,"tweet").equals("")))
				{
					String updates = ParamUtil.getString(req,"tweet");
					twitter.updateStatus(updates);
				}
			}
			else if(ParamUtil.getString(req,"fldname").equals("retweet"))
			{
				String retweeted="retweeted";
				Status ms = twitter.retweetStatus(ParamUtil.getLong(req, "id"));
			}
			else if(ParamUtil.getString(req,"fldname").equals("followers"))
			{
				if(ParamUtil.getString(req,"fol_unfol").equals("follow"))
				{
					int uId=ParamUtil.getInteger(req, "uId");
					user=twitter.createFriendship(uId);
				}
				else if(ParamUtil.getString(req,"fol_unfol").equals("unfollow"))
				{
					int uId=ParamUtil.getInteger(req,"uId");
					user=twitter.destroyFriendship(uId);
				}
				req.setAttribute("followers","followers");
			}
			else if(ParamUtil.getString(req,"fldname").equals("following"))
			{
				if(ParamUtil.getString(req,"fol_unfol").equals("unfollow"))
				{
					int uId=ParamUtil.getInteger(req,"uId");
					user=twitter.destroyFriendship(uId);
				}
				req.setAttribute("following","following");
			}
			else if(ParamUtil.getString(req,"fldname").equals("mytweets"))
			{
				req.setAttribute("mytweets","mytweets");
			}
			else if(ParamUtil.getString(req,"fldname").equals("retweets_by_me"))
			{
				req.setAttribute("retweets_by_me","retweets_by_me");
			}
			else if(ParamUtil.getString(req,"fldname").equals("mention"))
			{
				req.setAttribute("mention","mention");
			}
			else if(ParamUtil.getString(req,"fldname").equals("trends"))
			{
				req.setAttribute("curTrends","curTrends");
			}
		}
		else
		{
			callBkURL=req.getParameter("callback").toString();
							
			twitter = new TwitterFactory().getOAuthAuthorizedInstance(Conskey,ConsSecret);
			requestToken = twitter.getOAuthRequestToken(callBkURL);
										
			session.setAttribute("requestToken",requestToken);
			session.setAttribute("twitter",twitter);
					
			res.sendRedirect(requestToken.getAuthorizationURL()+"&oauth_access_type=write");
		}
			
		return mapping.findForward("twitter.view");
	}

	public String render(HttpServletRequest req) throws Exception
	{
		return "twitter.view";
	}
	
}