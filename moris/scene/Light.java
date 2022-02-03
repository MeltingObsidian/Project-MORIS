package moris.scene;

import moris.scene.object.Object;

import java.awt.*;

public interface Light extends Object {
    double getStrength();
    Color getColor();

    void setStrength(double strength);
    void setColor(Color color);
}
