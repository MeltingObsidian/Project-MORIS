package moris.renderer;

import moris.exception.MORISIllegalMethodCallException;
import moris.scene.Scene;
import moris.scene.object.Renderable;
import moris.scene.object.camera.Camera;
import moris.scene.object.camera.PerspectiveCamera;
import moris.util.Ray;
import moris.util.Vector;

import java.awt.image.BufferedImage;

public abstract class MORISRT {
    private static boolean propertiesAreSet =false;
    static int MAX_BOUNCES;
    static double CLIP_START;
    static double CLIP_END;

    public static void setProperties(int maxBounces, double clipStart, double clipEnd){
        MAX_BOUNCES = maxBounces;
        CLIP_START = clipStart;
        CLIP_END = clipEnd;
        propertiesAreSet = true;
    }

    public void render(Scene scene) throws MORISIllegalMethodCallException{
        if(propertiesAreSet){
            Camera activeCamera = scene.getActiveCamera();

            for (int x = 0; x < activeCamera.getWidth(); x++) {
                for (int y = 0; y < activeCamera.getHeight(); y++) {
                    Ray ray = Ray.create(activeCamera.getOrigin(), new Vector(x - activeCamera.getWidth()/2.0, activeCamera.getHeight()/2.0 - y, -(activeCamera.getHeight()/2.0)/Math.tan(activeCamera.getFov() * 0.5)).mul(activeCamera.getDirection()).normalize());
                    for (Renderable object : scene.getSceneObjects()) {
                        if (object.intersects(ray)){

                        }
                    }
                }
            }
        }else {
            throw new MORISIllegalMethodCallException("The method moris.renderer.MORISRT.setProperties(int, double) should be executed before invoking the method moris.renderer.MORISRT.render(moris.scene.Scene)");
        }
    }

    abstract void onImageRendered(BufferedImage renderedImage);
}
