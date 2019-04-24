
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author windows 7
 */
public class DBConnection {
    public Connection koneksi;

    public Connection connect(){
       //untuk koneksi ke driver
       try{
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("berhasil load driver");
       }catch(ClassNotFoundException cnfe){
           System.out.println("Tidak ada Driver "+cnfe);
       }

       //untuk koneksi ke database
       try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_pkl", "root", "");
            System.out.println("Koneksi Database Berhasil");
        } catch (SQLException se) {
            System.out.println("Koneksi Database Gagal :" + se);
        } catch (Exception e) {
        }
       return koneksi;
    }
}
