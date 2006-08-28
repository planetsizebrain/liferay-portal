/**
 * Copyright (c) 2000-2006 Liferay, LLC. All rights reserved.
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

package com.liferay.portlet.imagegallery.service.http;

import com.liferay.portal.kernel.util.StackTraceUtil;

import com.liferay.portlet.imagegallery.service.spring.IGFolderServiceUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.RemoteException;

/**
 * <a href="IGFolderServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class IGFolderServiceSoap {
	public static com.liferay.portlet.imagegallery.model.IGFolderModel addFolder(
		java.lang.String plid, java.lang.String parentFolderId,
		java.lang.String name, java.lang.String description,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.addFolder(plid,
					parentFolderId, name, description, addCommunityPermissions,
					addGuestPermissions);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static void deleteFolder(java.lang.String folderId)
		throws RemoteException {
		try {
			IGFolderServiceUtil.deleteFolder(folderId);
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderModel getFolder(
		java.lang.String folderId) throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.getFolder(folderId);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderModel updateFolder(
		java.lang.String folderId, java.lang.String parentFolderId,
		java.lang.String name, java.lang.String description,
		boolean mergeWithParentFolder) throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.updateFolder(folderId,
					parentFolderId, name, description, mergeWithParentFolder);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	private static Log _log = LogFactory.getLog(IGFolderServiceSoap.class);
}