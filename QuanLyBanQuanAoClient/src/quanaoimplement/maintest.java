package quanaoimplement;
import java.rmi.RemoteException;

import quanaoimplement.GetDanhSachDichVuStub.StringListGetByJson;
public class maintest {
	public static void main(String[] args) throws RemoteException {
		GetDanhSachDichVuStub stub = new GetDanhSachDichVuStub();
		StringListGetByJson bb = new StringListGetByJson();
		bb.setI(1);
		String xx = stub.stringListGetByJson(bb).get_return();
		System.out.println(xx);
	}
}
