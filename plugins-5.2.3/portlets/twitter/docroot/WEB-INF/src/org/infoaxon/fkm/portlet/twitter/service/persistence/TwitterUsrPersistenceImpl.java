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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.infoaxon.fkm.portlet.twitter.NoSuchTwitterUsrException;
import org.infoaxon.fkm.portlet.twitter.model.TwitterUsr;
import org.infoaxon.fkm.portlet.twitter.model.impl.TwitterUsrImpl;
import org.infoaxon.fkm.portlet.twitter.model.impl.TwitterUsrModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="TwitterUsrPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrPersistenceImpl extends BasePersistenceImpl
	implements TwitterUsrPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = TwitterUsrImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_TWITTEROBJECT = new FinderPath(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByTwitterobject", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_TWITTEROBJECT = new FinderPath(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByTwitterobject",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TWITTEROBJECT = new FinderPath(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTwitterobject", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(TwitterUsr twitterUsr) {
		EntityCacheUtil.putResult(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrImpl.class, twitterUsr.getPrimaryKey(), twitterUsr);
	}

	public void cacheResult(List<TwitterUsr> twitterUsrs) {
		for (TwitterUsr twitterUsr : twitterUsrs) {
			if (EntityCacheUtil.getResult(
						TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
						TwitterUsrImpl.class, twitterUsr.getPrimaryKey(), this) == null) {
				cacheResult(twitterUsr);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(TwitterUsrImpl.class.getName());
		EntityCacheUtil.clearCache(TwitterUsrImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public TwitterUsr create(long userid) {
		TwitterUsr twitterUsr = new TwitterUsrImpl();

		twitterUsr.setNew(true);
		twitterUsr.setPrimaryKey(userid);

		return twitterUsr;
	}

	public TwitterUsr remove(long userid)
		throws NoSuchTwitterUsrException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TwitterUsr twitterUsr = (TwitterUsr)session.get(TwitterUsrImpl.class,
					new Long(userid));

			if (twitterUsr == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No TwitterUsr exists with the primary key " +
						userid);
				}

				throw new NoSuchTwitterUsrException(
					"No TwitterUsr exists with the primary key " + userid);
			}

			return remove(twitterUsr);
		}
		catch (NoSuchTwitterUsrException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public TwitterUsr remove(TwitterUsr twitterUsr) throws SystemException {
		for (ModelListener<TwitterUsr> listener : listeners) {
			listener.onBeforeRemove(twitterUsr);
		}

		twitterUsr = removeImpl(twitterUsr);

		for (ModelListener<TwitterUsr> listener : listeners) {
			listener.onAfterRemove(twitterUsr);
		}

		return twitterUsr;
	}

	protected TwitterUsr removeImpl(TwitterUsr twitterUsr)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (twitterUsr.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(TwitterUsrImpl.class,
						twitterUsr.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(twitterUsr);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrImpl.class, twitterUsr.getPrimaryKey());

		return twitterUsr;
	}

	public TwitterUsr update(TwitterUsr twitterUsr) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(TwitterUsr twitterUsr) method. Use update(TwitterUsr twitterUsr, boolean merge) instead.");
		}

		return update(twitterUsr, false);
	}

	public TwitterUsr update(TwitterUsr twitterUsr, boolean merge)
		throws SystemException {
		boolean isNew = twitterUsr.isNew();

		for (ModelListener<TwitterUsr> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(twitterUsr);
			}
			else {
				listener.onBeforeUpdate(twitterUsr);
			}
		}

		twitterUsr = updateImpl(twitterUsr, merge);

		for (ModelListener<TwitterUsr> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(twitterUsr);
			}
			else {
				listener.onAfterUpdate(twitterUsr);
			}
		}

		return twitterUsr;
	}

	public TwitterUsr updateImpl(
		org.infoaxon.fkm.portlet.twitter.model.TwitterUsr twitterUsr,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, twitterUsr, merge);

			twitterUsr.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
			TwitterUsrImpl.class, twitterUsr.getPrimaryKey(), twitterUsr);

		return twitterUsr;
	}

	public TwitterUsr findByPrimaryKey(long userid)
		throws NoSuchTwitterUsrException, SystemException {
		TwitterUsr twitterUsr = fetchByPrimaryKey(userid);

		if (twitterUsr == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No TwitterUsr exists with the primary key " +
					userid);
			}

			throw new NoSuchTwitterUsrException(
				"No TwitterUsr exists with the primary key " + userid);
		}

		return twitterUsr;
	}

	public TwitterUsr fetchByPrimaryKey(long userid) throws SystemException {
		TwitterUsr twitterUsr = (TwitterUsr)EntityCacheUtil.getResult(TwitterUsrModelImpl.ENTITY_CACHE_ENABLED,
				TwitterUsrImpl.class, userid, this);

		if (twitterUsr == null) {
			Session session = null;

			try {
				session = openSession();

				twitterUsr = (TwitterUsr)session.get(TwitterUsrImpl.class,
						new Long(userid));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (twitterUsr != null) {
					cacheResult(twitterUsr);
				}

				closeSession(session);
			}
		}

		return twitterUsr;
	}

	public List<TwitterUsr> findByTwitterobject(String twitterobject)
		throws SystemException {
		Object[] finderArgs = new Object[] { twitterobject };

		List<TwitterUsr> list = (List<TwitterUsr>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TWITTEROBJECT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr WHERE ");

				if (twitterobject == null) {
					query.append("twitterobject IS NULL");
				}
				else {
					query.append("twitterobject = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (twitterobject != null) {
					qPos.add(twitterobject);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<TwitterUsr>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TWITTEROBJECT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<TwitterUsr> findByTwitterobject(String twitterobject,
		int start, int end) throws SystemException {
		return findByTwitterobject(twitterobject, start, end, null);
	}

	public List<TwitterUsr> findByTwitterobject(String twitterobject,
		int start, int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				twitterobject,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<TwitterUsr> list = (List<TwitterUsr>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TWITTEROBJECT,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr WHERE ");

				if (twitterobject == null) {
					query.append("twitterobject IS NULL");
				}
				else {
					query.append("twitterobject = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (twitterobject != null) {
					qPos.add(twitterobject);
				}

				list = (List<TwitterUsr>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<TwitterUsr>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TWITTEROBJECT,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public TwitterUsr findByTwitterobject_First(String twitterobject,
		OrderByComparator obc)
		throws NoSuchTwitterUsrException, SystemException {
		List<TwitterUsr> list = findByTwitterobject(twitterobject, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No TwitterUsr exists with the key {");

			msg.append("twitterobject=" + twitterobject);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTwitterUsrException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public TwitterUsr findByTwitterobject_Last(String twitterobject,
		OrderByComparator obc)
		throws NoSuchTwitterUsrException, SystemException {
		int count = countByTwitterobject(twitterobject);

		List<TwitterUsr> list = findByTwitterobject(twitterobject, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No TwitterUsr exists with the key {");

			msg.append("twitterobject=" + twitterobject);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTwitterUsrException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public TwitterUsr[] findByTwitterobject_PrevAndNext(long userid,
		String twitterobject, OrderByComparator obc)
		throws NoSuchTwitterUsrException, SystemException {
		TwitterUsr twitterUsr = findByPrimaryKey(userid);

		int count = countByTwitterobject(twitterobject);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr WHERE ");

			if (twitterobject == null) {
				query.append("twitterobject IS NULL");
			}
			else {
				query.append("twitterobject = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (twitterobject != null) {
				qPos.add(twitterobject);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					twitterUsr);

			TwitterUsr[] array = new TwitterUsrImpl[3];

			array[0] = (TwitterUsr)objArray[0];
			array[1] = (TwitterUsr)objArray[1];
			array[2] = (TwitterUsr)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<TwitterUsr> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<TwitterUsr> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<TwitterUsr> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<TwitterUsr> list = (List<TwitterUsr>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<TwitterUsr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TwitterUsr>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<TwitterUsr>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByTwitterobject(String twitterobject)
		throws SystemException {
		for (TwitterUsr twitterUsr : findByTwitterobject(twitterobject)) {
			remove(twitterUsr);
		}
	}

	public void removeAll() throws SystemException {
		for (TwitterUsr twitterUsr : findAll()) {
			remove(twitterUsr);
		}
	}

	public int countByTwitterobject(String twitterobject)
		throws SystemException {
		Object[] finderArgs = new Object[] { twitterobject };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TWITTEROBJECT,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr WHERE ");

				if (twitterobject == null) {
					query.append("twitterobject IS NULL");
				}
				else {
					query.append("twitterobject = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (twitterobject != null) {
					qPos.add(twitterobject);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TWITTEROBJECT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM org.infoaxon.fkm.portlet.twitter.model.TwitterUsr");

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.infoaxon.fkm.portlet.twitter.model.TwitterUsr")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TwitterUsr>> listenersList = new ArrayList<ModelListener<TwitterUsr>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TwitterUsr>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "org.infoaxon.fkm.portlet.twitter.service.persistence.TwitterUsrPersistence.impl")
	protected org.infoaxon.fkm.portlet.twitter.service.persistence.TwitterUsrPersistence twitterUsrPersistence;
	private static Log _log = LogFactoryUtil.getLog(TwitterUsrPersistenceImpl.class);
}