package moris.util;

import java.awt.Color;

/**
 * Class for creating and operating on Vectors
 * */
public class Vector {
    public double x, y, z;
    
    /**
     * Creates a 3D Vector object with coordinates (0, 0, 0)
    */
    public Vector(){
        x = y = z = 0;
    }
    /**
     * Creates a Vector object with the all coordinates same
     * */
    public Vector(double d){
        x = y = z = d;
    }
    /**
     * Creates a 3D Vector with the given coordinates
    */
    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns a new Vector object after adding one Vector to another
     * */
    public Vector add(Vector v){
        return new Vector(x+v.x, y+v.y, z+v.z);
    }
    /**
     * Returns a new Vector object after subtracting one Vector from another
     * */
    public Vector sub(Vector v){
        return new Vector(x-v.x, y-v.y, z-v.z);
    }
    /**
     * Returns a new Vector object after multiplying one Vector with another
     * */
    public Vector mul(Vector v){
        return new Vector(x*v.x, y*v.y, z*v.z);
    }
    /**
     * Returns a new Vector object after dividing one Vector by another
     * */
    public Vector div(Vector v){
        return new Vector(x/v.x, y/v.y, z/v.z);
    }

    /**
     * Returns a new Vector object after adding one Vector to another
     * */
    public Vector add(double d){
        return add(new Vector(d));
    }
    /**
     * Returns a new Vector object after subtracting one Vector from another
     * */
    public Vector sub(double d){
        return sub(new Vector(d));
    }
    /**
     * Returns a new Vector object after multiplying one Vector with another
     * */
    public Vector mul(double d){
        return mul(new Vector(d));
    }
    /**
     * Returns a new Vector object after dividing one Vector by another
     * */
    public Vector div(double d){
        return div(new Vector(d));
    }

    /**
     * Returns the distance between two Vectors
     * */
    public double distance(Vector v){
        return Math.sqrt(Math.pow((v.x-x), 2) + Math.pow((v.y-y), 2) + Math.pow((v.z-z), 2));
    }
    /**
     * Returns the dot product of two Vectors
     * */
    public double dot(Vector v){
        return (x*v.x + y*v.y + z*v.z);
    }
    public Vector cross(Vector v){
        return new Vector(
                y*v.z - z*v.y,
                z*v.x - x*v.z,
                x*v.y - y*v.x
        );
    }
    /**
     * Returns the magnitude of the Vector Object
     * */
    public double getMagnitude(){
        return Math.sqrt(x*x + y*y + z*z);
    }
    /**
     * Returns a color after clamping all the values between 0 and 255
     * */
    public static Color clamp255(double r, double g, double b){
         r = (r > 255) ? 255 : (r < 0) ? 0 : r;
         g = (g > 255) ? 255 : (g < 0) ? 0 : g;
         b = (b > 255) ? 255 : (b < 0) ? 0 : b;
         return new Color((int)r, (int)g, (int)b);
    }

    /**
     * Returns a new Vector object after multiplying one Vector with another
     * */
    public Vector dot(double d){
        return new Vector(x*d, y*d, z*d);
    }
    /**
     * Returns this Vector after normalizing it
     * */
    public Vector normalize(){
        return div(getMagnitude());
    }
    /**
     * Returns the direction of this Vector
     * */
    public Vector getDirection(){
        return normalize();
    }
}