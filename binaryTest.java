import proj1package.BinaryTools;
// tests the methods in BinaryTools class
public class binaryTest {
	public static void main(String[] args) {
		String test8bit1 = "01011010";
		String test8bit2 = "01010110";
		String test32bit = "10110010011001101100110101101001";
		String test8bitones = "11111111";
		String test32bitones = "01111111111111111111111111111111";
		System.out.println("8 bit 1:  " + test8bit1);
		System.out.println("8 bit 2:  " + test8bit2);
		System.out.println("XOR test: " + BinaryTools.xorIt(test8bit1, test8bit2));
		System.out.println("Shift test 1: " + BinaryTools.shiftIt(test8bit1));
		System.out.println("P test: " + BinaryTools.permuteIt(test32bitones));
		System.out.println("S box 1: " + BinaryTools.SubstitutionS(test8bitones));
	}
}
