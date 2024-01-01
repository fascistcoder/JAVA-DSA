package com.datastructures.Greedy;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/12/23
 */
public class Activity {
	private String name;
	private int startTime;
	private int endTime;

	public Activity(String name, int startTime, int endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override public String toString() {
		return "{Activity Name='" + name + '\'' +
			   ", startTime=" + startTime +
			   ", endTime=" + endTime +
			   '}';
	}
}
