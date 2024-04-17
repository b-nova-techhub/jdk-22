private final static ScopedValue<String> NAME = ScopedValue.newInstance();
private final static ScopedValue<String> AGE = ScopedValue.newInstance();

void main() throws Exception
{
	ScopedValue.where(NAME, "Tom").where(AGE, "27").run(() -> getInfo());
}

void getInfo()
{
	System.out.println(STR."Hello \{NAME.get()}!");
	System.out.println(STR."Age \{AGE.get()}!");
}