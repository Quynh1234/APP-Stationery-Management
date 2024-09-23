/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package giuaki_buinhuquynh;

import baitaplon_buinhuquynh.XSSFSheet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author quynh
 */
public class TaoPhieuMuon_DAO {
       private Connection con;
     
      public TaoPhieuMuon_DAO(){
          String dbUrl = "jdbc:mysql://localhost:3306/tblphieumuon";
          String dbClass = "com.mysql.jdbc.Driver";
          try{
              Class.forName(dbClass);
                con =  DriverManager.getConnection(dbUrl, "root", "");
              //  con = DriverManager.getConnection(dbUrl,"root","");
                System.out.print("Hello");
          }catch(Exception e){
              e.printStackTrace();
          }
          
      }
      public void rsTableModel (JTable table, DefaultTableModel tableModel){
         // arr = new ArrayList<Student>();
          try{
              Statement statement =   con.createStatement();
              ResultSet resultSet = statement.executeQuery("SELECT * FROM tblphieumuon");
              ResultSetMetaData metaData = resultSet.getMetaData();
              
              int columnCount =metaData.getColumnCount();
              for (int columnIndex = 1; columnIndex<= columnCount ; columnIndex ++){
                  tableModel.addColumn(metaData.getColumnLabel(columnIndex));
              }
              while(resultSet.next()){
                  Object[] row = new Object[columnCount];
                  for(int i=0; i<columnCount; i++){
                      row[i] = resultSet.getObject(i+1);
                  }
                  //resultSet.getString("")
                  //arr.add()
                  tableModel.addRow(row);
                  
              }
          }catch(Exception e){
              e.printStackTrace();
          }
      }
       public void loadDataToComboBox(TaoPhieuMuon_Frm tpf) {
          try {
            // Tạo statement và thực hiện truy vấn để lấy dữ liệu từ CSDL
                Statement statement = con.createStatement(); 
                ResultSet resultSet = statement.executeQuery("SELECT maNV FROM vppemployee ");
                // Xóa toàn bộ mục trong JComboBox trước khi thêm mới
                tpf.soluongCb.removeAllItems();
              
                
                // Thêm dữ liệu từ kết quả truy vấn vào JComboBox
                while (resultSet.next()) {
                    String item = resultSet.getString("maNV");
                    tpf.soluongCb.addItem(item);
                    
                }
                // Đóng các tài nguyên
                resultSet.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      
       public void add_customer(TaoPhieuMuon tp){
          // System.out.println(" mnv "+ac.getTxtmaNV());
          String sql = "INSERT INTO tblphieumuon(maPhieuMuon, maBanDoc, maSach, soLuong, ngayMuon) value(?,?,?,?,?)";
          try{
              PreparedStatement ps =  con.prepareStatement(sql);
              ps.setString(1, tp.getTxtID());
              ps.setString(2, tp.getTxtmaBD());
              ps.setString(3, tp.getTxtmaSach());
              ps.setInt(4, tp.getTxtsoLuong());
              ps.setString(5, tp.getTxtngayMuon());
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại!");
              e.printStackTrace();
          }
      }
      
       public void delete_customer(Object j){
        String sql = "DELETE FROM tblphieumuon WHERE maPhieuMuon = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, j.toString());
            int row = ps.executeUpdate();
            if(row>0 )JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa tài khoản thất bại!");
            e.printStackTrace();
        }
    
      } 
        public void edit_account(TaoPhieuMuon tp, Object obj){
            String sql = "UPDATE tblphieumuon SET maPhieuMuon = ?, maBanDoc = ? ,maSach =? , soLuong =?, ngayMuon =? WHERE maPhieuMuon= ?";
          try{
              PreparedStatement ps =  con.prepareStatement(sql);
              ps.setString(1, tp.getTxtID());
              ps.setString(2, tp.getTxtmaBD());
              ps.setString(3, tp.getTxtmaSach());
              ps.setInt(4, tp.getTxtsoLuong());
              ps.setString(5, tp.getTxtngayMuon());
              ps.setString(6, obj.toString());
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null, "Sửa tài khoản thành công!");
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Sửa tài khoản thất bại!");
              e.printStackTrace();
          }
      }
         public void sortaccount (JTable table, DefaultTableModel tableModel){
          try{
              Statement sta = con.createStatement();
              ResultSet res = sta.executeQuery("SELECT * FROM tblphieumuon ORDER BY maPhieuMuon DESC");
              ResultSetMetaData resm = res.getMetaData();
              
              int columnCount = resm.getColumnCount();
              for(int columnIndex = 1; columnIndex<= columnCount; columnIndex++){
                  tableModel.addColumn(resm.getColumnLabel(columnIndex));
              }
              //them du lieu tu ket qua truy van vao model
              while(res.next()){
                  Object[] row = new Object[columnCount];
                  for(int i =0; i<columnCount; i++){
                      row[i] = res.getObject(i+1);
                  }
                  tableModel.addRow(row);
              }
              JOptionPane.showMessageDialog(null, "Tài khoản đã được sắp xếp thành công");
          }catch(Exception e){
              e.printStackTrace();
          }
      }
         

        public void xuatexcel6(JTable table,DefaultTableModel tableModel, TaoPhieuMuon_Frm tpf ){
        XSSFWorkbook workbook = new XSSFWorkbook();
        org.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.createSheet("Lop Data");

        // Tạo hàng header
        XSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            XSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(tableModel.getColumnName(i));
        }

        // Dữ liệu
        FileOutputStream fileOut = null;
        try {
            // Hiển thị hộp thoại lưu tệp
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Excel File");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
            fileChooser.setFileFilter(filter);
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx"; // Đảm bảo rằng tên file có phần mở rộng .xlsx
                }
                fileOut = new FileOutputStream(filePath);

                // Viết dữ liệu vào file Excel
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i + 1);
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        XSSFCell cell = row.createCell(j);
                        Object value = tableModel.getValueAt(i, j);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                    }
                }

                // Lưu file Excel
                workbook.write(fileOut);
                System.out.println("Excel file exported successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
          }
        public static void main(String[] args){
            TaoPhieuMuon_DAO tpd =  new TaoPhieuMuon_DAO();
        }
       
}
