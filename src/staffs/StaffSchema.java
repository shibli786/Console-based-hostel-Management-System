package staffs;

import java.sql.SQLException;

import admin.Main;

public class StaffSchema {

	private static final String CREATE = "create table staff(staf_id varchar(15),name varchar(35),room_no varchar(30),mob varchar(10),address varchar(255))";
    private static final String CHECK="select COUNT(1) from all_tables where table_name='staff' ";
    void onCreate() throws SQLException {
    	Main.rs=Main.st.executeQuery(CHECK);
    	while(Main.rs.next()) {
    		int ans=Main.rs.getInt("COUNT(1)");
    		if(ans>0) {
    			System.out.println("Staff Table already exist ");
    			
    		}
    		else {
    			Main.st.execute(CREATE);
    			
    		}
    	}
    }

}
