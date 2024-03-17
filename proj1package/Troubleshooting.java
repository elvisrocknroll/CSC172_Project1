package proj1package;
import java.lang.Error;

public class Troubleshooting {
	public static void stringTooLongError(int actual, int expected) {
		String message = "Input string wrong length, %d bytes with %d expected".formatted(actual, expected);
		throw new Error(message);
	}
	public static void mismatchedError(int n, int m) {
		String message = "Input string lengths mismatched (%d, %d)".formatted(n, m);
		throw new Error(message);
	}
}
