package ca.sfu.cmpt276a2.Model;

/**
 * Lens class simulating the make, maximum aperture and focal length of a camera lens.
 */
public class Lens {

    private String make;
    private double maxAperture;
    private double focalLength;

    //Constructor
    public Lens(String make, double maxAperture, double focalLength){

        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLength = focalLength;

    }

    public String getMake() {
        return make;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }

    @Override
    public String toString() {
        return make + ' ' + maxAperture + "mm F" + focalLength;
    }
}
