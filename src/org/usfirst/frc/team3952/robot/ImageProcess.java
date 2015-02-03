package org.usfirst.frc.team3952.robot;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;








import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.ROI;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Timer;

public class ImageProcess {
	Image frame;
	int session;
	ROI cam;
	Point start;
	Point stop;
	public ImageProcess(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0",
	    NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	    NIVision.IMAQdxConfigureGrab(session);
	    start = new Point(0,0);
	    stop = new Point(640,640);
	}
	public void startCamera(){
        NIVision.IMAQdxStartAcquisition(session);
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
        NIVision.IMAQdxGrab(session, frame, 1);
	    NIVision.imaqAddLineContour(cam, start, stop);
        CameraServer.getInstance().setImage(frame);
        Timer.delay(0.005);		// wait for a motor update time
        
	}
	public void stopCamera(){
        NIVision.IMAQdxStopAcquisition(session);
	}
	public boolean isTote(){
		return false;
	}	
}
