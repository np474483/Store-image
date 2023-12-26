package jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Storeimage 
{
	public static void main(String[] args)
	{
	String url="jdbc:mysql://localhost:3307/test1";
	String user="root";
	String password="Nikhil@167#";
	
	String filePath="C://nikhiljava//rohit.jpg";
	
	try
	{
		Connection con=DriverManager.getConnection(url,user,password);
		
		String sql="INSERT INTO test(name,image)values(?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1, "Rohit Sharma");
		
		FileInputStream inputStream=new FileInputStream(new File(filePath));
		statement.setBlob(2, inputStream);
		
		
		int row=statement.executeUpdate();
		if(row>0)
		{
			System.out.println("A contact was inserted with photo image.");
		}
		con.close();
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
		
	}
	catch(IOException ex)
	{
		ex.printStackTrace();
	}

}
}
