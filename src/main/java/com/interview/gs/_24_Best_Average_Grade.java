package com.interview.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _24_Best_Average_Grade {
	public static double bestAvgGrade(String[][] studentMarks) {
		Map<String, List<Double>> studentMarksMap = new HashMap<>();

		for (int i = 0; i < studentMarks.length; i++) {
			String[] stdMarks = studentMarks[i];

			if (!studentMarksMap.containsKey(stdMarks[0])) {
				List<Double> marks = new ArrayList<>();
				studentMarksMap.put(stdMarks[0], marks);
			}
			studentMarksMap.get(stdMarks[0]).add(Double.parseDouble(stdMarks[1]));
		}

		double bestAvg = 0;
		for (Map.Entry<String, List<Double>> entry : studentMarksMap.entrySet()) {
			String student = entry.getKey();
			List<Double> allSubjectMarks = entry.getValue();
			int subjectCount = allSubjectMarks.size();
			Double sumOfMarks = allSubjectMarks.stream().reduce(0.0, Double::sum);
			Double average = sumOfMarks / subjectCount;
			if (bestAvg < average) {
				bestAvg = average;
			}
		}
		return bestAvg;
	}

	public static void main(String[] args) {
		String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

		if (bestAvgGrade(s1) == 84) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}
}
