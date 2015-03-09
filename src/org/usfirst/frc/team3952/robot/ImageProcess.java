package org.usfirst.frc.team3952.robot;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import java.nio.ByteBuffer;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Point;
import com.ni.vision.NIVision.RGBValue;
import com.ni.vision.NIVision.ROI;
import com.ni.vision.NIVision.RawData;
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
	int quality;
	public ImageProcess(){
		 frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		 session = NIVision.IMAQdxOpenCamera("cam0",
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	        // the camera name (ex "cam0") can be found through the roborio web interface
	     
	}
	public void runCamera(){	
		NIVision.IMAQdxConfigureGrab(session);
		NIVision.IMAQdxStartAcquisition(session);
		NIVision.IMAQdxGrab(session, frame, 1);
		CameraServer.getInstance().setImage(frame);
		RawData data = NIVision.imaqFlatten(frame,
				NIVision.FlattenType.FLATTEN_IMAGE,
				NIVision.CompressionType.COMPRESSION_JPEG, 10 * 30);
		//Timer.delay(0.005);
		/* Find the start of the JPEG data */
        		// wait for a motor update time                
	}
	public void stopCamera(){
        NIVision.IMAQdxStopAcquisition(session);
	}
	public boolean isTote(){
		return false;
	}	
}
