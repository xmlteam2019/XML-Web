package helperclasses;

import java.awt.geom.Point2D;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;

import mainmodel.Smestaj;

public class DistanceMath {
	
	/*
	public static double calculateAverageDistance(Point2D selectedPoint, ArrayList<Point2D> points) {
		if(points.size() != 0) {
			double sum = 0;
			for(Point2D p : points) {
				sum += calculateDistance(selectedPoint, p);
			}
			return sum/points.size();
		}
		return 0;
	}
	*/
	
	public static double calculateAverageDistance(double selectedX, double selectedY, ArrayList<Smestaj> smestaji) {
		if(smestaji.size() != 0) {
			double sum = 0;
			for(Smestaj s : smestaji) {
				sum += calculateDistance(selectedX, selectedY, s.getLokacija().getCoordX(), s.getLokacija().getCoordY());
			}
			return sum/smestaji.size();
		}
		return 0;
	}
	
	public static double calculateAverageDistance(Point2D selectedPoint, ArrayList<Smestaj> smestaji) {
		if(smestaji.size() != 0) {
			double sum = 0;
			for(Smestaj s : smestaji) {
				sum += calculateDistance(selectedPoint, s.getLokacija().getCoordinates());
			}
			return sum/smestaji.size();
		}
		return 0;
	}
	
	public static double calculateDistance(double x1, double y1, double x2, double y2) {		
		return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));		
	}
	
	public static double calculateDistance(Point2D p1, Point2D p2) {		
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));		
	}

	public static HashMap<Smestaj, Double> calculateAndGenerateDistances(Point2D p, ArrayList<Smestaj> smestaji) {

		HashMap<Smestaj, Double> result = new HashMap<Smestaj, Double>();
		for(Smestaj s: smestaji) {
			result.put(s, calculateDistance(p, s.getLokacija().getCoordinates()));
		}
		
		return result;
	}
	
}
