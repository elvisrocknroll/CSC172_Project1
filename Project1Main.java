import proj1package.*;
import java.util.Scanner;

/*
CSC 172 Project 1
Class BinaryTools
Elvis Imamura
Tiffany Xiang

main class, contains test cases and user input section
*/

public class Project1Main {

	static String allones64 = "1111111111111111111111111111111111111111111111111111111111111111";
	static String allzeroes64 = "0000000000000000000000000000000000000000000000000000000000000000";
	static String block1 = "1100110010000000000001110101111100010001100101111010001001001100";
	static String block2 = "0101011010001110111001000111100001001110010001100110000011110101";
	static String block3 = "0011000101110111011100100101001001001101011010100110011111010111";
	
	public static void main(String[] args) {
		runTests();
		userInput();
	}
	static void runTests() {
		// runs all specified tests
		System.out.println("Output for: encryption(all ones, all ones)");
		System.out.println(EncryptionTools.encryption(allones64, allones64));
		System.out.println("Output for: encryption(all zeroes, all ones)");
		System.out.println(EncryptionTools.encryption(allzeroes64, allones64));
		System.out.println("Output for: encryption(all zeroes, all zeroes)");
		System.out.println(EncryptionTools.encryption(allzeroes64, allzeroes64));
		System.out.println("Output for: encryption(block, all zeroes), where:\nblock = " + block1);
		System.out.println(EncryptionTools.encryption(block1, allzeroes64));
		System.out.println("Output for: decryption(all ones, all ones)");
		System.out.println(EncryptionTools.decryption(allones64, allones64));
		System.out.println("Output for: decryption(all zeroes, all ones)");
		System.out.println(EncryptionTools.decryption(allzeroes64, allones64));
		System.out.println("Output for: decryption(all zeroes, all zeroes)");
		System.out.println(EncryptionTools.decryption(allzeroes64, allzeroes64));
		System.out.println("Output for: decryption(block, all ones), where:\nblock = " + block2);
		System.out.println(EncryptionTools.decryption(block2, allones64));
		System.out.println("Output for: decryption(block, all zeroes), where:\nblock = " + block3);
		System.out.println(EncryptionTools.decryption(block3, allzeroes64));
	}
	static void userInput() {
		// takes user input and performs encryption/decryption
		Scanner s = new Scanner(System.in);
		System.out.print("Do you want to encrypt or decrypt (E/D): ");
		char mode = s.next().charAt(0);
		System.out.print("Filename: ");
		String infile = ReadWrite.readFile(s.next());
		System.out.print("Secret key: ");
		String key = s.next();
		String crypt = "";
		switch (mode) {
			case 'E':
				crypt = EncryptionTools.encryption(infile, key);	
				break;
			case 'D':
				crypt = EncryptionTools.decryption(infile, key);	
				break;
		}
		System.out.print("Output file: ");
		String outfile = s.next();
		ReadWrite.writeFile(outfile, crypt);
	}
}
