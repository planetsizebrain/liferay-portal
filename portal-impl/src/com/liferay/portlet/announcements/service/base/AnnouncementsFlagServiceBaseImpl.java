/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.announcements.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.announcements.model.AnnouncementsFlag;
import com.liferay.portlet.announcements.service.AnnouncementsFlagService;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsFlagPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the announcements flag remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.announcements.service.impl.AnnouncementsFlagServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.announcements.service.impl.AnnouncementsFlagServiceImpl
 * @see com.liferay.portlet.announcements.service.AnnouncementsFlagServiceUtil
 * @generated
 */
public abstract class AnnouncementsFlagServiceBaseImpl extends BaseServiceImpl
	implements AnnouncementsFlagService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.announcements.service.AnnouncementsFlagServiceUtil} to access the announcements flag remote service.
	 */

	/**
	 * Returns the announcements flag local service.
	 *
	 * @return the announcements flag local service
	 */
	public com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService getAnnouncementsFlagLocalService() {
		return announcementsFlagLocalService;
	}

	/**
	 * Sets the announcements flag local service.
	 *
	 * @param announcementsFlagLocalService the announcements flag local service
	 */
	public void setAnnouncementsFlagLocalService(
		com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService announcementsFlagLocalService) {
		this.announcementsFlagLocalService = announcementsFlagLocalService;
	}

	/**
	 * Returns the announcements flag remote service.
	 *
	 * @return the announcements flag remote service
	 */
	public AnnouncementsFlagService getAnnouncementsFlagService() {
		return announcementsFlagService;
	}

	/**
	 * Sets the announcements flag remote service.
	 *
	 * @param announcementsFlagService the announcements flag remote service
	 */
	public void setAnnouncementsFlagService(
		AnnouncementsFlagService announcementsFlagService) {
		this.announcementsFlagService = announcementsFlagService;
	}

	/**
	 * Returns the announcements flag persistence.
	 *
	 * @return the announcements flag persistence
	 */
	public AnnouncementsFlagPersistence getAnnouncementsFlagPersistence() {
		return announcementsFlagPersistence;
	}

	/**
	 * Sets the announcements flag persistence.
	 *
	 * @param announcementsFlagPersistence the announcements flag persistence
	 */
	public void setAnnouncementsFlagPersistence(
		AnnouncementsFlagPersistence announcementsFlagPersistence) {
		this.announcementsFlagPersistence = announcementsFlagPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return AnnouncementsFlag.class;
	}

	protected String getModelClassName() {
		return AnnouncementsFlag.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = announcementsFlagPersistence.getDataSource();

			DB db = DBFactoryUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService.class)
	protected com.liferay.portlet.announcements.service.AnnouncementsFlagLocalService announcementsFlagLocalService;
	@BeanReference(type = com.liferay.portlet.announcements.service.AnnouncementsFlagService.class)
	protected AnnouncementsFlagService announcementsFlagService;
	@BeanReference(type = AnnouncementsFlagPersistence.class)
	protected AnnouncementsFlagPersistence announcementsFlagPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	private String _beanIdentifier;
}