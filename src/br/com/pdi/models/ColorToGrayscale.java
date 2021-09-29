package br.com.pdi.models;

import java.awt.Color;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class ColorToGrayscale {

	public static Mat imageToGray(Mat source) {
		double red = 0, green = 0, blue = 0, gray = 0;
		Mat dst = new Mat(source.rows(), source.cols(), CvType.CV_8UC1);
		// Imgproc.cvtColor(source, dst, Imgproc.COLOR_RGB2GRAY);

		for (int i = 0; i < source.rows(); i++) {
			for (int j = 0; j < source.cols(); j++) {
				double pixel[] = source.get(i, j);

				red = pixel[0];
				green = pixel[1];
				blue = pixel[2];

				gray = (blue*2 + green/6 - red) / 3;
				
				dst.put(i, j, gray);

			}
		}

		return dst;
	}

}
