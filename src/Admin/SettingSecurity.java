package Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Registration.MainClass;

public class SettingSecurity {
	private static final String choice1 = "what is your childhood nickname";

	public static String getChoice1() {
		return choice1;
	}

	public static String getChoice2() {
		return choice2;
	}

	public static String getChoice3() {
		return choice3;
	}

	public static String getChoice4() {
		return choice4;
	}

	public static String getChoice5() {
		return choice5;
	}

	private static final String choice2 = "what is the name of your fovourite childhood friend";
	private static final String choice3 = "which food do you like the best";
	private static final String choice4 = "In which city you mother is born";
	private static final String choice5 = "Which city you have visted fist ";
	private static String ans;

	public static void securityQuestion() throws SQLException {
		MainClass.st.execute("drop table question");
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String sql = "Create table Question(question varchar(230),ans varchar(50))";
		MainClass.st.execute(sql);
		System.out.println("security table is created");
		choice();

		int choice = sc.nextInt();

		onInsert(choice);

	}

	private static void onInsert(int ch) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ans");
		ans = sc.next();
		switch (ch) {

		case 1: {
			String sql = "INSERT INTO QUESTION VALUES('" + choice1 + "','"
					+ ans + "'" + ")";
			MainClass.st.execute(sql);
			System.out.println("inserted successfully");
		}
			break;

		case 2: {
			String sql = "INSERT INTO QUESTION VALUES('" + choice2 + "','"
					+ ans + "'" + ")";
			MainClass.st.execute(sql);
			System.out.println("inserted successfully");
		}
			break;
		case 3: {
			String sql = "INSERT INTO QUESTION VALUES('" + choice3 + "','"
					+ ans + "'" + ")";
			MainClass.st.execute(sql);
			System.out.println("inserted successfully");
		}
			break;
		case 4: {
			String sql = "INSERT INTO QUESTION VALUES('" + choice4 + "','"
					+ ans + "'" + ")";
			MainClass.st.execute(sql);
			System.out.println("inserted successfully");
		}
			break;
		case 5: {
			String sql = "INSERT INTO QUESTION VALUES('" + choice5 + "','"
					+ ans + "'" + ")";
			MainClass.st.execute(sql);
			System.out.println("inserted successfully");
		}
			break;

		}

	}

	static void choice() {
		System.out.println("Select Security Question");

		System.out.println("choice 1: " + choice1);
		System.out.println("choice 2: " + choice2);
		System.out.println("choice 3: " + choice3);
		System.out.println("choice 4: " + choice4);
		System.out.println("choice 5: " + choice5);

	}

	

}
