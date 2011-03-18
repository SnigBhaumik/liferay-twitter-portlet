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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="TwitterUsrPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public interface TwitterUsrPersistence extends BasePersistence {
	public void cacheResult(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr);

	public void cacheResult(
		java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> twitterUsrs);

	public void clearCache();

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr create(long userid);

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr remove(long userid)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr remove(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr update(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr)
		throws com.liferay.portal.SystemException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr update(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws com.liferay.portal.SystemException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr updateImpl(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws com.liferay.portal.SystemException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByPrimaryKey(
		long userid)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr fetchByPrimaryKey(
		long userid) throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject)
		throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findByTwitterobject(
		java.lang.String twitterobject, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByTwitterobject_First(
		java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr findByTwitterobject_Last(
		java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;

	public org.infoaxon.fkm.portlet.twitter.model.TwitterUsr[] findByTwitterobject_PrevAndNext(
		long userid, java.lang.String twitterobject,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByTwitterobject(java.lang.String twitterobject)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByTwitterobject(java.lang.String twitterobject)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}