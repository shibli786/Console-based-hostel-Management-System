package Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Registration.MainClass;

public class PassRecover {
	static Scanner sc;
	static String pass; 
	static ResultSet rs1;
	private static String quest;
	private static String ans;
	static final String select = "select * from ADMINDETAIL";

	public static String getQuest() {
		return quest;
	}

	public static void setQuest(String quest) {
		PassRecover.quest = quest;
	}

	public static String getAns() {
		return ans;
	}

	public static void setAns(String ans) {
		PassRecover.ans = ans;
	}

	static ResultSet rs;
	static int count=0;
	static String sql = "SELECT * FROM question";

	public static void recover() throws SQLException {
		
		sc = new Scanner(System.in);
		SettingSecurity.choice();
		int choice = sc.nextInt();
	//System.out.println("enter security Choice");
		int d=0;
		while(choice>5 && d<3) {
			if(d==2) {System.out.println("You have tried many Time System is exiting... "); System.exit(0);}
			System.out.println("plz enter choice less than 6");
			choice=sc.nextInt();
			d++;
			
		}
		System.out.println("Enter Security Answer ");
		pass = sc.next();

		String ch1 = SettingSecurity.getChoice1();
		String ch2 = SettingSecurity.getChoice2();
		String ch3 = SettingSecurity.getChoice3();
		String ch4 = SettingSecurity.getChoice4();
		String ch5 = SettingSecurity.getChoice5();
		rs=MainClass.st
				.executeQuery(sql);

		while (rs.next()) {
			String quest = rs.getString("question");
			String ans = rs.getString("ans");
			setQuest(quest);
			setAns(ans);
			//System.out.println(getAns());
			//System.out.println(getQuest());

		}
		rs1 = MainClass.st.executeQuery(select);

		while(rs1.next()) {
			
			
		
     if(choice==1) {
			if (ch1.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));

			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 2) {

			if (ch2.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));


			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 3) {

			if (ch3.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));


			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 4) {

			if (ch4.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));


			} else
				System.out.println("Wrong Answer ");

		} else if(choice==5) {

			if (ch5.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));

			} else
				System.out.println("Wrong Answer ");

		}
		//


		
	}
	if(count<2) {
		count++;
		//System.out.println();
		//System.out.println(count);
		System.out.println(3-count +" Attempt left");
		
		recover();
		
	}	
	
	}

}