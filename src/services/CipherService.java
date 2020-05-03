package services;

import java.security.KeyPair;

import methods.RsaCipher;
import methods.VigenereCipher;
import program.UserMenu;

public class CipherService {
	
	
	public static String cipherServiceEncrypt(String key, String eMessage, KeyPair pair, String privateKey) throws Exception {

		String signature = RsaCipher.sign(privateKey, pair.getPrivate());
		boolean isCorrect = RsaCipher.verify(privateKey, signature, pair.getPublic());
		if (isCorrect == true) {
			String encryptMessage = VigenereCipher.encrypt(eMessage, key);
			String cipherText = RsaCipher.encrypt(encryptMessage, pair.getPublic());
			return cipherText;
		} else {
			System.out.println("\t\t Chave privada incorreta, o texto não será encriptado \n");
			UserMenu.mainMenu();
		}
		return null;
	}
	

	public static String cipherServiceDecrypt(String key, String cipherText, KeyPair pair, String privateKeyUser) throws Exception {

		String signature = RsaCipher.sign(privateKeyUser, pair.getPrivate());
		boolean isCorrect = RsaCipher.verify(privateKeyUser, signature, pair.getPublic());
		if (isCorrect == true) {
			String decipheredMessage = RsaCipher.decrypt(cipherText, pair.getPrivate());
			String decryptMessage = VigenereCipher.decrypt(decipheredMessage, key);
			return decryptMessage;
		} else {
			System.out.println("\t\t Chave privada incorreta, o texto não será decriptado \n");
			UserMenu.mainMenu();
		}
		return null;
	}

}
