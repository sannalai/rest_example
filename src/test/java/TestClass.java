
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestClass {

	@Test
	public void test() {
		List<Double> doubles = new ArrayList<>(Arrays.asList(0.0, 50.78, 30.0, 120.7));
		doubles.add(null);

		List<Integer> ints = 
				doubles.stream()
				.filter(Objects::nonNull)
				.map(Double::intValue)
				.collect(Collectors.toList());

		ints.stream().forEach(System.out::println);

	}

}
