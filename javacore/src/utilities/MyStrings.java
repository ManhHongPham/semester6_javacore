package utilities;

import java.util.HashMap;
import java.util.Map.Entry;

import obj.Person;

import java.util.*;

public class MyStrings {
	/**
	 * đếm số kí tự có trong 1 chuỗi
	 * 
	 * @param str
	 * @param ch
	 * @return
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count = 0;

		// nếu có bỏ quả kiểu chữ HOA-thường
		if (isIgnoreCase) {
			str = str.toLowerCase();// chuyển về chữ thường
			ch = Character.toLowerCase(ch);// là dữ liệu nguyên thủy nên phải gọi đến lớp
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Đếm số từ của một chuỗi, giả sử các từ được ngăn cách nhau bởi một hoặc nhiều
	 * dấu 'space', tab '\t' và xuống dòng '\n'
	 * 
	 * @param input - chuỗi ký tự
	 * @return số từ của chuỗi ký tự input
	 */
	public static int countCharacter(String input) {
		// khai báo phần tử loại bỏ
		char SPACE = ' ';
		char TAB = '\t';
		char BREAK_LINE = '\n';
		// kiểm tra chuỗi có khác 0 hay k
		if (input == null) {
			return -1;
		}

		int count = 0; // đếm số lượng từ có trong chuỗi
		int size = input.length();// độ dài chuỗi
		boolean notCounted = true;

		for (int i = 0; i < size; i++) {
			if (input.charAt(i) != SPACE && input.charAt(i) != TAB && input.charAt(i) != BREAK_LINE) {
				if (notCounted) {
					count++;
					notCounted = false;
				}
			} else {
				notCounted = true;
			}
		}
		return count;
	}

	/**
	 * chuẩn hóa chuỗi
	 * 
	 * @param str
	 * @return
	 */
	public static String formatString(String str) {
		// list characters special
		char[] chs = { '`', '~', '!', '@', '#', '$', '%', '*', '&', '(', ')', '_', '-', '+', '=', '<', ',', '>', '.',
				'/', '?', '"', ';', ':', '"', '[', '{', ']', '}', '|', '\\', '\t' };
		// remove characters special from string
		for (char c : chs) {
			str = str.replace(c, ' ');
		}
		// remove character space
		str = str.trim();
		while (str.indexOf("  ") != -1) {
			str = str.replace("  ", " ");
		}
		return str;
	}

	public static int countWords(String str) {
		// format string
		str = MyStrings.formatString(str);
		return MyStrings.countChar(str, ' ', false) + 1;
	}

	/**
	 * tim tan xuat xuat hien cua 1 ki tu
	 * 
	 * @param str
	 * @return
	 */
	public static ArrayList<String> frequencyChar(String str, boolean isIgnoreCase) {
		ArrayList<String> fres = new ArrayList<>(); // do str ban dau k biet co bn ki tu
		// lấy các kí tự khác nhau trong chuỗi
		if (isIgnoreCase) {
			str = str.toUpperCase();
		}
		// lấy các ký tự khác nhau trong chuỗi
		String chs = "";
		char ch;
		String tmp = str.trim();// nếu tìm đc thì xóa những thứ còn lại

		for (int i = 0; i < tmp.length(); i++) {
			ch = tmp.charAt(i);
			if (ch != ' ') {
				chs += ch; // nỗi chuỗi
				tmp = tmp.replace(ch, ' '); // nếu nỗi đc chuỗi r sau lần duyệt tiếp theo nếu thấy thì xóa đi
			}
		}
		// đếm số lượng các kí tự
		int count;
		for (int i = 0; i < chs.length(); i++) {
			ch = chs.charAt(i);
			count = MyStrings.countChar(str, ch, isIgnoreCase);

			fres.add("(" + ch + "," + count + ")");
		}
		return fres;
	}

	/**
	 * phương thức đếm số chuỗi có trong 1 chuỗi lớn hơn
	 * 
	 * @param str
	 * @param strFind
	 * @return
	 */
	public static int countWord(String str, String strFind) {
		int count = 0;
		String[] inputs = str.split(" ");
		for (int j = 0; j < inputs.length; j++) {
			if (inputs[j].contains(strFind)) {
				count++;
			}
		}
		return count;
	}

	public static ArrayList<String> frequencyWord(String string, boolean isIgnoreCase) {
		ArrayList<String> fres = new ArrayList<>();

		String[] words = string.split(" ");
		int count = 0;
		String word = " ";
		String a;
		String tmp = string.trim();
		for (int i = 0; i < words.length; i++) {
			a = words[i];
			if (a != " ") {
				word += a;
				tmp = tmp.replace(a, " ");
			}
		}

		for (int i = 0; i < word.length(); i++) {
			word = words[i];
			count = MyStrings.countWord(string, words[i]);
			fres.add("(" + word + "," + count + ")");
		}
		return fres;
	}

	// B1
	static void characterCount(String inputString) {
		// Creating a HashMap containing char
		// as a key and occurrences as a value
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		// Converting given string to char array

		char[] strArray = inputString.toCharArray();

		// checking each char of strArray
		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {

				// If char is present in charCountMap,
				// incrementing it's count by 1
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				charCountMap.put(c, 1);
			}
		}

		// Printing the charCountMap
		for (Map.Entry entry : charCountMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	// B2
	public static void countWordsSpecial(String a) {

		Map<String, String> map = new HashMap<String, String>();

		if (a != null) {
			String[] separatedWords = a.split("#");
			for (String str : separatedWords) {
				if (map.containsKey(str)) {
					int count = Integer.parseInt(map.get(str));
					map.put(str, String.valueOf(count + 1));
				} else {
					map.put(str, "1");
				}
			}
		}

		System.out.println("Count :- " + map);
	}

	/**
	 * tần xuất xuất hiện từng từ nếu chưa có key(word) thì put key vs value=1, nếu
	 * có thì replace = value +1 của key
	 * 
	 * @param str
	 * @return
	 */
	public static HashMap<String, Integer> countEachWord(String str) {
		// use hashmap để mô tả từng từ trong str ứng vs value
		HashMap<String, Integer> map = new HashMap<String, Integer>(); // create 1 tập entry

		String[] listWords = str.split("#");
		for (String string : listWords) {
			if (map.containsKey(string)) { // kt xem trong map có chưa
				map.replace(string, map.get(string) + 1); // có r thì cập nhật lại
			} else {// chưa thì thêm vào map
				map.put(string, 1);
			}
		}
		map.remove("");
		return map;

	}

	public static void testCount(String str) {
		for (Entry<String, Integer> entry : MyStrings.countEachWord(str).entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	/**
	 * lấy ra số kí tự cần tìm từ chuỗi đã đc chuẩn hóa, i đi từ 0 chỉ vào dấu cách,
	 * khi i tại vị trí cách count tăng lên 1 bằng đúng sl từ cần đếm
	 * 
	 * cắt nếu vị trí cắt ở giữa 1 từ thì phải cắt ở vị trí tiếp theo eg: cắt ở vị
	 * trí ã thì chuyển sang từ ms, nếu x thì lấy từ xã
	 * 
	 * @param str    -chuỗi cần cắt
	 * @param nWords -số lượng cắt
	 * @param atPos  - cắt từ vị trí nào
	 * @return
	 */
	public static String getWordds(String str, byte nWords, byte atPos) {
		// chuan hoa
		str = MyStrings.formatString(str);

		// cat chuoi theo adpost
		str = str.substring(atPos);

		// xac dinh vi tri can cat
		int begin = 0;
		int i = 0;
		int count = 0; // dem so dau cach
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				if (atPos == 0) {
					begin = 0;
					count++;
				} else {
					if (atPos == i) {
						if (begin == 0) {
							begin = i;
						} else {
							count++;
						}

					} else {
						if (begin == 0) {
							begin = i + 1;
						} else {
							count++;
						}
					}
				}
			}
			if (count >= nWords) {
				break;
			}
		}
		// tra ve ket qua tại vị trí 1 là kí tự cách nếu k trừ đi 1, thì sẽ bằng chỉ số
		// chứ k bằng sl thực
		if (i < str.length() - 1) {
			return str.substring(begin, i) + "...";
		} else {
			return str.substring(begin);
		}
	}

	public static void main(String[] args) {
//		String str = "can you tell me why don't you smile if you smile you can bla bla bla";
//		String str2 = "son#####balo#bla#bla###son";
//		String str3 = "cộng	hòa			xã		hội 		chủ	nghĩa 		việt		nam";
//		System.out.println("số ký tự o là: " + MyStrings.countChar(str, 'o', true));
//		System.out.println("số từ trong str là: " + MyStrings.countCharacter(str));
//		System.out.println("số lượng từ 'of' có trong str là:" + MyStrings.countWord(str, str2));
//		System.out.println("số từ trong str là: " + MyStrings.countWords(str));
//		System.out.println(MyStrings.frequencyChar(str, true));
//		System.out.println(MyStrings.frequencyWord(str, false));
//		System.out.println(MyStrings.countCharacter(str));
//		MyStrings.countWordsSpecial(str);
		// testCount(str2);
//		System.out.println(MyStrings.getWordds(str3, (byte) 4, (byte) 9));
		
		
		
	}
}
