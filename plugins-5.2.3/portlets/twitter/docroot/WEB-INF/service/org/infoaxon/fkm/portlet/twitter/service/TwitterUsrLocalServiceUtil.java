/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.infoaxon.fkm.portlet.twitter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="TwitterUsrLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrLocalServiceUtil {
	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr addTwitterUsr(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException {
		return getService().addTwitterUsr(twitterUsr);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr createTwitterUsr(
		long userid) {
		return getService().createTwitterUsr(userid);
	}

	public static void deleteTwitterUsr(long userid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteTwitterUsr(userid);
	}

	public static void deleteTwitterUsr(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException {
		getService().deleteTwitterUsr(twitterUsr);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr getTwitterUsr(
		long userid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getTwitterUsr(userid);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> getTwitterUsrs(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getTwitterUsrs(start, end);
	}

	public static int getTwitterUsrsCount()
		throws com.liferay.portal.SystemException {
		return getService().getTwitterUsrsCount();
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr updateTwitterUsr(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException {
		return getService().updateTwitterUsr(twitterUsr);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr updateTwitterUsr(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateTwitterUsr(twitterUsr, merge);
	}

	public static twitter4j.Twitter getTwitterObj(long userid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getTwitterObj(userid);
	}

	public static void setTwitterObj(long userid, byte[] twitterobject)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().setTwitterObj(userid, twitterobject);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll()
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().findAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static TwitterUsrLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					TwitterUsrLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new TwitterUsrLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(TwitterUsrLocalService service) {
		_service = service;
	}

	private static TwitterUsrLocalService _service;
}