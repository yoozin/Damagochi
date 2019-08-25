package damagochi;

import java.util.Scanner;

public class DamagochiStartDrawing extends DamagochiFunction {   //DamagochiStartDrawing class start
	   //화면넘기기 메소드
	   public static void screenClear() { //screenClear start
	      for (int i = 0; i < 50; i++)
	         System.out.println();
	   }//screenClear end
	   
	   // 제일 처음 나오는 화면
	   public static void damagochiStartDrawing() { //damagochiStartDrawing start


      System.out.print(
    		  " \n" + 
    		  "        ∧＿∧                \n" + 
    		  "      （｡･ω･｡)つ━☆・*。\n"
            + "      ⊂　 　 ノ 　　　・゜+.        　\n" + 
    		  "       しーＪ　   °。+ ¨)\n"
            + "                .· ´¸.·*´¨)   ¸.·*¨)\n" + 
    		  " 　　　               　(¸.·´       (¸.·'* ☆\n"
            + "　　　　　               　～❤   1. ロード       \n" + 
    		  "　　　　　                  　～❤   2. 新しく始める      \n"
            + "　　　　　　　                   ～❤   3. たまごっち削除        \n"
            + "　　　　　　　　         　     　　　 ～❤   4. 終了     \n" + 
            "      (╭☞•́⍛•̀)╭☞数字を入力してください。:"

            );

	   }//damagochiStartDrawing end

	   //다마고치의 상태를 나타내주는 상태바 메소드
	   public static void damagochiStatementDrawing(Damagochi d1) { //damagochiStatementDrawing start

	      int maxExp = 0; 
	      int maxLvl = 3;   

	      if (d1.getLevel() == 1) { //레벨 1일때 
	         maxExp = 10;      //맥스 경험치 10
	      }

	      else if (d1.getLevel() == 2) { //레벨 2일때 
	         maxExp = 30;         //맥스 경험치 30
	      }

	      else if (d1.getLevel() == 3) { //레벨 3일때 
	         maxExp = 50;   //맥스 경험치 50
	      }
	      
	      //다마고치의 상태바

      System.out.println("-------------------------------------------------------------------------------");
      System.out.println("|空腹:" + d1.getHunger() + "/100" + " 疲労度:" + d1.getFatigue() + "/100" + "  親密度: "
            + d1.getIntimacy() + "/100" + "  経験値 : " + d1.getExperience() + "/" + maxExp + "  レベル :"
            + d1.getLevel() + "/" + maxLvl + "  Date : " + d1.dDay + "| ");
      System.out.println("-------------------------------------------------------------------------------");

      if (d1.getExperience() >= maxExp && d1.getLevel() <= maxLvl) { // 경험치가 꽉 차고 최대레벨 3 밑이면 레벨업

          System.out.println("     ~~~~レベルアップしました~~~");
          int level = d1.getLevel() + 1; //객체에 레벨+1을 레벨 변수에 담음
          d1.setLevel(level);      //다마고치객체에 다시 적용
          d1.setExperience(0); // 경험치 0으로 초기화
       }
    }//damagochiStatementDrawing end
    


//////////////////////////////////////////////다마고치 밥먹이기 드로잉///////////////////////////////////////////////////////////////////////
	   
//밥 먹이기 메뉴
	   public static void damagochiFeedDrawing() { // damagochiFeedDrawing start
      System.out.println("--------------------------------");
      System.out.println("|           1. ご飯               |");
      System.out.println("--------------------------------");
      System.out.println("|           2. エサ              |");
      System.out.println("--------------------------------");
      System.out.println("|           3. Back           |");
      System.out.println("--------------------------------");
      System.out.println("|      数字を入力してください 　▼\t\t|");
   } // damagochiFeedDrawing end

   //다마고치 재우기 드로잉
	   public static void damagochiSleepDrawing() {   //damagochiSleepDrawing start
	  System.out.println("--------------------------------");
      System.out.println("|           1. 寝かせる            | ");
      System.out.println("--------------------------------");
      System.out.println("|           2. Back           |");
      System.out.println("--------------------------------");
	   }   ////damagochiSleepDrawing end

	   public static void damagochiFuntionDrawing() { //damagochiFuntionDrawing start

      System.out.println("----------------------------------------");
      System.out.println("|           1. エサをやる                 |");
      System.out.println("----------------------------------------");
      System.out.println("|           2. 遊んでやる                 |");
      System.out.println("----------------------------------------");
      System.out.println("|           3. 寝かせる                  |");
      System.out.println("----------------------------------------");
      System.out.println("|           4. Back　                   |");
      System.out.println("----------------------------------------");
      System.out.println("|           5. アップデート                |");
      System.out.println("----------------------------------------");
      System.out.println("|       数字を入力してください。 ▼          |");
      System.out.println("----------------------------------------");

	   } //damagochiFuntionDrawing end


	   //미니게임 선택메뉴
	   public static void minigameStartDrawingPicture() { //minigameStartDrawingPicture start
	  System.out.println("-------------------------------");
      System.out.println("|           1.ジャンケンポン       | ");
      System.out.println("-------------------------------");
      System.out.println("|           2.ナンバーゲーム   　|");
      System.out.println("-------------------------------");
      System.out.println("|           3. Back      　　   |");
      System.out.println("-------------------------------");
	   } //minigameStartDrawingPicture end

	   //게임 끝났을때 보이는 화면
	   public static void endingDrawing() { //endingDrawing start
      System.out.println(
    		"*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-*-**-*-*Game Over*-*-**-*-**-*-**--**-*-*-**-*\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-\r\n" + 
            "*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-*-*-**-*-**-*-**-");
	   }   ////endingDrawing end


	   //다마고치 메인메뉴 메소드
	   public static void damagochiRunning(Damagochi da1) { //damagochiRunning start

	      DamagochiDBO db = new DamagochiDBO();   //db 쿼리 클래스 객체화
	      DamagochiPicture damaFace = new DamagochiPicture(); //사진 클래스 객체화
	      Thread damaclock = new StartTimeStamp(da1);   //쓰레드 객체화
	      damaclock.start();      //쓰레드 시작
	      DamagochiStatementControl DSC = new DamagochiStatementControl();   //상태 컨트롤 클래스 객체화

	      Scanner sc = new Scanner(System.in);   //스캐너 객체화

	      while (true) { //while start

	    	   screenClear();
	           damagochiStatementDrawing(da1); // 상태창 출력
	           DSC.DamagochiStatementControl(da1);  //상태컨트롤 클래스에 다마고치 객체 넣음
	           if (da1.getLevel() < 4) {   //레벨 4미만
	              damaFace.damaBasicFace(da1); // 기본얼굴출력
	              damagochiFuntionDrawing(); // 기능메뉴출력
	           } else {   //레벨 3초과일시
	              endingDrawing(); // 얼굴출력
	              System.out.println("サヨナラ！バイバイ~" + "\n５秒後最初の画面に戻ります。");
	              damagochiFuntionDrawing(); // 기능출력
	              try {
	                 Thread.sleep(5000);   //5초 대기
	              } catch (InterruptedException e) {
	                 e.printStackTrace();
	              }
	              String name = da1.getName(); //해당 다마고치객체를 name에 담음
	              db.deleteDamagochi(name); // 디비에서 삭제
	              screenClear(); // 스크린클리어
	              break;
	           }

	  ///////////////////////////////////////// 다마고치 죽으면 메인화면////////////////////////////////////////////////////

	           if ((da1.getIntimacy() <= 0 || da1.getHunger() >= 100) || da1.getFatigue() >= 100) { //친밀도 0이하 배고픔 0이하 피로도 100이상
	              //친밀도 0이하 배고픔 0이하 피로도 100이상일 경우
	              screenClear();   //화면 넘기기
	              System.out.println(
	              //죽은 그림

       

                        " ┏ⅲⅲⅲ┓\n" + 
                        "d ご¿ご b あの。。\n" + 
                        " ┃\"ε \"┃ ね。。。\n" + 
                        " ┗┒  ┎┛ ..." 
                  );
            System.out.println(da1.getName()+"が死にました。");

            String name = da1.getName();
            db.deleteDamagochi(name); // 죽을애를 삭제
            System.out.println("メーン画面に戻ります。");
            damaclock.stop();

            try {
               Thread.sleep(1000);   //1초 대기
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

            // DamagochiMain Damagochi = new DamagochiMain();
            // Damagochi.DamagochiMain();
            break; //메인화면
         }

////////////////////////////////////////// 다마고치 기능 실행화면//////////////////////////////////////////////////////////////

         String putFuntionNum = sc.next(); //사용자로부터 기능선택을 받음

         if (putFuntionNum.equals("1")) { //1번일 경우
            screenClear();         //화면 지우기
            damagochiFeed(da1); //밥먹이기 기능수행
            continue;
         }

         else if (putFuntionNum.equals("2")) { //2번일 경우
            screenClear();         //화면 지우기
            minigameStart(da1);      //미니게임기능수행
            continue;
         }

         else if (putFuntionNum.equals("3")) { //3번일 경우
            screenClear();               //화면지우기
            damagochiSleep(da1);         //재우기기능수행
            continue;
         }

         else if (putFuntionNum.equals("4")) {   //4번일 경우
            screenClear();               //화면 지우기
            db.saveDamagochi(da1); // 뒤로가서 메인화면가기전에 저장!
            screenClear();         //화면지우기
            break;               //화면을 나감
         }

         else if (putFuntionNum.equals("5")) { //5번일 경우
            screenClear();         //화면지우기
            continue;         //상태 업데이트수행
         }

         else {
            System.out.println("入力が間違っています。");
            try {
               Thread.sleep(2000);   //2초대기
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            continue;   //다시 수행

         }

      }//while end
   }////damagochiRunning end
}////DamagochiStartDrawing class end