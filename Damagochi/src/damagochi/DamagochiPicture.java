package damagochi;

public class DamagochiPicture {
   
   
   public static void damaBasicFace(Damagochi da1) {// damaBasicFace start
         if (da1.getLevel() == 1) { // 레벨 1일때
            if (da1.getFatigue() >= 80) { // 레벨 1에서 피로도가 80이상일 경우
               tiredPicture(da1); // 피곤한표정
            } else if (da1.getHunger() >= 90) {// 레벨1에서 배고픔이 90이상일 경우
               hungryPicture(da1); // 배고픈표정
            } else if (da1.getIntimacy() <= 30) {// 레벨1에서 친밀도가 30이하일경우
               sadPicture(da1); // 슬픈표정
            } else {
               damagochiLv1Drawing(da1);
            }
         } else if (da1.getLevel() == 2) {
            if (da1.getFatigue() >= 80) { // 레벨 2에서 피로도가 80이상일 경우
               tiredPicture(da1); // 피곤한표정
            } else if (da1.getHunger() >= 90) {// 레벨2에서 배고픔이 90이상일 경우
               hungryPicture(da1); // 배고픈표정
            } else if (da1.getIntimacy() <= 30) {// 레벨2에서 친밀도가 30이하일경우
               sadPicture(da1); // 슬픈표정
            } else {
               damagochiLv2Drawing(da1);
            }
         } else if (da1.getLevel() == 3) {
            if (da1.getFatigue() >= 80) { // 레벨 3에서 피로도가 80이상일 경우
               tiredPicture(da1); // 피곤한표정
            } else if (da1.getHunger() >= 90) {// 레벨3에서 배고픔이 90이상일 경우
               hungryPicture(da1); // 배고픈표정
            } else if (da1.getIntimacy() <= 30) {// 레벨3에서 친밀도가 30이하일경우
               sadPicture(da1); // 슬픈표정
            } else {
               damagochiLv3Drawing(da1);
            }
         }
      }// damaBasicFace end

      public static void damagochiLv1Drawing(Damagochi d1) {
         System.out.println(

               "\t        /)─―ヘ \n" + 
               "\t　　　＿／　　　　　＼\n" + 
               "\t　 ／　　　　●　　　●丶 \n" + 
               "\t　｜　　　 　　　　▼　　| \n" + 
               "\t　｜　　　　　　　亠　 ノ \n" + 
               "\t　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n\t        [" + d1.getName() + "]");

      }

      public static void damagochiLv2Drawing(Damagochi d1) {
         System.out.println(

               "     \"*.  ♡  .*  \n" +
               "       /)♛益♛ヘ \n" +
               "　　　＿／　　 　　　＼      \n" +
               "　 ／　　　　◕　　　◕ 丶    \n"   +
               "　｜　　　 ★　　　▼　★ | \n" +
               "　｜　　　　　　　∀ 　 ノ   \n" +
               "　 U￣U￣￣￣￣U￣￣U     \n" + "\n" +
               "\n\t        ["   + d1.getName() + "]");
      }

      public static void damagochiLv3Drawing(Damagochi d1) {
         System.out.println(
               "         /)------------/)         \n"+
               "        |              |         \n" + 
               "        |     ●    ●   |         \n" +   
               "        |       ㅜ     |         \n" + 
               "        |   └-------┛  |          \n" + 
               "        └--------------┘          \n" + 
               "\n\t         [" + d1.getName() + "]");

      }
     // 기분좋은 캐릭터
      public static void smilePicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　 　　＿／　　　　　＼\n" + 
               "　 ／　　　　^　　　^ 丶 \n" + 
               "　｜　　　 　๑ 　▼　๑　| \n" + 
               "　｜　　　　　　　ω　  ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" + "幸せ~" + "\n\t        [" + d1.getName() + "]");
               
      }
      
      //슬픈 캐릭터
      public static void sadPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　　＿／　　　　  ＼\n" + 
               "　 ／　　　´•̥　　　•̥`丶 \n" + 
               "　｜　　 　 　̥ 　▼ 　̥　| \n" + 
               "　｜　　　　　　　ω　  ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" + "悲しい~"+ "\n\t        [" + d1.getName() + "]");
               
      }
      
      //당황 캐릭터
      public static void embarrassedPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　 　＿／　　　　  ＼ \n" + 
               "　 ／　 　  ꒪ 　　 ꒪ 丶 \n" + 
               "　｜  ฅ=͟͟͞͞(     ▼   　| \n" + 
               "　｜　　　　     ∆   ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" + "パニク.."+ "\n\t        [" + d1.getName() + "]");
      }
      
      //심심해하는 캐릭터
      public static void boredPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　 　＿／　　　　  ＼\n" + 
               "　 ／　 　　~~~ ~~~~ 丶 \n" + 
               "　｜      *   ▼  *　| \n" + 
               "　｜　　　　 　  Ɛ   ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" 
               + "\n\t        [" + d1.getName() + "]");
                                                                  
      }

      // 배고픈 캐릭터
      public static void hungryPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　　＿／　　　　   ＼\n" + 
               "　 ／　 　　ಠ 　　　ಠ 丶 \n" + 
               "　｜     ╬    ▼   　| \n" + 
               "　｜　　　　　　　益　  ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" + 
               "お腹ペコペコ"+ "\n\t        [" + d1.getName() + "]");
      }
      
      //배부른 캐릭터
      public static void beFullPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　　＿／　　　　　 ＼\n" + 
               "　 ／　　　　◕　　　◕丶 \n" + 
               "　｜　　　 　๑ 　▼　๑　| \n" + 
               "　｜　　　　　　　◞◟　 ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" +  "\n\t        [" + d1.getName() + "]");
      }

      //졸린 캐릭터
      public static void tiredPicture(Damagochi d1) {
         System.out.println(
               "        /)─――ヘ \n" + 
               "　　　＿／　　　 　  ＼zZ\n" + 
               "　 ／　 　  ꑓ 　　 ꑓ 丶 \n" + 
               "　｜   zZ     ▼   　| \n" + 
               "　｜　　　　    ﹏   ノ \n" + 
               "　 U￣U￣￣￣￣U￣￣U\n" + 
               "\n" + "\n\t        [" + d1.getName() + "]");
      }
      
      
      
      
      
      
      
      //가위바위보 -> 바위
      public void rockPicture() {
         System.out.println(
               " ┏━━┳━━┳━━┳━━☆   今日\n" + 
               " ┃  ┃  ┃  ┃  ┃   \n" +
               "┏┻━━┻━━┓━━┛━━┛   一日\n" + 
               "┃  ┏━━━┛     ┃   よく\n" + 
               "┗━━━━┓   ┏━━━┛   頑張って\n" + 
               "☆    ┃   ┃  □★\n");
      }
      //가위바위보 -> 가위
      public void scissorsPicture() {
         System.out.println("┏━━┓\n" + 
               "┃  ┣━━━━━━━┓♡\n" + 
               "┃━━━━┗━┳━━━┛\n" + 
               "┃━━━━┗━┫\n" + 
               "┗━━━━┗━┛~~☆★");
      }
      
      //가위바위보 -> 보
      public void paperPicture() {
         System.out.println(
               "  ┏━━┳━━┳━━┳━━☆   \n" + 
               "  ┃  ┃  ┃  ┃  ┃   \n" +
               "  ┃  ┃  ┃  ┃  ┃   \n" +
               "┏━┃  ┃  ┃  ┃  ┃   \n" +
               "┃ ┃           ┃\n" + 
               "┃             ┃   \n" + 
               "┗━━━━┓   ┏━━━━┛   \n" + 
               "☆    ┃   ┃  ★\n"
               );
      }

}