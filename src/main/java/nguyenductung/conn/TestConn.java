package nguyenductung.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConn {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Start connection....");
		
		Connection conn = ConnectionUtils.getMSSQLConnection();

		System.out.println("Get connection " + conn);
		System.out.println("Done!");

	}

}
