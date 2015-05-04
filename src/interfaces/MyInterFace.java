package interfaces;

import java.sql.SQLException;

public interface MyInterFace {

	void onCreate() throws SQLException;

	void onAlter();

	void onDrop() throws SQLException;

	

	

}
