import proj1package.*;

public class encryptionTest {
	public static void main(String[] args) {
//		String block = "111001101101101001101100100110100100101101010010101011010101001010001101101101001101100100110100100101101010010101011010101001010001101101101001101100100110100100101101010010101011010101001010";
//		String inkey = "0010110101001010101101010100101000101101010010101011010101001010";
		String block = "1111111111111111111111111111111111111111111111111111111111111111";
		String inkey = "11111111111111111111111111111111111111111111111111111111";
		int[] ptest = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 110, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
		System.out.println(block.length());
		System.out.println(inkey.length());
		System.out.println(EncryptionTools.encryptBlock(block, inkey));
		System.out.println(EncryptionTools.decryptBlock(EncryptionTools.encryptBlock(block, inkey), inkey));
		System.out.println(BinaryTools.unpermuteIt(EncryptionTools.functionF(block.substring(0, 32), block.substring(0, 32))));
		BinaryTools.permuteInt(ptest);
	}
}
