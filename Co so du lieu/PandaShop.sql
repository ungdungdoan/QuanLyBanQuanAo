create table NhomSanPham
(
MaNhom int not null,
TenNhom nvarchar(15)
)

alter table NhomSanPham
add constraint pk_MaNhom primary key (MaNhom)

create table SanPham
(
MaSanPham int not null,
TenSanPham nvarchar(40) not null,
MaNhom int,
KichCo nchar(5),
DonViTinh nvarchar(20),
Gia money,
SoLuongTon int
)

alter table SanPham
add constraint pk_MaSanPham primary key (MaSanPham),
	constraint fk_MaNhom foreign key (MaNhom) references NhomSanPham(MaNhom),
	constraint ck_Gia check (Gia>0),
	constraint ck_KichCo check (KichCo='NULL'),
	constraint ck_SoLuongTon check (SoLuongTon>0)

create table HoaDon
(
MaHoaDon int not null,
NgayLapHoaDon DateTime,
NgayGiao DateTime,
NoiChuyen nvarchar(60) not null,
MaKhachHang nchar(5)
)

alter table HoaDon
add constraint pk_MaHoaDon primary key (MaHoaDon),
	constraint fk_MaKhachHang foreign key (MaKhachHang) references KhachHang(MaKhachHang),
	constraint ck_NgayLapHoaDon check (NgayLapHoaDon>=getDate()),
	constraint ck_NgayGiao check (NgayGiao>=NgayLapHoaDon)

create table ChiTietHoaDon
(
MaHoaDon int not null,
MaSanPham int not null,
SoLuong smallint,
DonGia money,
)

alter table ChiTietHoaDon
add constraint pk_ChiTietHoaDon primary key (MaHoaDon,MaSanPham),
	constraint fk_MaHoaDon foreign key (MaHoaDon) references HoaDon(MaHoaDon),
	constraint fk_MaSanPham foreign key (MaSanPham) references SanPham(MaSanPham),
	constraint ck_SoLuong check (SoLuong>0)

create table KhachHang
(
MaKhachHang nchar(5) not null,
TenKhachHang nvarchar(40) not null,
LoaiKhachHang nvarchar(3),
DiaChi nvarchar(60),
SoDienThoai nvarchar(24),
DiaChiEmail nvarchar(50),
DiemTichLuy int
)

alter table KhachHang
add constraint pk_MaKhachHang primary key (MaKhachHang),
	constraint ck_LoaiKhachHang check (LoaiKhachHang='VIP' or LoaiKhachHang='TV'),
	constraint ck_DiemTichLuy check (DiemTichLuy>=0)

create table TaiKhoan
(
MaKhachHang nchar(5),
TenDangNhap nvarchar(50),
MatKhau nvarchar(50)
)

alter table TaiKhoan
add constraint fk_TaiKhoan foreign key (MaKhachHang) references KhachHang(MaKhachHang)

insert into NhomSanPham values 
(1,N'Áo sơ mi nam'), (2,N'Áo thun nam'), (3,N'Áo khoác nam'), (4,N'Quần jean nam'), (5,N'Quần kaki nam'),
(6,N'Quần tây nam'), (7,N'Quần lửng nam'), (8,N'Áo sơ mi nữ'), (9,N'Áo thun nữ'), (10,N'Áo khoác nữ'),
(11,N'Áo đầm'), (12,N'Quần jean nữ'), (13,N'Quần tây nữ'), (14,N'Quần short nữ'), (15,N'Váy')

insert into SanPham values
(1,N'Áo sơ mi nam tay dài cam S1',1,NULL,N'cái',180000,250), 
(2,N'Áo sơ mi nam tay dài vàng S2',1,NULL,N'cái',180000,250), 
(3,N'Áo sơ mi nam tay dài xanh bạc hà S3',1,NULL,N'cái',180000,250), 
(4,N'Áo sơ mi nam tay dài xanh biển S4',1,NULL,N'cái',180000,250), 
(5,N'Áo sơ mi nam tay dài tím cà S5',1,NULL,N'cái',180000,250), 
(6,N'Áo sơ mi nam tay dài trắng S6',1,NULL,N'cái',180000,250), 
(7,N'Áo sơ mi nam tay dài caro S7',1,NULL,N'cái',180000,250), 
(8,N'Áo sơ mi nam tay ngắn caro S8',1,NULL,N'cái',180000,250), 
(9,N'Áo thun nam tay ngắn in chữ T1',2,NULL,N'cái',140000,200), 
(10,N'Áo thun nam tay ngắn in chữ T2',2,NULL,N'cái',140000,200), 
(11,N'Áo thun nam tay ngắn in chữ T3',2,NULL,N'cái',140000,200), 
(12,N'Áo thun nam tay ngắn in chữ T4',2,NULL,N'cái',140000,200), 
(13,N'Áo khoác nam C1',3,NULL,N'cái',320000,250), 
(14,N'Áo khoác nam C2',3,NULL,N'cái',320000,250), 
(15,N'Quần jean nam xanh J1',4,NULL,N'cái',350000,200), 
(16,N'Quần jean nam đen J2',4,NULL,N'cái',350000,200),
(17,N'Quần kaki nam trắng K1',5,NULL,N'cái',240000,250),
(18,N'Quần kaki nam đen K2',5,NULL,N'cái',240000,250), 
(19,N'Quần tây nam đen P1',6,NULL,N'cái',290000,200), 
(20,N'Quần tây nam xanh đen P2',6,NULL,N'cái',290000,200), 
(21,N'Quần lửng nam xanh lá X1',7,NULL,N'cái',180000,250), 
(22,N'Quần lửng nam xanh dương X2',7,NULL,N'cái',180000,250), 
(23,N'Áo sơ mi nữ tay dài caro S1',8,NULL,N'cái',180000,250), 
(24,N'Áo sơ mi nữ tay dài caro S2',8,NULL,N'cái',180000,250), 
(25,N'Áo sơ mi nữ tay dài caro S3',8,NULL,N'cái',180000,250), 
(26,N'Áo thun nữ tay ngắn in chữ T1',9,NULL,N'cái',140000,200), 
(27,N'Áo thun nữ tay dài in chữ T2',9,NULL,N'cái',140000,200), 
(28,N'Áo khoác nữ C1',10,NULL,N'cái',320000,250), 
(29,N'Áo đầm nữ trắng D1',11,NULL,N'cái',350000,200), 
(30,N'Áo đầm nữ đen D2',11,NULL,N'cái',350000,200), 
(31,N'Quần jean nữ xanh J1',12,NULL,N'cái',350000,250), 
(32,N'Quần jean nữ xanh J2',12,NULL,N'cái',350000,250), 
(33,N'Quần tây nữ kem P1',13,NULL,N'cái',290000,200), 
(34,N'Quần tây nữ đen P2',13,NULL,N'cái',290000,200), 
(35,N'Quần short nữ xanh dương X1',14,NULL,N'cái',150000,250), 
(36,N'Quần short nữ xanh lá X2',14,NULL,N'cái',150000,250), 
(37,N'Váy trắng K1',15,NULL,N'cái',180000,200), 
(38,N'Váy đen K2',15,NULL,N'cái',180000,200)

insert into KhachHang values
('1',N'Nguyễn Đỗ Quốc Tuấn','VIP',N'Trịnh Hoài Đức, Quận Bình Thạnh',01646243184,'ndqtuan95@gmail.com',100), 
('2',N'Ngô Thị Tường Vy','TV',N'Nguyễn Văn Nghi, Quận Gò Vấp',0911709396,'ngothituongvysj2010@gmail.com',75)

insert into TaiKhoan values
('1','Panda','ndqtuan95'), 
('2','VyBap','nttvy96')

insert into HoaDon values
(1,'09/25/2016 08:00:00.000','09/30/2016 08:00:00.000',N'Trịnh Hoài Đức, Quận Bình Thạnh','1'), 
(2,'09/25/2016 09:00:00.000','09/30/2016 09:00:00.000',N'Nguyễn Văn Nghi, Quận Gò Vấp','2')

insert into ChiTietHoaDon values
(1,6,5,180000), 
(2,28,1,320000)