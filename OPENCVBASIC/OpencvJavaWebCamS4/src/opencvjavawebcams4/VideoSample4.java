/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvjavawebcams4;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.ImageIcon;
import javax.xml.bind.DatatypeConverter;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import static org.opencv.videoio.Videoio.CV_CAP_PROP_FRAME_HEIGHT;
import static org.opencv.videoio.Videoio.CV_CAP_PROP_FRAME_WIDTH;

/**
 *
 * @author felipe
 */
public class VideoSample4 {
    
    //
    private WebCamSample4 threadwebcamsample4 = null;
    private Thread t_webcam;
    
    //
    private BufferedImage image;
    private ImageIcon icon;
    
    //
    private javax.swing.JLabel imagelabel;
    
    //
    private javax.swing.JLabel jLblBase64Size;
    private javax.swing.JLabel jLblNormalSize;
    
    //
    private VideoCapture  cap;
    private Mat frame;
    
    //
    private boolean runable  = true;
    
    //
    private String rvalues [];
    private boolean set_resolution = false;
    
    //
    private float qualityimage = 0.75f;
    
    //
    private ByteArrayOutputStream baos;
    
    
    //
    VideoSample4(javax.swing.JLabel ImagePreview)
    {
        this.imagelabel = ImagePreview;
    }
    
    //
    public void StartWebCamSample4()
    {
        runable = true;
        
        threadwebcamsample4 = new WebCamSample4();
        t_webcam            = new Thread(threadwebcamsample4);
        t_webcam.setDaemon(true);
        t_webcam.start();     
    }

    //
    public void StopWebCamSample4()
    {
        runable = false;
    }  
    
    //
    public void SetEnvLabels(javax.swing.JLabel jLblBase64Size,javax.swing.JLabel jLblNormalSize)
    {
        this.jLblBase64Size = jLblBase64Size;
        this.jLblNormalSize = jLblNormalSize;
    } 
    
    //
    public void SetResolution(String Resolution)
    {
                    
        rvalues = Resolution.split(":");
        
        set_resolution = true;
    
    }   
    
    //
    public void ChangeQuality(String QualityImage)
    {
            if(QualityImage.compareTo("10") == 0)
            {
                qualityimage = 0.10f;
            }else if(QualityImage.compareTo("20") == 0)
            {
                qualityimage = 0.20f;
            }else if(QualityImage.compareTo("30") == 0)
            {
                qualityimage = 0.30f;
            }else if(QualityImage.compareTo("40") == 0)
            {
                qualityimage = 0.40f;
            }else if(QualityImage.compareTo("50") == 0)
            {
                qualityimage = 0.50f;
            }else if(QualityImage.compareTo("60") == 0)
            {
                qualityimage = 0.60f;
            }else if(QualityImage.compareTo("70") == 0)
            {
                qualityimage = 0.70f;
            }else if(QualityImage.compareTo("75") == 0)
            {
                qualityimage = 0.75f;
            }else if(QualityImage.compareTo("80") == 0)
            {
                qualityimage = 0.80f;
            }else if(QualityImage.compareTo("90") == 0)
            {
                qualityimage = 0.90f;
            }else if(QualityImage.compareTo("100") == 0)
            {
                qualityimage = 1.0f;
            }

    }
    
    /**
     * Credits : http://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
     */
    private static String HumanReadableByteCount(long bytes, boolean si) 
    {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
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
    
    
    class WebCamSample4 implements Runnable
    {       
        @Override
        public void run() 
        {
            baos = new ByteArrayOutputStream();
            
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
                    
                    baos.reset();
                                       
                    try {
                        
                        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
                        ImageWriter writer = iter.next();
                        ImageWriteParam iwp = writer.getDefaultWriteParam();
                        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                        iwp.setCompressionQuality(qualityimage);
                        writer.setOutput(new MemoryCacheImageOutputStream(baos));
                        writer.write(null, new IIOImage(image,null,null),iwp);
                        writer.dispose();  
                        
                        icon = new javax.swing.ImageIcon(ImageIO.read(new ByteArrayInputStream(baos.toByteArray())));
                        
                        jLblBase64Size.setText(HumanReadableByteCount(DatatypeConverter.printBase64Binary(baos.toByteArray()).length(),true));
                        jLblNormalSize.setText(HumanReadableByteCount(baos.toByteArray().length,true));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(VideoSample4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    

                    imagelabel.setIcon(icon);
                    
                }
            
            }//end while
            cap.release();
        }//end run
    }
}
