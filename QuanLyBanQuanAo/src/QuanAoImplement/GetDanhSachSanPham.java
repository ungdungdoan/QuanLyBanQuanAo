package QuanAoImplement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class GetDanhSachSanPham {
	private static Connection conn;
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/qlqa";
	private static String USER = "root";
	private static String PASS = "";

	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	
	public ArrayList<SanPham> getList(int a) throws SQLException {
		GetDanhSachSanPham conn = new GetDanhSachSanPham();
		ArrayList<SanPham> donationList = new ArrayList<SanPham>();
		Connection con = conn.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM quanao");

		ResultSet rs = stmt.executeQuery();
		System.out.println(rs);
		try {
			while(rs.next()) {
				SanPham SanPhamObj = new SanPham();
				SanPhamObj.setMaKhachHang(rs.getInt("makh"));
				SanPhamObj.setMaNhom(rs.getInt("manhom"));
				SanPhamObj.setMaSanPham(rs.getInt("masp"));
				SanPhamObj.setTenKhachHang(rs.getString("tenkh"));
				SanPhamObj.setKichCo(rs.getString("size"));
				SanPhamObj.setSoLuong(rs.getInt("soluong"));
				SanPhamObj.setSoDienThoai(rs.getString("sdt"));
				SanPhamObj.setDiaChi(rs.getString("diachi"));
				
				donationList.add(SanPhamObj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return donationList;
	}
}
