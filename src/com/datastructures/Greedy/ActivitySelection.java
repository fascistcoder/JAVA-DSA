package com.datastructures.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/12/23
 */

public class ActivitySelection {

	public static void main(String[] args) {
		ArrayList<Activity> activities = new ArrayList<>();
		activities.add(new Activity("A1", 0, 6));
		activities.add(new Activity("A2", 3, 4));
		activities.add(new Activity("A3", 1, 2));
		activities.add(new Activity("A4", 5, 8));
		activities.add(new Activity("A5", 5, 7));
		activities.add(new Activity("A6", 8, 9));
		 new ActivitySelection().activitySelection(activities);

	}

	void activitySelection(ArrayList<Activity> activityList) {
		Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
			@Override public int compare(Activity o1, Activity o2) {
				return o1.getEndTime() - o2.getEndTime();
			}
		};

		activityList.sort(finishTimeComparator);
		Activity previousActivity = activityList.get(0);
		System.out.println("Recommend schedule:\n" + activityList.get(0));

		for (int i = 1; i < activityList.size(); i++) {
			Activity activity = activityList.get(i);
			if (activity.getStartTime() >= previousActivity.getEndTime()) {
				System.out.println(activity);
				previousActivity = activity;
			}
		}
	}
}
