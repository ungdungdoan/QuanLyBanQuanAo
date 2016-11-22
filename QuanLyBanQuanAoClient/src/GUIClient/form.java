package GUIClient;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.axis2.AxisFault;

import quanaoservice.QuanLySQLExceptionException;
import quanaoservice.QuanLyStub;
import quanaoservice.QuanLyStub.AddSanPham;
import quanaoservice.QuanLyStub.DeleteQuanAo;
import quanaoservice.QuanLyStub.UpdateQuanAo;
@SuppressWarnings("serial")
public class form extends ManagerSanPham {
	String gender = "";
	ResultSet rst,rstLast;
	Object[][] data;
	int serialNo; 
	String SHOW = "Show";

	// Defining Constructor
	form(){
		idkhachHangField.enable(true);
		tenkhachHangField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(tenkhachHangField.getText().length()>50)
					e.consume();
			}
		});

		idNhomField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(idNhomField.getText().length()>90)
					e.consume();
			}
		});

		idsanPhamField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(idsanPhamField.getText().length()>90)
					e.consume();
			}
		});

		tenkhachHangField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(tenkhachHangField.getText().length()>90)
					e.consume();
			}
		});

		kichCoField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(kichCoField.getText().length()>90)
					e.consume();
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

					System.exit(0);
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});

		registerButton.addActionListener(new AbstractAction(SHOW) {
			public void actionPerformed(ActionEvent ae) {
				try{
					if (ae.getSource() == registerButton) {

						if (idkhachHangField.getText().equals(""))
							JOptionPane.showMessageDialog(idkhachHangField, 
									"Dien Ma khach hang");

						else if (idNhomField.getText().equals(""))
							JOptionPane.showMessageDialog(idNhomField, 
									"Dien Ma nhom");
						else if(idsanPhamField.getText().equals(""))
							JOptionPane.showMessageDialog(idsanPhamField, 
									"Dien Ma san pham");


						else if(tenkhachHangField.getText().equals(""))
							JOptionPane.showMessageDialog(tenkhachHangField,
									"Dien Ten khach hang");

						else if(kichCoField.getText().equals(""))
							JOptionPane.showMessageDialog(kichCoField,
									"Dien Kich Co");

						else if(soLuongField.getText().equals(""))
							JOptionPane.showMessageDialog(soLuongField,
									"Dien So Luong");

						else if(soDienThoaiField.getText().equals(""))
							JOptionPane.showMessageDialog(soDienThoaiField,
									"Dien So Dien Thoai");

						else {
							QuanLyStub mn = new QuanLyStub();
							AddSanPham a = new AddSanPham();
							a.setMakh(Integer.parseInt(idkhachHangField.getText()));
							a.setManhom(Integer.parseInt(idNhomField.getText()));
							a.setMasp(Integer.parseInt(idsanPhamField.getText()));
							a.setTenkh(tenkhachHangField.getText());
							a.setKichco(kichCoField.getText());
							a.setSoluong(Integer.parseInt(soLuongField.getText()));
							a.setSdt(soDienThoaiField.getText());
							a.setDiachi(diaChiField.getText());
							mn.addSanPham(a);
							refreshTable();
							int i=1;                            
							if(i==1) {
								JOptionPane.showMessageDialog(panel, 
										"Them Thanh Cong");
							}

							// fields are blank
							refreshTable();
							blankFields();
						}
					}
				}catch(Exception ex) {
					refreshTable();
					System.out.println(ex.getMessage()); 
				}
			}
		});

		updateButton.addActionListener(new AbstractAction(SHOW) {
			public void actionPerformed(ActionEvent e) {
				idkhachHangField.enable(false);

				int r = table.getSelectedRow();

				if(r>=0) {
					try {
						QuanLyStub	mn = new QuanLyStub();
						UpdateQuanAo u = new UpdateQuanAo();
						u.setMakh(Integer.parseInt(idkhachHangField.getText()));
						u.setManhom(Integer.parseInt(idNhomField.getText()));
						u.setMasp(Integer.parseInt(idsanPhamField.getText()));
						u.setTenkh(tenkhachHangField.getText());
						u.setKichco(kichCoField.getText());
						u.setSoluong(Integer.parseInt(soLuongField.getText()));
						u.setSdt(soDienThoaiField.getText());
						u.setDiachi(diaChiField.getText());

						try {
							mn.updateQuanAo(u);
							refreshTable();
						} catch (QuanLySQLExceptionException e1) {
							refreshTable();
							e1.printStackTrace();
						}
						refreshTable();
					} catch (AxisFault e1) {
						refreshTable();
						e1.printStackTrace();
					} catch (RemoteException e1) {
						refreshTable();
						System.out.println(e1);
						e1.printStackTrace();
					}
					int i=1;
				}
			}
		});

		//Registering Anonymous Listener Class
		deleteButton.addActionListener(new AbstractAction(SHOW) { 
			public void actionPerformed(ActionEvent e) {
				idkhachHangField.enable(false);
				try { 
					
					//Getting Selected Row No
					int r = table.getSelectedRow(); 
					if(r>=0) { 
						if (JOptionPane.showConfirmDialog(panel,
								"Bạn Có Muốn Xóa Không?","WARNING",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							String id = (String) table.getModel().getValueAt(r,0);

							// Executing MySQL Update Command
							//int i = stmt.executeUpdate("delete from regForm where id="+id);
							if(true) {
								int idX = (Integer.parseInt(id));
								QuanLyStub stub = new QuanLyStub();
								System.out.println(id);
								DeleteQuanAo d = new DeleteQuanAo();
								d.setMakh(idX);
								stub.deleteQuanAo(d);
								refreshTable();
								// fields are blank
								blankFields();
								refreshTable();   
								registerButton.setEnabled(true);
								deleteButton.setEnabled(false);
								updateButton.setEnabled(false);
								refreshTable();  
							}
						}
					}
				} catch(Exception ex) {
					refreshTable();
					System.out.println(ex.getMessage());
				}
			}
		});

		//Registering Anonymous Listener Class
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// calling method resetFields()
				resetFields();
				registerButton.setEnabled(true);
				updateButton.setEnabled(false);
				deleteButton.setEnabled(false);
				resetButton.setEnabled(false);
				refreshTable();
			}
		});

		// Registering Anonymous Listener Class
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//calling  refresh() method
				refreshTable();
			}
		});

		//Registering Anonymous Listener Class
		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				
				//Getting Selected Row No
				idkhachHangField.enable(false);
				int r = table.getSelectedRow();
				if(r>=0) { 
					deleteButton.setEnabled(true);
					updateButton.setEnabled(true);
					resetButton.setEnabled(true);
					registerButton.setEnabled(false); 

					//Fetching records from Table on Fields
					idkhachHangField.setText(""+table.getModel().getValueAt(r,0));
					idNhomField.setText(""+table.getModel().getValueAt(r,1));
					idsanPhamField.setText(""+table.getModel().getValueAt(r,2));                
					tenkhachHangField.setText(""+table.getModel().getValueAt(r,3));
					kichCoField.setText(""+table.getModel().getValueAt(r,4));
					soLuongField.setText(""+table.getModel().getValueAt(r,5));
					soDienThoaiField.setText(""+table.getModel().getValueAt(r,6));
					diaChiField.setText(""+table.getModel().getValueAt(r,7));
				}
			}

			//                @Override
			public void mouseReleased(MouseEvent arg0) {}
			//                @Override
			public void mousePressed(MouseEvent arg0) {}
			//                @Override 
			public void mouseExited(MouseEvent arg0) {}
			//                @Override 
			public void mouseEntered(MouseEvent arg0) {}
		});

		// Displaying rows into the Frame table
		addRows();
	}

	// addRows method
	public void addRows() {
		try{
			SanPhamManager tm = new SanPhamManager();
			List<SanPham> listSanPham = tm.getAllSanPham();

			Object[] row = null;

			for (int i = 0; i < listSanPham.size(); i++) {
				String string = listSanPham.get(i).getMaKhachHang()+","+listSanPham.get(i).getMaNhom()+","+listSanPham.get(i).getMaSanPham()+","+listSanPham.get(i).getTenKhachHang()+","+listSanPham.get(i).getKichCo()+","+listSanPham.get(i).getSoLuong()+","+listSanPham.get(i).getSoDienThoai()+","+listSanPham.get(i).getDiaChi()+",";
				row = string.split(",");

				// Adding records in table model 
				model.addRow(row);
			}
			panel.revalidate();
		} catch(Exception ex) { 
			System.out.println(ex.getMessage());}
	}

	private void resetFields() { 
		idkhachHangField.enable(true);

		//calling method blank fields() 
		blankFields();
	}

	// refresh method
	public void refreshTable() {

		// removing all the rows of the table
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		dm.getDataVector().removeAllElements();
		System.out.println("Refresh Table");

		//calling method addRows
		addRows();

	}

	private void blankFields() {
		// fields will be blank
		idkhachHangField.setText("");
		idNhomField.setText("");
		idsanPhamField.setText("");
		tenkhachHangField.setText("");
		kichCoField.setText("");
		soLuongField.setText("");
		soDienThoaiField.setText("");
		diaChiField.setText("");
		refreshTable();
	}

	// main() method
	public static void main(String[] args) {
		new form();
	}
}
