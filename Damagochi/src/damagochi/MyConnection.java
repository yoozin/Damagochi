package damagochi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

   
      public static Connection getMakeConnection() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         String user = "root";
         String password = "01035414344";
         String url = "jdbc:mysql://localhost:3306/damagochi_db?"
               + "characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
         
         Connection conn = DriverManager.getConnection(url, user, password);
         return conn;
         
      }

   }
