import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Lambdas2 {
	
	public static String intString(List<Integer> integers) {
		return integers.stream()
				.map((a) -> { return (((a & 1) == 0) ? "e" : "o") + a; })
				.collect(Collectors.joining(", "));
	}
	
	@Test
	public void testIntString() {
		assertEquals("o3, e44, e656, o655", intString(Arrays.asList(3, 44, 656, 655)));
	}
}
