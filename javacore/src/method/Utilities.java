package method;

import core.UCLN;

public class Utilities {
	/**
	 * phương thức lấy giá trị ngẫu nhiên và trả về giá trị MAX_VALUE
	 * @param MAX_VALUE
	 * @return
	 */
	public static int randomValue(int MAX_VALUE) {
		return (int) (Math.random() * MAX_VALUE);
	}

	
	public static boolean isPrime(int n) {
		boolean flag = true;
		if (n < 2) {
			flag = false;
		} else {
			for (int v = 2; v <= (int) (Math.sqrt(n)); v++) {
				if (n % v == 0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	public int getUCLN(int a, int b) {
		int ucln = -1;

		if (a * b != 0) {
			while (a != b) {
				if (a > b) {
					a -= b;
				} else {
					b -= a;
				}
			}
			ucln = a;

		}
		return ucln;
	}

	public int getUCLN(int a, int b, int c) {
		return getUCLN(getUCLN(a, b), c);
	}
}
