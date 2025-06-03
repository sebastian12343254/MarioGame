import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Random;
import javax.swing.Timer;

public class WhacAMole {
    private final int boardWidth = 600;
    private final int boardHeight = 650;

    JFrame frame = new JFrame("Mario");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[] buttons = new JButton[9];

    ImageIcon moleIcon;
    ImageIcon plantIcon; 

    JButton currMoleTile;
    JButton currPlantTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;

    WhacAMole(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("0");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.GRAY);
        frame.add(boardPanel);

        Image plantImg = new ImageIcon(getClass().getResource("./piranha.png")).getImage();
        plantIcon = new ImageIcon(plantImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image moleImg = new ImageIcon(getClass().getResource("./monty.png")).getImage();
        moleIcon = new ImageIcon(moleImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setForeground(Color.WHITE);
            boardPanel.add(buttons[i]); 

            buttons[i].addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                if(clickedButton == currMoleTile) {
                    textLabel.setText(String.valueOf(Integer.parseInt(textLabel.getText()) + 1));
                    clickedButton.setIcon(null);
                    currMoleTile = null;
                } else if(clickedButton == currPlantTile) {
                    textLabel.setText(String.valueOf(Integer.parseInt(textLabel.getText()) - 1));
                    clickedButton.setIcon(null);
                    currPlantTile = null;
                }
            });
        }

        setMoleTimer = new Timer(1000, e -> {
            if(currMoleTile != null) {
                currMoleTile.setIcon(null);
                currMoleTile = null;
            }
            int num = random.nextInt(9);
            JButton moleTile = buttons[num];

           if(currPlantTile == moleTile) return;

            currMoleTile = moleTile;
            moleTile.setIcon(moleIcon);
        });

        setPlantTimer = new Timer(1500, e -> {
            if(currPlantTile != null) {
                currPlantTile.setIcon(null);
                currPlantTile = null;
            }
            int num = random.nextInt(9);
            JButton PlantTile = buttons[num];

            if(currMoleTile == PlantTile) return;
              
            currPlantTile = PlantTile;
            PlantTile.setIcon(plantIcon);
        });

        setPlantTimer.start();
        setMoleTimer.start();
        frame.setVisible(true);
    }
}
