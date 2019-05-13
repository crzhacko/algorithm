package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Weight {

	// 다음 array는 물건의 중량이다. Array의 순서대로 물건을 상자에 담되,
	// 중량이 20을 넘지 않도록 상자를 분할하는 출력 함수를 만드시오.
	// 예) 9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2
	public static void main(String[] args) {
		List<Stack<Integer>> stackList = doDo();
		for (Stack<Integer> stack : stackList) {
			for (Integer element : stack) {
				System.out.print(element.toString() + " ");
			}
			System.out.println();
		}
	}
	
	public static List<Stack<Integer>> doDo() {
		final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);
		List<Stack<Integer>> result = new ArrayList<Stack<Integer>>();
		int sum = 0;
		int element;
		for (int i = 0, length = elements.size(); i < length; i++) {
			element = elements.get(i);
			if (i == 0 || sum + element > 20) {
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(element);
				result.add(stack);
				sum = element;
			} else {
				result.get(result.size() - 1).push(element);
				sum += element;
			}
		}
		
		return result;
	}
}
