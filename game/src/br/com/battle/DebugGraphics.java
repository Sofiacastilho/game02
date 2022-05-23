package br.com.battle;

import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import java.awt.*;

public class DebugGraphics implements GameObject {
    public GameObject hb;
    public Color color;

    public DebugGraphics(GameObject hb, Color color) {
        this.hb = hb;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.draw(hb.getHitBox());
        hb.draw(g2d);

    }

    @Override
    public double getX() {
        return getHitBox().getX();
    }

    @Override
    public double getY() {
        return getHitBox().getY();
    }

    @Override
    public void load() {
        hb.load();

    }

    @Override
    public void update(double s, InputManager keys) {
        this.hb.update(s, keys);
    }

    @Override
    public boolean isInGame() {
        return hb.isInGame();
    }

    @Override
    public Rectangle getHitBox() {
        return this.hb.getHitBox();
    }

    @Override
    public void onCollision(GameObject other) {

    }
}