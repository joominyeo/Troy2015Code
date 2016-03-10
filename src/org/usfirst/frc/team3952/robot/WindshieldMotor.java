package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Talon;

public class WindshieldMotor {

	Talon t;
	int channel;
	public WindshieldMotor(int channelx)
	{
		channel=channelx;
		t=new Talon(channel);
	}
	
}
