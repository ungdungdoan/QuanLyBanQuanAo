package QuanAoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DBConnect.DBConnection;

public class QuanLy {
	public static Connection con;
	public QuanLy(){
		DBConnection db = new DBConnection();
		this.con = db.getConnection();
	}
	public void addSanPham(int makh,int manhom,int masp, String tenkh,String kichco,int soluong,String sdt,String diachi) throws SQLException{
		String sql = "INSERT INTO quanao (makh,manhom,masp,tenkh,size,soluong,sdt,diachi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, makh);
		statement.setInt(2, manhom);
		statement.setInt(3, masp);
		statement.setString(4, tenkh);
		statement.setString(5, kichco);
		statement.setInt(6, soluong);
		statement.setString(7, sdt);
		statement.setString(8, diachi);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");

		}
		System.out.println("them thanh cong");
		detroy();
	}
	public void updateQuanAo(int makh,int manhom,int masp, String tenkh,String kichco,int soluong,String sdt,String diachi) throws SQLException{
		String sql = "UPDATE quanao SET manhom=?, masp=?, tenkh=?, size=?, soluong=?, sdt=?, diachi=? WHERE makh=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, manhom);
		statement.setInt(2, masp);
		statement.setString(3, tenkh);
		statement.setString(4, kichco);
		statement.setInt(5, soluong);
		statement.setString(6, sdt);
		statement.setString(7, diachi);
		statement.setInt(8, makh);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");

		}
		System.out.println("them thanh cong");
		detroy();
	}
	public void deleteQuanAo(int makh) throws SQLException{
		String sql = "DELETE FROM quanao WHERE makh=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, makh);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");

		}
		System.out.println("them thanh cong");
		detroy();
	}	
	public static void detroy() throws SQLException{
		con.close();
	}
}
