package core;
import method.Utilities;
public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// tao doi tuong dr su dung phuong thuc
		Utilities u= new Utilities();
		
		int n=u.randomValue(1000);
		System.out.print("Gia tri n= "+n);
		
		if(u.isPrime(n))
		{
			System.out.print("la nguyen to");
		}
		else 
		{
			System.out.print("Khong nguyen to");
		}
	}
}
