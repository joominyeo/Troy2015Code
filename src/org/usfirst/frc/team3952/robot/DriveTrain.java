package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class DriveTrain {
	Joystick j;
	Talon leftDrive;
	Talon rightDrive;
	private RobotDrive rd;
	private double power;
	private double turnRate;
	long time;
	public DriveTrain(Joystick joyStick){
		j = joyStick;
		leftDrive = new Talon(0);
		rightDrive = new Talon(1);
		rd = new RobotDrive(leftDrive, rightDrive);
		power  = 0.7;
		turnRate = 0.6;
	}
	public void driveForwardOnTheRightSide(long startTime){		
		while(System.currentTimeMillis() < startTime + 6000){
			leftDrive.set(.3);
			rightDrive.set(-.3);
		}
		leftDrive.set(0);
		rightDrive.set(0);		
	}
	public void driveForwardOnTheLeftSide(long startTime){
		while( System.currentTimeMillis() < startTime + 5500){
			leftDrive.set(.3);
			rightDrive.set(-.3);
		}
		leftDrive.set(0);
		rightDrive.set(0);
	}
	public void drive(){
		if(j.getRawButton(2)){
    		power = 1.0;
    		turnRate = .8;
    	}
    	else if(j.getRawButton(3)){
    		power = .6;
    		turnRate = .4;
    	}
    	else if(j.getRawButton(4)){
    		power = .4;
    		turnRate = .2;
    	}    	
    	else if(j.getRawButton(5)){
    		power = 0.0;
    		turnRate = 0.0;
    	}	
    	rd.arcadeDrive(-j.getY()*power, -j.getX()*turnRate);
	}
	public double getPower(){
		return power;
	}
	public double getTurnRate(){
		return turnRate;
	}
}
