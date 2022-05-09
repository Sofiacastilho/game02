package br.com.battle;

import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

public class Collision extends GameObject {
    Shot shot = new Shot(x, y);
    Alien alien = new Alien(x, y);

    public Collision(double x, double y){
        super("/image/explosion.png", x , y);
    }

    private boolean checkCollision() {
       return shot.intersects(alien);
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
