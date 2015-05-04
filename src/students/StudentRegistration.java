package students;

import java.sql.SQLException;

import java.util.Scanner;

import bean.BeanClass;

import admin.Main;


public class StudentRegistration extends BeanClass 
{
	static StudentRegistration studentreg;
	private String branch;
	private String roll_no;
	private String room_no;

	public String getRoll_no() 
	{
		return roll_no;

	}

	public void setRoll_no(String roll_no) 
	{
		if (Integer.parseInt(roll_no) > 0) 
		{
			this.roll_no = roll_no;
		} else {
			System.out.println("Roll no can't be negative Plz re enter");
			// goto trollNo;
		}
	}

	private String previous_school;
	private static Scanner sc;

	public String getBranch() 
	{
		return branch;
	}

	public void setBranch(String branch)
	{
		this.branch = branch;
	}

	public String getPrevious_school() 
	{
		return previous_school;
	}

	public void setPrevious_school(String previous_school) 
	{
		this.previous_school = previous_school;

	}

	public static void onInsert() throws SQLException 
	{

		sc = new Scanner(System.in);
		studentreg = new StudentRegistration();
		System.out.print("Enter name :");

		studentreg.setName(sc.nextLine());
		 System.out.print("enter Roll No :");
		 
		studentreg.setRoll_no(sc.nextLine());
		System.out.print("enter Branch :");

		studentreg.setBranch(sc.nextLine());
		System.out.print("Previous School :");
		
		studentreg.setPrevious_school(sc.nextLine());
		
		System.out.print("Mob no :");
		studentreg.setMobile_no(sc.nextLine());
		System.out.print("enter Address :");
		studentreg.setAddress(sc.nextLine());
		System.out.print("enter Room No :");
		studentreg.setRoom_no(sc.nextLine());
		System.out.print("enter father name :");
		studentreg.setFather_name(sc.nextLine());

		String sql = "INSERT INTO STUDENT VALUES(" + "'" + studentreg.getName()
				+ "'," + "'" + studentreg.getRoll_no() + "'," + "'"
				+ studentreg.getFather_name() + "'," + "'"
				+ studentreg.getAddress() + "'," + "'" + studentreg.getBranch()
				+ "'," + "'" + studentreg.getRoom_no() + "'," + "'"
				+ studentreg.getDob() + "'," + "'" + studentreg.getMobile_no()
				+ "'" + ")";
		Main.st.execute(sql);
		System.out.println("inserted successfully");

		Switching.switching();

	}

	public String getRoom_no()
	{
		return room_no;
	}

	public void setRoom_no(String room_no)
	{
		this.room_no = room_no;
	}

}
