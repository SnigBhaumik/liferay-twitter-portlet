<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean-el"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el"%>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles-el" prefix="tiles-el"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Stack"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.TreeSet"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.TimeZone"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Currency"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.util.LinkedHashSet"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.GregorianCalendar"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ResourceURL"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.PortletConfig"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ page import="javax.portlet.PortletContext"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.PortletSession"%>
<%@ page import="javax.portlet.PortletResponse"%>
<%@ page import="javax.portlet.PortletException"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="javax.portlet.ValidatorException"%>
<%@ page import="javax.portlet.UnavailableException"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>


<%@ page import="org.infoaxon.fkm.portlet.twitter.service.TwitterUsrLocalServiceUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="org.infoaxon.fkm.portlet.twitter.model.TwitterUsr"%>
<%@ page import="twitter4j.Twitter" %>
<%@ page import="twitter4j.User"%>
<%@ page import="java.net.URL"%>
<%@ page import="twitter4j.Paging"%>
<%@ page import="twitter4j.Status"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="twitter4j.IDs"%>
<%@ page import="twitter4j.ResponseList"%>
<%@ page import="twitter4j.Trend"%>
<%@ page import="twitter4j.Trends"%>
<%@ page import="twitter4j.PagableResponseList"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>





<portlet:defineObjects />
<liferay-theme:defineObjects />

<% 
	String ctxPath = request.getContextPath();
	if (ctxPath != null && ctxPath.length()==1) {
		ctxPath = "";
	}
	
	PortletSession pSession = renderRequest.getPortletSession();
	
	PortletURL renderURL = renderResponse.createRenderURL();
	PortletURL actionURL = renderResponse.createActionURL();

	String plns = "";
	if (renderRequest != null) {
		plns = renderResponse.getNamespace();
	}


	
	
	PortletURL actTwiURL = renderResponse.createActionURL();
	actTwiURL.setParameter("_spage", "/portlet_action/twitter/twitterPluginAction");
	actTwiURL.setWindowState(WindowState.NORMAL);

	
	PortletURL retweetURL = renderResponse.createRenderURL();
	retweetURL.setParameter("_spage", "/portlet_action/twitter/retweet");
	retweetURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	

	PortletURL viewURL = renderResponse.createActionURL();
	viewURL.setParameter("_spage", "/portlet_action/twitter/view");
	viewURL.setWindowState(WindowState.NORMAL);

	
	
	
	themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	Long userid=themeDisplay.getUserId();
%>

	

	



<%@ include file="/js/portlet_js.jsp" %>
<%@ include file="/css/portlet_css.jsp" %>