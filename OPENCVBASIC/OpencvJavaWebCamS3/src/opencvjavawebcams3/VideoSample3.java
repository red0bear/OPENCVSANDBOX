/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams3;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import static org.opencv.videoio.Videoio.CV_CAP_PROP_FRAME_HEIGHT;
import static org.opencv.videoio.Videoio.CV_CAP_PROP_FRAME_WIDTH;

/**
 *
 * @author felipe
 */
public class VideoSample3 {
    
    //
    private WebCamSample3 threadwebcamsample3 = null;
    private Thread t_webcam;
    
    //
    private BufferedImage image;
    private ImageIcon icon;
    
    //
    private javax.swing.JLabel imagelabel;
    
    //
    private VideoCapture  cap;
    private Mat frame;
    
    //
    private boolean runable  = true;
    
    
    //
    private String rvalues [];
    private boolean set_resolution = false;
    
    //
    VideoSample3(javax.swing.JLabel ImagePreview)
    {
        this.imagelabel = ImagePreview;
    }
    
    //
    public void StartWebCamSample3()
    {
        runable = true;
        
        threadwebcamsample3 = new WebCamSample3();
        t_webcam            = new Thread(threadwebcamsample3);
        t_webcam.setDaemon(true);
        t_webcam.start();     
    }

    //
    public void SetResolution(String Resolution)
    {
                    
        rvalues = Resolution.split(":");
        
        set_resolution = true;
    
    }
    
    //
    public void StopWebCamSample3()
    {
        runable = false;
    }    
    
    //Translate Mat to a Buffered Image , I took from some opencv forum but i dont remember the place :-(
    private Image ToBufferedImageArrayCopy(Mat m)
    {
    
        int type = BufferedImage.TYPE_BYTE_GRAY;
        
        if ( m.channels() > 1 ) {
            Mat m2 = new Mat();
            Imgproc.cvtColor(m,m2,Imgproc.COLOR_RGB2BGR);
            type = BufferedImage.TYPE_3BYTE_BGR;
            m = m2;
        }
        
        byte [] b = new byte[m.channels()*m.cols()*m.rows()];
        m.get(0,0,b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        image.getRaster().setDataElements(0, 0, m.cols(),m.rows(), b); 

        return image;
    }
    
    
    class WebCamSample3 implements Runnable
    {       
        @Override
        public void run() 
        {
            cap = new VideoCapture(0);                    
                    
            frame = new Mat();
                    
            while(runable)
            {
                if(cap.grab())
                {
                    if(set_resolution)
                    {
                        cap.set(CV_CAP_PROP_FRAME_WIDTH,Integer.valueOf(rvalues[0]));
                        cap.set(CV_CAP_PROP_FRAME_HEIGHT,Integer.valueOf(rvalues[1]));                     
                        set_resolution = false;
                    }
                                                    
                    cap.retrieve(frame);
                                                
                    image = (BufferedImage) ToBufferedImageArrayCopy(frame);
        
                    icon = new javax.swing.ImageIcon(image);

                    imagelabel.setIcon(icon);
                }
            
            }//end while
            cap.release();
        }//end run
    }
}
