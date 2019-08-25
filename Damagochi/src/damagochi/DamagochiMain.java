package damagochi;
import java.sql.SQLException;
import java.util.Scanner;

public class DamagochiMain { //DamagochiMain class start
	   public void DamagochiMain() {   //메인클래스 생성자

	      Scanner sc = new Scanner(System.in);   //스캐너 객체생성
	      DamagochiDBO damo = new DamagochiDBO();   //SQL 쿼리 클래스 객체 생성
	      DamagochiFunction damaFuntion = new DamagochiFunction();   //기능 클래스 객체 생성
	      DamagochiStartDrawing startDrawing = new DamagochiStartDrawing();   //메뉴클래스 객체 생성
	      
	      String putNum;   //사용자로부터 입력받아 메뉴를 선택하는 변수 선언
	      String putName;   //사용자로부터 이름을 입력받는 변수 선언
	      while (true) { // while start

	         startDrawing.damagochiStartDrawing(); // 시작화면 출력
	         putNum = sc.next();               //사용자로부터 변수를 입력받음
	         startDrawing.screenClear();      //화면을 넘김

	////////////////////////////////////////////// 불러오기///////////////////////////////////////////////////////////////////////////////
	         if (putNum.equals("1")) { //1번 if

	             while (true) { // while start
	                damo.selectAll();   //db쿼리문 클래스에서 모든 객체의정보를 불러옴
	                System.out.println("呼び寄せるたまごっちの名前を入力してください。 Back > 1");
	                String openSel = sc.next(); //이름과 숫자를 받음

	                if (openSel.equals("1")) { //1번을 선택할 경우
	                   break;      //다시 메뉴로 돌아감
	                }else if (openSel.length() > 0) { // String의 길이가 0이상일 경우

	                   Damagochi da1 = damo.selectOneDamagochi(openSel); //이름을 db에서 검색후 damagochi 객체에 담음
	                   if (da1 == null) { //damagochi객체에 값이 널인 경우
	                      System.out.println("たまごっちがありません！");
	                      try {
	                         Thread.sleep(3000); //3초간 대기
	                      } catch (InterruptedException e) {
	                         e.printStackTrace();
	                      }
	                      startDrawing.screenClear(); //화면 넘기기
	                      continue;            //다시 입력하도록 함
	                   }
	                   startDrawing.damagochiRunning(da1);//null이 아니라 객체가 있다면 메뉴실행
	                   break;
	                }else {
	                   System.out.println("入力が間違っています。");
	                   continue;   //다시 실행함
	                }

	             }//whilel end
	             startDrawing.screenClear();// 화면 넘기기
	          }//1번 if

         /////////////////// 새로만들기

         if (putNum.equals("2")) {//2번 if

            while(true) {
            	System.out.println(
            			"      ｡:・｡･ﾟ*.ﾟ｡\n" + 
            			"　 ･.ﾟ.｡:*･.\n" + 
            			"　.ﾟ❤.｡;｡.:*.ﾟ｡｡\n" + 
            			"　 :*｡_｡_*･_ﾟ\n" + 
            			"　 　＼ξ　＼　 ζ／\n" + 
            			"　  　 ∧∧＼ ξ\n" + 
            			"　　 （*･ω･ )／\n" + 
            			"    c/　  つ∀o♥ ～❤ たまごっち作るのよ \n" + 
            			"　 　 しー-Ｊ \n" + 
            			"　　　　\n" + 
            			"");
               System.out.println("生成するたまごっちの名前を入力してください。 Back > 1");
               String name = sc.next(); //이름을 사용자로부터 입력받음
               if (name.equals("1")) {//1을 입력한 경우
                  break;         //뒤로 돌아감
               }else if (name.length() > 0) { //String의 길이가 0이상일 때

                  Damagochi da1 = new Damagochi(name, 1, 0, 65, 65, 65, 1); //기본 수치값을 damagochi객체에 넣어줌

                  if (damo.insertDamagochi(da1) == 1) { // 디비에 이름이 없어서 새로 만든게 실행되면 1반환
                     System.out.println(name + "を新しく作りました。");
                     startDrawing.damagochiRunning(da1); //메뉴실행
                  } else { // 원래 있는 이름이면 원래 아이디 불러오기
                     continue;
                  }
                  break;
               }else {
                  System.out.println("入力が間違っています。");
                  continue; //메뉴 다시 실행
               }
            }//while end
            startDrawing.screenClear(); //화면 넘기기
         }//2번 if end

/////////////////////////////////////////////////// 삭제하기////////////////////////////////////////////////////////////////////

         if (putNum.equals("3")) { //3번 if

            while (true) { //while start
               damo.selectAll(); //db 쿼리클래스에서 모든 객체 정보 출력
               System.out.println("削除するたまごっちの名前を入力してください。Back > 1");
               String delSelect = sc.next(); //삭제할 이름을 받음
               if (delSelect.equals("1")) { //1을 선택한 경우
                  break;   //뒤로 가기
               } else if (delSelect.length() > 0) { //String이 0이상일 경우

                  Damagochi da1 = damo.selectOneDamagochi(delSelect); // 펫있는지 확인

                  if (da1 == null) { // 삭제할 펫이 없을 때
                     System.out.println("該当するたまごっちの名前はありません。");
                     try {
                        Thread.sleep(3000); //3초 기다림
                     } catch (InterruptedException e) {
                        e.printStackTrace();
                     }
                     startDrawing.screenClear(); //화면 넘기기
                     continue; //다시 물어봄
                  } else {
                     damo.deleteDamagochi(da1.getName()); // 펫삭제
                  }
                  continue;
               } else {
                  System.out.println("入力が間違っています。");
                  continue;
               }
            }
            startDrawing.screenClear(); //화면 넘기기
         }

////////////////////////////////////////////////////////// 종료하기///////////////////////////////////////////////////////////////////

         if (putNum.equals("4")) { //4번을 선택한 경우
            startDrawing.screenClear(); //화면 넘기기
            System.out.println("終了します。");
            break;   //종료
         }

      } // while end

   }//생성자 end
} ////DamagochiMain class end