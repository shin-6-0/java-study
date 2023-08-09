package chapter03;

import java.util.Arrays;

public class ArrayUtil {
	public static void main(String[] args) {
		int[]a = {10,20,30,40};
		
		double[]d = ArrayUtil.intToDoublie(a);
		System.out.println(Arrays.toString(d));
	}

	private static double[] intToDoublie(int[] a) {
		// TODO Auto-generated method stub
		double[] d = new double[a.length];
		for(int i=0;i<a.length;i++) {
			d[i]=a[i];
		}
		return null;
	}
	
	public static int[] doubleToInt(double[] d) {
		int[] a = new int[d.length];
		for(int i=0;i<d.length;i++) {
			
		}
		return a;
	}

	public static double[] intToDouble(int[] is) {
		// TODO Auto-generated method stub
		return null;
	}
}
