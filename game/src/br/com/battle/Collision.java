package br.com.battle;

import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import java.awt.*;

public class Collision extends GameObject {
    Shot shot = new Shot(x, y);
    Rectangle rectangle = new Rectangle();


    public Collision(double x, double y){
        super("/image/explosion.png", x , y);
    }

    private boolean checkCollision() {
       return rectangle.intersects(hitbox());
    }

    public void update(double s, InputManager keys) {
        if (checkCollision() == true){
            isInGame();
        }

    }


    @Override
    public boolean isInGame() {
        return false;
    }
}
