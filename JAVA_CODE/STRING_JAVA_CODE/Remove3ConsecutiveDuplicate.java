public class Remove3ConsecutiveDuplicate
{
	public String removeThreeConsecutiveDuplicate(String text)
	{
		if (text.length() < 2)
		{
			return text;
		}
		// Define some auxiliary variable
		int size = text.length() - 1;
		boolean task = false;
		int x = size;
		String result = "";
		String temp = "";
		int counter = 0;
		// Execute loop until when size is less than two
		while (size >= 0)
		{
			// Skip similar 3 adjacent characters
			while (size >= 0 && counter < 3 && text.charAt(x) == text.charAt(size))
			{
				temp = text.charAt(size) + temp;
				counter++;
				size--;
			}
			if (counter != 3)
			{
				// When adjacent are not same 
				// Then add new character at beginning of result
				result = temp + result;
			}
			else
			{
				task = true;
			}
			// Get new index
			x = size;
			counter = 0;
			temp = "";
		}
		if (task == true)
		{
			return removeThreeConsecutiveDuplicate(result);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
	String text = "zxxxxxzyyyzz";
		RemoveCharacters test = new RemoveCharacters();
		System.out.println(" Given Text : " + text);
		System.out.println(" Output     : " + test.removeAdjacent("zxxxxxzyyyzz"));
	}
}