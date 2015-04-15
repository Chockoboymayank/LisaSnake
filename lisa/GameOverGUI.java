package lisa;

// Created by lisa on 4/11/15.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GameOverGUI {
    public JPanel rootPanel;
    private JButton playAgainButton;
    private JButton quitButton;
    private JTextArea highScoreTextArea;
    private JLabel endTitleLabel;
    private JButton submitNameButton;
    private JLabel currentScoreLabel;
    private JTextField playerNameTextField;
    private JLabel highScoreInstructionLabel1;
    private JLabel highScoreInstructionLabel2;
    private LinkedList<Score> topTenScores;
    private Color greenish = new Color(28, 69, 10);
    private Color grayish = new Color(238, 238, 238);

    public GameOverGUI() {

        submitNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = playerNameTextField.getText();
                SnakeGame.currentScore.setName(playerName);
                ScoreManager.updateTopScoresFile();
                displayScoresInGUI();
                playerNameTextField.setText("");
                SnakeGame.snakeFrame.repaint();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeGame.reset();
                SnakeGame.displayOptionsGUI();
                resetScreen();
            }
        });
    }

    private void resetScreen() {
        endTitleLabel.setText("GAME OVER");
        highScoreInstructionLabel1.setVisible(false);
        highScoreInstructionLabel2.setVisible(false);
        playerNameTextField.setVisible(false);
        submitNameButton.setVisible(false);
        endTitleLabel.setForeground(Color.BLACK);
        rootPanel.setBackground(grayish);
        highScoreTextArea.setBackground(grayish);
        highScoreTextArea.setText("");
    }

    public void displayScoresInGUI() {
        currentScoreLabel.setText(Integer.toString(SnakeGame.currentScore.points));

        topTenScores = ScoreManager.getTopTenScores();
        String topScoresDisplay = "";
        for (int x = 0; x < topTenScores.size(); x ++) {
            Score topScore = topTenScores.get(x);
            String ordinal = Integer.toString(x + 1);
            String date = ScoreManager.dateFormat.format(topScore.date);

            topScoresDisplay += ordinal + ". " + topScore.points + " points: " + topScore.name + ", " + date + "\n";
        }

        highScoreTextArea.setText(topScoresDisplay);
    }

    public void newHighScore() {
        highScoreInstructionLabel1.setVisible(true);
        highScoreInstructionLabel2.setVisible(true);
        playerNameTextField.setVisible(true);
        submitNameButton.setVisible(true);

        if (SnakeGame.getGameStage() != SnakeGame.GAME_WON) {
            endTitleLabel.setText("NEW HIGH SCORE!");
        }
    }

    public void winDisplay() {
        // Super awesome display that's totally worth all that work
        endTitleLabel.setText("CONGRATULATIONS, YOU WON SNAKE!");
        endTitleLabel.setForeground(Color.WHITE);
        rootPanel.setBackground(greenish);
        highScoreTextArea.setBackground(greenish);
    }
}
