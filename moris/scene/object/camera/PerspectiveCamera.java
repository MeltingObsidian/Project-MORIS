package moris.scene.object.camera;

import moris.util.Vector;

/**Class used to Create PerspectiveCamera objects*/
public class PerspectiveCamera implements Camera{
    private final int width;
    private final int height;

    private Vector origin;
    private Vector direction;

    private double fov;

    /**Creates a PerspectiveCamera object taking in the resolution and Field of View*/
    public PerspectiveCamera(int width, int height, double fov){
        this.width = width;
        this.height = height;
        this.fov = fov;
    }

    /**Sets the Field of View of the PerspectiveCamera object*/
    public void setFov(double fov) {
        this.fov = fov;
    }

    @Override
    public double getFov() {
        return fov;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
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
        return direction;
    }
}
