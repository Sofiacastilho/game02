package br.pucpr.jge;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final GameManager instance = new GameManager();
    private List<GameObject> objects = new ArrayList<>();
    private List<GameObject> newObjects = new ArrayList<>();

    private GameManager() {
    }

    public static GameManager getInstance() {
        return instance;
    }

    public GameManager clear() {
        objects.clear();
        return this;
    }

    public GameManager add(GameObject obj) {
        obj.load();
        newObjects.add(obj);
        return this;
    }

    void update(double s, InputManager keys) {
        var it = objects.iterator();
        while (it.hasNext()) {
            var go = it.next();
            go.update(s, keys);
            if (!go.isInGame()) {
                it.remove();
            }
        }
        objects.addAll(newObjects);
        newObjects.clear();

        for(int i = 0; i < this.objects.size() - 1; ++i) {
            Rectangle obj1 = ((GameObject)this.objects.get(i)).hitbox().getBounds();

            for(int j = i + 1; j < this.objects.size(); ++j) {
                Rectangle obj2 = ((GameObject)this.objects.get(j)).hitbox().getBounds();
                if (obj1.intersects(obj2)) {
                    ((GameObject)this.objects.get(i)).checkCollision((GameObject)this.objects.get(j));
                    ((GameObject)this.objects.get(j)).checkCollision((GameObject)this.objects.get(i));
                }
            }
        }
    }

    void draw(Graphics2D g2d) {
        for (var obj : objects) {
            obj.draw(g2d);
        }
    }

}
