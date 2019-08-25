import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Day {

	public static void main(String[] args) {

		
		
		Calendar cal = Calendar.getInstance();

		int date = cal.get ( cal.DATE ) ;

		System.out.println(date);
		
		
	}

}
