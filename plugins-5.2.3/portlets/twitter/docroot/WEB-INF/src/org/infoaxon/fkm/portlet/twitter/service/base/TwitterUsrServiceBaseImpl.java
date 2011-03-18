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

package org.infoaxon.fkm.portlet.twitter.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import org.infoaxon.fkm.portlet.twitter.service.TwitterUsrLocalService;
import org.infoaxon.fkm.portlet.twitter.service.TwitterUsrService;
import org.infoaxon.fkm.portlet.twitter.service.persistence.TwitterUsrPersistence;

/**
 * <a href="TwitterUsrServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Lalit Jugran
 *
 */
public abstract class TwitterUsrServiceBaseImpl extends PrincipalBean
	implements TwitterUsrService {
	public TwitterUsrLocalService getTwitterUsrLocalService() {
		return twitterUsrLocalService;
	}

	public void setTwitterUsrLocalService(
		TwitterUsrLocalService twitterUsrLocalService) {
		this.twitterUsrLocalService = twitterUsrLocalService;
	}

	public TwitterUsrService getTwitterUsrService() {
		return twitterUsrService;
	}

	public void setTwitterUsrService(TwitterUsrService twitterUsrService) {
		this.twitterUsrService = twitterUsrService;
	}

	public TwitterUsrPersistence getTwitterUsrPersistence() {
		return twitterUsrPersistence;
	}

	public void setTwitterUsrPersistence(
		TwitterUsrPersistence twitterUsrPersistence) {
		this.twitterUsrPersistence = twitterUsrPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "org.infoaxon.fkm.portlet.twitter.service.TwitterUsrLocalService.impl")
	protected TwitterUsrLocalService twitterUsrLocalService;
	@BeanReference(name = "org.infoaxon.fkm.portlet.twitter.service.TwitterUsrService.impl")
	protected TwitterUsrService twitterUsrService;
	@BeanReference(name = "org.infoaxon.fkm.portlet.twitter.service.persistence.TwitterUsrPersistence.impl")
	protected TwitterUsrPersistence twitterUsrPersistence;
}