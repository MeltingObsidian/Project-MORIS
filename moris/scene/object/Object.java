package moris.scene.object;

import moris.util.Vector;

public interface Object {
    void setOrigin(Vector origin);
    void setDirection(Vector direction);

    Vector getOrigin();
    Vector getDirection();
}
