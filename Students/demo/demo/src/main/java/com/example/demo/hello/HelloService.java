package com.example.demo.hello;

import java.sql.*;
import java.util.*;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	List<Student> sList = new ArrayList<Student>();
	
	public Student getStudent(String n, int a, String l) {
		return new Student(n, a, l); 
	}

	public void addStudent(Student s) throws Exception {
		loadFromDB();
		sList.add(s);
		saveToDB(s);
	}

	public List<Student> getAllStudents() throws Exception {
		return sList;
	}
	
	private void loadFromDB() throws Exception {
		  sList = new ArrayList<Student>();
		  
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/university";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM students";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        String name = rs.getString("name");
	        String location = rs.getString("location");
	        int age = rs.getInt("age");
	        sList.add(new Student(name, age, location));
	      }
	      st.close();		
	}
	
	private void saveToDB(Student s)  throws Exception{
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/university";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // Add all students one by one 
	      String query = "insert into students values (?, ?, ?)";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, s.getName());
	      preparedStmt.setInt (2, s.getAge());
	      preparedStmt.setString   (3, s.getLocation());
	      preparedStmt.execute();
	}
}
