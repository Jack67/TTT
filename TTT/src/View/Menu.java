/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class Menu extends JMenuBar implements ActionListener{
    
    JMenu datei;
    JMenu option;
    JMenu opponent;
    JMenu begin;
    JSeparator sep1;
    JSeparator sep2;
    JMenuItem newGame;
    JMenuItem save;
    JMenuItem open;
    JMenuItem exit;
    JMenuItem offerGame;
    JMenuItem searchGame;
    JMenuItem ki;
    JMenuItem userLocal;
    JMenuItem userRemote;
    JMenuItem me;
    JMenuItem villain;
    
    public  Menu(){
        datei = new JMenu("Datei");
        save = new JMenuItem("Speichern...");
        open = new JMenuItem("Öffnen...");
        option = new JMenu("Optionen");
        opponent = new JMenu("Gegner");
        begin = new JMenu("Begin");
        sep1 = new JSeparator();
        sep2 = new JSeparator();
        newGame = new JMenuItem("Neues Spiel");
        exit = new JMenuItem("Exit");
        ki = new JMenuItem("Gegner KI");
        userLocal = new JMenuItem("Gegner lokaler Spieler");
        userRemote = new JMenuItem("Gegner Netzwerkspieler");
        offerGame = new JMenuItem("Spiel anbieten");
        searchGame = new JMenuItem("Spiel suchen");
        me = new JMenuItem("Ich");
        villain = new JMenuItem("Gegner");
        
        add(datei);
        add(newGame);
        datei.add(save);
        datei.add(open);
        datei.add(option);
        datei.add(sep1);
        datei.add(offerGame);
        datei.add(searchGame);
        datei.add(sep2);
        datei.add(exit);
        option.add(opponent);
        option.add(begin);
        opponent.add(ki);
        opponent.add(userLocal);
        opponent.add(userRemote);
        begin.add(me);
        begin.add(villain);
        
        newGame.addActionListener(this);
        save.addActionListener(this);
        open.addActionListener(this);
        offerGame.addActionListener(this);
        searchGame.addActionListener(this);
        exit.addActionListener(this);
        ki.addActionListener(this);
        userLocal.addActionListener(this);
        userRemote.addActionListener(this);
        me.addActionListener(this);
        villain.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Neues Spiel":
                System.out.println("Neues Spiel");
                break;
            case "Speichern...":
                System.out.println("Speichern...");
                break;
            case "Öffnen...":
                System.out.println("Öffnen...");
                break;
            case "Gegner KI":
                System.out.println("Gegner KI");
                break;
            case "Gegner lokaler Spieler":
                System.out.println("Gegner lokaler Spieler");
                break;
            case "Gegner Netzwerkspieler":
                System.out.println("Gegner Netzwerkspieler");
                break;
            case "Spiel anbieten":
                System.out.println("Spiel anbieten");
                break;
            case "Spiel suchen":
                System.out.println("Spiel suchen");
                break;
            case "Ich":
                System.out.println("Ich");
                break;
            case "Gegner":
                System.out.println("Gegner");
                break;
            case "Exit":
                System.out.println("Exit");
                break;
        }
    }
    
}
