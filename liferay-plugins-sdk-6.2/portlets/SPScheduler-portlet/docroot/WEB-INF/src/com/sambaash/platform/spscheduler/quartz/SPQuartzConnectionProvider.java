package com.sambaash.platform.spscheduler.quartz;

import java.sql.Connection;
import java.sql.SQLException;

import org.quartz.utils.ConnectionProvider;

import com.liferay.portal.kernel.util.InfrastructureUtil;

public class SPQuartzConnectionProvider implements ConnectionProvider {

	@Override
	public Connection getConnection() throws SQLException {
		return InfrastructureUtil.getDataSource().getConnection();
	}

	public void shutdown() throws SQLException {
	}

}