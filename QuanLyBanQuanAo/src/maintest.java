import java.sql.SQLException;

import QuanAoImplement.GetDanhSachSanPham;
import QuanAoService.QuanLy;

public class maintest {
	public static void main(String[] args) throws SQLException {
		GetDanhSachSanPham dd = new GetDanhSachSanPham();
		QuanLy bb = new QuanLy();
		bb.deleteQuanAo(1);
	}
}
