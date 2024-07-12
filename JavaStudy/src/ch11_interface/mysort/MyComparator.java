package ch11_interface.mysort;

public interface MyComparator<T> {
	boolean myCompare(T left, T right);
}