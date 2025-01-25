package MyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class JDBCHandling {
	Connection con = null;
	
	//Connection con = null;
	PreparedStatement pstmt = null;
JDBCHandling(){
		
		
		try {
			Class. forName("com.mysql.cj.jdbc.Driver");
			System.out.println("WOW : Driver Mil Gaya");
		}catch (ClassNotFoundException e) {
		 e.printStackTrace();
		System.out.println("Problem in loading Driver");
		}

		
	
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "2004");
		System.out.println("WOW: Connection Ho gaya");
		} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Problem in Connection");
		}
}


int insertData( String Item, String Price, String Category ) {
	int status = 0;
	
	
    try {
    	PreparedStatement pstmt = con.prepareStatement("INSERT INTO menu (Item, Price, Category) VALUES (?, ?, ?)");
    	pstmt.setString(1, Item);
    	pstmt.setString(2, Price);
    	pstmt.setString(3, Category);


		
		status= pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return status;
}

ResultSet getTable() {
    Statement stmt = null;
	try {
        stmt = con.createStatement();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    ResultSet result = null;
	try {
        result = stmt.executeQuery("select * from menu");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    return result;
}

ResultSet getRow(String item) {
    ResultSet result = null;
    PreparedStatement pstmt = null;
    try {
        String query = "SELECT * FROM menu WHERE Item = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, item);
        result = pstmt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}

int insertUpdate(String Item, String Price, String Category) {
	int status=0;
	
	try {
		//PreparedStatement pstmt = con.prepareStatement("update menu set Item=?,Price=?,Category=? WHERE Item=?");
		String query="update menu set Price=?,Category=? WHERE Item=?";
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, Price);
		pstmt.setString(2, Category);
		pstmt.setString(3, Item);
		
		status= pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return status;
}

int insertDelete(String Item, String Price, String Category) {
	int status=0;
	try {
		String query="DELETE FROM menu WHERE Item=?";
        pstmt = con.prepareStatement(query);
		
//		pstmt.setString(1, Price);
//		pstmt.setString(2, Category);
		pstmt.setString(1, Item);
		
		status = pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return status;
}



int insertData( String FullName, String MobileNo, String Email, String Address, String Gender, String Qualification, java.sql.Date DOB) {
	int status = 0;
	
	
    try {
    	PreparedStatement pstmt = con.prepareStatement("INSERT INTO Employee(FullName, MobileNo, Email, Address, Gender, Qualification, DOB) VALUES (?, ?, ?,?,?,?,?)");
    	pstmt.setString(1, FullName);
    	pstmt.setString(2, MobileNo);
    	pstmt.setString(3,Email);
    	pstmt.setString(4,Address);
    	pstmt.setString(5,Gender);
    	pstmt.setString(6, Qualification);
    	pstmt.setDate(7,DOB);


		
		status= pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return status;
}

int insertUpdate1 (String FullName, String MobileNo, String Email, String Address, String Qualification, java.sql.Date DOB) {
int status=0;
	
	try {
		//PreparedStatement pstmt = con.prepareStatement("update menu set Item=?,Price=?,Category=? WHERE Item=?");
		String query="update employee set MobileNo=?,Email=?,Address=?,Qualification=?,DOB=? WHERE FullName=?";
		pstmt = con.prepareStatement(query);
		
    	pstmt.setString(1, MobileNo);
    	pstmt.setString(2,Email);
    	pstmt.setString(3,Address);
    	pstmt.setString(4, Qualification);
    	pstmt.setDate(5,DOB);
    	pstmt.setString(6, FullName);
		
		status= pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return status;
}

int insertDelete1(String FullName, String MobileNo, String Email, String Address) {
	int status=0;
	try {
		String query="DELETE FROM employee WHERE FullName=?";
        pstmt = con.prepareStatement(query);
		
//		pstmt.setString(1, Price);
//		pstmt.setString(2, Category);
		pstmt.setString(1, FullName);
		
		status = pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return status;
}



ResultSet getTable1() {
    Statement stmt = null;
	try {
        stmt = con.createStatement();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    ResultSet result = null;
	try {
        result = stmt.executeQuery("select * from employee");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    return result;
}

ResultSet getRow1(String FullName) {

ResultSet result = null;
PreparedStatement pstmt = null;
try {
String query = "SELECT * FROM employee WHERE FullName = ?";
pstmt = con.prepareStatement(query);
pstmt.setString(1, FullName);
result = pstmt.executeQuery();
} catch (SQLException e) {
e.printStackTrace();
}
return result;
	
}


}
//    ResultSet result = null;
//PreparedStatement pstmt = null;
//try {
//  String query = "SELECT * FROM employee WHERE FullName = ?";
//  pstmt = con.prepareStatement(query);
//  pstmt.setString(1, FullName);
//  result = pstmt.executeQuery();
//} catch (SQLException e) {
//  e.printStackTrace();
//}
//return result;

