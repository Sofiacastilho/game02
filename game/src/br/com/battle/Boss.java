package br.com.battle;

import java.util.Random;

import br.pucpr.jge.AbstractGameObject;
import br.pucpr.jge.GameManager;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import java.util.Random;

public class Boss extends AbstractGameObject {
    private final double initialX;
    private double t;
    private boolean isAlive = true;
    private double shotInterval = 0;
    Random rnd = new Random();
    private int count;

    public Boss(double x, double y) {
        super("/image/green.png", x, y);
        this.initialX = x;
    }

    public void update(double s, InputManager keys) {
        x = initialX + Math.sin(t) * 50;
        t += s;

        shotInterval += s;
        count ++;
        if (count >= 200){
            int num = rnd.nextInt(1500);
            if (num == 1) {
                if (shotInterval > 2) {
                    var alienShot = new AlienShot(getX() + 25, getY());
                    GameManager.getInstance().add(alienShot);
                    shotInterval = 0;
                }
                count = 0;
            }
        }

    }

    @Override
    public boolean isInGame() {
        return isAlive;
    }

    @Override
    public void onCollision(GameObject other) {
        if (other instanceof Shot) {
            var explosion = new Explosion((int)getX(), (int)getY());
            GameManager.getInstance().add(explosion);
            isAlive = false;
        }
    }
}
