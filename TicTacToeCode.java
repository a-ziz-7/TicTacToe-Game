import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Objects;

public class TicTacToeCode extends JFrame implements ActionListener, KeyListener {

    JPanel panel = new JPanel();
    JButton textButton = new JButton("Turn: X");
    JLabel xScore = new JLabel();
    int x = 0;
    Color colorX = new Color(252, 172, 0);
    JLabel oScore = new JLabel();
    int o = 0;
    Color colorO = new Color(255, 0, 173);
    JButton[] buttons = new JButton[9];
    boolean playersTurn = true;
    int w = 700;
    int h = 700;
    boolean win = false;

    public TicTacToeCode() {

        try {
            setIconImage(ImageIO.read(new File("src/ttt.png")));
        } catch (Exception ignored) {

        }
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(w, h);
        setLocationRelativeTo(null);

        //textButton.setBackground(new Color(26, 2, 2));
        textButton.setBackground(new Color(16, 1, 8, 255));
        textButton.setForeground(new Color(30, 255, 90));
        textButton.setFont(new Font("Ink Free", Font.ITALIC, 50));
        textButton.setHorizontalAlignment(JLabel.CENTER);
        textButton.setOpaque(true);
        textButton.addActionListener(this);
        textButton.addKeyListener(this);

        xScore.setBackground(new Color(25, 25, 25));
        xScore.setForeground(new Color(30, 255, 90));
        xScore.setFont(new Font("Ink Free", Font.ITALIC, 45));
        xScore.setHorizontalAlignment(JLabel.CENTER);
        xScore.setText("X Score: 0");
        xScore.setOpaque(true);

        oScore.setBackground(new Color(25, 25, 25));
        oScore.setForeground(new Color(30, 255, 90));
        oScore.setFont(new Font("Ink Free", Font.ITALIC, 45));
        oScore.setHorizontalAlignment(JLabel.CENTER);
        oScore.setText("O Score: 0");
        oScore.setOpaque(true);

        panel.setLayout(new GridLayout(4, 3));
        panel.add(xScore);
        panel.add(textButton);
        panel.add(oScore);

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].setBackground(new Color(168, 229, 229));
            buttons[i].setFont(new Font("Ink Free", Font.ITALIC, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].addKeyListener(this);

        }

        add(panel);
        setVisible(true);

    }

    public void check() {
        //draw condition
        if (!(Objects.equals(buttons[0].getText(), ""))
                && !(Objects.equals(buttons[1].getText(), ""))
                && !(Objects.equals(buttons[2].getText(), ""))
                && !(Objects.equals(buttons[3].getText(), ""))
                && !(Objects.equals(buttons[4].getText(), ""))
                && !(Objects.equals(buttons[5].getText(), ""))
                && !(Objects.equals(buttons[6].getText(), ""))
                && !(Objects.equals(buttons[7].getText(), ""))
                && !(Objects.equals(buttons[8].getText(), ""))) {
            win = true;
            textButton.setText("Reset");
            textButton.setBackground(new Color(89, 0, 0));
        }

        //check X win conditions
        if (
                (Objects.equals(buttons[0].getText(), "X"))
                        && (Objects.equals(buttons[1].getText(), "X"))
                        && (Objects.equals(buttons[2].getText(), "X"))
        ) {
            xWins(0, 1, 2);
        } else if (
                (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X"))
        ) {
            xWins(3, 4, 5);
        } else if (
                (Objects.equals(buttons[6].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(6, 7, 8);
        } else if (
                (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(0, 3, 6);
        } else if (
                (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X"))
        ) {
            xWins(1, 4, 7);
        } else if (
                (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(2, 5, 8);
        } else if (
                (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))

        ) {
            xWins(0, 4, 8);

        } else if (
                (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(2, 4, 6);
        }


        //check O win conditions
        else if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[2].getText(), "O"))
        ) {
            oWins(0, 1, 2);
        } else if (
                (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O"))
        ) {
            oWins(3, 4, 5);
        } else if (
                (Objects.equals(buttons[6].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(6, 7, 8);
        } else if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(0, 3, 6);
        } else if (
                (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O"))
        ) {
            oWins(1, 4, 7);
        } else if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(2, 5, 8);
        } else if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(0, 4, 8);
        } else if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(new Color(255, 251, 0));
        buttons[b].setBackground(new Color(255, 251, 0));
        buttons[c].setBackground(new Color(255, 251, 0));
        win = true;
        x++;
        xScore.setText("X Score: " + x);

        textButton.setText("Reset");
        textButton.setBackground(new Color(89, 0, 0));

    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(new Color(255, 251, 0));
        buttons[b].setBackground(new Color(255, 251, 0));
        buttons[c].setBackground(new Color(255, 251, 0));
        win = true;
        o++;
        oScore.setText("O Score: " + o);
        textButton.setText("Reset");
        textButton.setBackground(new Color(89, 0, 0));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (win && e.getSource() == textButton) {
            textButton.setText(playersTurn ? "Turn: X" : "Turn: O");
            textButton.setBackground(new Color(26, 2, 2));
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
                buttons[i].setBackground(new Color(168, 229, 229));
            }
            win = false;
        }
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && !win) {
                if (playersTurn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(236, 169, 5));
                        buttons[i].setText("X");
                        playersTurn = false;
                        textButton.setText("Turn: O");
                        // dts
                        textButton.setBackground(colorO);
                        check();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        // dts
                        textButton.setBackground(colorX);
                        check();
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            boolean state = true;
            for (int i = 0; i < 9; i++) {
                state = state && Objects.equals(buttons[i].getText(), "");
            }
            if (state) {
                playersTurn = !playersTurn;
                if (playersTurn) {
                    textButton.setText("Turn: X");
//                    textButton.setBackground(colorX);
                } else {
                    textButton.setText("Turn: O");
//                    textButton.setBackground(colorO);
                }
            }
        }
        if (((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) && win)
                || e.getKeyCode() == KeyEvent.VK_R) {
            textButton.setText(playersTurn ? "Turn: X" : "Turn: O");
            textButton.setBackground(new Color(26, 2, 2));
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
                buttons[i].setBackground(new Color(168, 229, 229));
            }
            win = false;
        }
        if (!win) {
            int i;
            //0
            if (e.getKeyCode() == KeyEvent.VK_1 && Objects.equals(buttons[0].getText(), "")) {
                i = 0;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //1
            if (e.getKeyCode() == KeyEvent.VK_2 && Objects.equals(buttons[1].getText(), "")) {
                i = 1;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }

            }
            //2
            if (e.getKeyCode() == KeyEvent.VK_3 && Objects.equals(buttons[2].getText(), "")) {
                i = 2;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //3
            if (e.getKeyCode() == KeyEvent.VK_4 && Objects.equals(buttons[3].getText(), "")) {
                i = 3;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //4
            if (e.getKeyCode() == KeyEvent.VK_5 && Objects.equals(buttons[4].getText(), "")) {
                i = 4;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }

            }
            //5
            if (e.getKeyCode() == KeyEvent.VK_6 && Objects.equals(buttons[5].getText(), "")) {
                i = 5;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //6
            if (e.getKeyCode() == KeyEvent.VK_7 && Objects.equals(buttons[6].getText(), "")) {
                i = 6;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //7
            if (e.getKeyCode() == KeyEvent.VK_8 && Objects.equals(buttons[7].getText(), "")) {
                i = 7;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
            //8
            if (e.getKeyCode() == KeyEvent.VK_9 && Objects.equals(buttons[8].getText(), "")) {
                i = 8;
                if (playersTurn) {
                    buttons[i].setForeground(new Color(236, 169, 5));
                    buttons[i].setText("X");
                    playersTurn = false;
                    textButton.setText("Turn: O");
                    check();
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(194, 5, 236));
                        buttons[i].setText("O");
                        playersTurn = true;
                        textButton.setText("Turn: X");
                        check();
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}