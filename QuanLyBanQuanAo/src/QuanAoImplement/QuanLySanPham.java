package QuanAoImplement;
import java.sql.Connection;
import java.util.ArrayList;
import DBConnect.DBConnection;
public class QuanLySanPham {
	public ArrayList<SanPham> getList(int a) throws Exception
	{
		ArrayList<SanPham> courseList = new ArrayList<SanPham>();
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		GetDanhSachSanPham list = new GetDanhSachSanPham();
		courseList = list.getList(1);
		return courseList;
	}
}
