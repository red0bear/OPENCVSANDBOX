# OPENCVSANDBOX

###Help me to survive at this ugly world donating(2 BTC)
- 16TiZzX9c1xrKhRUu7vMRZbGw2wc7bzTop

###About this work

 I would like have many samples good to learn in how to build things correctly. But we know we have many ways to do ; but not one simple to start. After a long time i started build to myself this samples, but i dont see some future if i just take it to myself. So im sharing what i have been learned till now about opencv java with samples and at least some tricks "i dont see them like tricks but is the first word come at my mind". 

 i wish you could use it and make something good. At least i hope people help me back. 

###Linux Setup on Netbeans

- Obs:i like to compile opencv to specific to my machine , and i never used on linux this setup by packages

- Path to compiled libs when you go find .so: -Djava.library.path="path_where_you_compiled_opencv/lib"

- Path to jni jar when you are going to add libs: path_where_you_compiled_opencv/bin/opencv-310.jar

- On java add this on main call at your java app: System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

###Windows setup on Netbeans

- Path to compiled libs when you go find .dll: -Djava.library.path="C:\opencv\build\java\x64\"

- Path to jni jar when you are going to add libs: C:\opencv\build\java\opencv-310.jar

- On java add this on main : System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


###SAMPLE 1 

 This sample cover the basic call of webcam using Graphical interface using:
 - Threads on java
 - Open a webcam 
 - Convert a Mat to BufferedImage 
 - Display image on application "jpg"

###SAMPLE 2 

 This sample show how to calculate a FPS using:
 - Threads on java
 - Open a webcam 
 - Convert a Mat to BufferedImage 
 - Display image on application "jpg"
 - FPS example FPSNow/Max/Min/Avg

###SAMPLE 3 

 This sample show how to change resolution using:
 - Threads on java
 - Open a webcam 
 - Convert a Mat to BufferedImage 
 - Display image on application "jpg"
 - I used v4l2 aplication command to take resolution from my Webcam # v4l2-ctl --list-formats-ext

###SAMPLE 4 

 This sample show the efect you change quality of image and encode it on Base64 and use:
 - Threads on java
 - Open a webcam 
 - Convert a Mat to BufferedImage 
 - Display image on application "jpg"
 - I used v4l2 aplication command to take resolution from my Webcam # v4l2-ctl --list-formats-ext
 - Using Base64 to encode byte array according this link: https://en.wikipedia.org/wiki/Base64
 - Changing the quality of image between

