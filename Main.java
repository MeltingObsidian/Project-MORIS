import moris.exception.MORISIllegalMethodCallException;
import moris.scene.object.dynamic.Sphere;
import moris.scene.object.geometry.util.Triangle;
import moris.util.Ray;
import moris.util.Vector;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

class Main {
    /**This method creates an image in the project folder with ray-traced sphere(s).*/
    public static void main(String[] args) throws MORISIllegalMethodCallException {
        long start = System.nanoTime();
        final int width = 500;
        final int height = 500;

        double r , g, b;
        double str = Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2))/1.35;
        double dt;

        Sphere sphere = Sphere.createAt(new Vector(width/2.0, height/2.0, 20), 150);
        Sphere sphere2 = Sphere.createAt(new Vector(20, 300, 1), 50);
        Vector L = new Vector(10, 80, -350);//new Vec(0, 0, 0);

        Color grey = new Color(180, 180, 220);
        Color out;
        File image = new File("render.png");
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                /*Sphere intersection test*/
                Ray ray = Ray.create(new Vector(x, y, 0), new Vector(0, 0, 1));
                if(sphere.intersects(ray)){
                    Vector vector = L.sub(sphere.getIntersectionPoint());
                    if (vector.dot(sphere.getNormal()) > 1e-6){
                        dt = L.distance(sphere.getIntersectionPoint());
                        r = (str-dt)*0.7; g = (str-dt);b = (str-dt)*0.5;
                        out = Vector.clamp255(r, g, b);

                        buffer.setRGB(x, y, out.getRGB());
                    }

                }else if(sphere2.intersects(ray)){
                    Ray sec = Ray.create(sphere2.getIntersectionPoint(), L.sub(sphere2.getIntersectionPoint()).getDirection());
                    if ((!sphere.intersects(sec)) && L.sub(sphere2.getIntersectionPoint()).dot(sphere2.getNormal()) > 0){
                        dt = L.distance(sphere2.getIntersectionPoint());
                        r = (str-dt); g = (str-dt);b = str-dt;
                        out = Vector.clamp255(r, g, b);

                        buffer.setRGB(x, y, out.getRGB());
                    }
                }else{
                    buffer.setRGB(x, y, grey.getRGB());
                }
            }
        }

        try{
            ImageIO.write(buffer, "PNG", image);
            System.out.println("Image rendered successfully");
        }catch(Exception e){
            System.out.println("Could not render image");
            System.exit(1);
        }
        long end = System.nanoTime();
        System.out.println("Render Time: "+(end-start)/1000000000f+" seconds");
    }
}