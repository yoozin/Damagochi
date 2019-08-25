import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TimeStamp extends Thread {
	int j = 0;

	@Override
	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("실험할 다마고치의 이름을 입력해주세요.");
		String name = input.nextLine();

		for (int i = 1; i < 61; i++) {

//			System.out.println(i );

			if (i == 10) {
				i = 0;
				j++;

				System.out.println();

				Connection conn = null;
				Statement stmt = null;
				Statement Dstmt = null;

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					String id = "root";
					String pwd = "01035414344";
					String url = "jdbc:mysql://localhost:3306/book_db?"
							+ "characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
					conn = DriverManager.getConnection(url, id, pwd);
					stmt = conn.createStatement();

//						 stmt.executeUpdate(sql);
//						int rs = stmt.executeUpdate(sql);

					String sql = "update Damagochi set Experience = Experience+5 , Intimacy = Intimacy-5, Hunger = Hunger+5, Fatigue = Fatigue+5 where Name = '"
							+ name + "';";

					int rsCnt = stmt.executeUpdate(sql);
//					System.out.println("수정건수 : "+rsCnt);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
//				System.out.println(j+"분입니다.");
//				if(j == 3) {
//					break;

			}
			try {
				// 1초동안 재움
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

//	}
	}

	public static void main(String[] args) {

		Thread clock = new TimeStamp();
		clock.start();

	}

}
