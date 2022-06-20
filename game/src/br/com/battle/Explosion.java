package br.com.battle;

import br.pucpr.jge.AbstractGameObject;
import br.pucpr.jge.InputManager;

import java.awt.*;

public class Explosion extends AbstractGameObject{
    private double interval = 0.3;
    private int explosionY;
    private int explosionX;

    public Explosion(int x, double y) {
        super("/image/explosion.png", x, y);
        this.explosionY = 0;
        this.explosionX = 0;
    }

    public void update(double s, InputManager keys) {
        interval += s;
        if (interval > 0.2) {
            explosionY += 68;
            interval = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        var x = (int) getX();
        var y = (int) getY();
        g2d.drawImage(sprite,
                x, y, x+68,y+51,
                explosionY, explosionX, explosionY +68, explosionX +51,
                null);
    }

    @Override
    public boolean isInGame() {
        return explosionY < 680;
    }

}
