import proj1package.*;

public class Project1Main {

	static String allones64 = "1111111111111111111111111111111111111111111111111111111111111111";
	static String allzeroes64 = "0000000000000000000000000000000000000000000000000000000000000000";
	static String block1 = "1100110010000000000001110101111100010001100101111010001001001100";
	static String block2 = "0101011010001110111001000111100001001110010001100110000011110101";
	static String block3 = "0011000101110111011100100101001001001101011010100110011111010111";
	
	public static void main(String[] args) {
		runTests();
	}
	static void runTests() {
		System.out.println(EncryptionTools.encryptBlock(allones64, allones64));
		System.out.println(EncryptionTools.encryptBlock(allzeroes64, allones64));
		System.out.println(EncryptionTools.encryptBlock(allzeroes64, allzeroes64));
		System.out.println(EncryptionTools.encryptBlock(block1, allzeroes64));
		System.out.println(EncryptionTools.decryptBlock(allones64, allones64));
		System.out.println(EncryptionTools.decryptBlock(allzeroes64, allones64));
		System.out.println(EncryptionTools.decryptBlock(allzeroes64, allzeroes64));
		System.out.println(EncryptionTools.decryptBlock(block2, allones64));
		System.out.println(EncryptionTools.decryptBlock(block3, allzeroes64));
	}
}
