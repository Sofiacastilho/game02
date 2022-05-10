package br.com.battle;

import br.pucpr.jge.GameManager;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import static java.awt.event.KeyEvent.*;

public class Ship extends GameObject {
    private double shotInterval = 0.3;

    public Ship() {
        super("/image/intruder.png", 0, 500);
    }

    public void update(double s, InputManager keys) {
        shotInterval += s;

        if (keys.isDown(VK_RIGHT)) {
            x += 400 * s;
        } else if (keys.isDown(VK_LEFT)) {
            x -= 400 * s;
        }

        if (keys.isDown(VK_SPACE) && shotInterval > 0.3) {
            var shot = new Shot(getX() + 25, getY());
            GameManager.getInstance().add(shot);
            isFriendly();
            shotInterval = 0;
        }

    }

    public void checkCollision(GameObject object) {
        if (object instanceof Ship){

            setInGame(true);
        }else{
            setInGame(false);
        }

    }

    public boolean isInGame() {
        return inGame;
    }

}
