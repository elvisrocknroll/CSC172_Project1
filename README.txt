CSC 172 Project 1
Elvis Imamura
Tiffany Xiang 

class BinaryTools - Elvis Imamura
	xorIt(binary1, binary2)
	unxorIt
	shiftIt(binaryInput)
	unshiftIt
	permuteIt(binaryInput)
	unpermuteIt
	SubstitutionS(binaryInput)
	unSubstitutionS

class Troubleshooting - Elvis Imamura
	stringTooLongError(actual, expected)
	mismatchedError(n, m)

class EncryptionTools - collaborative (Elvis Imamura, Tiffany Xiang)
	functionF(rightHalf, subkey)
	encryptBlock(block, inputKey)
	decryptBlock(block, inputKey)
	encryption(longBinaryInput, inputKey)
	decryption(longBinaryInput, inputKey)
	keyScheduleTransform(inputKey)

Class ReadWrite - Tiffany Xiang
	readFile(filename)
	writeFile(filename, content)

Class Project1Main - Tiffany Xiang
	runTests()
	userInput()
