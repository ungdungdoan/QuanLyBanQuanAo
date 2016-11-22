package QuanAoImplement;
import java.util.ArrayList;
import com.google.gson.Gson;
public class GetDanhSachDichVu {
	public static String StringListGetByJson(int i) {
		String DanhSachTraVe = null;
		if(i==1) {
			ArrayList<SanPham> DanhSachSanPham = new ArrayList<SanPham>();
			try
			{GetDanhSachSanPham bblist = new GetDanhSachSanPham(); 
				DanhSachSanPham = bblist.getList(1);
				Gson gson = new Gson();
				DanhSachTraVe = gson.toJson(DanhSachSanPham);
			}
			catch (Exception e) {
				e.printStackTrace();
			}}
		return DanhSachTraVe;
	}
}
