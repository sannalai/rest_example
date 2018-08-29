
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class TestClass {

	@Test
	public void shouldCastDoubleListToIntegersAndFilterNulls() {
		List<Double> doubles = Arrays.asList(0.0, 50.78, 30.0, 120.7, null);
		List<Integer> ints = 
				doubles.stream()
				.filter(Objects::nonNull)
				.map(Double::intValue)
				.collect(Collectors.toList());

		double avg = Arrays.asList(
				Foo.builder().ints(Arrays.asList(1, 2)).build(),
				Foo.builder().ints(Arrays.asList(3, 4)).build())
		.stream()
		.map(Foo::getInts)
		.flatMap(List::stream)
		.collect(Collectors.averagingInt(i -> i));
		System.out.println(avg);
		
		Optional<Integer> sum = Arrays.asList(
				Foo.builder().ints(Arrays.asList(1, 2)).build(),
				Foo.builder().ints(Arrays.asList(3, 4)).build())
		.stream()
		.map(Foo::getInts)
		.flatMap(List::stream)
		.reduce(this::sum);
		
		System.out.println(sum.get());

		long x = System.currentTimeMillis();
		OptionalInt sum2 = 
		IntStream.range(0, Integer.MAX_VALUE)
			.parallel()
			.reduce(this::sum);
		System.out.println(System.currentTimeMillis() - x);
		System.out.println(sum2.getAsInt());
		
//		.forEach(System.out::println);
		
//		ints.stream().forEach(System.out::println);
	}
	
	public Integer sum(Integer currentSum, Integer toAdd) {
		return currentSum + toAdd;
	}
	
	public int fastSum(int currentSum, int toAdd) {
		return currentSum + toAdd;
	}
	
	@Getter
	@Builder
	public static class Foo {
		private List<Integer> ints;
	}

}
