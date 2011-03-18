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

package org.infoaxon.fkm.portlet.twitter.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import org.infoaxon.fkm.portlet.twitter.service.base.TwitterUsrLocalServiceBaseImpl;
import twitter4j.Twitter;
import org.infoaxon.fkm.portlet.twitter.model.TwitterUsr;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <a href="TwitterUsrLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class TwitterUsrLocalServiceImpl extends TwitterUsrLocalServiceBaseImpl {
	
	private TwitterUsr twitterUsr=null;
	private static final Log log = LogFactory.getLog(TwitterUsrLocalServiceImpl.class);
	
	public Twitter getTwitterObj(long userid)throws SystemException,PortalException {
		List list=new ArrayList();	
		Twitter twitter=null;
		twitterUsr=twitterUsrPersistence.findByPrimaryKey(userid);
		String use=	twitterUsr.getTwitterobject();
		byte[] buf = null;
		try{
			buf = new sun.misc.BASE64Decoder().decodeBuffer(use);
			ObjectInputStream   ins = new ObjectInputStream(new ByteArrayInputStream(buf));
			twitter =(Twitter)ins.readObject();
			ins.close();
		}catch(Exception e){
			System.out.println(e);
		}
        return twitter;
	}
		
	public void setTwitterObj(long userid,byte[] twitterobject)throws SystemException,PortalException
	{
		String s = null;
		s=new sun.misc.BASE64Encoder().encode(twitterobject);
		twitterUsr=twitterUsrPersistence.fetchByPrimaryKey(userid);
		if(Validator.isNotNull(twitterUsr)){
			twitterUsr.setTwitterobject(s);
			twitterUsrPersistence.update(twitterUsr, false);
		}
		else{
			twitterUsr=twitterUsrPersistence.create(userid);
			twitterUsr.setUserid(userid);
			twitterUsr.setTwitterobject(s);
			twitterUsrPersistence.update(twitterUsr, false);
		}
		log.info("***********twitterobject has been set in database successfully");
	}
	
	public List<org.infoaxon.fkm.portlet.twitter.model.TwitterUsr> findAll()throws SystemException,PortalException {
		return twitterUsrPersistence.findAll();
	}
	
	
}