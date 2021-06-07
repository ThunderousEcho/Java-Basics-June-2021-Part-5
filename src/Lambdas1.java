import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Lambdas1 {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("co", "a", "elephant", "eerie", "bot");

		System.out.print("Shortest to longest: ");
		System.out.println(
				strings.stream()
				.sorted((a, b) -> ((Integer)a.length())
						.compareTo(b.length()))
				.collect(Collectors.joining(", ")));
		
		System.out.print("Longest to shortest: ");
		System.out.println(
				strings.stream()
				.sorted((a, b) -> ((Integer)b.length())
						.compareTo(a.length()))
				.collect(Collectors.joining(", ")));
		
		System.out.print("Alphabetically by first character only: ");
		System.out.println(
				strings.stream()
				.sorted((a, b) -> ((Character)a.charAt(0))
						.compareTo(b.charAt(0)))
				.collect(Collectors.joining(", ")));
		
		System.out.print("Strings that contain 'e' first, everything else afterwards: ");
		System.out.println(
				strings.stream()
				.sorted((a, b) -> ((Integer)(a.contains("e") ? 0 : 1))
						.compareTo((b.contains("e") ? 0 : 1)))
				.collect(Collectors.joining(", ")));
		
		System.out.print("Strings that contain 'e' first, everything else afterwards (helper method version): ");
		System.out.println(
				strings.stream()
				.sorted((a, b) -> compareByEContainment(a, b))
				.collect(Collectors.joining(", ")));
	}
	
	static int compareByEContainment(String a, String b) {
		return ((Integer)(a.contains("e") ? 0 : 1)).compareTo((b.contains("e") ? 0 : 1));
	}
	
	@Test
	public void testOutput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		
		main(new String[] {});
		
		assertEquals("""
Shortest to longest: a, co, bot, eerie, elephant
Longest to shortest: elephant, eerie, bot, co, a
Alphabetically by first character only: a, bot, co, elephant, eerie
Strings that contain 'e' first, everything else afterwards: elephant, eerie, co, a, bot
Strings that contain 'e' first, everything else afterwards (helper method version): elephant, eerie, co, a, bot
				""".replace("\r", ""),
				outContent.toString().replace("\r", ""));
		
		System.setOut(originalOut);
	}
}
