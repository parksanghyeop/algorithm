package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Silver2304 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> maxPoles = new ArrayList<Integer>();
		List<Pole> poles = new ArrayList<Pole>();
		Stack<Pole> stack = new Stack<Pole>();

		int n = sc.nextInt();
		int max = 0;
		int result=0;
		
		for (int i = 0; i < n; i++) {
			Pole pole = new Pole(sc.nextInt(), sc.nextInt());
			max = Math.max(max, pole.height);
			poles.add(pole);
		}

		Collections.sort(poles);
		// 가장 높은 기둥들 정리
		for (Pole p : poles) {
			if (p.height == max)
				maxPoles.add(poles.indexOf(p));
		}

		// left 끝 기준 : maxPoles[0] max들의 맨앞
		for (int i = 0; i <= maxPoles.get(0); i++) {
			if (i == 0) {
				stack.push(poles.get(i));
			} else {
				if(stack.peek().height < poles.get(i).height) {
					result += (poles.get(i).pos - stack.peek().pos) * stack.peek().height;
					stack.pop();
					stack.push(poles.get(i));
				}
			}
//			System.out.println(poles.get(i).toString());
		}
		// right 끝 기준 : maxPoles[size-1]; max들의 가장 끝
		for (int i = poles.size()-1; i >= maxPoles.get(maxPoles.size() - 1); i--) {
			if (i == poles.size()-1) {
				stack.push(poles.get(i));
			} else {
				if(stack.peek().height < poles.get(i).height) {
					result += (stack.peek().pos - poles.get(i).pos) * stack.peek().height;
					stack.pop();
					stack.push(poles.get(i));
				}
			}
//			System.out.println(poles.get(i).toString());
		}
		int start = maxPoles.get(0);
		int end = maxPoles.get(maxPoles.size()-1);
//		System.out.println(start+" "+end);
//		System.out.println(result);
		result += max * Math.abs(poles.get(start).pos - poles.get(end).pos)+max; 
		System.out.println(result);

	}

	static class Pole implements Comparable<Pole> {
		int pos;
		int height;

		public Pole(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}

		@Override
		public int compareTo(Pole p) {
			if (this.pos > p.pos) {
				return 1;
			} else if (this.pos < p.pos) {
				return -1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "Pole [pos=" + pos + ", height=" + height + "]";
		}

	}
}
