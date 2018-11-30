/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Bruno Garcia
 */
public class Game extends JFrame{
     
    Cenario tela;
    
     public Game() throws InterruptedException, IOException
     {
         super("El Juego - Whac a Mole + Evolutionary Algorithm");
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setSize(1000, 800);
         setVisible(true);
         setLocationRelativeTo(null);
         tela = new Cenario();
         add(tela);
         
         this.revalidate();
         this.repaint(); 
         
     }
}
