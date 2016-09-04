/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams2;

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
public class VideoSample2 {
    
    //
    private javax.swing.JLabel jLblFpsNow;
    private javax.swing.JLabel jLblFpsMax;
    private javax.swing.JLabel jLblFpsMin;
    private javax.swing.JLabel jLblFpsAvg;
    
     /**
     * 200ms calcute period (ns)
     */
    private static final long PERIOD = (long) (1000000000L / 5); 

    /**
     * Credits: https://github.com/1860yk/FpsService/blob/master/src/com/baidu/fps/FpsView.java
     * This is the best fps calculation found till now
     */   
    private static long FPS_MAX_INTERVAL = 1000000000L; 
    
    private double mNowFPS = 0.0;
    private double mMaxFps = 0.0;
    private double mMinFps = Double.MAX_VALUE;
    private double mAvgFps = 0.0;
        
    private long mInterval = 0L;
    private long mLastTime = 0L;
    private long mTime = -1;
    private long mFrameCount = 0;
    private long mCaculateTimes = 0; 
    
    //
    private WebCamSample2 threadwebcamsample2 = null;
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
    VideoSample2(javax.swing.JLabel ImagePreview)
    {
        this.imagelabel = ImagePreview;
    }
    
    //
    public void SetEnvLabelsInfo(javax.swing.JLabel jLblFpsNow,javax.swing.JLabel jLblFpsMax,javax.swing.JLabel jLblFpsMin,javax.swing.JLabel jLblFpsAvg)
    {
        this.jLblFpsNow = jLblFpsNow; 
        this.jLblFpsMax = jLblFpsMax;
        this.jLblFpsMin = jLblFpsMin;
        this.jLblFpsAvg = jLblFpsAvg;
    }
    
    //
    public void StartWebCamSample2()
    {
        runable = true;
        
        threadwebcamsample2 = new WebCamSample2();
        t_webcam            = new Thread(threadwebcamsample2);
        t_webcam.setDaemon(true);
        t_webcam.start();     
    }

    //
    public void StopWebCamSample2()
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
    
    
    class WebCamSample2 implements Runnable
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
                    /**
                     * 
                     */
                    if(mLastTime == 0)
                    {
                        mLastTime = System.nanoTime();
                        mTime = System.nanoTime();
                    }
                    
                    /**
                     * 
                     */
                    cap.retrieve(frame);
                                                
                    image = (BufferedImage) ToBufferedImageArrayCopy(frame);
        
                    icon = new javax.swing.ImageIcon(image);

                    imagelabel.setIcon(icon);
                    
                    /**
                     * 
                     */ 		
                    long timeNow = System.nanoTime();
                    mFrameCount++;
                    mInterval += timeNow - mLastTime;
                    mLastTime = timeNow;
                    
                    if (mInterval >= PERIOD)
                    {
                        // nanoTime()
                        long realTime = timeNow - mTime /*- (interval - PERIOD)*/;
                        // caculate to real fps 
                        mNowFPS = ((double) mFrameCount / realTime) * FPS_MAX_INTERVAL;

                        // show
                        if(mNowFPS > mMaxFps)
                        {
                            mMaxFps = mNowFPS;
                            jLblFpsMax.setText(Double.toString((double)mMaxFps).substring(0, 4));
                        }
                            
                        if(mNowFPS < mMinFps)
                        {
                            mMinFps = mNowFPS;
                            jLblFpsMin.setText(Double.toString((double)mMinFps).substring(0, 4));
                        }

                        mAvgFps = (double)(mAvgFps * mCaculateTimes + mNowFPS) / (mCaculateTimes + 1);
                        mCaculateTimes ++;

                        // reset
                        mFrameCount = 0L;
                        mInterval = 0;
                        mTime = timeNow;
                        try
                        {
                            jLblFpsNow.setText(Double.toString((double)mNowFPS).substring(0, 4));
                            jLblFpsAvg.setText(Double.toString((double)mAvgFps).substring(0, 4));
                        }
                        catch(Exception e)
                        {
                           
                        }
                    }
                }
            
            }//end while
            cap.release();
        }//end run
    }
}
