package admin;

import java.io.Console;
import java.sql.*;
import java.util.Scanner;

import students.*;



public class Main {
	public static int ans = 0;

	static Connection c;
	public static Statement st;
	public static ResultSet rs;

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		boolean f2=true;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e1) {
			System.out.println("Oracle jdbc driver is missing\n" +
					"Download jar file ojdbc6.jar and place it in java-jre-lib-ext folder \n" +
					"");
			f2=false;
		}
		if(f2) {
		System.out.println("Connecting to database...");
		Scanner sc=new Scanner(System.in);
		System.out.print("enter oracle password :");
		String pass;
		Console con=System.console();
		if(con!=null) {
			pass=new String(con.readPassword());
			
		}
		else {
		 pass=sc.next();}
		// c = null;
		
		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"system", pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Password");
		}
	if(c!=null) {
		st = c.createStatement();
		System.out.println("connected Successfully");

		System.out.println("Welcome to the Hostel Management System");
		
		// Administrator
		System.out.println("Enter Signup/login");
		String v = sc.next().toLowerCase();
		if (v.equals("signup")) {
			//String ac = "drop table AdminDetail";
			
			// st.execute(ac);
			
			// System.out.println("droped");

			// String sql =
			// "SELECT COUNT(1) FROM ALL_TABLES WHERE TABLE_NAME = 'ADMINDETAIL'";
			// boolean ans = st.execute(sql);

			String p = "SELECT count(1) FROM all_tables where table_name = 'ADMINDETAIL'";

			ResultSet r = st.executeQuery(p);
			while (r.next()) {
				ans = r.getInt("COUNT(1)");
			}
			//System.out.println(ans);

			if (ans > 0) {
				System.out.println("Admin already registered");
				
					System.out
							.println("press 1 for login 2 for password Recovery");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:{
						Administrator.logIn();
						break;}
					case 2:{
						PassRecover.recover();
						break;}
					default:{
						System.out.println("enter 1 or 2");
						break;}

					}

				}
			 else {
				Administrator.signUp();}}
			

		else if (v.equals("login")) {
			Administrator.logIn();
		}
		else System.out.println("plz enter Right input");

	}}}

	public static void Success() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Press 1 for Student Dashboard  \nPress 2 for Staff Dashboard \nPress 3 for Admin Profile ");

		int ch = sc.nextInt();
		if (ch == 1) {
			Switching.switching();
		} else if (ch == 2) {
			System.out.println("under process");
		} 
		else if(ch==3) {}
		else {
			System.out.println("wrong input");
		}
	}
}
