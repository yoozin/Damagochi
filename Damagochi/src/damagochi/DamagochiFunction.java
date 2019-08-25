package damagochi;

import java.util.Random;
import java.util.Scanner;

//다마고치 기능 클래스
public class DamagochiFunction {
	Scanner sc = new Scanner(System.in);

////////////////////////////////////다마고치 밥먹이기////////////////////////////////////////////////////////
	public static void damagochiFeed(Damagochi da1) {

		DamagochiPicture damapic = new DamagochiPicture(); // 다마고치픽쳐 클래스에서 그림가져올것임
		DamagochiStartDrawing damaDrawing = new DamagochiStartDrawing(); // 인터페이스 드로잉

		Scanner sc = new Scanner(System.in); // 스캐너 객체 생성

		while (true) {

			damaDrawing.damagochiFeedDrawing(); // 다마고치 밥 선택 인터페이스 그림
			String foodSelectNum = sc.next(); // 밥먹일지 사료먹일지 고르기

			if (foodSelectNum.equals("1")) { // 1번 일때

				damaDrawing.screenClear(); // 화면 지우기
				System.out.println("ご飯を食べています〜");
				damapic.beFullPicture(da1); // 배부른 표정 출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

///  배고픔수치 변경
				int hunger = da1.getHunger() - 50;
				da1.setHunger(hunger); // 수치 적용
				break; // 뒤로가기
			} else if (foodSelectNum.equals("2")) { // 2번일때
				damaDrawing.screenClear(); // 화면지우기
				System.out.println("エサを食べています。");
				damapic.beFullPicture(da1); // 배부른 얼굴 출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
///  배고픔수치 변경
				int hunger = da1.getHunger() - 15;
				da1.setHunger(hunger); // 수치 적용
				break; // 나가기
			} else if (foodSelectNum.equals("3")) { // 뒤로가기
				break;
			} else {
				System.out.println("入力が間違っています。もう一度入力してください。"); // 잘못입력값
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue; // 다시 밥메뉴
			}
		} // while end
	}// damagochiFeed end

/////////////////////////////////////다마고치 재우기////////////////////////////////////////////////////////////////////
	public static void damagochiSleep(Damagochi da1) { // damagochiSleep start

		DamagochiPicture damapic = new DamagochiPicture();
		DamagochiStartDrawing damaDrawing = new DamagochiStartDrawing();

		Scanner sc = new Scanner(System.in);
		while (true) {// while start

			damaDrawing.damagochiSleepDrawing(); // 다마고치 재울지 말지 인터페이스 그림

			String foodSelectNum = sc.next(); // 사용자로부터 입력받음

			if (foodSelectNum.equals("1")) { // 1. 재우기
// 디비연결 업데이트해서 피로도 하락

				damaDrawing.screenClear();
				System.out.println("おねんねしてます");
				damapic.tiredPicture(da1); // 피곤한 얼굴 출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int fatigue = da1.getFatigue() - 50; // 50감소
				da1.setFatigue(fatigue); // 객체에 수치적용
				break; // 나가기
			} else if (foodSelectNum.equals("2")) {
// 뒤로가기
				break;
			} else {
				System.out.println("入力が間違っています。もう一度入力してください。");
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue; // 다시 선택
			}
		} // while end
	}// damagochiSleep end

///////////////////////////////////// 게임메소드////////////////////////////////////////////////////////////////////////////

//미니게임 선택메뉴 메소드
	public static void minigameStart(Damagochi da1) { // minigameStart start
		DamagochiStartDrawing damaDrawing = new DamagochiStartDrawing();
		Scanner sc = new Scanner(System.in);

		while (true) { // while start

			damaDrawing.minigameStartDrawingPicture(); // 미니게임 고를 수 있는 인터페이스 출력
			String gameSelectNum = sc.next();
			if (gameSelectNum.equals("1")) {
//가위바위보
				rspGame(da1);
				break;
			} else if (gameSelectNum.equals("2")) {
//숫자맞추기
				checkFiguresGame(da1);
				break;
			} else if (gameSelectNum.equals("3")) {
//뒤로가기
				break;
			} else {
				System.out.println("入力が間違っています。もう一度入力してください。");
				continue;
			}
		} // while end
	} // minigameStartDrawing end

	// 가위바위보 게임 메소드

	public static void rspGame(Damagochi da) { // rspGame start

		DamagochiPicture dp = new DamagochiPicture(); // 사진클래스 객체 생성
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		while (run) { // while start
			DamagochiStartDrawing.screenClear(); // 화면 지우기
			System.out.println("------------------------------------");
			System.out.println("  1.チョキ | 2.グー | 3.パー | 4.終了  ");
			System.out.println("------------------------------------");
			System.out.print("선택>");
			String select = sc.next(); // 사용자로 부터 받음

///////////////////////////////////// 사용자 가위바위보/////////////////////////////////////////////////////////////////////////////////
			if (select.equals("1")) { // 1번 선택
				System.out.println("-------------------------");
				System.out.println("   私がチョキを出しました。      ");
				System.out.println("-------------------------");
				dp.scissorsPicture(); // 가위 그림
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면 지우기

			} else if (select.equals("2")) { // 2번 선택
				System.out.println("-------------------------");
				System.out.println("   私がグーを出しました。      ");
				System.out.println("-------------------------");
				dp.rockPicture(); // 바위사진
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면 지우기
			} else if (select.equals("3")) { // 3번 선택
				System.out.println("-------------------------");
				System.out.println("   私がパーを出しました。        ");
				System.out.println("-------------------------");
				dp.paperPicture(); // 보자기 사진
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면지우기
			} else if (select.equals("4")) { // 4번 선택
				break; // 종료
			} else { // 잘못입력 시
				System.out.println("入力が間違っています。もう一度入力してください。");
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue; // 다시 시작
			}

			int com = (int) (Math.random() * 4) + 1; // 다마고치 캐릭터가 가위바위보 선택(랜덤)

/////////////////////////////////////////////////다마고치가 낸 가위바위보////////////////////////////////////////////////////////////
			switch (com) { // switch start
			case 1: // 랜덤 숫자가 1일때
				System.out.println("----------------------------------------");
				System.out.println(" 　 <" + da.getName() + "> がチョキを出しました。   ");
				System.out.println("----------------------------------------");
				dp.scissorsPicture(); // 가위그림출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면 지우기
				if (select.equals("1")) { // 만약 사용자가 낸값과 같을때
					System.out.println("------------------------");
					System.out.println("        ひきわけです!");
					System.out.println("------------------------");
					dp.embarrassedPicture(da); // 당황한표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy); // 수치적용

				} else if (select.equals("2")) { // 다마고치 가위 사용자 바위일 때
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が負けました。");
					System.out.println("--------------------------------------------");
					dp.sadPicture(da); // 슬플표정 출력
					System.out.println("親密度 10 アップ!");

					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy); // 수치적용

				} else {
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が勝ちました。");
					System.out.println("--------------------------------------------");
					dp.smilePicture(da); // 기쁜표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy); // 수치적용
				}
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 2: // 다마고치가 바위일 경우
				System.out.println("----------------------------------------");
				System.out.println("     <" + da.getName() + "> がグーを出しました。    ");
				System.out.println("----------------------------------------");
				dp.rockPicture(); // 주먹 그림 출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면 지우기
				if (select.equals("1")) { // 다마고치 바위 사용자 가위
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が勝ちました。");
					System.out.println("--------------------------------------------");
					dp.smilePicture(da); // 기쁜표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);

				} else if (select.equals("2")) { // 다마고치 바위 사용자 바위
					System.out.println("------------------------");
					System.out.println("        ひきわけです!");
					System.out.println("------------------------");
					dp.embarrassedPicture(da); // 당황한 표정출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);

				} else {
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が負けました。");
					System.out.println("--------------------------------------------");
					dp.sadPicture(da); // 슬픈표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);
				}
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 3: // 다마고치 보
				System.out.println("----------------------------------------");
				System.out.println("      <" + da.getName() + "> がグーを出しました。     ");
				System.out.println("----------------------------------------");
				dp.paperPicture(); // 보자기 출력
				try {
					Thread.sleep(3000); // 3초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				DamagochiStartDrawing.screenClear(); // 화면 지우기
				if (select.equals("1")) { // 다마고치 보 사용자 가위
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が負けました。");
					System.out.println("--------------------------------------------");
					dp.sadPicture(da); // 슬픈표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);
				} else if (select.equals("2")) { // 다마고치 보 사용자 바위
					System.out.println("--------------------------------------------");
					System.out.println("     <" + da.getName() + "> が勝ちました。");
					System.out.println("--------------------------------------------");
					dp.smilePicture(da);// 기쁜표정 출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);
				} else {
					System.out.println("------------------------");
					System.out.println("        ひきわけです");
					System.out.println("------------------------");
					dp.embarrassedPicture(da); // 당황한 표정출력
					System.out.println("親密度 10 アップ!");
					int intimacy = da.getIntimacy() + 10; // 상승 메소드
					da.setIntimacy(intimacy);
				}
				try {
					Thread.sleep(3000); // 3초대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			} // switch end
			int intimacy = da.getIntimacy() + 20; // 친밀도 상승
			da.setIntimacy(intimacy);
			int exp = da.getExperience() + 50; // 경험치 상승
			da.setExperience(exp);
			int fati = da.getFatigue() + 5; // 피로도 상승
			da.setFatigue(fati);
			System.out.println("親密度 +20 | 経験値 +50 | 疲労度 +5");
			try {
				Thread.sleep(3000); // 3초대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while end
		System.out.println("ジャンケンポン終了!!");
		// 친밀도 상승 적용코드

	}

	// 숫자맞추기 게임
	public static void checkFiguresGame(Damagochi da1) { // checkFiguresGame start
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int[] aArr = new int[5];
		int cnt = 0;
		DamagochiPicture dp = new DamagochiPicture();

		while (run) { // while start
			DamagochiStartDrawing.screenClear(); // 화면 지우기
			System.out.println("----------------------------------------");
			System.out.println("        数字５個当たったら勝ち ");
			System.out.println("  (３個以上当たったら親密度20アップ)");
			System.out.println("-----------------------------------------");

			for (int i = 0; i < aArr.length; i++) {
				System.out.print("入力" + (i + 1) + "> ");
				aArr[i] = sc.nextInt();
			}
			int com = (int) (Math.random() * 5) + 1; // 1~5까지의 수
			for (int i = 0; i < aArr.length; i++) {
				if (aArr[i] == com) {
					cnt++;
				}
			}
			try {
				Thread.sleep(3000); // 3초 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DamagochiStartDrawing.screenClear(); // 화면 지우기

			if (cnt >= 3 && cnt <= 5) {
				System.out.println("-----------------------------------");
				System.out.println("     当たった回数: " + cnt);
				System.out.println("     親密度 20 アップ! 経験値 10 アップ! 疲労度 5 アップ!");
				System.out.println("-----------------------------------");

				int intimacy = da1.getIntimacy() + 20; // 친밀도 상승
				da1.setIntimacy(intimacy);
				int exp = da1.getExperience() + 10; // 경험치 상승
				da1.setExperience(exp);
				int fati = da1.getFatigue() + 5; // 피로도 상승
				da1.setFatigue(fati);

				dp.smilePicture(da1); // 기쁜표정
			} else {
				System.out.println("-----------------------------------");
				System.out.println("     当たった回数: " + cnt);
				System.out.println("     もうちょっとがんばろ！仲良くなれます！");
				System.out.println("-----------------------------------");
				dp.sadPicture(da1); // 슬픈표정

			}
			cnt = 0;
			for (int i = 0; i < aArr.length; i++) {
				aArr[i] = 0;
			}
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("もう一回しますか？ (Y/N) > ");
			System.out.println("--------------------------------------");
			System.out.print("入力> ");
			String question = sc.next();

			if (question.equalsIgnoreCase("y")) {
				continue;
			} else if (question.equalsIgnoreCase("n")) {
				break;
			} else {
				break;
			}
		} // while end
		System.out.println("ナンバーゲーム終了!");
	}// checkFiguresGame end
} // DamagochiFuntion class end