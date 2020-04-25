import java.awt.image.BufferedImage;
import java.io.File;


import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LightCycles extends JFrame implements ActionListener {
    
    private static Player Player1 = new Player();
    private static Grid GameGrid = new Grid();
    private static Bike PlayerBike = new Bike();
    private static int gridSize = 500;
    JPanel backgroundFrame = new JPanel();
    ImageIcon onePImg = new ImageIcon("onep.PNG");
    ImageIcon twoPImg = new ImageIcon("twop.PNG");
    ImageIcon background = new ImageIcon("bg.jpg");
    JLabel bgLabel = new JLabel(background);
    private JButton singlePlayerGame = new JButton("Play One Player Game", onePImg);
    private JButton twoPlayerGame = new JButton("Play Two Player Game", twoPImg);
    private JButton exitGame = new JButton("Exit");
    private JButton red = new JButton("     ");
    private JButton blue = new JButton("     ");
    private JButton green = new JButton("     ");
    private JButton yellow = new JButton("     ");
    private JButton pink = new JButton("     ");
    private JButton cyan = new JButton("     ");
    private JButton magenta = new JButton("     ");
    private JButton orange = new JButton("     ");
    private final static String MENU = "Main Menu";
    private final static String OPTIONS = "Options";
    private final static String INSTRUCTIONS = "Instructions";
    private final Font bigFont = new Font("Arial", Font.PLAIN, 30);
    private final Font smallFont = new Font("Calibri", Font.BOLD, 15);
    private JTextField nameField1 = new JTextField(GameGrid.getpOneName(), 20);
    private JTextField nameField2 = new JTextField(GameGrid.getpTwoName(), 20);
    private String[] gridSizeStrings = new String[]{"Small", "Medium", "Large"};
    private JComboBox gridList = new JComboBox(gridSizeStrings);

    private LightCycles()
    {
        singlePlayerGame.addActionListener(this);
        twoPlayerGame.addActionListener(this);
        exitGame.addActionListener(this);

        red.setBackground(Color.RED);
        red.addActionListener(this);

        blue.setBackground(Color.BLUE);
        blue.addActionListener(this);

        green.setBackground(Color.GREEN);
        green.addActionListener(this);

        yellow.setBackground(Color.YELLOW);
        yellow.addActionListener(this);

        pink.setBackground(Color.PINK);
        pink.addActionListener(this);

        cyan.setBackground(Color.CYAN);
        cyan.addActionListener(this);

        magenta.setBackground(Color.MAGENTA);
        magenta.addActionListener(this);

        orange.setBackground(Color.ORANGE);
        orange.addActionListener(this);

        nameField1.addActionListener(this);
        nameField2.addActionListener(this);
    }

    public static void main(String args[]) throws IOException {
        //Create and set up the content pane
        LightCycles mainFrame = new LightCycles();
        mainFrame.setSize(500, 700);
        mainFrame.setResizable(false);
        mainFrame.addComponentToPane(mainFrame.getContentPane());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void addComponentToPane(Container pane) throws IOException {
        //creating the instructions image
        BufferedImage img = ImageIO.read(new File("instructions1.png"));
        Image dimg = img.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
        JLabel p1Instructions = new JLabel(new ImageIcon(dimg));
        p1Instructions.setSize(500, 200);

        BufferedImage img3 = ImageIO.read(new File("instructions2.png"));
        Image bimg = img3.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
        JLabel p2Instructions = new JLabel(new ImageIcon(bimg));
        p2Instructions.setSize(500, 200);

        BufferedImage img2 = ImageIO.read(new File("title.PNG"));
        Image aimg = img2.getScaledInstance(300, 80, Image.SCALE_SMOOTH);
        JLabel title = new JLabel(new ImageIcon(aimg));
        title.setSize(300, 80);

        //creates the tabbed pane which everything will be on
        JTabbedPane tabbedpane = new JTabbedPane();

        //creates the menu card
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
        backgroundFrame.add(bgLabel);
        backgroundFrame.setBackground(Color.black);
        menu.setBackground(Color.black);
        menu.setPreferredSize(super.getSize());
        bgLabel.setLayout(new FlowLayout());
        singlePlayerGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        singlePlayerGame.setFont(bigFont);
        twoPlayerGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoPlayerGame.setFont(bigFont);
        exitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitGame.setFont(bigFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(title);
        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(singlePlayerGame);
        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(twoPlayerGame);
        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(exitGame);
        menu.add(backgroundFrame);

        //creates the options card
        JPanel options = new JPanel();
        options.setBackground(Color.black);
        options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
        options.add(Box.createRigidArea(new Dimension(0,50))); //adds space between the elements

        Container colourCon1 = new Container();
        colourCon1.setLayout(new FlowLayout());
        options.add(colourCon1);
        JLabel colourLabel = new JLabel("Player 1 Bike Colour: ");
        colourLabel.setFont(smallFont);
        colourLabel.setForeground(Color.white);
        colourCon1.add(colourLabel);
        colourCon1.add(red);
        colourCon1.add(blue);
        colourCon1.add(green);
        colourCon1.add(yellow);

        Container nameCon1 = new Container();
        nameCon1.setLayout(new FlowLayout());
        options.add(nameCon1);
        JLabel nameLabel = new JLabel("Player 1 Name: ");
        nameLabel.setFont(smallFont);
        nameLabel.setForeground(Color.white);
        nameField1.setFont(smallFont);
        nameCon1.add(nameLabel);
        nameCon1.add(nameField1);

        Container colourCon2 = new Container();
        colourCon2.setLayout(new FlowLayout());
        options.add(colourCon2);
        JLabel colourLabel2 = new JLabel("Player 2 Bike Colour: ");
        colourLabel2.setFont(smallFont);
        colourLabel2.setForeground(Color.white);
        colourCon2.add(colourLabel2);
        colourCon2.add(pink);
        colourCon2.add(cyan);
        colourCon2.add(magenta);
        colourCon2.add(orange);

        Container nameCon2 = new Container();
        nameCon2.setLayout(new FlowLayout());
        options.add(nameCon2);
        JLabel nameLabel2 = new JLabel("Player 2 Name: ");
        nameLabel2.setFont(smallFont);
        nameLabel2.setForeground(Color.white);
        nameField2.setFont(smallFont);
        nameCon2.add(nameLabel2);
        nameCon2.add(nameField2);

        Container gridCon = new Container();
        gridCon.setLayout(new FlowLayout());
        options.add(gridCon);
        JLabel gLabel = new JLabel("Pick the Grid Size: ");
        gLabel.setFont(smallFont);
        gLabel.setForeground(Color.white);
        gridList.setSelectedIndex(0);
        gridList.addActionListener(this);
        gridCon.add(gLabel);
        gridCon.add(gridList);


        //creates the instructions card
        JPanel instructions = new JPanel();
        instructions.setLayout(new BoxLayout(instructions, BoxLayout.PAGE_AXIS));
        instructions.setBackground(Color.black);

        Container insCon = new Container();
        insCon.setLayout(new FlowLayout());
        instructions.add(insCon);
        insCon.add(p1Instructions);

        Container insCon2 = new Container();
        insCon2.setLayout(new FlowLayout());
        insCon2.add(p2Instructions);
        instructions.add(insCon2);

        //adds the cards as tabs to the tabbedpane
        tabbedpane.addTab(MENU, menu);
        tabbedpane.addTab(OPTIONS, options);
        tabbedpane.addTab(INSTRUCTIONS, instructions);

        pane.add(tabbedpane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == exitGame) {
            //exits the game
            System.exit(0);
        }
        else if(source == singlePlayerGame){
            //loads the light cycles game
            GameGrid.setGameMode(1);
            startGame();
        }

        else if(source == twoPlayerGame){
            //loads the light cycles game
            GameGrid.setGameMode(2);
            startGame();
        }

        //lets the user change player 1's colour
        else if(source == red){
            GameGrid.setpOneColour(red.getBackground()); //sets the bike colour to red
        }

        else if(source == blue){
            GameGrid.setpOneColour(blue.getBackground()); //sets the bike colour to blue
        }

        else if(source == green){
            GameGrid.setpOneColour(green.getBackground()); //sets the bike colour to green
        }

        else if(source == yellow){
            GameGrid.setpOneColour(yellow.getBackground()); //sets the bike colour to yellow
        }

        //lets the user change player 2's colour
        else if(source == pink){
            GameGrid.setpTwoColour(pink.getBackground()); //sets the bike colour to pink
        }

        else if(source == cyan){
            GameGrid.setpTwoColour(cyan.getBackground()); //sets the bike colour to cyan
        }

        else if(source == magenta){
            GameGrid.setpTwoColour(magenta.getBackground()); //sets the bike colour to magenta
        }

        else if(source == orange){
            GameGrid.setpTwoColour(orange.getBackground()); //sets the bike colour to orange
        }

        //lets the user change player 1's name
        else if(source == nameField1){
            String name = nameField1.getText();
            GameGrid.setpOneName(name);
        }

        //lets the user change player 2's name
        else if(source == nameField2){
            String name = nameField2.getText();
            GameGrid.setpTwoName(name);
        }

        else if (source == gridList){
            JComboBox cb = (JComboBox)e.getSource();
            String text = (String)cb.getSelectedItem();
            switch(text){
                case "Small":
                    gridSize = 500;
                    GameGrid.setGridSize(gridSize);
                    break;
                case "Medium":
                    gridSize = 700;
                    GameGrid.setGridSize(gridSize);
                    break;
                case "Large":
                    gridSize = 900;
                    GameGrid.setGridSize(gridSize);
                    break;
            }
        }
    }

    private static void startGame(){
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(gridSize + 50, gridSize + 100);
        gameFrame.setVisible(true);
        gameFrame.add(GameGrid, BorderLayout.CENTER);
        gameFrame.setBackground(Color.BLACK);

        gameFrame.setResizable(false);

        gameFrame.setTitle("LightCycles");
        gameFrame.setLocationRelativeTo(null);
        GameGrid.startGame();
    }
}