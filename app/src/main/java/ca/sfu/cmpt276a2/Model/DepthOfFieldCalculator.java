package ca.sfu.cmpt276a2.Model;

import java.text.DecimalFormat;

/**
 * A class designed to spit out an object containing specific calculated values for a camera lens
 * taking a photo of an object at a particular Distance using a certain Aperture
 */
public class DepthOfFieldCalculator {

    private double depthOfField;

    private double hyperFocalDistance;
    private double nearFocalPoint;
    private double farFocalPoint;

    private final double circleOfConfusion = 0.029; // "Circle of Confusion" for a "Full Frame" camera
    // Transferred from CameraUI class

    public DepthOfFieldCalculator(Lens lens, double distance, double aperture){
        distance *= 1000;//conversion from m to mm

        this.hyperFocalDistance = Math.pow(lens.getFocalLength(), 2) / (aperture * circleOfConfusion);

        this.nearFocalPoint = (this.hyperFocalDistance * distance) /
                (this.hyperFocalDistance + ( distance - lens.getFocalLength() ) );
        this.nearFocalPoint = this.nearFocalPoint/1000;//conversion to m

        if(distance > this.hyperFocalDistance)
            this.farFocalPoint = Double.POSITIVE_INFINITY;
        else{
            this.farFocalPoint = (this.hyperFocalDistance * distance) /
                    (this.hyperFocalDistance - ( distance - lens.getFocalLength() ) );
            this.farFocalPoint = this.farFocalPoint/1000;//conversion to m
        }

        this.hyperFocalDistance /= 1000;//conversion to m
        this.depthOfField = this.farFocalPoint - this.nearFocalPoint;//result in m
    }

    public double getDepthOfField() {
        return depthOfField;
    }

    public double getNearFocalPoint() {
        return nearFocalPoint;
    }

    public double getFarFocalPoint() {
        return farFocalPoint;
    }

    public double getHyperFocalDistance() { return hyperFocalDistance; }
}
