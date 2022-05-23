package br.com.battle;
import br.pucpr.jge.AbstractGameObject;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;


public class AlienShot extends AbstractGameObject {
    protected GameObject object;
    private boolean isAlive = true;

    public AlienShot(double x, double y) {
        super("/image/shot.png", x, y);
    }

    @Override
    public void update(double s, InputManager keys) {
        y += 800 * s;
        onCollision(object);
    }

    @Override
    public boolean isInGame() {
        return y > 50;
    }

    public void onCollision(GameObject other) {
        if (other instanceof Ship) {
            isAlive = false;
        }
    }

}

