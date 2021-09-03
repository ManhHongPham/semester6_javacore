package io;

import java.io.*;

public class TestStream2 {
	public static void main(String[] args) {
		String msg = "cập nhật dữ liệu từ chương trình lớn";
		StringReader in2 = new StringReader(msg);

		// xác định tệp tin ghi data
		FileWriter out2;
		try {
			out2 = new FileWriter("data2.txt");
			Stream.copy(in2, out2);

			in2.close();
			out2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
