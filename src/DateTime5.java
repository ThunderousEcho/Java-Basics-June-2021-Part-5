import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.YearMonth;

import org.junit.jupiter.api.Test;

public class DateTime5 {

	public static void reportMonthLengths(int year) {
		
		System.out.println("Month lengths for " + year + ":");
		for (int month = 1; month <= 12; month++) {
			YearMonth yearMonth = YearMonth.of(year, month);
			System.out.println("\t" + yearMonth.getMonth() + ": " + yearMonth.lengthOfMonth());
		}
	}
	
	@Test
	public void testOutput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		
		reportMonthLengths(2021);
		
		assertEquals("""
Month lengths for 2021:
	JANUARY: 31
	FEBRUARY: 28
	MARCH: 31
	APRIL: 30
	MAY: 31
	JUNE: 30
	JULY: 31
	AUGUST: 31
	SEPTEMBER: 30
	OCTOBER: 31
	NOVEMBER: 30
	DECEMBER: 31
			""".replace("\r", ""),
			outContent.toString().replace("\r", ""));
		
		System.setOut(originalOut);
	}
}
