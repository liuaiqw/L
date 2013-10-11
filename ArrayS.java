/**
 *  给定一个包含1-n的数列，我们通过交换任意两个元素给数列重新排序。求最少需要多少次交换，
 * 能把数组排成按1-n递增的顺序，其中，数组长度不超过100。 例如： 原数组是3,2,1， 我们只需
 *要交换1和3就行了，交换次数为1，所以输出1。 原数组是2,3,1，我们需要交换2和1，变成1,3,2，
 *再交换3和2，变为1，2，3，总共需要的交换次数为2，所以输出2。
 */
package com;

/**
 * @author 2w
 * 
 */
public class ArrayS {
	public static void main(String[] arg) {
		
	}

	public static int run(int[] a) {
		int temp = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int k = i; k < a.length; k++) {
				if (a[k] == i + 1 && k != i) {
					count++;
					temp = a[k];
					a[k] = a[i];
					a[i] = temp;
				}
			}
		}
		return count;
	}
}
