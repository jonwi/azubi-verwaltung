package jw.secondproject.server.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jw.secondproject.shared.business.role.Student;

public class Database {

	private final static String DB_URL = "jdbc:h2:I:\\git\\azubi-verwaltung\\db\\h2";

	private static final String USER = "root";

	private static final String PASS = "root";

	public static List<Student> rtvStudents(String name, String vorname) {

		Connection conn = null;
		Statement stmt = null;
		List<Student> list = new ArrayList<>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("org.h2.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name, vorname, matrikelnummer FROM students";
			if (name != null && vorname != null && !name.isEmpty() && !vorname.isEmpty()) {
				sql += " WHERE ";
			}
			if (name != null && !name.isEmpty()) {
				sql += " name like " + name;
			}
			if (vorname != null && !vorname.isEmpty()) {
				sql += " vorname like " + vorname;
			}
			sql += ";";

			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int matrikelnummer = rs.getInt("matrikelnummer");
				String nameRS = rs.getString("name");
				String vornameRS = rs.getString("vorname");
				Student student = new Student(matrikelnummer);
				student.setName(nameRS);
				student.setVorname(vornameRS);
				list.add(student);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return list;
	}

}
