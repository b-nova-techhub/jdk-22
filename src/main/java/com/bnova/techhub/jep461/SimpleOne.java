import java.util.List;
import java.util.stream.Gatherer;


void main()
{
	List<String> strings = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

	System.out.println(
			strings.stream().gather(printUpper())
					.toList());
}

public static Gatherer<? super String, ?, String> printUpper()
{
	Gatherer.Integrator<Void, ? super String, String> integrator =
			(state, element, downstream) -> {
				downstream.push(element.toUpperCase());
				return true;
			};
	return Gatherer.ofSequential(integrator);
}