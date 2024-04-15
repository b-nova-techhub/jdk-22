import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public class FileReader extends Base {
	public FileReader(File file) throws IOException {
		String content = readFileAsString(file.getPath());
		if (content.isEmpty())
			throw new IllegalArgumentException("File content cannot be empty");

		int processedData = switch (content)
		{
			case String data when data.startsWith("XML") -> processXML(data);
			case String data when data.startsWith("JSON") -> processJSON(data);
			default -> handleDefaultFormat(content);
		};
		super(processedData);
	}

	private static String readFileAsString(String resourcePath) throws IOException {
		InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(resourcePath);
		if (inputStream == null) {
			throw new IOException("Resource not found: " + resourcePath);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		return reader.lines().collect(Collectors.joining("\n"));
	}

	private static int processXML(String xml) {
		// Actual implementation for XML processing
		return xml.length() + 2000;  // Dummy implementation
	}

	private static int processJSON(String json) {
		// Actual implementation for JSON processing
		return json.length() + 1000;  // Dummy implementation
	}

	private static int handleDefaultFormat(String data) {
		// Default handling for other data formats
		return data.length();  // Dummy implementation
	}
}

abstract class Base {
	public Base(int data) {
		System.out.println(STR."Data processed: \{data}");
		// Constructor implementation
	}
}

void main(){
	var file = new File("tom.json");
	try {
		new FileReader(file);
	} catch (IOException e) {
		System.err.println(STR."Failed to read file: \{e.getMessage()}");
	}

	var file2 = new File("tim.xml");
	try {
		new FileReader(file2);
	} catch (IOException e) {
		System.err.println(STR."Failed to read file: \{e.getMessage()}");
	}

}