package base;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.*;
import org.bytedeco.ffmpeg.avutil.*;
import org.bytedeco.javacv.FrameGrabber.Exception;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ScreenRecorderUtil {
    private static OpenCVFrameGrabber grabber;
    private static FFmpegFrameRecorder recorder;

    public static void startRecording(String outputFilePath) throws Exception, FFmpegFrameRecorder.Exception, AWTException, InterruptedException {
        // Set up frame grabber for capturing screen
        grabber = new OpenCVFrameGrabber(0); // 0 for default screen capture
        grabber.start();

        // Set up frame recorder for MP4 output
        recorder = new FFmpegFrameRecorder(outputFilePath, grabber.getImageWidth(), grabber.getImageHeight());
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);  // Set the video codec to H.264
        recorder.setFormat("mp4");  // Set output format to MP4
        recorder.setFrameRate(30);  // Set the frame rate (fps)
        recorder.setVideoBitrate(2500000);  // Set bitrate for quality

        recorder.start();
        for (int i = 0; i < 300; i++) {
            BufferedImage screenCapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            recorder.record(new Java2DFrameConverter().convert(screenCapture));
            Thread.sleep(33); // Sleep for ~33ms (for ~30 fps)
        }
    }

    public static void stopRecording() throws Exception, FrameRecorder.Exception {
        // Stop recording and cleanup
        recorder.stop();
        grabber.stop();
    }

}
