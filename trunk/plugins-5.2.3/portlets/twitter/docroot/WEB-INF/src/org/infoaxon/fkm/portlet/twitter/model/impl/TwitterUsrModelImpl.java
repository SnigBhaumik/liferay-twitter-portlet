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

package org.infoaxon.fkm.portlet.twitter.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import org.infoaxon.fkm.portlet.twitter.model.TwitterUsr;
import org.infoaxon.fkm.portlet.twitter.model.TwitterUsrSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="TwitterUsrModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrModelImpl extends BaseModelImpl<TwitterUsr> {
	public static final String TABLE_NAME = "fkm_twitter";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userid", new Integer(Types.BIGINT) },
			

			{ "twitterobject", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table fkm_twitter (userid LONG not null primary key,twitterobject TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table fkm_twitter";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.infoaxon.fkm.portlet.twitter.model.TwitterUsr"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.infoaxon.fkm.portlet.twitter.model.TwitterUsr"),
			true);

	public static TwitterUsr toModel(TwitterUsrSoap soapModel) {
		TwitterUsr model = new TwitterUsrImpl();

		model.setUserid(soapModel.getUserid());
		model.setTwitterobject(soapModel.getTwitterobject());

		return model;
	}

	public static List<TwitterUsr> toModels(TwitterUsrSoap[] soapModels) {
		List<TwitterUsr> models = new ArrayList<TwitterUsr>(soapModels.length);

		for (TwitterUsrSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.infoaxon.fkm.portlet.twitter.model.TwitterUsr"));

	public TwitterUsrModelImpl() {
	}

	public long getPrimaryKey() {
		return _userid;
	}

	public void setPrimaryKey(long pk) {
		setUserid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userid);
	}

	public long getUserid() {
		return _userid;
	}

	public void setUserid(long userid) {
		_userid = userid;
	}

	public String getTwitterobject() {
		return GetterUtil.getString(_twitterobject);
	}

	public void setTwitterobject(String twitterobject) {
		_twitterobject = twitterobject;
	}

	public TwitterUsr toEscapedModel() {
		if (isEscapedModel()) {
			return (TwitterUsr)this;
		}
		else {
			TwitterUsr model = new TwitterUsrImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setUserid(getUserid());
			model.setTwitterobject(HtmlUtil.escape(getTwitterobject()));

			model = (TwitterUsr)Proxy.newProxyInstance(TwitterUsr.class.getClassLoader(),
					new Class[] { TwitterUsr.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = new ExpandoBridgeImpl(TwitterUsr.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public Object clone() {
		TwitterUsrImpl clone = new TwitterUsrImpl();

		clone.setUserid(getUserid());
		clone.setTwitterobject(getTwitterobject());

		return clone;
	}

	public int compareTo(TwitterUsr twitterUsr) {
		long pk = twitterUsr.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TwitterUsr twitterUsr = null;

		try {
			twitterUsr = (TwitterUsr)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = twitterUsr.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{userid=");
		sb.append(getUserid());
		sb.append(", twitterobject=");
		sb.append(getTwitterobject());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("org.infoaxon.fkm.portlet.twitter.model.TwitterUsr");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userid</column-name><column-value><![CDATA[");
		sb.append(getUserid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterobject</column-name><column-value><![CDATA[");
		sb.append(getTwitterobject());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userid;
	private String _twitterobject;
	private transient ExpandoBridge _expandoBridge;
}