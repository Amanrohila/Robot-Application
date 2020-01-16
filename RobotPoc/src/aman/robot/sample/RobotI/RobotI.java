package aman.robot.sample.RobotI;

import aman.robot.sample.Model.RobotModel;

public interface RobotI {

	public static boolean isNull(String value) {
		return value == null ? true : "".equals(value) ? true : false;
	}

	default boolean printPrice(String str) {
		if (!isNull(str)) {
			System.out.println("RobotI:: default Bacode Scan Reult SUCCESS::" + str);
			return true;
		} else {
			System.out.println("RobotI:: default Bacode Scan Reult:: FAILURE" + str);
			return false;
		}
	}

	public void walkBatteryConsume(double distance);

	public void walkWeightBatteryConsume(int weight);

	public void WalkWeightBatteryConsume(double distance, int weight);

	default boolean canCarryWithWeight(int weight) {
		if (weight < 10) {
			return true;
		}
		return false;
	}

	default boolean canWalkWithPower(int requiredBattery, RobotModel model) {
		if (requiredBattery <= model.getBattery()) {
			return true;
		} else {
			return false;
		}
	}

}
