/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package giuaki_buinhuquynh;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quynh
 */
public class TaoPhieuMuon_Frm extends JFrame implements ActionListener{
    public JButton addPhieu;
    public JButton editPhieu;
    public JButton deletePhieu;
    public JButton clearPhieu;
    public JButton sortPhieubyName;
    public JButton xuatexcelCustomer;
    public JButton sortPhieubyDate;
    public JScrollPane jScrollPaneCostumerTable;
    public JTable table;
    public String[][] data;
    public DefaultTableModel tableModel;
    public JLabel mapmLabel;
    public JLabel mabdLabel;
    public JLabel masachLabel;
    public JLabel ngaymuonLabel;
    public JLabel soluongLabel;
  

    public JTextField mapmField;
    public JTextField mabdField;
    public JTextField masachField;
    public JComboBox soluongCb;
    public JTextField ngaymuonField;
   
    public int row;
    public Object o;
   

    
    //private ActionEvent e;

    public TaoPhieuMuon_Frm() {
        initComponents();
        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
        hienthi_tbl(tpd);
        
    }

   

    public void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addPhieu= new JButton("Add");
        editPhieu = new JButton("Edit");
        deletePhieu = new JButton("Delete");
        clearPhieu = new JButton("Clear");
        sortPhieubyDate = new JButton("Sort By Date");
        sortPhieubyName = new JButton("Sort By Name");
        xuatexcelCustomer = new JButton("Xuat Excel");
        //btnexit = new JButton("Đăng Xuất");

        
        jScrollPaneCostumerTable = new JScrollPane(table);
        table = new JTable();
        tableModel  = new DefaultTableModel();
        table.setModel(tableModel);
        jScrollPaneCostumerTable.setViewportView(table);
        jScrollPaneCostumerTable.setPreferredSize(new Dimension(500,300));
//        table.addMouseListener(new MouseListener() {
        table.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e){
                row = table.getSelectedRow();
                o = tableModel.getValueAt(row, 0);
                
                Object datamapm = tableModel.getValueAt(row, 0);
                Object datamabd = tableModel.getValueAt(row, 1);
                Object datamasach = tableModel.getValueAt(row, 2);
                Object datasoluong = tableModel.getValueAt(row, 3);
                Object datangaymuon = tableModel.getValueAt(row, 4);
                
                mapmField.setText(datamapm.toString());
                mabdField.setText(datamabd.toString());
                masachField.setText(datamasach.toString());
                soluongCb.setSelectedItem(datasoluong.toString());
                ngaymuonField.setText(datangaymuon.toString());
                
            }
//            public void mouseClicked(MouseEvent e) {          
//                row = table.getSelectedRow();
//                // lay du lieu tu cot 0
//                o = tableModel.getValueAt(row, 0);
//                Object j = tableModel.getValueAt(row, 3);
//                
//                // hien thi du lieu len JTextFiled
//               Object datamapm =  tableModel.getValueAt(row, 0); // Lấy dữ liệu từ cột 0
//               Object datatmabd = tableModel.getValueAt(row, 1); // Lấy dữ liệu từ cột 1
//               Object datamasach =  tableModel.getValueAt(row, 2); // Lấy dữ liệu từ cột 2
//               Object datasoluong = tableModel.getValueAt(row, 3); // Lấy dữ liệu từ cột 3
//               Object datangaymuon = tableModel.getValueAt(row, 4); // Lấy dữ liệu từ cột 4
//               
//               
////               soluongCb.removeAllItems();
////              TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
////                tpd.loadDataToComboBox(TaoPhieuMuon_Frm.this);
//                // Đặt giá trị mặc định cho JComboBox bằng giá trị từ hàng được chọn
//                
//                
//                
//               
//                mapmField.setText(datamapm.toString());
//                mabdField.setText(datatmabd.toString());
//                masachField.setText(datamasach.toString());
//                soluongCb.setSelectedItem(datasoluong.toString());
//                ngaymuonField.setText(datangaymuon.toString());
//            }
                
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        mapmLabel = new JLabel("Mã Phiếu Mượn");
        mabdLabel = new JLabel("Mã Bạn Đọc");
        masachLabel = new JLabel("Mã Sách");
        ngaymuonLabel = new JLabel("Ngày Mượn");
        soluongLabel = new JLabel("Số Lượng");
        

        mapmField = new JTextField(6);
        mabdField = new JTextField(15);
        masachField = new JTextField(6);
        soluongCb = new JComboBox(new String[]{"1","2","3","4"});
        ngaymuonField = new JTextField(6);
        
        //txtSearch = new JTextField(10);
        //txtSearch.setPreferredSize(new Dimension(100,25));
        
        
//        data = new String[][]{
//                { "1", "Bui Nhu Quynh", "21","Ha Noi","9.0" }
//               
//        };
//        String[] columnNames = { "ID", "Name", "Age","Address","GPA"};        
        //tbl_ds = new JTable(data, columnNames);
       
    
  

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(1200,600);
        panel.setLayout(layout);
        panel.add(jScrollPaneCostumerTable);

        panel.add(addPhieu);
        panel.add(editPhieu);
        panel.add(deletePhieu);
        panel.add(clearPhieu);
        panel.add(sortPhieubyDate);
        panel.add(sortPhieubyName);
        panel.add(xuatexcelCustomer);
    //    panel.add(btnexit);
        

        panel.add(mapmLabel);
        panel.add(mabdLabel);
        panel.add(masachLabel);
        panel.add(soluongLabel);
        panel.add(ngaymuonLabel);
    

        panel.add(mapmField);
        panel.add(mabdField);
        panel.add(masachField);
       
        panel.add(soluongCb);
        panel.add(ngaymuonField);
       
         

        layout.putConstraint(SpringLayout.WEST, mapmLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mapmLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, mabdLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mabdLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, masachLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, masachLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, soluongLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, soluongLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ngaymuonLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ngaymuonLabel, 130, SpringLayout.NORTH, panel);
     
        

        layout.putConstraint(SpringLayout.WEST, mapmField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mapmField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, mabdField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mabdField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, masachField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, masachField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, soluongCb, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, soluongCb, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ngaymuonField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,ngaymuonField, 130, SpringLayout.NORTH, panel);
       

        layout.putConstraint(SpringLayout.WEST, jScrollPaneCostumerTable, 400, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCostumerTable, 20, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addPhieu, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addPhieu, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editPhieu, 60, SpringLayout.WEST, addPhieu);
        layout.putConstraint(SpringLayout.NORTH, editPhieu, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearPhieu, 60, SpringLayout.WEST, editPhieu);
        layout.putConstraint(SpringLayout.NORTH, clearPhieu, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deletePhieu, 70, SpringLayout.WEST, clearPhieu);
        layout.putConstraint(SpringLayout.NORTH, deletePhieu, 200, SpringLayout.NORTH, panel);
        
        
        layout.putConstraint(SpringLayout.WEST, sortPhieubyName, 400, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortPhieubyName, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortPhieubyDate, 150, SpringLayout.WEST, sortPhieubyName);
        layout.putConstraint(SpringLayout.NORTH, sortPhieubyDate, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, xuatexcelCustomer, 160, SpringLayout.WEST, sortPhieubyDate);
        layout.putConstraint(SpringLayout.NORTH, xuatexcelCustomer, 340, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, txtSearch, 120, SpringLayout.WEST, xuatexcelCustomer);
//        layout.putConstraint(SpringLayout.NORTH, txtSearch, 340, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, btnexit, 130, SpringLayout.WEST, txtSearch);
//        layout.putConstraint(SpringLayout.NORTH, btnexit, 340, SpringLayout.NORTH, panel);
        
        
        addPhieu.addActionListener(this);
//        editCustomer.addActionListener(this);
//        clearCustomer.addActionListener(this);
        deletePhieu.addActionListener(this);
//        sortCustomerGPABtn.addActionListener(this);
//        searchCustomer.addActionListener(this);
//        xuatexcelCustomer.addActionListener(this);
  
        
        add(panel);
        setTitle("Customer Information");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        
        
        
      
        
        
    }
    public void hienthi_tbl(TaoPhieuMuon_DAO tpd) {
        tpd.rsTableModel(table, tableModel);
    }

    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        JButton btn = (JButton) e.getSource();
        if (btn.equals(addPhieu)) {
            addPhieu_actionperformed();
            // Xóa hết dữ liệu từ model của JTable
          tableModel.setRowCount(0);
          tableModel.setColumnCount(0);
            TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
            hienthi_tbl(tpd);
        } 
         if(btn.equals(clearPhieu)){
             clearCustomer_actionperformed();
         }
        if(btn.equals(deletePhieu)){
            deleteCustomer_actionperformed();
        }
       
        if(btn.equals(sortPhieubyName)){
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);
   
    }}
     private void addPhieu_actionperformed() {
        //throw new UnsupportedOperationException("Not yet implemented");
        TaoPhieuMuon tp = new TaoPhieuMuon();
        tp.setTxtID(mapmField.getText());
        tp.setTxtmaBD(mabdField.getText());
        tp.setTxtmaSach(masachField.getText());
        tp.setTxtsoLuong(Integer.parseInt(soluongCb.getSelectedItem().toString()));
        
        tp.setTxtngayMuon(ngaymuonField.getText());
       

        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
        tpd.add_customer(tp);
                
    // JOptionPane.showMessageDialog(null, "Add successful!");
    //std.rsTableModel(tbl_ds, model);
    }
//
//    private void addCustomer_actionperformed(TaoPhieuMuon_Frm taoPhieuMuon_Frm) {
//        //throw new UnsupportedOperationException("Not yet implemented");
//        TaoPhieuMuon tp = new TaoPhieuMuon();
//        tp.setTxtID(mapmField.getText());
//        tp.setTxtmaBD(mabdField.getText());
//        tp.setTxtmaSach(masachField.getText());
////        tp.setTxtsoLuong(Integer.parseInt(soluongCb.getSelectedItem().toString()));
//        tp.setTxtngayMuon(ngaymuonField.getText());
//       
//
//        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
//        tpd.add_customer(tp);
//    }

   

    private void clearCustomer_actionperformed() {
        //throw new UnsupportedOperationException("Not yet implemented");
       mabdField.setText(" ");
       mabdField.setText(" ");
       masachField.setText(" ");
       soluongCb.setSelectedItem(null);
       ngaymuonField.setText(" ");
      
       
    }

    public void deleteCustomer_actionperformed(){
        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
         tpd.delete_customer(o);
         tableModel.removeRow(row);
         tableModel.fireTableDataChanged();
         
       mabdField.setText(" ");
       mabdField.setText(" ");
       masachField.setText(" ");
       soluongCb.setSelectedItem(null);
       ngaymuonField.setText(" ");
    }
    
//    public void  editCustomer_actionperformed(){
//        TaoPhieuMuon tp = new TaoPhieuMuon();
//        tp.setTxtID(mapmField.getText());
//        tp.setTxtmaBD(mabdField.getText());
//        tp.setTxtmaSach(masachField.getText());
//        tp.setTxtsoLuong(Integer.parseInt(soluongCb.getSelectedItem().toString()));
//        tp.setTxtngayMuon(ngaymuonField.getText());
//
//        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
//        tpd.edit_customer(tp, o);
//        
//                tableModel.setValueAt(mapmField.getText(),row, 0); // Lấy dữ liệu từ cột 0
//                tableModel.setValueAt(mabdField.getText(),row, 1); // Lấy dữ liệu từ cột 1
//                tableModel.setValueAt(masachField.getText(),row, 2); // Lấy dữ liệu từ cột 2
//                tableModel.setValueAt(soluongCb.getSelectedItem().toString(),row, 3); // Lấy dữ liệu từ cột 3
//                tableModel.setValueAt(ngaymuonField.getText(),row, 4); // Lấy dữ liệu từ cột 4
//                
//    }
//    
    
//    public void sortCustomerGPABtn_actionperformed(){
//        TaoPhieuMuon_DAO tpd = new TaoPhieuMuon_DAO();
//        tpd.sort(table, tableModel);
//    }
    
  
    
//    public void xuatexcelCustomer_actionperformed(){
//          Customer_DAO csd = new Customer_DAO();
//          csd.xuatexcel(table, tableModel, this);
//    }   
        
   

//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
        public static void main(String [] args){
            TaoPhieuMuon_Frm tpf = new TaoPhieuMuon_Frm();
        }

   
}
