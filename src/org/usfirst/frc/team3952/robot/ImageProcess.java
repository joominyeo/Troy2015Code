package org.usfirst.frc.team3952.robot;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.RGBValue;
import com.ni.vision.NIVision.ROI;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Timer;

public class ImageProcess {
	Image frame;
	int session;
	Point start;
	Point stop;
	Point middle;
	ROI cam;
	CameraServer s;
	public ImageProcess(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0",
	    NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	    NIVision.IMAQdxConfigureGrab(session);
	    NIVision.imaqFlatten(frame,
	    NIVision.FlattenType.FLATTEN_IMAGE,
		NIVision.CompressionType.COMPRESSION_JPEG, 10 * 30);
	}
	public boolean detectTote(){
		// 1. Retrieve the image from the camera stream.
		// 2. Convert image to binary Format: only shows white and black pixels
		// 3. Calculate contour: use function that splits binary function into an array
		// 4. Calculate the center of each contour: uses moments of the contour fo find the centre
		// 5. Figure out which one is on the left and/or right: using the distance of the mass centre
		//	compare with midpoint
		// source: http://youtu.be/HYWgS2M8Zy4?t=2m6s
		//	   https://github.com/rr1706/vision2015/tree/master/src
		
	}
	public void runCamera(){
		int id = 0;
        NIVision.IMAQdxStartAcquisition(session);
        // NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
        NIVision.IMAQdxGrab(session, frame, 1);	    
        //NIVision.imaqAttenuate(frame, frame, NIVision.AttenuateMode.ATTENUATE_HIGH);
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
