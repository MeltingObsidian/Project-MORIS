package moris.scene.object.camera;

import moris.scene.object.Object;

public interface Camera extends Object {
    double getFov();
    int getWidth();
    int getHeight();
}
