package com.Registration;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Admin.Administrator;

public class StudentSchema implements Defineable {
	
	public void onCreate() throws SQLException {
		// TODO Auto-generated method stub
		String sq="select count(1) from all_tables where table_name='STUDENT'";
		ResultSet rs=MainClass.st.executeQuery(sq);
		int ans = 0;
		while(rs.next()) {
		ans	=rs.getInt("COUNT(1)");}
		if(ans>0) {
			System.out.println("Student table already EXIST");
			System.out.println("Do you want to drop whole table enter Y/N");
			Scanner sc= new Scanner(System.in);
			String ab=sc.next().toLowerCase();
			if(ab.equals("y")) {
				System.out.println("enter login detail to proceed");
				System.out.print("username : ");String username=sc.next();
				System.out.print("password : ");String pass=sc.next();
				sq="Select * from AdminDetail";
				rs=MainClass.st.executeQuery(sq);
				while(rs.next()) {
					
					String u=rs.getString("username");
					String p=rs.getString("password");
				
					
					if(username.equals(u)&&pass.equals(p)) {
						onDrop(); 
					}
					else {
						System.out.println("Username/Password is Incorrect");
						System.out.println("System is exiting...");
						System.exit(0);
						
						
						
						
					}
					
					
				}
				
				//Administrator.getUsername()
				
				
				
				
			}
			else
			Switching.switching();
		}
		else {
			
		
		
		
		
		//MainClass.st.execute("drop table STUDENT");
				String CREATE = "CREATE TABLE STUDENT" + "(" + "name varchar(60),"
				+ "roll_no  varchar(5) primary key,"
				+ "father_name varchar(60)," + "address varchar(230),"
				+ "branch varchar(230)," + "room_no varchar(230),"
				+ "dob varchar(30)," + "mobile_no Varchar(10)" + ")";
		MainClass.st.execute(CREATE);
		System.out.println("table is Created");
		Switching.switching();

	}}

	public void onDrop() throws SQLException {
		// TODO Auto-generated method stub
		
		MainClass.st.execute("drop table STUDENT");
		System.out.println("Table is dropped Successfully ");
		Switching.switching();

	}

	@Override
	public void onAlter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTruncate() {
		// TODO Auto-generated method stub

	}

}
