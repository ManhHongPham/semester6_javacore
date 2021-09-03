package io;

import java.io.*;

public class Stream {
	/**
	 * sao chép dữ liệu từ luồng byte
	 * 
	 * @param in
	 * @param out
	 * @throws IOException //nếu có lỗi thì đẩy ra bên ngoài chứ k xử lý bên trong
	 */
	public static void copy(InputStream in, OutputStream out) throws IOException {
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
	}

	/**
	 * 
	 * sao chép dữ liệu từ luồng ký tự
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void copy(Reader in, Writer out) throws IOException {
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
	}

}
