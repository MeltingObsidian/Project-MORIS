package moris.scene.object.geometry;

import moris.exception.MORISIllegalMethodCallException;
import moris.scene.object.geometry.util.Face;
import moris.util.Ray;
import moris.util.Vector;

import java.util.*;

public class Mesh {
    ArrayList<Face> faces;

    boolean tCalc = false;
    double t;
    Vector P;

    public Mesh() {
        faces = new ArrayList<>();
    }

    public void addFace(Face face) {
        faces.add(face);
    }

    public void addFaces(Face...faces) {
        this.faces.addAll(Arrays.asList(faces));
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public void clear() {
        faces.clear();
    }

    public void setFaces(ArrayList<Face> faces) {
        this.faces = faces;
    }

    public boolean intersects(Ray ray) throws MORISIllegalMethodCallException {
        Map<Double, Vector> t = new HashMap<>();
        double smallest = Double.MAX_VALUE;
        for (Face face : faces) {
            if (face.intersects(ray)) {
                t.put(face.getDepth(), face.getIntersectionPoint());
                smallest = Math.min(smallest, face.getDepth());
            }
        }
        this.t = smallest;
        this.P = t.get(smallest);
        return !t.isEmpty();
    }

    public double getDepth() throws MORISIllegalMethodCallException {
        if (!tCalc) throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.Mesh.getDepth()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.Mesh.intersects(moris.util.Ray)\"");
        return t;
    }

    public Vector getIntersectionPoint() throws MORISIllegalMethodCallException {
        if (!tCalc) throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.Mesh.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.Mesh.intersects(moris.util.Ray)\"");
        return P;
    }
}
