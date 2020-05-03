package program;

import java.security.KeyPair;
import java.text.DecimalFormat;
import java.util.Scanner;

import methods.RsaCipher;
import services.CipherService;

public class UserMenu {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		System.out.println("--- Bem vindo ao sistema de criptografia Vigenere + RSA ---\n");
		
		mainMenu();

	}

	public static void mainMenu() throws Exception {
		
		System.out.println("\t\t Menu de criptografia Vigenere e RSA\n");		

		System.out.print("\t\t Digite a chave VIGENERE com letras MAIÚSCULAS: ");
		String key = input.next();
		input.nextLine();
		System.out.print("\t\t Digite a mensagem a ser encriptada: ");
		String EMessage = input.nextLine();

		System.out.print("\t\t Digite sua chave PRIVADA: ");
		String privateKey = input.next(); // private key is CHAVE

		long start = System.nanoTime();
		KeyPair pair = RsaCipher.generateKeyPair();
		String cipherText = CipherService.cipherServiceEncrypt(key, EMessage, pair, privateKey);
		long elapsed = System.nanoTime();
		double elapsedTimeInSecond = (double) (elapsed - start) / 1_000_000_000;

		System.out.println("\t Mensagem encryptada: " + cipherText + "\n");
		System.out.println("\t Processo executado em: " + new DecimalFormat("#.##########").format(elapsedTimeInSecond)
				+ " segundos \n\n");

		Thread.sleep(1000);
		System.out.println("\t Iniciando o processo de decriptação da mensagem...\n");
		Thread.sleep(1000);
		System.out.println("\t\t Bem vindo novo usuário! \n");
		System.out.println("\t\t Você receberá uma chave privada... Cuide bem dela!\n");
		Thread.sleep(1500);
		System.out.println("\t KEY = " + privateKey + "\n");
		System.out.print("\t\t Informe a chave privada para decriptar a mensagem acima: ");
		String privateKeyUser = input.next();

		long start2 = System.nanoTime();
		String decryptMessage = CipherService.cipherServiceDecrypt(key, cipherText, pair, privateKeyUser);
		long elapsed2 = System.nanoTime();
		double elapsedTimeInSecond2 = (double) (elapsed2 - start2) / 1_000_000_000;

		System.out.println("\t Mensagem decriptada: " + decryptMessage + "\n");
		System.out.println("\t Processo executado em: " + new DecimalFormat("#.##########").format(elapsedTimeInSecond2)
				+ " segundos \n\n");

		mainMenu();
		
	}

}
