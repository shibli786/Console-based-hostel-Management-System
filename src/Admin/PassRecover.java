package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


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
		SecurityQuestion.choice();
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

		String ch1 = SecurityQuestion.getChoice1();
		String ch2 = SecurityQuestion.getChoice2();
		String ch3 = SecurityQuestion.getChoice3();
		String ch4 = SecurityQuestion.getChoice4();
		String ch5 = SecurityQuestion.getChoice5();
		rs=Main.st
				.executeQuery(sql);

		while (rs.next()) {
			String quest = rs.getString("question");
			String ans = rs.getString("ans");
			setQuest(quest);
			setAns(ans);
			//System.out.println(getAns());
			//System.out.println(getQuest());

		}
		rs1 = Main.st.executeQuery(select);
		boolean flag=false;

		while(rs1.next()) {
			
			
		
     if(choice==1) {
			if (ch1.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));
				flag=true;
				int c1=0,c2=-1;
				while(c1++<3 &&c2==-1) {
				System.out.println("Press 1 for login 2 for exit ");
				
				
				int o=sc.nextInt();
				if(o==1) { Administrator.logIn(); c2=0;}else if(o==2) {
					System.out.println("System is exiting...");
					c2=0;
					System.exit(0);
				}
				else {
					System.out.println("Input 1 or 2");
				}}
					
				

			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 2) {

			if (ch2.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));

				flag=true;
			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 3) {

			if (ch3.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));

				flag=true;
			} else
				System.out.println("Wrong Answer ");

		} else if (choice == 4) {

			if (ch4.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));
				flag=true;

			} else
				System.out.println("Wrong Answer ");

		} else if(choice==5) {

			if (ch5.equals(getQuest()) && pass.equals(getAns())) {
				System.out.println("Password has been recoverd Successfully");
				System.out.println("UserName := "+rs1.getString("username"));

				System.out.println("Password := "+rs1.getString("password"));
				flag=true;
			} else
				System.out.println("Wrong Answer ");

		}
		//


		
	}
	if(count<2 && !flag) {
		count++;
		//System.out.println();
		//System.out.println(count);
		System.out.println(3-count +" Attempt left");
		
		recover();
		
	}	
	
	}

}