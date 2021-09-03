package io;

import java.io.*;

public class TestStream {
	public static void main(String[] args) {

		FileReader in1;
		FileWriter out1;
		try {
			// xác định tệp tin để đọc
			in1 = new FileReader("xyz.txt"); // file đầu vào cần phải có sẵn để nhận

			// xác định tệp tin để ghi data
			out1 = new FileWriter("data.txt"); // file xuất sẽ tự tạo cho
			Stream.copy(in1, out1);

			// đóng luồng
			in1.close();
			out1.close();

		} catch (FileNotFoundException e) { // bắt đc lỗi filenofound, có thể thay IOExeption
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
