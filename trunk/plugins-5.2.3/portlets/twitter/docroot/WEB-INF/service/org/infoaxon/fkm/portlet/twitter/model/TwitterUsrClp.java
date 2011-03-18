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

package org.infoaxon.fkm.portlet.twitter.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="TwitterUsrClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrClp extends BaseModelImpl<TwitterUsr>
	implements TwitterUsr {
	public TwitterUsrClp() {
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
		return _twitterobject;
	}

	public void setTwitterobject(String twitterobject) {
		_twitterobject = twitterobject;
	}

	public TwitterUsr toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			TwitterUsr model = new TwitterUsrClp();

			model.setEscapedModel(true);

			model.setUserid(getUserid());
			model.setTwitterobject(HtmlUtil.escape(getTwitterobject()));

			model = (TwitterUsr)Proxy.newProxyInstance(TwitterUsr.class.getClassLoader(),
					new Class[] { TwitterUsr.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		TwitterUsrClp clone = new TwitterUsrClp();

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

		TwitterUsrClp twitterUsr = null;

		try {
			twitterUsr = (TwitterUsrClp)obj;
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
}