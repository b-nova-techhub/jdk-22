import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;


void main(){
	List<String> words = List.of("Hello", "World", "Java", "Is", "Awesome", "And", "So", "Are", "You");

	List<List<String>> groupedWords = words.stream()
			.collect(Collectors.groupingBy(word -> words.indexOf(word) / 4))
			.values()
			.stream()
			.toList();

	System.out.println(groupedWords);

	groupedWords = words.stream()
			.gather(Gatherers.windowFixed(4))
			.toList();

	System.out.println(groupedWords);
}