private final static ScopedValue<String> NAME
		= ScopedValue.newInstance();

void main()
{
	ScopedValue.where(NAME, "Tom").run(() -> greet());
}

void greet()
{
	System.out.println(STR."Hello \{NAME.get()}!");
	ScopedValue.where(NAME, "Tim").run(() -> goodbye());
	goodbye();
}

void goodbye()
{
	System.out.println(STR."GoodBye \{NAME.get()}!");
}