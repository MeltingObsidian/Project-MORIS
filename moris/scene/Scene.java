package moris.scene;

import moris.scene.object.Renderable;
import moris.scene.object.camera.Camera;

import java.util.ArrayList;
import java.util.Collections;

public class Scene {
    ArrayList<Renderable> sceneObjects = new ArrayList<Renderable>();

    Camera activeCamera;

    private Scene(){}
    private Scene(Renderable object){
        sceneObjects.add(object);
    }
    private Scene(Renderable... objects){
        Collections.addAll(sceneObjects, objects);
    }
    public static Scene createEmpty(){
        return new Scene();
    }
    public static Scene createWithSingleObject(Renderable object){
        return new Scene(object);
    }
    public static Scene createWithMultipleObjects(Renderable... objects){
        return new Scene(objects);
    }

    public ArrayList<Renderable> getSceneObjects() {
        return sceneObjects;
    }
    public void setActiveCamera(Camera activeCamera) {
        this.activeCamera = activeCamera;
    }
    public Camera getActiveCamera() {
        return activeCamera;
    }
}
