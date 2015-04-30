package Admin;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Registration.MainClass;

public class Administrator {
	static final String sql = "select * from ADMINDETAIL";
	static ResultSet rs;

	public static void onCreate() throws SQLException {
		// String drop="drop table AdminDetail";
		String sql = "Create table ADMINDETAIL(name varchar(220),username varchar(23),password varchar(30))";
		// MainClass.st.execute(drop);
		MainClass.st.execute(sql);
		System.out.println("Admin table is created");
	}

	private static void onInsert() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		setName(sc.next());
		System.out.println("enter username");
		setUsername(sc.next());
		System.out.println("enter password");
		setPassword(sc.next());

		// password = sc.next();
		String sql = "insert into ADMINDETAIL values(" + "'"
				+ Administrator.getName() + "','" + Administrator.getUsername()
				+ "','" + Administrator.getPassword() + "'" + ")";
		MainClass.st.execute(sql);
		SettingSecurity.securityQuestion();
	}

	static String username;;

	public static void setUsername(String username) {
		Administrator.username = username;
	}

	public static void setPassword(String password) {
		Administrator.password = password;
	}

	static int Count = 0;

	 public static String getUsername() throws SQLException {
		rs = MainClass.st.executeQuery(sql);
		while (rs.next()) {
			username = rs.getString("username");
		}
		return username;
	}

	private static String getPassword() throws SQLException {
		while (rs.next()) {
			password = rs.getString("password");

		}
		return password;
	}

	static String password;
	static String name = null;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Administrator.name = name;
	}

	Console c;

	public static void signUp() throws SQLException {
		onCreate();
		onInsert();

		logIn();

	}

	public static void logIn() throws SQLException {

		// TODO Auto-generated method stub
		String password1;
		
		Console c=System.console();
		System.out.println("Enter login detail");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter UserID :");
		
		String username1 = sc.next();
		System.out.print("Enter password :");
		if(c!=null) password1=new String(c.readPassword());
		else
		 password1 = sc.next();

		rs = MainClass.st.executeQuery(sql);
		while (rs.next()) {

			if (username1.equals(rs.getString("username"))
					&& password1.equals(rs.getString("password"))) {

				System.out.println("Login Success");
				MainClass.Success();
			}

			else {

				if (Count == 2) {
					System.out.println("Recover forgotten password press Y/N");
					String ch = sc.next().toLowerCase();
					if (ch.equals("y")) {
						PassRecover.recover();
					}
					else {
						System.out.println("System is exiting...");
					}
					

				}

				else {
					Count++;

					System.out.println("login Failed");

					logIn();
				}
			}

		}

	}

	private void se() throws SQLException {
		// TODO Auto-generated method stub
		rs = MainClass.st.executeQuery(sql);
		while (rs.next()) {

			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
		}

	}

}
