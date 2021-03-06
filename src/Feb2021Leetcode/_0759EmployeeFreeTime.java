package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _0759EmployeeFreeTime {

	public static void main(String[] args) {
		List<List<Interval>> intervals = new ArrayList<List<Interval>>();
		List<Interval> interval1 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 2));
		interval1.add(new Interval(5, 6));

		List<Interval> interval2 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 3));

		List<Interval> interval3 = new ArrayList<Interval>();
		interval3.add(new Interval(4, 10));

		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);

		System.out.println(employeeFreeTime(intervals));

		intervals = new ArrayList<List<Interval>>();
		interval1 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 3));
		interval1.add(new Interval(6, 7));

		interval2 = new ArrayList<Interval>();
		interval1.add(new Interval(2, 4));

		interval3 = new ArrayList<Interval>();
		interval3.add(new Interval(2, 5));
		interval3.add(new Interval(9, 12));

		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);

		System.out.println(employeeFreeTime(intervals));

	}

	static class Interval {
		public int start;
		public int end;

		public Interval() {
		}

		public Interval(int _start, int _end) {
			start = _start;
			end = _end;
		}
	};

	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> allIntervals = new ArrayList<Interval>();
		if (schedule == null || schedule.size() == 0)
			return allIntervals;

		for (List<Interval> list : schedule) {
			allIntervals.addAll(list);
		}

		Collections.sort(allIntervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		List<Interval> mergedIntervals = new ArrayList<Interval>();

		int prevStart = allIntervals.get(0).start;
		int prevEnd = allIntervals.get(0).end;

		for (int i = 1; i < allIntervals.size(); i++) {

			int currStart = allIntervals.get(i).start;
			int currEnd = allIntervals.get(i).end;

			if (currStart >= prevStart && currStart <= prevEnd) {
				prevEnd = Math.max(prevEnd, currEnd);
			} else {
				mergedIntervals.add(new Interval(prevStart, prevEnd));
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}
		mergedIntervals.add(new Interval(prevStart, prevEnd));

		List<Interval> freeTime = new ArrayList<Interval>();
		for (int i = 1; i < mergedIntervals.size(); i++) {
			Interval i1 = mergedIntervals.get(i - 1);
			Interval i2 = mergedIntervals.get(i);
			freeTime.add(new Interval(i1.end, i2.start));
		}
		return freeTime;
	}
}
