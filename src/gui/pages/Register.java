package src.gui.pages;

import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class Register { 

    private FPage page;
    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    private FTextField nick_tf;
    private FTextField name_tf;
    private FTextField surname_tf;
    private FPage bts_pane;
    public FButton back_btn;
    public FButton continue_btn;
    private FLabel procedure_lb;

    public FPage getPage() {
        return page;
    }

    public Register(){

        page = new FPage();

        gbc = new GridBagConstraints();

        title_lbl = new FLabel("Registrazione", new Font("Manrope ExtraBold", Font.PLAIN, 99));
        title_lbl.setForeground(Color.BLACK);
        gbc.fill = GridBagConstraints.CENTER;
        setGridCoordinatesXY(gbc, 0, 0);
        // spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(0, 0, 0, 0);
        page.add(title_lbl, gbc);

        text = "Registrati per avere accesso a tutte le funzioni";
        info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(20, 0, 15, 0);
        page.add(info_lbl, gbc);

        nicktxtAlreadyClicked = false;
        nick_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
        nick_tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
            //mouse pressed
                if(!nicktxtAlreadyClicked || email_tf.getText().equals("Email")) {
                    email_tf.setText("");
                    emailtxtAlreadyClicked = true;
            }
        });

        nick_tf.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(final FocusEvent e) {
                //focus lost
                    if(email_tf.getText().equals(""))
                        email_tf.setText("Email");
                }
        });
        
        nick_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.insets = new Insets(10, 0, 0, 0);
        nick_tf.setBackground(Color.WHITE);
        page.add(nick_tf, gbc);

        name_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
        name_tf.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(final FocusEvent arg0) {
            //focus lost
                }
                @Override
                public void focusGained(final FocusEvent e) {
            //focus gained
                }
            });
            name_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(10, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(name_tf, gbc);

        surname_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
        surname_tf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent arg0) {
                //focus lost
            }
            @Override
            public void focusGained(final FocusEvent e) {
                //focus gained
            }
        });
        surname_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(10, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 4);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(surname_tf, gbc);

        bts_pane = new FPage();
        setGridCoordinatesXY(gbc, 0, 5);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(bts_pane, gbc);

        back_btn = new FButton("Indietro");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        // gbc.insets = new Insets(0,0,0,294);
        bts_pane.add(back_btn, gbc);

        FLabel gap_lbl = new FLabel();
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.weightx = 0.1;
        setGridCoordinatesXY(gbc, 1, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(gap_lbl, gbc);

        continue_btn = new FButton("Continua");
        continue_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                //mouse clicked
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.weightx = 0.5;
        setGridCoordinatesXY(gbc, 2, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(continue_btn, gbc);

        procedure_lb = new FLabel("1/3", new Font("Manrope", Font.PLAIN, 15));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.ipadx = -100;
        bts_pane.add(procedure_lb, gbc);
    }

    public static void setGridCoordinatesXY(final GridBagConstraints gbc, final int x, final int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}