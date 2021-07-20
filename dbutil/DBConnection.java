package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn;
    static{
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-V0BN5VQ:1521/xe","onlineexam","student");
            JOptionPane.showMessageDialog(null, "Connect successfully to Database", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "DB Connection error", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        }
        public static Connection getConnection(){
            return conn;
        }
        public static void closeConnection(){
            try{
                conn.close();
                JOptionPane.showMessageDialog(null,"Disconnected from DB");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Cannot disconnected from DB");
                ex.printStackTrace();
            }
        }
}
