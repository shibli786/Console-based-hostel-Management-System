package com.Registration;

import java.sql.SQLException;
import java.util.Scanner;

import Students.StudentManipulation;

public class Switching {
	static StudentSchema studentschema;
	 static String sql;
	
	
	
	
	public static  void switching() throws SQLException {
		studentschema= new StudentSchema();
		
		System.out.println("Type CREATE/INSERT/SELECT/DROP/SEARCH for relevant operations " );
		Scanner sc= new Scanner(System.in);
		String choice= sc.next().toLowerCase();
		
		switch(choice) {
		case "create":try {
				studentschema.onCreate();
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		case "insert":StudentRegistration.onInsert();
		break;
		case "select":StudentManipulation.onSelect();
		break;
		case "search":StudentManipulation.onSearch();
		break;
		case "update":StudentManipulation.onUpdate();
		break;
		case "delete":StudentManipulation.onDelete();
		break;
			
		
		
		
		
		
		}
		}

	

}
