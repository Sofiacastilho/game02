package br.pucpr.jge;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    protected double x;
    protected double y;
    protected BufferedImage sprite;
    private String spriteName;
    private boolean inGame = true;

    public GameObject(String spriteName, double x, double y) {
        this.spriteName = spriteName;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void load() {
        sprite = new Loader().loadImage(spriteName);
    }

    public void update(double s, InputManager keys) {
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(sprite, (int)x, (int)y, null);
    }

    public boolean isInGame() {
        return inGame;
    }

    public Rectangle hitbox(){
        return(new Rectangle ((int)x, (int)y, sprite.getWidth(), sprite.getHeight()));
    }

    public void checkCollision(GameObject object) {

    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
