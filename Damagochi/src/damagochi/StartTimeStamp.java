package damagochi;

public class StartTimeStamp extends Thread {  //다마고치러닝과 동시에 작동되는 메소드

	Damagochi da1;
	DamagochiTest back = new DamagochiTest();
	DamagochiStartDrawing damast = new DamagochiStartDrawing();
	DamagochiPicture damaFace = new DamagochiPicture();


	public StartTimeStamp(Damagochi da1) {//StartTimeStamp에 다마고치 인자값을 넣어줌.

		this.da1 = da1;

	}
	// 시간이 지날수록 다마고치의 상태가 안좋아짐.
	// 시간이 지날수록 날짜가 올라감.

	public void run() {
		boolean go = true;
		int i = 1;
		int a = 0;
		while (go) {
			i++;

			if (i %20 == 0) { //20초마다 상태가 안좋아짐

				int intimacy = da1.getIntimacy() - 5;
				da1.setIntimacy(intimacy);

				int hunger = da1.getHunger() + 5;
				da1.setHunger(hunger);

				int fatigue = da1.getFatigue() + 5;
				da1.setFatigue(fatigue);

			}

			else if (i % 30 == 0) { //30초마다 날짜가 변화함

				int dDay = da1.getdDay() + 1;
				da1.setdDay(dDay);
			
				System.out.println(dDay + "日になりました。");

			}
			try {
				//1초를 의미함
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}