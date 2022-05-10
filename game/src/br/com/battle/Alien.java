package br.com.battle;

import br.pucpr.jge.GameManager;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import java.util.Random;

public class Alien extends GameObject {
    private double initialX;
    private double t;
    private double shotInterval = 0;
    Random rnd = new Random();
    private int count;


    public Alien(double x, double y) {
        super("/image/destroyer.png", x, y);
        this.initialX = x;
    }

    public void update(double s, InputManager keys) {
        x = initialX + Math.sin(t) * 50;
        t += s;
        shotInterval += s;
        count ++;
        if (count >= 120){
            int num = rnd.nextInt(500);
            if (num == 10) {
                if (shotInterval > 2) {
                    var alienShot = new AlienShot(getX() + 25, getY());
                    GameManager.getInstance().add(alienShot);
                    shotInterval = 0;
                }
                count = 0;
            }
        }

    }

    public boolean isInGame(){
        return true;
    }

    public void checkCollision(GameObject object) {
        if (object instanceof Ship){
            setInGame(false);
        }else{
            setInGame(true);
        }
    }

}
