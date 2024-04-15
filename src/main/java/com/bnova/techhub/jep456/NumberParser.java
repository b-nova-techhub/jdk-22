void main(){
	var numberString = "a";
	oldStyle(numberString);
	newStyle(numberString);
}

private static void oldStyle(String numberString)
{
	try {
		int i = Integer.parseInt(numberString);
		System.out.println(STR."Number: \{i}");
	} catch (NumberFormatException ex) {
		System.out.println(STR."Bad number: \{numberString}");
	}
}

private static void newStyle(String numberString)
{
	try {
		int i = Integer.parseInt(numberString);
		System.out.println(STR."Number: \{i}");
	} catch (NumberFormatException _) {
		System.out.println(STR."Bad number: \{numberString}");
	}
}
