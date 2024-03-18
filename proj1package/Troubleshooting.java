package proj1package;
import java.lang.Error;

/*
CSC 172 Project 1
Class Troubleshooting
Elvis Imamura
Tiffany Xiang

contains custom errors in order to debug encryption/decryption methods
*/

public class Troubleshooting {
	// error when string length does not match expected length
	public static void stringTooLongError(int actual, int expected) {
		String message = "Input string wrong length, %d bytes with %d expected".formatted(actual, expected);
		throw new Error(message);
	}
	public static void mismatchedError(int n, int m) {
	// error when input string lengths do not match
		String message = "Input string lengths mismatched (%d, %d)".formatted(n, m);
		throw new Error(message);
	}
}
