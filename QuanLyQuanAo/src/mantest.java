import java.sql.SQLException;
import java.util.ArrayList;

import QuanAoImplement.GetDanhSachDichVu;
import QuanAoImplement.GetDanhSachSanPham;
import QuanAoImplement.SanPham;
import QuanAoService.QuanLy;

public class mantest {
public static void main(String[] args) throws SQLException {
QuanLy ql = new QuanLy();
ql.updateQuanAo(123, 111, 222, "aaa", "a", 54, "132425", "132536");
	}
}
