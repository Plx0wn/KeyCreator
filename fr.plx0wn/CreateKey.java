package fr.plx0wn;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Random;

public class CreateKey {

	private static String randomLetter(boolean uppercase, boolean special) {
		Random r = new Random();
		int chance1 = r.nextInt(2);
		int chance2 = r.nextInt(2);

		if (special) {
			if (chance1 == 0) {
				char lttr = (char) (r.nextInt(26) + 'a');
				String str = "" + lttr;
				if (uppercase) {
					if (chance2 == 0) {
						return str.toUpperCase();
					} else {
						return str;
					}
				} else {
					return str;
				}
			} else {
				return randomSpecialCharacter();
			}
		} else {
			char lttr = (char) (r.nextInt(26) + 'a');
			String str = "" + lttr;
			if (uppercase) {
				if (chance2 == 0) {
					return str.toUpperCase();
				} else {
					return str;
				}
			} else {
				return str;
			}
		}
	}

	private static int randomNumber() {
		Random r = new Random();
		return r.nextInt(9);
	}

	private static String randomSpecialCharacter() {
		Random r = new Random();
		String[] listCharacter = { "{", "}", "[", "]", "@", "?", "!", "/", "&", "~" };
		return listCharacter[r.nextInt(listCharacter.length)];
	}

	public static String KeyGenerator(int size, boolean number, boolean letter, boolean special, boolean uppercase) {
		Random r = new Random();
		String key = "";
		for (int i = 0; i < size; i++) {
			int chance = r.nextInt(2);
			if ((number) || (letter)) {
				if ((number) && (letter)) {
					if (chance == 0) {
						key = key + randomNumber();
					} else {
						key = key + randomLetter(uppercase, special);
					}
				} else {
					if (number) {
						key = key + randomNumber();
					}
					if (letter) {
						key = key + randomLetter(uppercase, special);
					}
				}
			}
		}
		StringSelection selection = new StringSelection(key);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		return key;
	}
}
