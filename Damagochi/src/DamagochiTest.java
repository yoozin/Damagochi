import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DamagochiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int putNum;
		String putName;

		System.out.println("1.불러오기");
		System.out.println("2.새로만들기");

		putNum = sc.nextInt();

		//////////////////////////////////////////////////

		Connection conn = null;
		Statement stmt = null;
		Statement Dstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String id = "root";
			String pwd = "01035414344";
			String url = "jdbc:mysql://localhost:3306/book_db?" + "characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.createStatement();

//				 stmt.executeUpdate(sql);
//				int rs = stmt.executeUpdate(sql);

			if (putNum == 1) {
				System.out.println("이름을 입력하세요 : ");
				putName = sc.next();

			}

			if (putNum == 2) {
				System.out.println("새로 만들 이름을 입력하세요 : ");
				putName = sc.next();

				String sql = "insert into Damagochi (Name, Level, Experience, Intimacy, Hunger, Fatigue)values ('"
						+ putName + "'," + 1 + "," + 0 + "," + 65 + "," + 65 + "," + 65 + ");";

				stmt.executeUpdate(sql);

//				System.out.println("rs" + Drs);

				String Dsql = "select * from Damagochi where Name = '"+putName+"';";
//				rs = stmt.executeQuery(sql);
				ResultSet rs = stmt.executeQuery(Dsql);
				while (rs.next()) {
					System.out.print(rs.getString(1) + " | "); // 첫번째 컬럼
					System.out.print(rs.getInt(2) + " | "); // 두번째 컬럼
					System.out.print(rs.getInt(3) + " | "); // 세번째 컬럼
					System.out.print(rs.getInt(4) + " | "); // 네번째 컬럼
					System.out.print(rs.getInt(5) + " | "); // 네번째 컬럼
					System.out.println(rs.getInt(6) + " | "); // 네번째 컬럼

				}

			}

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

	}

}
