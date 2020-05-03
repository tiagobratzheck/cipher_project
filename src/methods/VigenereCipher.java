package methods;

public class VigenereCipher {
		
	// ASCII: "H" is 72 && "S" is 83	
	public static String encrypt(String Message, String Key) {
		String EMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			if (letter == ' ') {
				EMessage += " ";
			} else {
				EMessage += (char) (((letter - 65) + (Key.charAt(j) - 65)) % 26 + 65);
				j = ++j % Key.length();
			}
		}
		return EMessage;
	}
	
	// ASCII: "Z" is 90 && "S" is 83	
	public static String decrypt(String Message, String Key) {
		String DMessage = "";			
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			if (letter == ' ') {
				DMessage += " ";
			} else {
				DMessage += (char) ((letter - Key.charAt(j) + 26) % 26 + 65);
				j = ++j % Key.length();
			}
		}
		return DMessage;
	}
}
