
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates and runs a tic-tac-toe game
 *
 * @author Ethan Mooney
 */

public class TicTacToe extends JFrame {

    int alt = 0;
    String letter = "";
    int count = 0;

    private final JButton b11;
    private final JButton b12;
    private final JButton b13;
    private final JButton b21;
    private final JButton b22;
    private final JButton b23;
    private final JButton b31;
    private final JButton b32;
    private final JButton b33;
    private final JButton bSouth;
    private final JPanel panel;
    private final JPanel panelSouth;
    private final JTextField textNorth;

    public TicTacToe() {

        textNorth = new JTextField("Play Tic-Tac-Toe: O's turn!");
        textNorth.setEditable(false);

        b11 = new JButton();
        b12 = new JButton();
        b13 = new JButton();
        b21 = new JButton();
        b22 = new JButton();
        b23 = new JButton();
        b31 = new JButton();
        b32 = new JButton();
        b33 = new JButton();
        bSouth = new JButton();

        panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(3, 3));
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b21);
        panel.add(b22);
        panel.add(b23);
        panel.add(b31);
        panel.add(b32);
        panel.add(b33);

        Font fontNorth = new Font("Courier New", Font.BOLD, 18);
        Font fontButton = new Font("Courier New", Font.BOLD, 56);

        b11.setFont(fontButton);
        b12.setFont(fontButton);
        b13.setFont(fontButton);
        b21.setFont(fontButton);
        b22.setFont(fontButton);
        b23.setFont(fontButton);
        b31.setFont(fontButton);
        b32.setFont(fontButton);
        b33.setFont(fontButton);

        textNorth.setFont(fontNorth);

        panelSouth = new JPanel();
        bSouth.setText("New Game");
        panelSouth.add(bSouth, "Center");

        Container contentPane = getContentPane();
        contentPane.add(panel, "Center");
        contentPane.add(textNorth, "North");
        contentPane.add(panelSouth, "South");

        ButtonObserver observer = new ButtonObserver();
        b11.addActionListener(observer);
        b12.addActionListener(observer);
        b13.addActionListener(observer);
        b21.addActionListener(observer);
        b22.addActionListener(observer);
        b23.addActionListener(observer);
        b31.addActionListener(observer);
        b32.addActionListener(observer);
        b33.addActionListener(observer);
        bSouth.addActionListener(observer);
    }

    private class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (alt % 2 == 0) {
                letter = "O";
                textNorth.setText("X's Turn");
            } else {
                letter = "X";
                textNorth.setText("O's Turn");
            }

            Object source = e.getSource();
            if (source == b11) {
                b11.setText(letter);
                b11.setEnabled(false);
                alt++;

            } else if (source == b12) {
                b12.setText(letter);
                b12.setEnabled(false);
                alt++;
            } else if (source == b13) {
                b13.setText(letter);
                b13.setEnabled(false);
                alt++;
            } else if (source == b21) {
                b21.setText(letter);
                b21.setEnabled(false);
                alt++;
            } else if (source == b22) {
                b22.setText(letter);
                b22.setEnabled(false);
                alt++;
            } else if (source == b23) {
                b23.setText(letter);
                b23.setEnabled(false);
                alt++;
            } else if (source == b31) {
                b31.setText(letter);
                b31.setEnabled(false);
                alt++;
            } else if (source == b32) {
                b32.setText(letter);
                b32.setEnabled(false);
                alt++;

            } else if (source == b33) {
                b33.setText(letter);
                b33.setEnabled(false);
                alt++;

            } else if (source == bSouth) {
                reset(true);
                textNorth.setText("Play Tic-Tac-Toe : O's Turn!");
                b11.setText("");
                b12.setText("");
                b13.setText("");
                b21.setText("");
                b22.setText("");
                b23.setText("");
                b31.setText("");
                b32.setText("");
                b33.setText("");

            }
            Winner(source);
        }

        public void Winner(Object source) {
            //Across
            if (b11.getText().equals(b12.getText()) && (b12.getText().equals(b13.getText())) && !b13.getText().equals("")) {
                textNorth.setText(b11.getText() + " wins!");
                reset(false);
            } else if (b21.getText().equals(b22.getText()) && (b22.getText().equals(b23.getText())) && !b23.getText().equals("")) {
                textNorth.setText(b21.getText() + " wins!");
                reset(false);
            } else if (b31.getText().equals(b32.getText()) && (b32.getText().equals(b33.getText())) && !b33.getText().equals("")) {
                textNorth.setText(b31.getText() + " wins!");
                reset(false);
            }//Down
            else if (b11.getText().equals(b21.getText()) && (b21.getText().equals(b31.getText())) && !b31.getText().equals("")) {
                textNorth.setText(b11.getText() + " wins!");
                reset(false);
            } else if (b12.getText().equals(b22.getText()) && (b22.getText().equals(b32.getText())) && !b32.getText().equals("")) {
                textNorth.setText(b12.getText() + " wins!");
                reset(false);
            } else if (b13.getText().equals(b23.getText()) && (b23.getText().equals(b33.getText())) && !b33.getText().equals("")) {
                textNorth.setText(b13.getText() + " wins!");
                reset(false);
            }//Diagonal
            else if (b13.getText().equals(b22.getText()) && (b22.getText().equals(b31.getText())) && !b31.getText().equals("")) {
                textNorth.setText(b13.getText() + " wins!");
                reset(false);
            } else if (b11.getText().equals(b22.getText()) && (b22.getText().equals(b33.getText())) && !b33.getText().equals("")) {
                textNorth.setText(b11.getText() + " wins!");
                reset(false);
            } //Tie
            else if (!(b11.getText().equals(b12.getText()) && (b12.getText().equals(b13.getText())) && !b13.getText().equals("")) && !(b21.getText().equals(b22.getText()) && (b22.getText().equals(b23.getText())) && !b23.getText().equals("")) && !(b31.getText().equals(b32.getText()) && (b32.getText().equals(b33.getText())) && !b33.getText().equals("")) && !(b11.getText().equals(b21.getText()) && (b21.getText().equals(b31.getText())) && !b31.getText().equals("")) && !(b12.getText().equals(b22.getText()) && (b22.getText().equals(b32.getText())) && !b32.getText().equals("")) && !(b13.getText().equals(b23.getText()) && (b23.getText().equals(b33.getText())) && !b33.getText().equals("")) && !(b13.getText().equals(b22.getText()) && (b22.getText().equals(b31.getText())) && !b31.getText().equals("")) && !(b11.getText().equals(b22.getText()) && (b22.getText().equals(b33.getText())) && !b33.getText().equals("")) && (alt == 9)) {
                textNorth.setText("Game Over! : Tie!");
                reset(false);
            }

        }

        public void reset(boolean s) {

            b11.setEnabled(s);
            b12.setEnabled(s);
            b13.setEnabled(s);
            b21.setEnabled(s);
            b22.setEnabled(s);
            b23.setEnabled(s);
            b31.setEnabled(s);
            b32.setEnabled(s);
            b33.setEnabled(s);

            alt = 0;

        }

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}
