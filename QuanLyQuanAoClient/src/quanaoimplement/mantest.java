package quanaoimplement;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import quanaoimplement.GetDanhSachDichVuStub.StringListGetByJson;

public class mantest {

	public static void main(String[] args) throws RemoteException {
		GetDanhSachDichVuStub stub = new GetDanhSachDichVuStub();
		StringListGetByJson bb = new StringListGetByJson();
		bb.setI(1);
		String xx = stub.stringListGetByJson(bb).get_return();
		System.out.println(xx);
	}

}
