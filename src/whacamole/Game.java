/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import javax.swing.JFrame;

/**
 *
 * @author Bruno Garcia
 */
public class Game extends JFrame{
     
    Cenario tela;
    
     public Game() throws InterruptedException
     {
         super("El Juego - Whac a Mole + Evolutionary Algorithm");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(1000, 800);
         setVisible(true);
         setLocationRelativeTo(null);
         tela = new Cenario();
         add(tela);
         tela.match();
     }
}
