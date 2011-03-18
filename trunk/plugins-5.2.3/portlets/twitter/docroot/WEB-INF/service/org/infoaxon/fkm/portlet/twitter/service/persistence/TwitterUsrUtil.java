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

package org.infoaxon.fkm.portlet.twitter.service.persistence;

/**
 * <a href="TwitterUsrUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrUtil {
	public static void cacheResult(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr) {
		getPersistence().cacheResult(twitterUsr);
	}

	public static void cacheResult(
		java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> twitterUsrs) {
		getPersistence().cacheResult(twitterUsrs);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr create(
		long userid) {
		return getPersistence().create(userid);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr remove(
		long userid)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException {
		return getPersistence().remove(userid);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr remove(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(twitterUsr);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr update(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(twitterUsr);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr update(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(twitterUsr, merge);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr updateImpl(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(twitterUsr, merge);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByPrimaryKey(
		long userid)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException {
		return getPersistence().findByPrimaryKey(userid);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr fetchByPrimaryKey(
		long userid) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(userid);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByTwitterobject(twitterobject);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByTwitterobject(twitterobject, start, end);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByTwitterobject(twitterobject, start, end, obc);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByTwitterobject_First(
		java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException {
		return getPersistence().findByTwitterobject_First(twitterobject, obc);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByTwitterobject_Last(
		java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException {
		return getPersistence().findByTwitterobject_Last(twitterobject, obc);
	}

	public static org.infoaxon.fkm.portlet.twitter.model.TwitterUsr[] findByTwitterobject_PrevAndNext(
		long userid, java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException {
		return getPersistence()
				   .findByTwitterobject_PrevAndNext(userid, twitterobject, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByTwitterobject(java.lang.String twitterobject)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByTwitterobject(twitterobject);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByTwitterobject(java.lang.String twitterobject)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByTwitterobject(twitterobject);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static TwitterUsrPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(TwitterUsrPersistence persistence) {
		_persistence = persistence;
	}

	private static TwitterUsrPersistence _persistence;
}