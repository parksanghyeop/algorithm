package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Silver4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Double> trees = new TreeMap<>();
		
		String tree;
		int total = 0;
		
		while((tree = br.readLine()) != null && tree.length()!=0) {
			double count = trees.containsKey(tree) ? trees.get(tree) : 0;
			
			if(count==0) {
				trees.put(tree,(double) 1);
			} else {
				trees.put(tree, count+1);
			}
			total++;
		}
		
		for(Entry<String, Double> e : trees.entrySet()) {
			double avg = e.getValue() / total *100;
			System.out.printf("%s %.4f\n",e.getKey(),avg);
		}
	}
}
