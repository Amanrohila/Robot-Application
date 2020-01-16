package aman.robot.sample;

import aman.robot.sample.Model.RobotModel;
import aman.robot.sample.RobotI.RobotI;
import aman.robot.sample.Services.RobotService;
import aman.robot.sample.Utils.Constant;

public class MainApplication {
	
	public static void main(String[] args) {
		RobotModel model = new RobotModel();
		model.setBattery(100);
		
		RobotI robotIntance = new RobotService(model);

		robotIntance.walkBatteryConsume(3.5);
		robotIntance.WalkWeightBatteryConsume(2, 3);
		robotIntance.walkWeightBatteryConsume(12);
		
		robotIntance.printPrice(Constant.SUCCESS);
		robotIntance.printPrice(Constant.NOT_VISIBLE);
		robotIntance.printPrice(null);
	}

}
