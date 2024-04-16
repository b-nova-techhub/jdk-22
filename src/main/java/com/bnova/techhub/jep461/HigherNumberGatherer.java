import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Gatherer;


void main()
{
	List<Integer> numbers = List.of(1, 2, 5, 3, 2, 3, 4, 5, 6, 7, 5, 11, 8, 9, 10, 20);

	System.out.println(
			numbers.stream().gather(getOnlyIncreasingNumbers(Comparator.comparingInt(a -> a)))
					.toList());

	System.out.println(
			numbers.stream().gather(getOnlyIncreasingNumbersWithFinisher(Comparator.comparingInt(a -> a)))
					.toList());
}

public static <T> Gatherer<T, ?, T> getOnlyIncreasingNumbers(
		Comparator<T> comparator)
{
	Supplier<AtomicReference<T>> initializer = AtomicReference::new;
	Gatherer.Integrator<AtomicReference<T>, T, T> integrator =
			(state, element, downstream) -> {
				T largest = state.get();
				var isLarger = largest == null
						|| comparator.compare(element, largest) > 0;
				if (isLarger)
				{
					downstream.push(element);
					state.set(element);
				}
				return true;
			};
	return Gatherer.ofSequential(initializer, integrator);
}

public static Gatherer<? super Integer, ?, Integer> getOnlyIncreasingNumbersWithFinisher(
		Comparator<Integer> comparator)
{
	Supplier<AtomicReference<Integer>> initializer = AtomicReference::new;
	Gatherer.Integrator<AtomicReference<Integer>, ? super Integer, Integer> integrator =
			(state, element, downstream) -> {
				Integer largest = state.get();
				var isLarger = largest == null
						|| comparator.compare(element, largest) > 0;
				if (isLarger)
				{
					downstream.push(element);
					state.set(element);
				}
				return true;
			};

	BiConsumer<AtomicReference<Integer>, Gatherer.Downstream<? super Integer>> finisher = (state, downstream) -> {
		Integer lastElement = state.get();
		downstream.push(lastElement * 2);
	};

	return Gatherer.ofSequential(initializer, integrator, finisher);
}