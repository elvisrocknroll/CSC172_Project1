import proj1package.*;

public class encryptBlockTest {
	public static void main(String[] args) {
		String block = "1001101101101001101100100110100100101101010010101011010101001010";
		String inkey = "0010110101001010101101010100101000101101010010101011010101001010";
		System.out.println(block.length());
		System.out.println(inkey.length());
		System.out.println(EncryptionTools.encryptBlock(block, inkey));
	}
}
