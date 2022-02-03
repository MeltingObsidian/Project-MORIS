package moris.scene.object.dynamic;

import moris.exception.MORISIllegalMethodCallException;
import moris.scene.object.Renderable;
import moris.util.Ray;
import moris.util.Vector;

public class Sphere implements Renderable {
    Vector origin;
    double radius;

    private Vector P;
    private double t;
    private boolean tCalc;

    private Sphere(Vector origin, double radius){
        this.origin = origin;
        this.radius = radius;
    }
    public static Sphere createAt(Vector origin, double radius){
        return new Sphere(origin, radius);
    }

    @Override
    public Vector getIntersectionPoint() throws MORISIllegalMethodCallException {
        if (tCalc) return P;
        else throw new MORISIllegalMethodCallException("Method \"moris.scene.object.dynamic.Sphere.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.dynamic.Sphere.intersects(moris.util.Ray)\"");
    }
    @Override
    public double getDepth() throws MORISIllegalMethodCallException {
        if (tCalc) return t;
        else throw new MORISIllegalMethodCallException("Method \"moris.scene.object.dynamic.Sphere.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.dynamic.Sphere.intersects(moris.util.Ray)\"");
    }
    @Override
    public boolean intersects(Ray ray){
        Vector o = ray.origin;
        Vector d = ray.direction;
        Vector oc = o.sub(origin);
        double b = 2*oc.dot(d);
        double c = oc.dot(oc)- radius * radius;
        double disc = b*b-4*c;
        if(disc < 1e-4){
            return false;
        }else{
            disc = Math.sqrt(disc);
            double t0 = -b-disc;
            double t1 = -b+disc;
            
            t = Math.min(t0, t1);
            P = ray.origin.add(ray.direction.mul(t));
            tCalc = true;
            return true;
        }
    }

    public Vector getNormal(){
        return P.sub(origin).normalize();
    }

    @Override
    public void setOrigin(Vector origin) {
        this.origin = origin;
    }
    @Override
    public void setDirection(Vector direction) {}
    @Override
    public Vector getOrigin() {
        return origin;
    }
    @Override
    public Vector getDirection() {
        return new Vector();
    }
}