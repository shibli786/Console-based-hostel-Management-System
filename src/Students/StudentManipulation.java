package Students;

import java.beans.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Registration.MainClass;

public class StudentManipulation {
	static Scanner sc;

	static ResultSet rs;
	Statement st;

	public static void onSelect() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "Select * from STUDENT";
		rs = MainClass.st.executeQuery(sql);
		while (rs.next()) {

			String father_name = rs.getString("father_name");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String mobile_no = rs.getString("mobile_no");
			Date dob;
			String branch = rs.getString("branch");
			String roll_no = rs.getString("roll_no");
			String room_no = rs.getString("room_no");

			System.out.print("Name " + name);
			System.out.print(",Roll No " + roll_no);
			System.out.print(",Room no " + room_no);
			System.out.print(",Branch " + branch);
			System.out.print(",Mob " + mobile_no);
			System.out.print(",father Name " + father_name);
			System.out.print(",Address " + address);
			System.out.println();
		}

	}

	public static void onUpdate() throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("Enter Student Roll No");
		String roll = sc.next();
		System.out.println("Enter Coloumn name you want to update");
		String coloumn = sc.next();
		System.out.println("enter new values");
		String value = sc.next();
		String sql = "update student set " + coloumn + "= '" + value + "'"
				+ "where roll_no='" + roll + "'";
		MainClass.st.execute(sql);
		 System.out.println("updated Successfully");

	}

	public static void onDelete() throws SQLException {
		sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out
				.println("Enter Roll No u want to delete record associated with it");

		String roll = sc.next();
		String sql = "delete STUDENT where roll_no =" + "'" + roll + "'";
		MainClass.st.execute(sql);
		System.out.println(" Roll no of deleted Student record is " + roll);

	}

	public static void onSearch() {
		// TODO Auto-generated method stub

	}
}
