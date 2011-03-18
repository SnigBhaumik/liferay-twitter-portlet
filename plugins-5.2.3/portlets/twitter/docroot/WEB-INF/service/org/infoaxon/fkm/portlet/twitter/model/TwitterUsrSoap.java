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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="TwitterUsrSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public class TwitterUsrSoap implements Serializable {
	public static TwitterUsrSoap toSoapModel(TwitterUsr model) {
		TwitterUsrSoap soapModel = new TwitterUsrSoap();

		soapModel.setUserid(model.getUserid());
		soapModel.setTwitterobject(model.getTwitterobject());

		return soapModel;
	}

	public static TwitterUsrSoap[] toSoapModels(TwitterUsr[] models) {
		TwitterUsrSoap[] soapModels = new TwitterUsrSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TwitterUsrSoap[][] toSoapModels(TwitterUsr[][] models) {
		TwitterUsrSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TwitterUsrSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TwitterUsrSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TwitterUsrSoap[] toSoapModels(List<TwitterUsr> models) {
		List<TwitterUsrSoap> soapModels = new ArrayList<TwitterUsrSoap>(models.size());

		for (TwitterUsr model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TwitterUsrSoap[soapModels.size()]);
	}

	public TwitterUsrSoap() {
	}

	public long getPrimaryKey() {
		return _userid;
	}

	public void setPrimaryKey(long pk) {
		setUserid(pk);
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

	private long _userid;
	private String _twitterobject;
}