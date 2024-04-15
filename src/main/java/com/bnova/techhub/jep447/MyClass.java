
public class MyClass extends SuperClass {
	public MyClass(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name must not be null");
		} else {
			System.out.println(STR."Hello \{name}");
		}
		super();
	}
}

class SuperClass {
	public SuperClass() {
		System.out.println("Super class constructor");
	}
}

void main() {
	new MyClass("John");
	new MyClass(null);
}