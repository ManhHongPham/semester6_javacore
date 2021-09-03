package utilities;

import obj.Person;
import java.util.*;

public class MyArrays {
	public static Scanner sc = new Scanner(System.in);

	/**
	 * 1-phương thức sinh mảng ngẫu nhiên mảng 1 chiều, kểu dữ liệu int
	 * 
	 * 2-static phương thức gắn liền với class
	 * 
	 * @param n
	 * @return
	 */
	public static int[] generateArray(int n) {
		// mảng trung gian
		int[] arrInt = new int[n];

		// sinh giá trị
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = method.Utilities.randomValue(100);
		}
		return arrInt;
	}

	/**
	 * sinh ngẫu nhiên mang 2 chiều
	 * 
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}
		return arrInt;
	}

	/**
	 * sinh ngẫu nhiên mảng object
	 * 
	 * @param n
	 * @return
	 */
	public static Person[] generatePerson(int n) {

		// khai báo danh sách, sẽ tham chiếu đến kiểu dữ liệu là null
		Person[] list = new Person[n];

		// khai bao một dánh sách tên
		String[] firstName = { "hòa", "hoài", "thu", "thu hoài", "huy", "anh", "ngọc", "lan", "thế ngân", "lan ngân",
				"thủy", "thúy", "thùy", "linh", "huy", "anh hoa", "ngọc anh", "yến anh", "quang anh", "châu anh",
				"anh châu" };

		String[] lastNames = { "hoàng", "nguyễn", "phạm", "đỗ", "bùi", "mai", "giang" };

		// sinh dữ liệu cho các phần tử
		int index;
		for (int i = 0; i < list.length; i++) {

			// cấp phát bộ nhớ cho phần tử mảng
			list[i] = new Person();

			// sinh ngẫu nhiên tên
			index = method.Utilities.randomValue(firstName.length);
			list[i].setFirstName(firstName[index]);

			// sinh ngẫu nhiên họ
			index = method.Utilities.randomValue(lastNames.length);
			list[i].setLastName(lastNames[index]);

			// sinh ngẫu nhiên tuổi
			index = 18 + method.Utilities.randomValue(5);
			list[i].setAge((byte) index);
		}

		return list;
	}

	/**
	 * phương thức sắp xếp mảng 1 chiều theo thứ tự được xác định bởi isINC(is
	 * increament)
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[] sortedArrey(int[] arrInt, boolean isINC) {
		// xác định hương sắp xêp
		byte oriented = (byte) ((isINC) ? 1 : -1);
		// sắp xếp
		int tmp;
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * oriented > arrInt[j] * oriented) {
					tmp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = tmp;
				}
			}
		}
		return arrInt;
	}

	/**
	 * phương thức sắp xếp mảng 2 chiều, chuyển mảng 2 chiều thành mảng 1 chiều rồi
	 * sắp xêp sau đó đưa lại mảng chiều về 1 chiều
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[][] sortArreyType1(int[][] arrInt, Boolean isINC) {
		// lấy kích thước của mảng
		int rows = arrInt.length;// số dòng
		int cols = arrInt[0].length;

		// khai báo mảng 1 chiều trung gian
		int[] tmp = new int[rows * cols];

		// lấy giá trị
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tmp[j + i * cols] = arrInt[i][j];
			}
		}
		// sắp xếp
		tmp = MyArrays.sortedArrey(tmp, isINC);

		// đưa lai mảng 2 chiều
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arrInt[i][j] = tmp[j + i * cols];
			}
		}
		return arrInt;
	}

	/**
	 * phương thức sắp xếp mảng 2 chiều, so sánh lần lượt các vị trí với nhau
	 * 
	 * @param arrInt
	 * @param isINTC
	 * @return
	 */
	private static int[][] sortArrayType2(int[][] arrInt, Boolean isINTC) {

		// xác định hướng sắp xêp
		byte oriented = (byte) ((isINTC) ? 1 : -1);

		int rows = arrInt.length;// số dòng
		int cols = arrInt[0].length; // số cột

		int temp;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < rows; k++) {
					for (int h = 0; h < cols; h++) {
						if (arrInt[k][h] * oriented > arrInt[i][j] * oriented) {
							temp = arrInt[i][j];
							arrInt[i][j] = arrInt[k][h];
							arrInt[k][h] = temp;
						}
					}
				}
			}
		}

		return arrInt;
	}

	/**
	 * phương thức sắp xếp hàng bất kì theo một quy tắc nào đó, trong đó cột tương
	 * ứng ở vị trí hàng tịnh tiến theo
	 * 
	 * @param arrInt
	 * @param isINTC
	 * @return
	 */
	private static int[][] sortedArrayType3(int[][] arrInt, Boolean isINTC) {

		byte oriented = (byte) ((isINTC) ? 1 : -1);

		int rows = arrInt.length;// số dòng
		int cols = arrInt[0].length; // số cột

		int line = (int) (Math.random() * rows);

		System.out.println("Sắp xếp tịnh tiến theo dòng thứ:" + line);
		for (int i = 0; i < cols - 1; i++) {
			for (int j = i + 1; j < cols; j++) {
				if (arrInt[line][i] * oriented > arrInt[line][j] * oriented) {
					for (int h = 0; h < rows; h++) {
						int tmp = arrInt[h][i];
						arrInt[h][i] = arrInt[h][j];
						arrInt[h][j] = tmp;
					}
				}
			}
		}
		return arrInt;
	}

	/**
	 * phương thức lọc số nguyên tố đưa lên đầu mảng và có sắp xếp
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[] filterArray(int[] arrInt, boolean isINC) {
		// sắp xêp
		arrInt = MyArrays.sortedArrey(arrInt, isINC);

		// tách nguyên tố
		int[] temp1 = new int[arrInt.length];// lưu nguyên tố
		int[] temp2 = new int[arrInt.length];// không nguyên tố
		int t1 = 0, t2 = 0;
		for (int value : arrInt) {
			if (method.Utilities.isPrime(value)) {
				temp1[t1++] = value; // tăng rồi gán tóa tử rồi tăng lên
			} else {
				temp2[t2++] = value;
				// t2++;
			}
		}

		// ghép mảng t2 vào phần tiếp theo của mảng
		for (int i = t1; i < temp1.length; i++) {
			temp1[i] = temp2[i - t1];
		}

		return temp1;
	}

	/**
	 * sắp xếp tại một dòng bất kì trong mảng 2 chiều, các giá trị tại cột tương ứng
	 * được tịnh tiến theo phần tử mảng được sáp xếp từ mảng ban đầu, lấy dòng bất
	 * kì ->rồi sắp xếp(tmpAtRow) i start 0->end, so sánh ở cột i vs j-> tương ứng
	 * copy toàn bộ cột ở vị trí j cũ vào mảng mới tmp
	 * 
	 * trường hợp có 2 vị trí có gia trị giống nhau sau khi i=j đã gán vị trí vào vs
	 * nhau, ta phải gán =-1 thì lần đi tiếp của j sẽ k gặp vị trí trùng nữa sẽ lặp
	 * lại data, và phải break để k ghi đè data lên
	 * 
	 * @param arrInt
	 * @param atRow
	 * @return
	 */
	public static int[][] sortedAtRow(int[][] arrInt, byte atRow, boolean isINC) {

		// so dong
		int rows = arrInt.length;
		// so cột
		int cols = arrInt[0].length;

		if (atRow >= 0 && atRow < rows) {
			// lấy ra dòng cần sắp xếp
			int[] tmpAtRow = arrInt[atRow].clone();
			// sắp xếp
			tmpAtRow = MyArrays.sortedArrey(tmpAtRow, isINC);

			// mảng trung gian kết quả ghi nhận tịnh tiến
			int[][] tmp = new int[rows][cols];

			// thực hiện tịnh tiến
			for (int i = 0; i < tmpAtRow.length; i++) {
				for (int j = 0; j < cols; j++) {
					if (arrInt[atRow][j] == tmpAtRow[i]) {
						for (int k = 0; k < rows; k++) {
							tmp[k][i] = arrInt[k][j];
						}
						arrInt[atRow][j] = -1; // sau khi lấy xong giá trị thì hủy, phát hiện các cột trùng nhau
						break;
					}
				}
			}
			arrInt = tmp;
		}
		return arrInt;
	}

	public static Person[] searchPerson(Person[] list, String name) {
		// khai báo mảng kết quả
		Person[] results = null;

		// đếm số kết quả
		int count = 0;
		for (Person person : list) {
			if (person.getFirstName().contains(name)) {
				count++;
			}
		}
		// khởi tạo bộ nhớ để lưu kết quả
		results = new Person[count];

		// ghi nhận kết quả
		count = 0;
		for (Person person : list) {
			if (person.getFirstName().contains(name)) {
				results[count++] = person;
			}
		}
		return results;
	}

	/**
	 * ArrayList<Person> xach định rõ đối tượng làm việc với 3 constructor type 1(k
	 * tham số) auto create 10 typ2 collecttion type3 int
	 * 
	 * @param list
	 * @param name
	 * @return
	 */
	public static ArrayList<Person> searchPersonV2(Person[] list, String name) {
		// khai báo mảng kết quả
		ArrayList<Person> results = new ArrayList<>();
		for (Person person : list) {
			if (person.getFirstName().contains(name))
				results.add(person);
		}
		return results;

	}

	public static ArrayList<Person> sortedByAge(Person[] list) {
		// chuyển mảng list sang tạp hợp collections
		ArrayList<Person> tmp = new ArrayList<>();
		// sap cheosp phần tử
		Collections.addAll(tmp, list);

		// sắp xêp
		Collections.sort(tmp);

		return tmp;
	}

	public static ArrayList<Person> sortedByName(Person[] list) {
		// chuyển mảng list sang tạp hợp collections
		ArrayList<Person> tmp = new ArrayList<>();
		// sap cheosp phần tử
		Collections.addAll(tmp, list);

		// sắp xêp
		Collections.sort(tmp, new PersonComparetorName());

		return tmp;
	}

	public static void printPerson(ArrayList person) {
		Person p;
		for (int i = 0; i < person.size(); i++) {
			p = (Person) person.get(i);
			System.out.println(p);
		}
	}

	public static void printPersonV2(ArrayList<Person> list) {
		for (Person person : list) {
			System.out.println(person);
		}
	}

	/**
	 * phương thức sắp xếp tên, so sánh tên 2 chuỗi nếu >0 chuỗi i đứng sau ch
	 * 
	 * @param persons
	 * @return
	 */
	public static Person[] sortArrayPerson(Person[] persons) {
		for (int i = 0; i < persons.length; i++) {
			for (int j = i + 1; j < persons.length; j++) {
				if (persons[i].getFirstName().compareTo(persons[j].getFirstName()) > 0) {
					Person temp = new Person();
					temp = persons[i];
					persons[i] = persons[j];
					persons[j] = temp;

				}
			}
		}
		return persons;
	}

	/**
	 * phương thức in giá trị các phần tử mảng 1 chiều
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[] arrInt) {
		for (int v : arrInt) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	/**
	 * phương thức in giá trị các phần tử mảng 2 chiều
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[][] arrInt) {
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}
	}

	public static void printPerson(Person[] list) {
		for (Person person : list) {
			System.out.println(person);
		}
	}

	public static void main(String[] args) {
		// sinh mảng 1 chieu
		// int[] arrInt = MyArrays.generateArray(20);

		// sinh mang 2 chiều
		// int[][] arrInt = MyArrays.generateArray(10, 10);

		Person[] list = MyArrays.generatePerson(10);
		// MyArrays.printPerson(list);

		// in giá trị
		// MyArrays.printArray(arrInt);

		// sắp xếp tăng dần
		// arrInt = MyArrays.sortedArrey(arrInt, true);
		// System.out.println();
		// arrInt = MyArrays.sortedAtRow(arrInt, (byte) 0, true);
		// arrInt = MyArrays.sortedArrayType3(arrInt, true);
		// MyArrays.printArray(arrInt);

		//System.out.println();
//		MyArrays.sortArrayPerson(list);
//		MyArrays.printPerson(list);
		//ArrayList<Person> results1 = new ArrayList<Person>();
		Person[] a= sortArrayPerson(list);
		
		//ArrayList<Person> results2 = MyArrays.sortedByName(list);
		MyArrays.printPerson(a);

		System.out.println("------------");
		//MyArrays.printPerson(results2);

	}
}
