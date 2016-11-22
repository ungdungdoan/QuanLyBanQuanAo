package GUIClient;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import quanaoimplement.GetDanhSachDichVuStub;
import quanaoimplement.GetDanhSachDichVuStub.StringListGetByJson;
import quanaoimplement.GetDanhSachDichVuStub.StringListGetByJsonResponse;
public class SanPhamManager {
	public List<SanPham> getAllSanPham() throws RemoteException {
		GetDanhSachDichVuStub stub = new GetDanhSachDichVuStub();
		StringListGetByJson ss = new StringListGetByJson();
		ss.setI(1);
		StringListGetByJsonResponse cc =stub.stringListGetByJson(ss);
		String ee =cc.get_return();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<SanPham>>(){}.getType();
		List<SanPham> danhsachSanPham = gson.fromJson(ee, type); 
		return danhsachSanPham;
	}
}
