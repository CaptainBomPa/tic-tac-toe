package com.example.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePlayerVsPlayer implements ActionListener {
    JFrame frame;
    static final int SCREEN_WIDTH = 630;
    static final int SCREEN_HEIGHT = 600;
    static final String BG_COLOR = "#00A6A1";
    static final String BG_COLOR_BUTTON = "#02B7B1";
    static final String BG_COLOR_HOVER = "#01E4DC";
    int total_moves = 0;

    private JLabel label0;
    private JLabel label1;
    private JLabel label2;
    private JButton button01;                          //               |            |
    private JButton button11;                          //     button01  |  button11  |  button21
    private JButton button21;                          //               |            |
    private JButton button02;                          //     ----------------------------------
    private JButton button12;                          //               |            |
    private JButton button22;                          //     button02  |  button12  |  button22
    private JButton button03;                          //               |            |
    private JButton button13;                          //     ----------------------------------
    private JButton button23;                          //               |            |
    private JButton returnButton;                      //     button03  |  button13  |  button23
    private JButton restartButton;                     //               |            |
    int whichPlayerMove = 1; // 1 - player1 move
                             // 2- player2 move

    public GamePlayerVsPlayer(JFrame frame)
    {
        this.frame = frame;
        frame.setTitle("Player vs Player");
        frame.setLayout(new GridLayout(0,3));
        frame.getContentPane().setBackground(Color.decode(BG_COLOR));

        label0 = new JLabel("");
        label0.setHorizontalAlignment(JLabel.CENTER);
        label0.setFont(new Font("", Font.BOLD, 25));
        frame.add(label0);

        label1 = new JLabel("Move: ");
        label1.setHorizontalAlignment(JLabel.RIGHT);
        label1.setFont(new Font("", Font.BOLD,25));
        label1.setForeground(Color.WHITE);
        frame.add(label1);

        label2 = new JLabel("x");
        label2.setHorizontalAlignment(JLabel.LEFT);
        label2.setFont(new Font("", Font.BOLD,60));
        label2.setForeground(Color.RED);
        frame.add(label2);

        initBoard(frame);

        restartButton = new JButton("Restart");
        restartButton.setBackground(Color.decode(BG_COLOR));
        restartButton.setBorder(BorderFactory.createEmptyBorder());
        restartButton.setFont(new Font("", Font.BOLD,25));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        frame.add(restartButton);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.validate();
                new GamePlayerVsPlayer(frame);
            }
        });
        restartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                restartButton.setBackground(Color.decode(BG_COLOR_HOVER));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restartButton.setBackground(Color.decode(BG_COLOR));
            }
        });

        returnButton = new JButton("Return to menu");
        returnButton.setBackground(Color.decode(BG_COLOR));
        returnButton.setBorder(BorderFactory.createEmptyBorder());
        returnButton.setFont(new Font("", Font.BOLD,25));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFocusPainted(false);
        frame.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.validate();
                new Main(frame);
            }
        });
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                returnButton.setBackground(Color.decode(BG_COLOR_HOVER));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                returnButton.setBackground(Color.decode(BG_COLOR));
            }
        });

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void initBoard(JFrame frame)
    {
        button01 = new JButton("");
        button01.setBackground(Color.decode(BG_COLOR));
        button01.setFocusPainted(false);
        button01.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.black));
        button01.setContentAreaFilled(false);
        button01.setMargin(new Insets(0,0,0,0));
        button01.setFont(new Font("", Font.BOLD, 60));
        frame.add(button01);

        button11 = new JButton("");
        button11.setBackground(Color.decode(BG_COLOR));
        button11.setFocusPainted(false);
        button11.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.black));
        button11.setContentAreaFilled(false);
        button11.setFont(new Font("", Font.BOLD, 60));
        frame.add(button11);

        button21 = new JButton("");
        button21.setBackground(Color.decode(BG_COLOR));
        button21.setFocusPainted(false);
        button21.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        button21.setContentAreaFilled(false);
        button21.setFont(new Font("", Font.BOLD, 60));
        frame.add(button21);

        button02 = new JButton("");
        button02.setBackground(Color.decode(BG_COLOR));
        button02.setFocusPainted(false);
        button02.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.black));
        button02.setContentAreaFilled(false);
        button02.setFont(new Font("", Font.BOLD, 60));
        frame.add(button02);

        button12 = new JButton("");
        button12.setBackground(Color.decode(BG_COLOR));
        button12.setFocusPainted(false);
        button12.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.black));
        button12.setContentAreaFilled(false);
        button12.setFont(new Font("", Font.BOLD, 60));
        frame.add(button12);

        button22 = new JButton("");
        button22.setBackground(Color.decode(BG_COLOR));
        button22.setFocusPainted(false);
        button22.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        button22.setContentAreaFilled(false);
        button22.setFont(new Font("", Font.BOLD, 60));
        frame.add(button22);

        button03 = new JButton("");
        button03.setBackground(Color.decode(BG_COLOR));
        button03.setFocusPainted(false);
        button03.setBorder(BorderFactory.createMatteBorder(0,0,0,2,Color.black));
        button03.setContentAreaFilled(false);
        button03.setFont(new Font("", Font.BOLD, 60));
        frame.add(button03);

        button13 = new JButton("");
        button13.setBackground(Color.decode(BG_COLOR));
        button13.setFocusPainted(false);
        button13.setBorder(BorderFactory.createMatteBorder(0,0,0,2,Color.black));
        button13.setContentAreaFilled(false);
        button13.setFont(new Font("", Font.BOLD, 60));
        frame.add(button13);

        button23 = new JButton("");
        button23.setBackground(Color.decode(BG_COLOR));
        button23.setFocusPainted(false);
        button23.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
        button23.setContentAreaFilled(false);
        button23.setFont(new Font("", Font.BOLD, 60));
        frame.add(button23);

        button01.addActionListener(this);
        button11.addActionListener(this);
        button21.addActionListener(this);
        button02.addActionListener(this);
        button12.addActionListener(this);
        button22.addActionListener(this);
        button03.addActionListener(this);
        button13.addActionListener(this);
        button23.addActionListener(this);
    }

    public void checkIfWinner()
    {
        if(button01.getText().equals(button11.getText()) && button11.getText().equals(button21.getText()))
        {
            if(button01.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button11.setBackground(Color.PINK); button11.setContentAreaFilled(true);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button01.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button11.setBackground(Color.PINK); button11.setContentAreaFilled(true);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button02.getText().equals(button12.getText()) && button12.getText().equals(button22.getText()))
        {
            if(button02.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button02.setBackground(Color.PINK); button02.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button22.setBackground(Color.PINK); button22.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button02.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button02.setBackground(Color.PINK); button02.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button22.setBackground(Color.PINK); button22.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button03.getText().equals(button13.getText()) && button13.getText().equals(button23.getText()))
        {
            if(button03.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                button13.setBackground(Color.PINK); button13.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button03.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                button13.setBackground(Color.PINK); button13.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button01.getText().equals(button02.getText()) && button02.getText().equals(button03.getText()))
        {
            if(button01.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button02.setBackground(Color.PINK); button02.setContentAreaFilled(true);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button01.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button02.setBackground(Color.PINK); button02.setContentAreaFilled(true);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button11.getText().equals(button12.getText()) && button12.getText().equals(button13.getText()))
        {
            if(button11.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button11.setBackground(Color.PINK); button11.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button13.setBackground(Color.PINK); button13.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button11.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button11.setBackground(Color.PINK); button11.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button13.setBackground(Color.PINK); button13.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button21.getText().equals(button22.getText()) && button22.getText().equals(button23.getText()))
        {
            if(button21.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                button22.setBackground(Color.PINK); button22.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button21.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                button22.setBackground(Color.PINK); button22.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button01.getText().equals(button12.getText()) && button12.getText().equals(button23.getText()))
        {
            if(button01.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
            else if(button01.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button01.setBackground(Color.PINK); button01.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button23.setBackground(Color.PINK); button23.setContentAreaFilled(true);
                endProcedure();
            }
        }
        else if(button21.getText().equals(button12.getText()) && button12.getText().equals(button03.getText()))
        {
            if(button21.getText().equals("x"))
            {
                label0.setText("The winner is: x");
                label0.setForeground(Color.RED);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                endProcedure();

            }
            else if(button21.getText().equals("o"))
            {
                label0.setText("The winner is: o");
                label0.setForeground(Color.GREEN);
                button21.setBackground(Color.PINK); button21.setContentAreaFilled(true);
                button12.setBackground(Color.PINK); button12.setContentAreaFilled(true);
                button03.setBackground(Color.PINK); button03.setContentAreaFilled(true);
                endProcedure();
            }
        }
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public void endProcedure()
    {
        if(button01.getText().equals("")) button01.setEnabled(false);
        if(button11.getText().equals("")) button11.setEnabled(false);
        if(button21.getText().equals("")) button21.setEnabled(false);
        if(button02.getText().equals("")) button02.setEnabled(false);
        if(button12.getText().equals("")) button12.setEnabled(false);
        if(button22.getText().equals("")) button22.setEnabled(false);
        if(button03.getText().equals("")) button03.setEnabled(false);
        if(button13.getText().equals("")) button13.setEnabled(false);
        if(button23.getText().equals("")) button23.setEnabled(false);
    }

    public void changePlayerMove()
    {
        if(total_moves == 8)
        {
            label0.setText("DRAW");
            label0.setForeground(Color.gray);
            endProcedure();
        }
        else if(whichPlayerMove == 1)
        {
            label2.setText("o");
            label2.setForeground(Color.GREEN);
            whichPlayerMove = 2;
            total_moves++;
        }
        else
        {
            label2.setText("x");
            label2.setForeground(Color.RED);
            whichPlayerMove = 1;
            total_moves++;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button01)
        {
            if(!button01.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button01.setText("x");
                button01.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button01.setText("o");
                button01.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button11)
        {
            if(!button11.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button11.setText("x");
                button11.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button11.setText("o");
                button11.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button21)
        {
            if(!button21.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button21.setText("x");
                button21.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button21.setText("o");
                button21.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button02)
        {
            if(!button02.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button02.setText("x");
                button02.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button02.setText("o");
                button02.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button12)
        {
            if(!button12.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button12.setText("x");
                button12.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button12.setText("o");
                button12.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button22)
        {
            if(!button22.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button22.setText("x");
                button22.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button22.setText("o");
                button22.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button03)
        {
            if(!button03.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button03.setText("x");
                button03.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button03.setText("o");
                button03.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button13)
        {
            if(!button13.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button13.setText("x");
                button13.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button13.setText("o");
                button13.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }
        else if(e.getSource() == button23)
        {
            if(!button23.getText().equals(""))
            {
                label0.setText("Invalid move!");
                label0.setForeground(Color.RED);
            }
            else if(whichPlayerMove == 1)
            {
                button23.setText("x");
                button23.setForeground(Color.RED);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
            else if(whichPlayerMove == 2)
            {
                button23.setText("o");
                button23.setForeground(Color.GREEN);
                label0.setText("");
                checkIfWinner();
                changePlayerMove();
            }
        }

    }
}
