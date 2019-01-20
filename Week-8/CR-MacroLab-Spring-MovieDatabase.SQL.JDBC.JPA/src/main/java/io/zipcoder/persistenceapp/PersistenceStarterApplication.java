package io.zipcoder.persistenceapp;

import io.zipcoder.persistenceapp.service.PersonService;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class PersistenceStarterApplication {

	@Autowired
	static PersonService personService;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";

	//  Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public static void main(String[] args) {
		SpringApplication.run(PersistenceStarterApplication.class, args);

		Connection conn = null;
		Statement stmt = null;
		try{
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected database successfully...");

			// STEP 3: Execute a query
			stmt = conn.createStatement();
			String sql = "SELECT * FROM PERSON";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("query result: ");

			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("First name: " + rs.getString(2));
				System.out.println("Last name: " + rs.getString(3));
				System.out.println("Mobile phone: " + rs.getString(4));
				System.out.println("Birthday date: " + rs.getString(5));
				System.out.println("Home ID: " + rs.getInt(6));
			}

			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch(SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if(stmt!=null) stmt.close();
			} catch(SQLException se2) {
			} // nothing we can do
			try {
				if(conn!=null) conn.close();
			} catch(SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
