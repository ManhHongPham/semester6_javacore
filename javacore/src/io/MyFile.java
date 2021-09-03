package io;

import java.io.IOException;
import java.io.*;;

public class MyFile {
	public static void textOutputFile() throws IOException {
		// xác định tệp tin để ghi dữ liệu vào
		FileWriter outFileWriter = new FileWriter("danhsach.txt");

		// xác đinh đối tượng thực hiện nhiệm vụ xuất dữ liệu ra file
		PrintWriter out = new PrintWriter(outFileWriter);

//		out.println(1234);
//		out.println("hello cac bn nhỏ");
//		out.println(1234.21);
//		out.println(true);

		out.println("\t\tdanh sach sinh vien:");
		out.println("\t|tên\t|mã");
		for (int i = 0; i < 10; i++) {
			out.print("\t|tên" + i + "\t|mã\t|");
			out.println("mạnh\t|");
		}
		out.println(true);

		out.close();
	}

	/**
	 * đọc dữ liệu từ file văn bản
	 * 
	 * @throws IOException
	 */
	public static void textInputFile() throws IOException {
		// xác định tệp tin để đọc
		FileReader inFileReader = new FileReader("java0702.txt");

		// tạo bộ đệm đọc
		BufferedReader in = new BufferedReader(inFileReader);

		String tmpStr;
		int anInt;
		float tmpfloat;
		boolean atboolean;

		tmpStr = in.readLine();
		anInt = (new Integer(tmpStr)).intValue(); // đọc số nguyên
		System.out.println(anInt);

		tmpStr = in.readLine(); // đọc chuỗi
		System.out.println(tmpStr);

		tmpStr = in.readLine();
		tmpfloat = (new Float(tmpStr)).floatValue(); // đọc số nguyên
		System.out.println(tmpfloat);

		tmpStr = in.readLine();
		atboolean = (new Boolean(tmpStr)).booleanValue(); // đọc số nguyên
		System.out.println(atboolean);

		in.close();
	}

	public static void main(String[] args) {
		try {
			textInputFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
