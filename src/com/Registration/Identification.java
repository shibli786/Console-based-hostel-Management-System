package com.Registration;

import java.sql.SQLException;

public class Identification {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void install() throws SQLException {
		String CREATE="create table InstallationDetail(times int)";
		MainClass.st.execute(CREATE);

	}

}
