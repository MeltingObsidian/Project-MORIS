package moris.scene.object.geometry.util;

import moris.exception.MORISIllegalMethodCallException;
import moris.scene.object.Renderable;
import moris.util.Ray;
import moris.util.Vector;

public class Triangle implements Renderable {
    Vector A, B, C;

    Vector origin;
    Vector direction;

    private boolean tCalc = false;
    private Vector P;
    private double t;

    public Triangle(Vector A, Vector B, Vector C){
        this.A = A;
        this.B = B;
        this.C = C;
        calculateOrigin();
    }

    private void calculateOrigin(){
        origin = A.add(B.add(C)).div(3);
    }

    @Override
    public void setOrigin(Vector origin) {
        this.origin = origin;
    }
    @Override
    public void setDirection(Vector direction) {
        this.direction = direction;
    }
    @Override
    public Vector getOrigin() {
        return origin;
    }
    @Override
    public Vector getDirection() {
        Vector AB = B.sub(A);
        Vector AC = C.sub(A);

        direction = AB.cross(AC);
        return direction;
    }
    @Override
    public boolean intersects(Ray ray) {
        Vector edge1 = B.sub(A);
        Vector edge2 = C.sub(A);
        Vector pvec = ray.getDirection().cross(edge2);
        double det = edge1.dot(pvec);
        if (det > -1e-6 && det < 1e-6) {
            return false;
        }
        double inv_det = 1.0 / det;
        Vector tvec = ray.getOrigin().sub(A);
        double u = tvec.dot(pvec) * inv_det;
        if (u < 0.0 || u > 1.0) {
            return false;
        }
        Vector qvec = tvec.cross(edge1);
        double v = ray.getDirection().dot(qvec) * inv_det;
        if (v < 0.0 || u + v > 1.0) {
            return false;
        }
        double t = edge2.dot(qvec) * inv_det;
        if (t > 1e-6) {
            P = ray.getOrigin().add(ray.getDirection().mul(t));
            this.t = t;
            tCalc = true;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double getDepth() throws MORISIllegalMethodCallException {
        if (tCalc)
            return t;
        else
            throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.util.Triangle.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.util.Triangle.intersects(moris.util.Ray)\"");
    }
    @Override
    public Vector getIntersectionPoint() throws MORISIllegalMethodCallException {
        if (tCalc)
            return P;
        else
            throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.util.Triangle.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.util.Triangle.intersects(moris.util.Ray)\"");
    }
}
