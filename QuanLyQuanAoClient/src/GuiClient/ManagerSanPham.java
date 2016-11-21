package GuiClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerSanPham extends JFrame{
	PreparedStatement preStatement,updatePreStmt;
	JLabel title, idkhachHang, idNhom, idsanPham, tenkhachHang, kichCo, soLuong, soDienThoai, diaChi;
	JTextField idkhachHangField, idNhomField, idsanPhamField, tenkhachHangField, kichCoField, soLuongField, soDienThoaiField, diaChiField;
	JButton registerButton, exitButton,updateButton,deleteButton,resetButton,
	refresh;
	JRadioButton male, female;
	ButtonGroup bg;
	JPanel panel;
	JTable table;

	DefaultTableModel model;

	JScrollPane scrollpane;
	public ManagerSanPham() {
		super("QUẢN LÝ BÁN QUẦN ÁO");
		setSize(1300, 650);
		setLayout(null);
		// Calling connect method, this will connect us to database
		// Defining Labels 
		title = new JLabel("Q U Ả N     L Ý     B Á N     Q U Ầ N     Á O");
		title.setBounds(380, 7, 300, 30);
		idkhachHang = new JLabel("Mã Khách Hàng");
		idkhachHang.setBounds(30, 50, 100, 20);
		idNhom = new JLabel("Mã Nhóm"); 
		idNhom.setBounds(30, 85, 100, 20);
		idsanPham = new JLabel("Mã Sản Phẩm"); 
		idsanPham.setBounds(30, 120, 100, 20);
		tenkhachHang = new JLabel("Tên Khách Hàng"); 
		tenkhachHang.setBounds(30, 155, 100, 20); 
		kichCo = new JLabel("Kích Cỡ"); 
		kichCo.setBounds(30, 190, 100, 20);
		soLuong = new JLabel("Số Lượng"); 
		soLuong.setBounds(30, 225, 100, 20);
		soDienThoai = new JLabel("Số Điện Thoại"); 
		soDienThoai.setBounds(30, 260, 100, 20);
		diaChi = new JLabel("Địa Chỉ"); 
		diaChi.setBounds(30, 295, 100, 20);

		// Defining field
		idkhachHangField = new JTextField(); 
		idkhachHangField.setBounds(150, 50, 160, 20);
		
		idNhomField = new JTextField(); 
		idNhomField.setBounds(150, 85, 160, 20);

		idsanPhamField = new JTextField(); 
		idsanPhamField.setBounds(150, 120, 160, 20);

		tenkhachHangField = new JTextField(); 
		tenkhachHangField.setBounds(150, 155, 160, 20);

		kichCoField = new JTextField(); 
		kichCoField.setBounds(150, 190, 160, 20);

		soLuongField = new JTextField(); 
		soLuongField.setBounds(150, 225, 160, 20);

		soDienThoaiField = new JTextField(); 
		soDienThoaiField.setBounds(150, 260, 160, 20);

		diaChiField = new JTextField(); 
		diaChiField.setBounds(150, 295, 400, 20);



		add(title);
		add(idkhachHang);
		add(idNhom);
		add(idsanPham);
		add(tenkhachHang);
		add(kichCo);
		add(soLuong);
		add(soDienThoai);
		add(diaChi);
		add(idkhachHangField);
		add(idNhomField);
		add(idsanPhamField);
		add(tenkhachHangField);
		add(kichCoField);
		add(soLuongField);
		add(soDienThoaiField);
		add(diaChiField);

		// Defining Exit Button
		exitButton = new JButton("Thoát"); 
		exitButton.setBounds(550, 330, 100, 25); 

		// Defining Register Button
		registerButton = new JButton("Thêm");
		registerButton.setBounds(30, 330, 100, 25);
		
		// Defining Delete Button
		deleteButton = new JButton("Xoá");
		deleteButton.setBounds(160, 330, 100, 25);
		deleteButton.setEnabled(false);

		// Defining Update Button
		updateButton = new JButton("Cập Nhật");
		updateButton.setBounds(290, 330, 100, 25);
		updateButton.setEnabled(false);

		// Defining Reset Button
		resetButton = new JButton("Reset");
		resetButton.setBounds(420, 330, 100, 25);
		resetButton.setEnabled(false);

		// fixing all Buttons
		add(exitButton);
		add(registerButton);
		add(updateButton);
		add(deleteButton);
		add(resetButton); 

		// Defining Panel
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.setBounds(330, 50, 940, 230);
		panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
		add(panel);

		//Defining Model for table
		model = new DefaultTableModel();

		//Adding object of DefaultTableModel into JTable
		table = new JTable(model);

		//Fixing Columns move
		table.getTableHeader().setReorderingAllowed(false);

		// Defining Column Names on model
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Mã Nhóm");
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Kích Cỡ");
		model.addColumn("Số Lượng");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");

		// Enable Scrolling on table
		scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollpane);

		//Displaying Frame in Center of the Screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2,
				dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}