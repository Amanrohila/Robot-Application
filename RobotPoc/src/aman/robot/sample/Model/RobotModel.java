package aman.robot.sample.Model;

import aman.robot.sample.Utils.Constant;

public class RobotModel {
	private int battery = 0;

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		if (battery >= Constant.MIN_POWER && battery <= Constant.MAX_POWER) {
			this.battery = battery;
		}
	}

}
