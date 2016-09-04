/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author felipe
 */
public class VideoSample1 {
    
    //
    private WebCamSample1 threadwebcamsample1 = null;
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
    VideoSample1(javax.swing.JLabel ImagePreview)
    {
        this.imagelabel = ImagePreview;
    }
    
    //
    public void StartWebCamSample1()
    {
        runable = true;
        
        threadwebcamsample1 = new WebCamSample1();
        t_webcam            = new Thread(threadwebcamsample1);
        t_webcam.setDaemon(true);
        t_webcam.start();     
    }

    //
    public void StopWebCamSample1()
    {
        runable = false;
    }    
    
    //Translate Mat to a Buffered Image
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
    
    
    class WebCamSample1 implements Runnable
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
