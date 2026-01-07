/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package js;

/**
 *
 * @author java4
 */
import java.io.*;
import java.sql.*;
 
public class DatabaseImageExample {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/interaction","root","root");
            
            File file=new File("D:\\image1.png");
            FileOutputStream fos=new FileOutputStream(file);
            byte b[];
            Blob blob;
            
            PreparedStatement ps=con.prepareStatement("select * from tweet where tid='1'"); 
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                blob=rs.getBlob("photo");
                b=blob.getBytes(1,(int)blob.length());
                fos.write(b);
            }
            
            ps.close();
            fos.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
