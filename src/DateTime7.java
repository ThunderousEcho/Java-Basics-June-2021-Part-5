import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class DateTime7 {
	
	public static boolean isFridayThe13th(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
	}
	
	@Test
	public void testFridayThe13th() {
		assertFalse(isFridayThe13th(LocalDate.of(2020, Month.JUNE, 13)));
		assertFalse(isFridayThe13th(LocalDate.of(2020, Month.AUGUST, 14)));
		assertTrue(isFridayThe13th(LocalDate.of(2020, Month.NOVEMBER, 13)));
	}
}
