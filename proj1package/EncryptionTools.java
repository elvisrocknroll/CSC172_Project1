package proj1package;

/*
CSC 172 Project 1
Elvis Imamura
Tiffany Xiang
class EncryptionTools
contains methods used in the encryption process
*/

public class EncryptionTools {
	public static String functionF(String rightHalf, String subkey) {
		// round function f
		if (rightHalf.length() != subkey.length()) Troubleshooting.mismatchedError(rightHalf.length(), subkey.length());
		if (rightHalf.length() != 32) Troubleshooting.stringTooLongError(rightHalf.length(), 32);
		if (subkey.length() != 32) Troubleshooting.stringTooLongError(subkey.length(), 32);
		String xored = BinaryTools.xorIt(rightHalf, subkey);
		String binaryOut = BinaryTools.SubstitutionS(xored.substring(0, 8)) + 
			BinaryTools.SubstitutionS(xored.substring(8, 16)) + 
			BinaryTools.SubstitutionS(xored.substring(16, 24)) + 
			BinaryTools.SubstitutionS(xored.substring(24, 32));
		return BinaryTools.permuteIt(binaryOut);
	}
	public static String unfunctionF(String rightHalf, String subkey) {
		// undoes a round function f transform
		if (rightHalf.length() != subkey.length()) Troubleshooting.mismatchedError(rightHalf.length(), subkey.length());
		if (rightHalf.length() != 32) Troubleshooting.stringTooLongError(rightHalf.length(), 32);
		if (subkey.length() != 32) Troubleshooting.stringTooLongError(subkey.length(), 32);
		String unperm = BinaryTools.unpermuteIt(rightHalf);
		String unsub = BinaryTools.unSubstitutionS(unperm.substring(0, 8)) +
			BinaryTools.unSubstitutionS(unperm.substring(8, 16)) +
			BinaryTools.unSubstitutionS(unperm.substring(16, 24)) +
			BinaryTools.unSubstitutionS(unperm.substring(24, 32));
		return BinaryTools.unxorIt(unsub, subkey);
	}
	public static String encryptBlockRound(String block, String inputKey) {
		// completes one round of encryption
		if (block.length() != 64) Troubleshooting.stringTooLongError(block.length(), 64);
		String L0 = block.substring(0, 32);
		String R0 = block.substring(32, 64);
		String subkey = inputKey.substring(0, 32);
		String L1 = R0;
		String R1 = BinaryTools.xorIt(L0, functionF(R0, subkey));
		return L1 + R1;
	}
	public static String decryptBlockRound(String block, String inputKey) {
		// completes one round of decryption
		if (block.length() != 64) Troubleshooting.stringTooLongError(block.length(), 64);
		String L1 = block.substring(0, 32);
		String R1 = block.substring(32, 64);
		String subkey = inputKey.substring(0, 32);
		String L0 = BinaryTools.unxorIt(R1, functionF(L1, subkey));
		String R0 = L1;
		return L0 + R0;
	}
	public static String encryptBlock(String block, String inputKey) {
		// completes 10 rounds of encryption
		for (int i = 0; i < 10; i++) {
			inputKey = keyScheduleTransform(inputKey);
			block = encryptBlockRound(block, inputKey);
		}
		return block;
	}
	public static String decryptBlock(String block, String inputKey) {
		// completes 10 rounds of decryption by using subkeys in reverse order
		String[] keys = new String[10];
		for (int i = 0; i < 10; i++) {
			inputKey = keyScheduleTransform(inputKey);
			keys[i] = inputKey;
		}
		for (int i = 9; i >= 0; i--) {
			block = decryptBlockRound(block, keys[i]);
		}
		return block;
	}
	public static String keyScheduleTransform(String inputKey) {
		// transforms key by left shifting both halves
		int n = inputKey.length();
		String c0 = inputKey.substring(0, n/2);
		String d0 = inputKey.substring(n/2, n);
		String c1 = BinaryTools.shiftIt(c0);
		String d1 = BinaryTools.shiftIt(d0);
		return c1 + d1;
	}
	public static String encryption(String longBinaryInput, String inputKey) {
		// encrypts a long binary string by separating into 64 bit blocks
		String longBinaryOutput = "";
		int start = 0;
		int end = start + 64;
		while (start != longBinaryInput.length()) {
			longBinaryOutput += encryptBlock(longBinaryInput.substring(start, end), inputKey);
			start += 64;
			end += 64;
		}
		return longBinaryOutput;
	}
	public static String decryption(String longBinaryInput, String inputKey) {
		// decrypts a long binary string by separating into 64 bit blocks
		String longBinaryOutput = "";
		int start = 0;
		int end = start + 64;
		while (start != longBinaryInput.length()) {
			longBinaryOutput += decryptBlock(longBinaryInput.substring(start, end), inputKey);
			start += 64;
			end += 64;
		}
		return longBinaryOutput;
	}
}
