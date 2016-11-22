package QuanAoImplement;

public class SanPham {
	private int MaKhachHang;
	private int MaNhom;
	private int MaSanPham;
	private String TenKhachHang;
	private String KichCo;
	private int SoLuong;
	private String SoDienThoai;
	private String DiaChi;

	public int getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public int getMaNhom() {
		return MaNhom;
	}

	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}

	public int getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getKichCo() {
		return KichCo;
	}

	public void setKichCo(String kichCo) {
		KichCo = kichCo;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public SanPham(int maKhachHang, int maNhom, int maSanPham, String tenKhachHang, String kichCo, int soLuong,
			String soDienThoai, String diaChi) {
		super();
		MaKhachHang = maKhachHang;
		MaNhom = maNhom;
		MaSanPham = maSanPham;
		TenKhachHang = tenKhachHang;
		KichCo = kichCo;
		SoLuong = soLuong;
		SoDienThoai = soDienThoai;
		DiaChi = diaChi;
	}

	public SanPham() {
	}
}
