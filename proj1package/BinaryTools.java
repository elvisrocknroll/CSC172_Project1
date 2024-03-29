package proj1package;

/*
CSC 172 Project 1
Class BinaryTools
Elvis Imamura
Tiffany Xiang

contains methods for working with binary inputs
*/

import java.lang.StringBuilder;

public class BinaryTools {
	// Rijndael substitution box
	static String[][] S = new String[][] {
		{"01100011", "01111100", "01110111", "01111011", "11110010", "01101011", "01101111", "11000101", "00110000", "00000001", "01100111", "00101011", "11111110", "11010111", "10101011", "01110110"},
		{"11001010", "10000010", "11001001", "01111101", "11111010", "01011001", "01000111", "11110000", "10101101", "11010100", "10100010", "10101111", "10011100", "10100100", "01110010", "11000000"},
		{"10110111", "11111101", "10010011", "00100110", "00110110", "00111111", "11110111", "11001100", "00110100", "10100101", "11100101", "11110001", "01110001", "11011000", "00110001", "00010101"},
		{"00000100", "11000111", "00100011", "11000011", "00011000", "10010110", "00000101", "10011010", "00000111", "00010010", "10000000", "11100010", "11101011", "00100111", "10110010", "01110101"},
		{"00001001", "10000011", "00101100", "00011010", "00011011", "01101110", "01011010", "10100000", "01010010", "00111011", "11010110", "10110011", "00101001", "11100011", "00101111", "10000100"},
		{"01010011", "11010001", "00000000", "11101101", "00100000", "11111100", "10110001", "01011011", "01101010", "11001011", "10111110", "00111001", "01001010", "01001100", "01011000", "11001111"},
		{"11010000", "11101111", "10101010", "11111011", "01000011", "01001101", "00110011", "10000101", "01000101", "11111001", "00000010", "01111111", "01010000", "00111100", "10011111", "10101000"},
		{"01010001", "10100011", "01000000", "10001111", "10010010", "10011101", "00111000", "11110101", "10111100", "10110110", "11011010", "00100001", "00010000", "11111111", "11110011", "11010010"},
		{"11001101", "00001100", "00010011", "11101100", "01011111", "10010111", "01000100", "00010111", "11000100", "10100111", "01111110", "00111101", "01100100", "01011101", "00011001", "01110011"},
		{"01100000", "10000001", "01001111", "11011100", "00100010", "00101010", "10010000", "10001000", "01000110", "11101110", "10111000", "00010100", "11011110", "01011110", "00001011", "11011011"},
		{"11100000", "00110010", "00111010", "00001010", "01001001", "00000110", "00100100", "01011100", "11000010", "11010011", "10101100", "01100010", "10010001", "10010101", "11100100", "01111001"},
		{"11100111", "11001000", "00110111", "01101101", "10001101", "11010101", "01001110", "10101001", "01101100", "01010110", "11110100", "11101010", "01100101", "01111010", "10101110", "00001000"},
		{"10111010", "01111000", "00100101", "00101110", "00011100", "10100110", "10110100", "11000110", "11101000", "11011101", "01110100", "00011111", "01001011", "10111101", "10001011", "10001010"},
		{"01110000", "00111110", "10110101", "01100110", "01001000", "00000011", "11110110", "00001110", "01100001", "00110101", "01010111", "10111001", "10000110", "11000001", "00011101", "10011110"},
		{"11100001", "11111000", "10011000", "00010001", "01101001", "11011001", "10001110", "10010100", "10011011", "00011110", "10000111", "11101001", "11001110", "01010101", "00101000", "11011111"},
		{"10001100", "10100001", "10001001", "00001101", "10111111", "11100110", "01000010", "01101000", "01000001", "10011001", "00101101", "00001111", "10110000", "01010100", "10111011", "00010110"}
	};
	// Permutation box
	static int[] P = new int[] {
		16,  7, 20, 21, 29, 12, 28, 17,
		1,  15, 23, 26,  5, 18, 31, 10,
		2,   8, 24, 14, 32, 27,  3,  9,
		19, 13, 30,  6, 22, 11,  4, 25
	};
	public static String xorIt(String binary1, String binary2) {
		// custom XOR gate evaluated between two binary strings
		StringBuilder binaryOut = new StringBuilder();
		int n = binary1.length();
		if (n != binary2.length()) {
			Troubleshooting.mismatchedError(n, binary2.length());
		}
		for (int i = 0; i < n; i++) {
			if (binary1.charAt(i) == binary2.charAt(i)) {
				binaryOut.append("0");
			}
			else {
				binaryOut.append("1");
			}
		}
		return binaryOut.toString();
	}
	public static String unxorIt(String xored, String key) {
		// returns the second input of a XOR gate given the output and one input
		StringBuilder binaryOut = new StringBuilder();
		int n = xored.length();
		if (n != xored.length()) Troubleshooting.mismatchedError(n, xored.length());
		for (int i = 0; i < n; i++) {
			switch (xored.charAt(i)) {
			case '0':
				binaryOut.append(key.charAt(i));
				break;
			case '1':
				binaryOut.append((key.charAt(i) == '1') ? '0' : '1');
				break;
			}
		}
		return binaryOut.toString();
	}
	public static String shiftIt(String binaryInput) {
		// moves the last element of the binary string to the beginning
		int n = binaryInput.length();
		StringBuilder binaryOut = new StringBuilder();
		binaryOut.append(binaryInput.substring(1, n));
		binaryOut.append(binaryInput.charAt(0));
		return binaryOut.toString();		
	}
	public static String unshiftIt(String binaryInput) {
		// moves the first element of the binary string to the end
		int n = binaryInput.length();
		StringBuilder binaryOut = new StringBuilder();
		binaryOut.append(binaryInput.charAt(n-1));
		binaryOut.append(binaryInput.substring(0, n-1));
		return binaryOut.toString();		
	}
	public static String permuteIt(String binaryInput) {
		// uses permutation P to reorganize elements in a 32-bit binary string
		if (binaryInput.length() != P.length) {
			Troubleshooting.stringTooLongError(binaryInput.length(), 32);
		}
		char[] binaryOut = new char[32];
		for (int i = 0; i < 32; i++) {
			binaryOut[i] = binaryInput.charAt(P[i] - 1);
		}
		return String.valueOf(binaryOut);
	}
	public static String unpermuteIt(String binaryInput) {
		// undoes permuted binary string with permutation P
		if (binaryInput.length() != P.length) {
			Troubleshooting.stringTooLongError(binaryInput.length(), 32);
		}
		char[] binaryOut = new char[32];
		for (int i = 0; i < 32; i++) {
			binaryOut[P[i] - 1] = binaryInput.charAt(i);
		}
		return String.valueOf(binaryOut);
	}
	public static String SubstitutionS(String binaryInput) {
		// uses the substitution box to output a binary string using the first and last 4 bits in an 8-bit binary string
		int row = Integer.parseInt(binaryInput.substring(0, 4), 2);
		int column = Integer.parseInt(binaryInput.substring(4, 8), 2);
		return S[row][column];
	}
	public static String unSubstitutionS(String binaryInput) {
		// returns the concatenated row and column indices for a given S-box cell
		for (int row = 0; row < 16; row++) {
			for (int column = 0; column < 16; column++) {
				if (S[row][column].equals(binaryInput)) {
					return intToBinary(row) + intToBinary(column);
	 			}
			}
		}
		return null;
	}
	public static String intToBinary(int num) {
		// converts an integer to a 4 bit binary string
		char[] binaryOut = new char[] {'0', '0', '0', '0'};
		int pow2 = 8;
		for (int i = 0; i < 4; i++) {
			if (num % pow2 == 0) {
				binaryOut[i] = '1';
				num = num / pow2;
			}
			pow2 = pow2/2;
		}
		return String.valueOf(binaryOut);
	}
}
