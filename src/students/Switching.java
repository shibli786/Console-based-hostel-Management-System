package students;

import java.sql.SQLException;
import java.util.Scanner;


public class Switching {
	static StudentSchema studentschema;
	 static String sql;
	
	
	
	
	public static  void switching() throws SQLException {
		studentschema= new StudentSchema();
		
		System.out.println("Type CREATE/INSERT/SELECT/UPDATE/DROP/SEARCH/DELETE/EXIT for relevant operations " );
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
		switching();
		break;
		case "select":StudentOperations.onSelect();
		switching();
		break;
		case "search":StudentOperations.onSearch();
		switching();
		break;
		case "update":StudentOperations.onUpdate();
		switching();
		break;
		case "delete":StudentOperations.onDelete();
		switching();
		break;
		case "drop":StudentOperations.onDrop();
		switching();
		break;
		case "exit":System.out.println("System is exiting...\nexited");System.exit(0);
		default:System.out.println("eneter correct choice");switching();break;
			
		
		
		
		
		
		}
		}

	

}
