package br.com.battle;


import br.pucpr.jge.GameFrame;
import br.pucpr.jge.InputManager;
import br.pucpr.jge.Steps;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_SPACE;

public class TelaInicial implements Steps{

    @Override
    public void load() {
    }

    @Override
    public boolean update(double s, InputManager keys) {
        if (keys.isDown(VK_SPACE)) {
            EventQueue.invokeLater(() -> new GameFrame("Star Battle", 800, 600, new StarBattle()).setVisible(true));
            return false;
        }
        if (keys.isDown(VK_ESCAPE)) {
            return false;
        }
        return true;
    }

    @Override
    public void draw(Graphics2D g2d) throws FontFormatException, IOException {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 800, 600);

        g2d.setColor(Color.white);
        g2d.drawString("Star Battle" , 300, 300);


        g2d.drawString("Pressione ESPAÇO para iniciar ou ESC para encerrar", 250, 400);


    }

    @Override
    public void unload() {
    }
}