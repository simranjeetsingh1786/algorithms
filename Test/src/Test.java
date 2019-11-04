import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 ** Instructions:
 **
 ** Given a list of student test scores, find the best average grade. Each
 * student may have more than one test score in the list.
 **
 ** Complete the bestAverageGrade function in the editor below. It has one
 * parameter, scores, which is an array of student test scores. Each element in
 * the array is a two-element array of the form [student name, test score] e.g.
 * [ "Bobby", "87" ]. Test scores may be positive or negative integers.
 **
 ** If you end up with an average grade that is not an integer, you should use a
 * floor function to return the largest integer less than or equal to the
 * average. Return 0 for an empty input.
 **
 ** Example:
 **
 ** Input: [ 
 * [ "Bobby", "87" ], 
 * [ "Charles", "100" ], 
 * [ "Eric", "64" ], 
 * [ "Charles", "22" ] 
 * ].
 **
 ** Expected output: 87 
 * Explanation: The average scores are 87, 61, and 64 for
 * Bobby, Charles, and Eric, respectively. 
 * 87 is the highest.
 * 
 */

public class Test {
	
	private static String[][] scores = {{"Bobby", "87"},{"Charles", "100"},{"Eric", "64"},{"Charles", "22"}};
	/**
	 * Goldman Sach's Interview Question
	 */
	public static void main(String[] args) {
		bestAverageGrade(scores);
	}

	/**
	 * PRINT THE STUDENT WITH BEST AVERAGE GRADE
	 * @param scores
	 */
	public static void bestAverageGrade(String[][] scores) {
		Map<String,List<Integer>> input = new HashMap<String, List<Integer>>();
		for(int i=0; i < scores.length ; i++) {
			System.out.println(scores[i][0]);
			System.out.println(scores[i][1]);
			if(input.containsKey(scores[i][0])) {
				input.get(scores[i][0]).add(Integer.valueOf(scores[i][1]));
			}else {
				List<Integer> marks = new ArrayList<Integer>();
				marks.add(Integer.valueOf(scores[i][1]));
				input.put(scores[i][0], marks);
			}
			
		}
		System.out.println("Input Data : " + input);
		
		int bestAverage = 0;
		String name = "";
		for(String key : input.keySet()) {
			float temp = 0;
			for(int a : input.get(key)) {
					temp = temp + a;
			}
			temp = temp/ (input.get(key).size());
			int average = Math.round(temp);
			if(average > bestAverage) {
				bestAverage = average;
			}
		}
		
		System.out.println(name);
		System.out.println(bestAverage);
	}

}

