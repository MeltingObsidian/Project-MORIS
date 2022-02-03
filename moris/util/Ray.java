package moris.util;

public class Ray{
    public Vector origin;
    public Vector direction;
    
    /**
     * Creates a Ray object with two Vector object parameters
    */
    private Ray(Vector origin, Vector direction){
    
        this.origin = origin;
        this.direction = direction;
    
    }

    public static Ray create(Vector origin, Vector direction){
        return new Ray(origin, direction);
    }

    public Vector getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }
}