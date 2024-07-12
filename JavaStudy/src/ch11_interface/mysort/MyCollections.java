package ch11_interface.mysort;

import java.util.ArrayList;

public class MyCollections {
	public static <T> void printList(ArrayList<T> paramList) { // 제너릭 내부에 어떤 객체 타입도 들어올 수 있다.
		for (int i = 0; i < paramList.size(); i++) {
			System.out.println(paramList.get(i));
		}
	}

	public static <T> void sort(ArrayList<T> paramList, MyComparator<T> myComp) {
		for (int k = 0; k < paramList.size() - 1; k++) {
			for (int i = 0; i < paramList.size() - 1 - k; i++) {
				if (myComp.myCompare(paramList.get(i), paramList.get(i + 1))) {
					T temp = paramList.get(i);
					paramList.set(i, paramList.get(i + 1));
					paramList.set(i + 1, temp);
				}
			}
		}
	}
}