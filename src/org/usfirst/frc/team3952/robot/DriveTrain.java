package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	Joystick j;
	Talon leftDrive;
	Talon rightDrive;
	private RobotDrive rd;
	private double power;
	private double turnRate;
	public DriveTrain(Joystick joyStick){
		j = joyStick;
		leftDrive = new Talon(0);
		rightDrive = new Talon(1);
		rd = new RobotDrive(leftDrive, rightDrive);
		power  = 1.0;
		turnRate = .8;
	}
	public void drive(){
		if(j.getRawButton(5)){
    		power = 0;
    		turnRate = 0;
    	}
    	else if(j.getRawButton(6)){
    		power = .8;
    		turnRate = .6;
    	}
    	else if(j.getRawButton(7)){
    		power = .5;
    		turnRate = .4;
    	}    	
    	else if(j.getRawButton(8)){
    		power = 1.0;
    		turnRate = .8;
    	}	
		rd.arcadeDrive(j.getY() * power, -j.getX() * turnRate, true);
	}
	public double getPower(){
		return power;
	}
	public double getTurnRate(){
		return turnRate;
	}
}
