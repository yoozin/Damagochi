package damagochi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DamagochiDBO { // DamagochiDBO class start

	   Connection conn; // 커넥션 변수선언

	   public DamagochiDBO() {
	      try {
	         conn = MyConnection.getMakeConnection(); // 커넥션 객체생성
	      } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	      }
	   }

	////////////////////////////////////////////////////insert/////////////////////////////////////////////////////////////
	   public int insertDamagochi(Damagochi da) {
	      int cnt = 0; // 카운트
	      // 객체정보를 넣는 쿼리문
	      String sql = "insert into Damagochi(Name, Level, Experience, Intimacy, Hunger, Fatigue, DDay) values(?,?,?,?,?,?,?)";

	      try (PreparedStatement pst = conn.prepareStatement(sql);) {
	         pst.setString(1, da.getName()); // 객체에 이름을 value 1번 ?에 적음
	         pst.setInt(2, da.getLevel()); // 객체에 레벨을 value 2번 ?에 적음
	         pst.setInt(3, da.getExperience()); // 객체에 경험치을 value 3번 ?에 적음
	         pst.setInt(4, da.getIntimacy()); // 객체에 친밀도를 value 4번 ?에 적음
	         pst.setInt(5, da.getHunger()); // 객체에 배고픔을 value 5번 ?에 적음
	         pst.setInt(6, da.getFatigue()); // 객체에 피로도를 value 6번 ?에 적음
	         pst.setInt(7, da.getdDay()); // 객체에 날짜를 value 7번 ?에 적음
	         cnt = pst.executeUpdate(); // 적용
	      } catch (SQLException e) {
	         System.out.println("すでに同じ名前があります。"); // 겹치는 것 잇으면 이미 생성된 이름있다고 출력
	      }
	      return cnt; // 적용되면 1반환
	   }

	///////////////////////////////////////////////////selectAll/////////////////////////////////////////////////////////////      
	   // 객체 전체출력
	   public void selectAll() { // selectAll start

	      Damagochi da = null;
	      String sql = "select * from damagochi";

	      try (PreparedStatement pst = conn.prepareStatement(sql)) {

	         ResultSet rs = pst.executeQuery();
	         ArrayList<Damagochi> slist = new ArrayList<Damagochi>();

	         while (rs.next()) {
	            // db에 있는 객체를 각 변수에 담음
	            String name = rs.getString("Name");
	            int level = rs.getInt("Level");
	            int experience = rs.getInt("Experience");
	            int hunger = rs.getInt("Hunger");
	            int intimacy = rs.getInt("Intimacy");
	            int fatigue = rs.getInt("Fatigue");
	            int dDay = rs.getInt("dDay");
	            // 다마고치 객체에 담고
	            da = new Damagochi(name, level, experience, intimacy, hunger, fatigue, dDay);
	            // 리스트에 담는다
	            slist.add(da);
	         }
	         System.out.println("----------------------Saved Data----------------------");
	         for (Damagochi d : slist) {
	            System.out.println(d);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }// selectAll end

	////////////////////////////////////////////////////delete/////////////////////////////////////////////////////////////
	   public void deleteDamagochi(String name) {

	      while (true) {
	         // 삭제 쿼리
	         String deleteSql = "delete from Damagochi where Name = ?";
	         int cnt = 0;

	         try (Connection conn = MyConnection.getMakeConnection();
	               PreparedStatement pst = conn.prepareStatement(deleteSql)) {

	            pst.setString(1, name);

	            cnt = pst.executeUpdate();

	            System.out.println(name + "が削除されました。");
	            try {
	               Thread.sleep(3000);
	            } catch (InterruptedException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	            break;

	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            continue;
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }

	      }

	   }

	////////////////////////////////////////////////////select/////////////////////////////////////////////////////////////

	   public Damagochi selectOneDamagochi(String name) {
	      Damagochi da = null;
	      String sql = "select * from Damagochi where Name = ?";

	      try (PreparedStatement pst = conn.prepareStatement(sql)) {
	         pst.setString(1, name);
	         ResultSet rs = pst.executeQuery();

	         while (rs.next()) {

	            String dname = rs.getString("Name");
	            int dlevel = rs.getInt("Level");
	            int dexperience = rs.getInt("Experience");
	            int dintimacy = rs.getInt("Intimacy");
	            int dhunger = rs.getInt("Hunger");
	            int dfatigue = rs.getInt("Fatigue");
	            int ddDay = rs.getInt("DDay");
	            da = new Damagochi(dname, dlevel, dexperience, dintimacy, dhunger, dfatigue, ddDay);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return da;
	   }

	////////////////////////////////////////////////////saveDamagochi/////////////////////////////////////////////////////////////
	   public void saveDamagochi(Damagochi da) { // saveDamagochi start
	      Scanner sc = new Scanner(System.in);
	      String sql = "update Damagochi set Name =? , Level = ?, Experience = ? , Intimacy = ?, "
	            + "Hunger = ?, Fatigue = ?, Dday =? where Name = ?";

	      try (PreparedStatement pst = conn.prepareStatement(sql)) {

	         while (true) { //while start
	            System.out.println("Saveしますか？ Y/N");
	            String saveSelect = sc.next();

	            //////////////////////////////////////////////////////// 저장할때
	            if (saveSelect.equalsIgnoreCase("y")) {

	               pst.setString(1, da.getName());
	               pst.setInt(2, da.getLevel());
	               pst.setInt(3, da.getExperience());
	               pst.setInt(4, da.getIntimacy());
	               pst.setInt(5, da.getHunger());
	               pst.setInt(6, da.getFatigue());
	               pst.setInt(7, da.getdDay());
	               pst.setString(8, da.getName());
	               pst.executeUpdate();

	               System.out.println("Saveできました〜");
	               try {
	                  Thread.sleep(3000); //3초대기
	               } catch (InterruptedException e) {
	                  e.printStackTrace();
	               }
	               break;
	            }

	            //////////////////////////////////////////////////////////////// 저장안할때

	            else if (saveSelect.equalsIgnoreCase("n")) {

	               System.out.println("前の画面に戻ります。");

	               try {
	                  Thread.sleep(3000);
	               } catch (InterruptedException e) {
	                  e.printStackTrace();
	               }
	               break;
	            }
	            ////////////////////////////////////////////////////////////////// 잘못입력했을때
	            else {
	               System.out.println("入力が間違っています。もう一度入力してください。");
	               continue;
	            }
	         } //while end
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   } // saveDamagochi end
	} // DamagochiDBO class end