package moris.scene.object.geometry.util;

import moris.exception.MORISIllegalMethodCallException;
import moris.util.Ray;
import moris.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class Face {
    ArrayList<Vector> vertices;
    ArrayList<Triangle> triangles;

    private boolean tCalc = false;
    private double t;
    private Vector P;

    public Face() {
        vertices = new ArrayList<>();
        triangles = new ArrayList<>();
    }

    public void addVertex(Vector v) {
        vertices.add(v);
    }

    public void addVertices(Vector...vectors) {
        vertices.addAll(Arrays.asList(vectors));
    }

    public ArrayList<Vector> getVertices() {
        return vertices;
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setVertices(ArrayList<Vector> vertices) {
        this.vertices = vertices;
    }

    public void clear() {
        vertices.clear();
        triangles.clear();
    }

    public boolean intersects(Ray ray) throws MORISIllegalMethodCallException {
        for (Triangle triangle : triangles) {
            if (triangle.intersects(ray)) {
                tCalc = true;
                t = triangle.getDepth();
                P = triangle.getIntersectionPoint();
                return true;
            }
        }
        return false;
    }

    public double getDepth() throws MORISIllegalMethodCallException {
        if (!tCalc) throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.util.Face.getDepth()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.util.Face.intersects(moris.util.Ray)\"");
        return t;
    }

    public Vector getIntersectionPoint() throws MORISIllegalMethodCallException {
        if (!tCalc) throw new MORISIllegalMethodCallException("Method \"moris.scene.object.geometry.util.Face.getIntersectionPoint()\" should only be used within an if block with one of the conditions as method \"moris.scene.object.geometry.util.Face.intersects(moris.util.Ray)\"");
        return P;
    }
}
