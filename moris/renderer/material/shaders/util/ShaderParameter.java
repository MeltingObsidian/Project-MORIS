package moris.renderer.material.shaders.util;

public class ShaderParameter {
    private final int type;

    public static final int COLOR = 0;
    public static final int INTEGER = 1;
    public static final int FLOATING_POINT = 2;

    public ShaderParameter(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
