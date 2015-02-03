
package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	//Speed / 20 feet = 2.38, 2.50, 2.60
	DriveTrain driveTrain;
	RobotDrive rd; // Robot Drive, add the Talons in here
	ImageProcess camera;
	DashBoard board;
    public void robotInit() {
    	board = new DashBoard(); 
    	camera = new ImageProcess();    	
    	driveTrain = new DriveTrain(new Joystick(1));
    	camera.startCamera();
    	board.addBooleanLog("Tote", camera.isTote());
		board.addNumberLog("Power", driveTrain.getPower()*100);
		board.addNumberLog("TurnRate", driveTrain.getTurnRate()*100);	
    }

    /**
     * This function is called periodically during autonomous
     */
    //"java -jar "C:\\Users\\Nocturnis Pham\\wpilib\\tools\\SmartDashboard.jar""
    //""C:\\Program Files (x86)\\FRC Dashboard\\Dashboard.exe""
 
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    
	public void teleopPeriodic() {
		driveTrain.drive();
		board.addBooleanLog("Tote", camera.isTote());
		board.addNumberLog("Power", driveTrain.getPower()*100);
		board.addNumberLog("TurnRate", driveTrain.getTurnRate()*100);	
		}
    
    /**s
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
    	
    }
    
}
