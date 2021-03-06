/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fgdo.life.NewGameState;

import fr.fgdo.life.GameState.Board.BoardParams;
import fr.fgdo.life.Life;
import fr.fgdo.life.State.State;
import fr.fgdo.math.Vector2;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author olivbau
 */
public class NewGameState extends State implements MouseListener{
    
    private JFormattedTextField mapHeightTextField;
    private JFormattedTextField mapWidthTextField;
    private JTextField mapNameTextField;
    
    public NewGameState(Life lifeGame) {
        super(lifeGame);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        
        NumberFormat numF = NumberFormat.getNumberInstance(); 
        numF.setMaximumIntegerDigits(7);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(new JLabel("Map name : "),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mapNameTextField = new JTextField("New Map");
        mapNameTextField.setPreferredSize(new Dimension(150, 20));
        mapNameTextField.setMinimumSize(new Dimension(150, 20));
        add(mapNameTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Map Width : "),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mapWidthTextField = new JFormattedTextField(numF);
        mapWidthTextField.setValue(1000);
        mapWidthTextField.setPreferredSize(new Dimension(50, 20));
        mapWidthTextField.setMinimumSize(new Dimension(50, 20));
        add(mapWidthTextField,gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Map Height : "),gbc);
        
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mapHeightTextField = new JFormattedTextField(numF);
        mapHeightTextField.setValue(1000);
        mapHeightTextField.setPreferredSize(new Dimension(50, 20));
        mapHeightTextField.setMinimumSize(new Dimension(50, 20));
        add(mapHeightTextField,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addMouseListener(this);
        add(confirmButton,gbc);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        BoardParams params = new BoardParams();
        params.size = new Vector2<>(Integer.parseInt(mapWidthTextField.getText().replace("\u00A0","").replaceAll(",", "")), Integer.parseInt(mapHeightTextField.getText().replace("\u00A0","").replaceAll(",", "")));
        params.name = mapNameTextField.getText();
        getLifeGame().setGridParams(params);
        getLifeGame().setSize(1500,1000);
        getLifeGame().setLocationRelativeTo(null);
        getLifeGame().enterState(2);
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
