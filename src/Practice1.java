import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Practice1 {
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		// ≥≠ 8261¿œ
		
	public int Birth() {
		int yy = sc.nextInt();
		int mm = sc.nextInt();
		int dd = sc.nextInt();
		int final_dd = 0;
		
		int final_yy = (cal.get(Calendar.YEAR) - yy)*365;
		
		System.out.println("cal.get(Calendar.YEAR) = " + cal.get(Calendar.YEAR));
		System.out.println("final_yy = " + final_yy);
		System.out.println();
		
		int middle_mm = Math.abs(cal.get(Calendar.DAY_OF_MONTH) + 1 - mm);
		
		System.out.println("cal.get(Calendar.DAY_OF_MONTH) = " + cal.get(Calendar.DAY_OF_MONTH)+1);
		System.out.println("middle_mm = " + middle_mm);
		System.out.println();
		
		int middle_dd = Math.abs(cal.get(Calendar.DAY_OF_WEEK) - dd);
		
		System.out.println("cal.get(Calendar.DAY_OF_WEEK) = " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("middle_dd = " + middle_dd);
		System.out.println();
		
		for(int i = mm; i < middle_mm; i++) {
			int allMonth = middle_mm*cal.getActualMaximum(i);
			System.out.println("allMonth = "  + allMonth);
		}
		System.out.println();
		
		final_dd = final_yy + middle_mm + middle_dd;
		System.out.println(final_dd);
		System.out.println();
		
		return final_dd;
	}
	
	public static void main(String[] args) {
		Practice1 p = new Practice1();
		System.out.println(p.Birth());
	}
}