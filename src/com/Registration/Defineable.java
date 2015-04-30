package com.Registration;

import java.sql.SQLException;

public interface Defineable {
	
	 void onCreate() throws SQLException;
	 void  onAlter();
	void  onDrop()throws SQLException;
	void onTruncate(); 
	
	
	}
