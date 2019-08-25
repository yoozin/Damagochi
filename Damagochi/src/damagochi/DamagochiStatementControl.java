package damagochi;

public class DamagochiStatementControl { //다마고치의 상태제어

   public void DamagochiStatementControl(Damagochi da) {

      if (da.getFatigue() > 80) { //다마고치의 피로가 80 이상이면 알림
    	  
         System.out.println(da.getName() + "が疲れています。");

      }
      if (da.getFatigue() < 0) { //다마고치의 피로가 0이하로 내려가면 0으로 유지되도록 설정
         da.setFatigue(0);

      }
      if (da.getFatigue() > 100) { //다마고치의 피로가 100이상으로 올라가면 100으로 유지되도록 설정
         da.setFatigue(100);

      }
      
      if (da.getHunger() > 80) { //다마고치의 배고픔이 80 이상이면 알림

         System.out.println(da.getName() + "がおなかちゅきまちた。");

      }
      if (da.getHunger() < 0) { //다마고치의 배고픔이 0이하로 내려가면 0으로 유지되도록 설정
         da.setHunger(0);

      }
      if (da.getHunger() > 100) { //다마고치의 배고픔이 100이상으로 올라가면 100으로 유지되도록 설정
         da.setHunger(100);

      }
      if (da.getIntimacy() < 20) { //다마고치의 친근감이 20 이하면 알림

         System.out.println(da.getName() + "がさびちぃ。。");

      }
      if (da.getIntimacy() < 0) { //다마고치의 친근감이 0이하로 내려가면 0으로 유지되도록 설정
         da.setIntimacy(0);

      }
      if (da.getIntimacy() > 100) { //다마고치의 친근감이 100이상으로 올라가면 100으로 유지되도록 설정
         da.setIntimacy(100); 

      }
      
   }
   
   
   

}