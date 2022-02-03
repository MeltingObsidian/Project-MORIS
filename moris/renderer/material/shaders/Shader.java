package moris.renderer.material.shaders;

import moris.renderer.material.shaders.util.ShaderParameter;

import java.util.ArrayList;

public interface Shader {
    public ArrayList<ShaderParameter> SHADER_PARAMETERS = new ArrayList<>();

    public ArrayList<ShaderParameter> getInputs();
}
