package moris.scene.object;

import moris.exception.MORISIllegalMethodCallException;
import moris.util.Ray;
import moris.util.Vector;

public interface Renderable extends Object{
    boolean intersects(Ray ray);

    double getDepth() throws MORISIllegalMethodCallException;
    Vector getIntersectionPoint() throws MORISIllegalMethodCallException;
}
