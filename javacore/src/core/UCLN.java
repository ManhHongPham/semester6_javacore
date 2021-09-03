package core;

public class UCLN {
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
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

			ucln = a;// ucln = b;

		}
		return ucln;
	}

	public int getUCLN(int a, int b, int c) {
		return getUCLN(getUCLN(a, b), c);
	}
}
