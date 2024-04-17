private final static ScopedValue<String> NAME = ScopedValue.newInstance();

void main() throws Exception
{
	var name = ScopedValue.where(NAME, "Tom").call(() -> getName());
	var anotherName = ScopedValue.where(NAME, "Tim").call(() -> getName());
	System.out.println(STR."The name is \{name}");
	System.out.println(STR."The another name is \{anotherName}");
}

String getName()
{
	return NAME.get().toUpperCase();
}