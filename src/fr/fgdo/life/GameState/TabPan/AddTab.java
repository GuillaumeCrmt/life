/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fgdo.life.GameState.TabPan;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Olivier
 */
public class AddTab extends JPanel{

    public AddTab() {
        add(new JButton("Add Creature"));
        add(new JButton("Add Food"));
    }
    
}