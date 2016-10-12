///////////////////////////////////////
/*

 WordCount - count of lines, words & sentence characters from standard input.

 Test Case sample:
 1. Check multiple line split
 2. Check ? and . sentence terminator
 3. Check First char is Uppercase  or not after ? and . on multiple line by boolean variables

 Example:

 OMG I LOVE it. OMG. I LOVE it
 OMG. I LOVE it?
 OMG! I LOVE it.

 */
/////////////////////////////////////////////
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner sysIn = new Scanner(System.in);
		long nl = 0L; // #lines
		long nw = 0L; // #words
		long nc = 0L; // #chars
		long ns = 0L; // #Sentence
		String delimiters = "?.";
		String worddelimiters = "?!.";
		String s;
		boolean inword = false; // true only when inside a word
		boolean sentenceCheck = false;
		// boolean endofFileCheck = false;
		while (sysIn.hasNextLine()) {

			s = sysIn.nextLine(); // restore line separator
			++nl;
			nc += s.length();

			// // Sentence Count Begin

			int k = 0;
			// / Check multiple line First is sentenceCheck is true
			if (sentenceCheck == true) {
				// System.out.printf(" test 1 ==== %d lines, %d words, %d chars%n,%d sentence %n ",
				// nl, nw, nc,ns);
				if (s.isEmpty()) {
					sentenceCheck = true;
				}
				sentenceCheck = false;

				boolean setenceFound = false;
				for (k = 0; k < s.length(); ++k) {
					// System.out.printf(" ti m error " + k);
					if ((Character.isUpperCase(s.charAt(k)))) {
						setenceFound = true;
						break;
					}
					if (Character.isWhitespace(s.charAt(k))) {
						// if whitespace, we're not inside a word
						continue;
					}
					if (s.charAt(k) == '\n') {
						// if whitespace, we're not inside a word
						sentenceCheck = true;
						break;
					}
					// System.out.printf(" ti m error 1");

					if ((Character.isLowerCase(s.charAt(k)))) {
						setenceFound = false;
						break;
					}

				}
				if (setenceFound) {
					// System.out.printf(" ti m error ==== %d lines, %d words, %d chars%n,%d sentence %n ",
					// nl, nw, nc,ns);
					ns++;
				}
			}
			// // General Check
			for (int z = k; z < s.length(); ++z) {
				// System.out.printf(" test 1 ==== %d lines, %d words, %d chars%n,%d sentence %n ",
				// nl, nw, nc,ns);

				if ((delimiters.indexOf(s.charAt(z)) != -1)) {
					// If the delimiters string contains the character
					boolean setenceFound1 = false;
					int j = z;
					// System.out.println(s.charAt(j));
					// System.out.println(s.length());
					// System.out.println(j);
					if ((j == (s.length() - 1))
							&& (delimiters.indexOf(s.charAt(z)) != -1)) {
						sentenceCheck = true;

						// System.out.printf("%d lines, %d words, %d chars%n,%d sentence %n ",
						// nl, nw, nc,ns);
						continue;
					}
					sentenceCheck = false;
					for (; j < s.length(); ++j) {
						if (Character.isWhitespace(s.charAt(j))) {
							// if whitespace, we're not inside a word
							continue;
						}

						if ((Character.isUpperCase(s.charAt(j)))) {
							setenceFound1 = true;
							break;
						}
						if ((Character.isLowerCase(s.charAt(j)))) {
							setenceFound1 = false;
							break;
						}
					}

					if (setenceFound1) {
						ns++;
					}

				}
			}

			// // Sentence Count End
			boolean checkWordWhiteSpace = false;
			for (int i = 0; i < s.length(); ++i) {

				if (Character.isWhitespace(s.charAt(i))) {
					// if whitespace, we're not inside a word
					inword = false;
				} else if (!inword) {
					inword = true;
					++nw;
				}
				if ((i == (s.length() - 1))
						&& (worddelimiters.indexOf(s.charAt(i)) != -1)) {
					++nw;
				}
			}
			// System.out.printf("Line u End === %d lines, %d words, %d chars%n,%d sentence %n ",
			// nl, nw, nc, ns);

		}
		if (sentenceCheck == true) {
			ns++;
		}
		System.out.printf("%d lines, %d words, %d chars%n,%d sentence %n ", nl,
				nw, nc, ns);

		sysIn.close();
		return;
	}
}