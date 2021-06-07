import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Lambdas3 {

	public static List<String> a3LetterStrings(List<String> strings) {
		return strings.stream()
				.filter((a) -> a.charAt(0) == 'a' && a.length() == 3)
				.collect(Collectors.toList());
	}
	
	@Test
	public void testIntString() {
		
		List<String> input = Arrays.asList("bot", "are", "anteater", "awe", "cat");
		List<String> output = a3LetterStrings(input);
		
		assertEquals(2, output.size());
		assertEquals("are", output.get(0));
		assertEquals("awe", output.get(1));
	}
}
