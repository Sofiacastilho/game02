package br.com.battle;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;


public class AlienShot extends GameObject {
    protected GameObject object;

    public AlienShot(double x, double y) {
        super("/image/shot.png", x, y);
    }

    @Override
    public void update(double s, InputManager keys) {
        y += 800 * s;
        checkCollision(object);
    }

    @Override
    public boolean isInGame() {
        return y > 50;
    }

    public void checkCollision(GameObject object) {
        if (object instanceof Ship) {
            setInGame(true);
        }else{
            setInGame(false);
        }
    }

}

