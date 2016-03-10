package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class LinearActuatorWinch{
//	double chainPitch;
//	int maxDistance;
//	double heightOfTrashbin;
//	double heightOfTote = 12.1; // inches
//	boolean atMax;
//	boolean atMin;
//	double sprocketDia;
//	double armRate;
//	int gearNum;

	Joystick j;
	Talon linAct;
	Talon winch;
	Encoder encoder;
	AnalogInput pot;
	//boolean moving;
	//DigitalInput bottom;
	//DigitalInput top;
	//DashBoard board;


	public LinearActuatorWinch(Joystick joyStick){
		//armRate = 1.0;
		//board = inBoard;
		//bottom = new DigitalInput(3);
		//top = new DigitalInput(2);
		//chainPitch = .375;
		//maxDistance = 2222;
		//heightOfTrashbin = 29;
		//heightOfTote = 2222/3.25;
		//atMax = false;
		//atMin = false;
		//sprocketDia = 2.1;
		//gearNum = 15;
		j = joyStick;
		pot = new AnalogInput(0);
		linAct = new Talon(2);
		winch = new Talon(3);
		//moving=false;
		//encoder = new Encoder(1,0,true, EncodingType.k2X);
		//encoder.setDistancePerPulse(2);
	}
	public boolean atMax()
	{
		return pot.getValue()>=4.5;
	}

	public boolean atMin()
	{
		return (pot.getValue()<=0.5);
		
	}
//	public void setRate(double inputRate){
//		armRate = inputRate;
//	}

	public void moveLinAct(double dir){
//		linAct.set(dir);
		if(dir==0.0)
			linAct.set(0.0);
		else if(dir>0.0)
		{
			if(atMax())
				linAct.set(0.0);
			else
				linAct.set(dir);
		}
		else{
			if(atMin())
				linAct.set(0.0);
			else
				linAct.set(dir);
		}
	}

	public void windWinch(double dir){//positive dir extends
//		if( dir > 0){
//			winch.set(0);
//		}
//		else if(dir < 0){
//			winch.set(0);
//		}
//		else{
//			winch.set(dir);
//		}
		if(winch.get()!=0.0)
			winch.set(0.0);
		else
			winch.set(dir);
	}

	public void stop(){
		linAct.set(0);
		winch.set(0);
	}

	public void goLAW(){
		if(j.getRawButton(5)){//linAct retract
				moveLinAct(-0.5);
    	}
    	else if(j.getRawButton(6)){//linAct extend
				moveLinAct(0.5);
    	}
    	else if(j.getRawButton(8)){//winch Unwind
				windWinch(0.9);//moveLinAct(0);
    	}
    	else if(j.getRawButton(7)){//winch wind
				windWinch(-0.9);
    	}
	}
	
	
	//REMOVE THIS LATER
	public void printVoltageValueThing()
	{
		System.out.println(pot.getValue());
	}
	
}

