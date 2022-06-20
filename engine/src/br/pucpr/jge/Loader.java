package br.pucpr.jge;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Loader {
    private String root;
    private Map<String,BufferedImage> objectPool = new HashMap<String,BufferedImage>();

    public Loader(String root) {
        this.root = root;
    }

    public Loader() {
        this("/assets");
    }

    BufferedImage createErrorImage() {
        var img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        var g2d = img.getGraphics();
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(0, 0, 100, 100);
        g2d.dispose();

        return img;
    }

    public BufferedImage loadImage(String path) {
        var name = root + path;
        try {
            if (objectPool.get(path) != null){
                return objectPool.get(path);
            }else {
                objectPool.put(path, ImageIO.read(getClass().getResourceAsStream(name)));
                return objectPool.get(path);
            }

        } catch (Exception e) {
            System.err.println("Unable to load " + name);
            return createErrorImage();
        }
    }
}
