package teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import db.DB;

public class AcessandoDados {

	public static void main(String[] args) { 
		
		// user=developer
		// password=s123456
		// dburl=jdbc:mysql://localhost:3306/coursejdbc
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		//System.out.println(formatter.format(calendar.getTime()));
		
		
		try {
			connection = DB.getConnection();
			
			statement =  connection.createStatement();
			
			//String sql = "SELECT * FROM seller";
			
			//String sql = "SELECT Id, Name, Email, BirthDate, BaseSalary, DepartMentId "
					//	+"FROM seller";
			
			String sql = 
			"SELECT * "+
			"FROM seller "+
			"INNER JOIN department "+
			"ON seller.Id = department.Id";
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				int id = resultSet.getInt("Id");
				String Name = resultSet.getString("Name");
				String Email = resultSet.getString("Email");
				Date birthDate = resultSet.getDate("BirthDate");
				
				String DepartmentName = resultSet.getString(8);
				
				System.out.println(id + " "+Name+" "+Email+" "+formatter.format(birthDate)+" "+DepartmentName);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		

	}
}
