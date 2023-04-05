import java.sql.Timestamp;
import java.util.Date;

public class Test {
	public static void main(String[] args) {

//		Timestamp now = new Timestamp(System.currentTimeMillis());
//		System.out.println(now);	// 2023-04-04 17:07:38.457
		
		// 2023-04-04 18:10:01
		Date date = new Date(123, 3, 4, 18, 10, 1);
		Timestamp now = new Timestamp(date.getTime());
		System.out.println(now);
	}
}
