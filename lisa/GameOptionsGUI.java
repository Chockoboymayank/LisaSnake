package lisa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Created by lisa on 3/30/15.

public class GameOptionsGUI {
    public JPanel rootPanel;
    private JButton playButton;
    private JButton quitButton;
    private JLabel sizeLabel;
    private JComboBox sizeComboBox;
    private JCheckBox soundEffectsOnCheckBox;
    private JCheckBox warpWallsOnCheckBox;
    private JCheckBox avocadosOnCheckBox;
    private JCheckBox rodentOnCheckBox;
    private JLabel titleLabel;
    private JComboBox speedComboBox;
    private JTextArea instructionsTextArea;
    private JCheckBox rodentsOnCheckBox;

    // Constructor
    public GameOptionsGUI() {

        // Set options for size ComboBox
        final String small = "8 x 8";
        final String medium = "12 x 12";
        final String large = "16 x 16";
        sizeComboBox.addItem(small);
        sizeComboBox.addItem(medium);
        sizeComboBox.addItem(large);
        sizeComboBox.setSelectedItem(small);

        // Set options for speed ComboBox
        final String s = "slow";
        final String m = "medium";
        final String f = "fast";
        speedComboBox.addItem(s);
        speedComboBox.addItem(m);
        speedComboBox.addItem(f);
        sizeComboBox.setSelectedItem(medium);

        speedComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String speed = speedComboBox.getSelectedItem().toString();
                if (speed.equals(s)) {
                    SnakeGame.setGameSpeed(500);
                } else if (speed.equals(m)) {
                    SnakeGame.setGameSpeed(350);
                } else if (speed.equals(f)) {
                    SnakeGame.setGameSpeed(200);
                }
            }
        });

        sizeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String size = sizeComboBox.getSelectedItem().toString();
                if (size.equals(small)) {
                    SnakeGame.setGridSize(401);
                } else if (size.equals(medium)) {
                    SnakeGame.setGridSize(601);
                } else if (size.equals(large)) {
                    SnakeGame.setGridSize(801);
                }
            }
        });

        soundEffectsOnCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (soundEffectsOnCheckBox.isSelected()) {
                    SnakeGame.setSoundsOn(true);
                } else {
                    SnakeGame.setSoundsOn(false);
                }
            }
        });

        warpWallsOnCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (warpWallsOnCheckBox.isSelected()) {
                    SnakeGame.setWarpWallsOn(true);
                } else {
                    SnakeGame.setWarpWallsOn(false);
                }
            }
        });

        avocadosOnCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (avocadosOnCheckBox.isSelected()) {
                    SnakeGame.setObstaclesOn(true);
                } else {
                    SnakeGame.setObstaclesOn(false);
                }
            }
        });

        rodentsOnCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rodentsOnCheckBox.isSelected()) {
                    SnakeGame.setPreyOn(true);
                } else {
                    SnakeGame.setPreyOn(false);
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeGame.displayGameGrid();
            }
        });
    }
}
