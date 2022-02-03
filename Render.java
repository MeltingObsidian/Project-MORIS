import moris.scene.object.geometry.util.Triangle;
import moris.util.Ray;
import moris.util.Vector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render {
    public static void main(String[] args) throws IOException {
        int width = 200;
        int height = 200;

        Vector a = new Vector(100, 0, 10);
        Vector b = new Vector(0, 200, 10);
        Vector c = new Vector(200, 200, 10);
        Triangle triangle = new Triangle(a, b, c);

        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Color triangleColor = new Color(255, 0, 0);
        Color backgroundColor = new Color(100, 100, 100);
        File image = new File("image.png");

        long start = System.nanoTime();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Ray ray = Ray.create(new Vector(x, y, 0), new Vector(0, 0, 1));
                if(triangle.intersects(ray)) {
                    buffer.setRGB(x, y, triangleColor.getRGB());
                } else {
                    buffer.setRGB(x, y, backgroundColor.getRGB());
                }
            }
        }
        ImageIO.write(buffer, "png", image);

        long end = System.nanoTime();
        System.out.println("Render time: " + (end - start) / 1000000 + "ms");
    }
}
