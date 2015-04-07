package org.usfirst.frc.team3952.robot;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;

import com.ni.vision.NIVision;
import com.ni.vision.VisionException;
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
	ROI cam;
	CameraServer s;
	int quality;
	List<Byte> m_imageData;
	boolean easyMode = false;
	
	public ImageProcess(boolean inputEasyMode){
		easyMode = inputEasyMode;
	}
	
	public void runCamera() throws IOException{
		if(easyMode){
			s = CameraServer.getInstance();
			s.setQuality(50);
			s.startAutomaticCapture("cam0");
		}
		else{
			NIVision.IMAQdxConfigureGrab(session);
			NIVision.IMAQdxStartAcquisition(session);
			NIVision.IMAQdxGrab(session, frame, 1);
			RawData data = NIVision.imaqFlatten(frame,
					NIVision.FlattenType.FLATTEN_IMAGE,
					NIVision.CompressionType.COMPRESSION_JPEG, 10 * 50);
			ByteBuffer buffer = data.getBuffer();
		}		
	}
	
	public void stopCamera(){
        NIVision.IMAQdxStopAcquisition(session);
	}
	
	public boolean isTote(){
		return false;
	}	
}