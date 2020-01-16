package aman.robot.sample.Services;

import aman.robot.sample.Model.RobotModel;
import aman.robot.sample.RobotI.BarcodeCodeI;
import aman.robot.sample.RobotI.RobotI;
import aman.robot.sample.Utils.Constant;

public class RobotService implements RobotI {

	private RobotModel model;

	public RobotService(RobotModel model) {
		this.model = model;
	}

	@Override
	public boolean printPrice(String barCode) {
		BarcodeCodeI codeI = (code) -> {
			if (!RobotI.isNull(code)) {
				if (code.equalsIgnoreCase(Constant.SUCCESS)) {
					System.out.println("Price 10");
					return true;
				} else {
					System.out.println("Scan Failure");
					return false;
				}
			} else {
				System.out.println("Scan Failure due to invalid value");
			}
			return false;
		};

		return codeI.scanBarcode(barCode);
	}
/**Assumptions value 20 is the value calculated per KM i.e according to 5 KM per charge
 * 
 * */
	@Override
	public void walkBatteryConsume(double distance) {
		int requiredBattery = (int) (20 * distance);
		if (canWalkWithPower(requiredBattery, model)) {
			int battery = model.getBattery() - requiredBattery;
			setbattery(battery);
			System.out.println("Robot Walk " + distance + " km, consume battery " + requiredBattery + "% remaining battery " + battery+"%");
		} else {
			System.out.println("Robot can't walk due to low battery");
		}
	}

	private void setbattery(int battery) {
		model.setBattery(battery);
		if (battery<15)
			System.out.println("LOW BATTERY: [Red light on Robot head ]");
	}

	@Override
	public void walkWeightBatteryConsume(int weight) {
		if(canCarryWithWeight(weight)) {
			int requiredBattery  = weight*2;
			if (canWalkWithPower(requiredBattery, model)) {
				int battery = model.getBattery() - requiredBattery;
				setbattery(battery);
				System.out.println(
						"Robot Walk with " + weight + " kg consume battery " + requiredBattery + "% remaining battery " + battery +"%");
			} else {
				System.out.println("Robot can't walk due to low battery");
			}
			
		}
		else {
			System.out.println("Overweight:  [RED LED display on chest] ");
		}

	}

	@Override
	public void WalkWeightBatteryConsume(double distance, int weight) {
		if(canCarryWithWeight(weight)) {
			int requiredBattery  = (int) (weight*2 + 20*distance);
			if (canWalkWithPower(requiredBattery, model)) {
				int battery = model.getBattery() - requiredBattery;
				setbattery(battery);
				System.out.println(
						"Robot Walk with " + weight + " kg distance "+distance +"kg consume battery " + requiredBattery + "% remaining battery " + battery +"%");
			} else {
				System.out.println("Robot can't walk due to low battery");
			}
			
		}
		else {
			System.out.println("Overweight:  [RED LED display on chest] ");
		}

	}

}
