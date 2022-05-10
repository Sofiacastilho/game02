package br.com.battle;
import br.pucpr.jge.GameObject;
import br.pucpr.jge.InputManager;

import java.awt.*;

public class AlienShot extends GameObject {
    public AlienShot(double x, double y) {
        super("/image/shot.png", x, y);
    }

    @Override
    public Rectangle hitbox() {
        return(new Rectangle ((int)x, (int)y, 100, 100));
    }

    @Override
    public void update(double s, InputManager keys) {
        y += 800 * s;
    }

    @Override
    public boolean isInGame() {
        return y > +50;
    }

    private boolean checkCollision() {
        if (this.hitbox().intersects(hitbox())){
            System.out.println("colidiu tiro");
            return true;
        }
        return false;
    }
}

