package br.com.pdi.models;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class HoughCircles {

	public void run(Mat src) {

		if (src.empty()) {
			System.out.println("Error opening image!");
			System.exit(-1);
		}
		
		Mat gray = ColorToGrayscale.imageToGray(src);
		
		Imgproc.medianBlur(gray, gray, 7);
		
		Mat circles = new Mat();

		Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0, 15, 255.0, 17, 10, 75);
		
		for (int x = 0; x < circles.cols(); x++) {
			double[] c = circles.get(0, x);
			Point center = new Point(Math.round(c[0]), Math.round(c[1]));
			// circle center
			Imgproc.circle(src, center, 1, new Scalar(0, 200, 0), 3, 8, 0);
			// circle outline
			int radius = (int) Math.round(c[2]);
			Imgproc.circle(src, center, radius, new Scalar(255, 0, 255), 3, 8, 0);
		}
		HighGui.imshow("detected circles", src);
		HighGui.waitKey();
		System.exit(0);
	}
}