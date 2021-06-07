import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Test;

public class DateTime6 {
	
	public static void listMondays(int year, Month month) {
		
		LocalDate startOfMonth = LocalDate.of(year, month, 1);
		LocalDate endOfMonth = startOfMonth.plusMonths(1);
		
		LocalDate monday = startOfMonth.plusDays(DayOfWeek.MONDAY.getValue() - startOfMonth.getDayOfWeek().getValue()); //this math only works if sunday is the first day of the week
		
		if (monday.isBefore(startOfMonth)) {
			monday = monday.plusWeeks(1);
		}
		
		while (monday.isBefore(endOfMonth)) {
			System.out.println(monday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			monday = monday.plusWeeks(1);
		}
	}
	
	@Test
	public void testJune2021() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		
		listMondays(2021, Month.JUNE);
		
		assertEquals("""
Monday, June 7, 2021
Monday, June 14, 2021
Monday, June 21, 2021
Monday, June 28, 2021
			""".replace("\r", ""),
			outContent.toString().replace("\r", ""));
		
		System.setOut(originalOut);
	}
	
	@Test
	public void testAugust2021() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		
		listMondays(2021, Month.AUGUST);
		
		assertEquals("""
Monday, August 2, 2021
Monday, August 9, 2021
Monday, August 16, 2021
Monday, August 23, 2021
Monday, August 30, 2021
			""".replace("\r", ""),
			outContent.toString().replace("\r", ""));
		
		System.setOut(originalOut);
	}
	
	@Test
	public void testFebruary2021() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		
		listMondays(2021, Month.FEBRUARY);
		
		assertEquals("""
Monday, February 1, 2021
Monday, February 8, 2021
Monday, February 15, 2021
Monday, February 22, 2021
			""".replace("\r", ""),
			outContent.toString().replace("\r", ""));
		
		System.setOut(originalOut);
	}
}
