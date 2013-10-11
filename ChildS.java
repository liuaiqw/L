/**
 *  子序列的定义：对于一个序列a=a[1],a[2],......a[n]，则非空序列a'=a[p1],a[p2]......a[pm]为a的一个子序列，
 *其中1<=p1<p2<.....<pm<=n。 例如：4,14,2,3和14,1,2,3都为4,13,14,1,2,3的子序列。 对于给出序列a，有些子序
 *列可能是相同的，这里只算做1个，要求输出a的不同子序列的数量。 输入： 长度为n的数组1<=n<=100,数组元素
 *0<=a[i]<=110 输出：子序列的个数对1000000007取余数的结果（由于答案比较大，输出Mod 1000000007的结果即可）。 
 */
package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 2w
 * 
 */

public class ChildS {
	public static int run(int[] a) {
		int rtn = 0;
		int[] b=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int same=-1;
			for (int j = 0; j < i; j++) {
				if(a[i]==a[i-j-1]){
					same=i-j-1;
					break;
				}
			}
			if(same==-1)
				rtn = rtn + rtn + 1;
			else if(same==0)
				rtn=rtn*2;
			else
				rtn=rtn+rtn-b[same-1];
			if(rtn > 1000000007) {
				rtn -= 1000000007;
			}
			if(rtn<0){
				rtn+=1000000007;
			}
			b[i]=rtn;
		}
		return rtn;
	}

	

	public static void main(String[] arg) {
		int count = 100;
		int[] a = new int[count];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 120);
		}
		int[] b = { 37, 119, 9, 76, 68, 43, 17, 29, 57, 29, 113, 8, 8, 27, 101,
				115, 75, 26, 58, 103, 40, 56, 60, 90, 6, 67, 84, 20, 117, 107,
				68, 6, 81, 21, 6, 39, 31, 89, 43, 42, 53, 118, 1, 66, 104, 47,
				25, 46, 28, 39, 78, 73, 1, 0, 10, 55, 77, 18, 112, 19, 104,
				108, 22, 45, 45, 118, 109, 1, 81, 53, 114, 91, 34, 52, 105, 46,
				22, 56, 72, 57, 10, 88, 28, 104, 11, 90, 18, 62, 47, 63, 76,
				96, 97, 12, 59, 84, 80, 109, 63, 25 };
		int[] c = { 1,1,1,1,1,1,1,1,2,2};
		System.out.println(run(c));
		int k = (int) (Math.pow(2, count) - 1) % 1000000007;
		System.out.println((Math.pow(2, count) - 1) % 1000000007);
		// System.out.println(Math.pow(2, 100));
	}
}
