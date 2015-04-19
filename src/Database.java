import java.awt.Image;
import java.sql.*;
import java.util.*;
//import java.
public class Database
{
  public static void main( String args[] )
  {
    //Connection c = null;
    Statement stmt = null;
    String sql=null;
      //Class.forName("org.sqlite.JDBC");
    try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    Connection c = null;
	try {
		c = DriverManager.getConnection("jdbc:sqlite:test1.db");
	} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   // c = DriverManager.getConnection("jdbc:sqlite:test.db");
      try 
      {
		stmt = c.createStatement();
	  }
      catch (SQLException e) 
      {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
      try {
      sql = "CREATE TABLE COMPANY " +
                   "(ID INT      NOT NULL," +
                   " NAME           TEXT    NOT NULL, " + 
                   " AGE            INT     NOT NULL, " + 
                   " ADDRESS        CHAR(50), " + 
                   " SALARY         REAL)"; 
      //stmt.executeUpdate(sql);
      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
              "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try{
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	 stmt.executeUpdate(sql);
	
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	 stmt.executeUpdate(sql);
	
	 sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	       "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	 String kpl = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) ";
	 String name1="Patien1";
	 kpl = kpl+"VALUES ("+6+", '"+name1+"', "+25+", '"+name1+" ', "+65555.00+" );";
	 System.out.println(kpl);
	 System.out.println(kpl);
	 stmt.executeUpdate(kpl);
	 name1= "Teddy";
	 sql = "DELETE from COMPANY where ID='"+1+"';";
     stmt.executeUpdate(sql);
    // c.commit();
     
	ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	//int[] id1 = null;
	ArrayList<Integer> id1 = new ArrayList<Integer>();
	int i=0;
	//String[] name2=null;
	ArrayList<String> name2 = new ArrayList<String>();
	//int[] age1= null;
	ArrayList<Integer> age1= new ArrayList<Integer>();
	
	//String[] address1 = null;
	ArrayList<String> address1 = new ArrayList<String>();
	
	//double[] Salary1= null;
	ArrayList<Double> Salary1 = new ArrayList<Double>();
	while (rs.next())
	 {
		 int id= rs.getInt("id");
		 String name = rs.getString("name");
		 int age = rs.getInt("age");
		 String address= rs.getString("address");
		 double Salary = rs.getDouble("Salary");
		 
		 if (name.equals("Allen"))
		 {
			id1.add(id);
			name2.add(name);
			age1.add(age);
			address1.add(address);
			Salary1.add(Salary);
			i++;
		 }
		 
	 }
	
	for (int f =0; f<i; f++)
	{
		System.out.println("ID= "+id1.get(f)+"\tNAME= "+name2.get(f)+"\tAGE= "+age1.get(f)+"\tADDRESS= "+address1.get(f)+"\tSalary= "+Salary1.get(f));
	}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}