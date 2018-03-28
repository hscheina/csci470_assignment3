/***************************************************
 * Haley Scheina & Alonso Arteaga
 * CSCI 470
 * Assignment 2
 **************************************************/


import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormatSymbols;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Main {

    public static void main(String[] args){
        DrawGui gui = new DrawGui();


//        JFrame frame = new JFrame("iTunes Store Album");
//        Container content = frame.getContentPane();
//        content.setLayout(new BorderLayout());
//        frame.setBounds(100, 100, 950, 550);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
////Create the menu bar.
//        JMenuBar menuBar = new JMenuBar();
//            JMenu typeMenu = new JMenu("Type");
//                JCheckBoxMenuItem new_music_MenuItem = new JCheckBoxMenuItem("New Music");
//                JCheckBoxMenuItem recent_releases_MenuItem = new JCheckBoxMenuItem("Recent Releases");
//                JCheckBoxMenuItem top_albums_MenuItem = new JCheckBoxMenuItem("Top Albums");
//            JMenu limitMenu = new JMenu("Limit");
//                JCheckBoxMenuItem menuItem10 = new JCheckBoxMenuItem("10");
//                JCheckBoxMenuItem menuItem25 = new JCheckBoxMenuItem("25");
//                JCheckBoxMenuItem menuItem50 = new JCheckBoxMenuItem("50");
//                JCheckBoxMenuItem menuItem100 = new JCheckBoxMenuItem("100");
//            JMenu explicitMenu = new JMenu("Explicit");
//                JCheckBoxMenuItem yes_menuItem = new JCheckBoxMenuItem("Yes");
//                JCheckBoxMenuItem no_menuItem = new JCheckBoxMenuItem("No");
//        JButton getAlbums = new JButton("Get Albums");
//            getAlbums.setPreferredSize(new Dimension(100,20));
//            JPanel buttonPanel = new JPanel(new FlowLayout());
//
////Build the first menu.
//       // menu.setMnemonic(KeyEvent.VK_A);
//        menuBar.add(typeMenu);
//            typeMenu.add(new_music_MenuItem);
//            typeMenu.add(recent_releases_MenuItem);
//            typeMenu.add(top_albums_MenuItem);
//        menuBar.add(limitMenu);
//            limitMenu.add(menuItem10);
//            limitMenu.add(menuItem25);
//            limitMenu.add(menuItem50);
//            limitMenu.add(menuItem100);
//        menuBar.add(explicitMenu);
//            explicitMenu.add(yes_menuItem);
//            explicitMenu.add(no_menuItem);
//
//        content.add(buttonPanel, BorderLayout.PAGE_START);
//        buttonPanel.add(getAlbums);
//
//////a group of JMenuItems
////        JMenuItem menuItem = new JMenuItem("A text-only menu item",
////                KeyEvent.VK_T);
////        menuItem.setAccelerator(KeyStroke.getKeyStroke(
////                KeyEvent.VK_1, ActionEvent.ALT_MASK));
////        menuItem.getAccessibleContext().setAccessibleDescription(
////                "This doesn't really do anything");
////        menu.add(menuItem);
////
////        menuItem = new JMenuItem("Both text and icon",
////                new ImageIcon("images/middle.gif"));
////        menuItem.setMnemonic(KeyEvent.VK_B);
////        menu.add(menuItem);
////
////        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
////        menuItem.setMnemonic(KeyEvent.VK_D);
////        menu.add(menuItem);
////
//////a group of radio button menu items
////        menu.addSeparator();
////        ButtonGroup group = new ButtonGroup();
////
//////a group of check box menu items
////        menu.addSeparator();
////        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
////        cbMenuItem.setMnemonic(KeyEvent.VK_C);
////        menu.add(cbMenuItem);
////
////        cbMenuItem = new JCheckBoxMenuItem("Another one");
////        cbMenuItem.setMnemonic(KeyEvent.VK_H);
////        menu.add(cbMenuItem);
////
//////a submenu
////        menu.addSeparator();
////
////        menuItem = new JMenuItem("An item in the submenu");
////        menuItem.setAccelerator(KeyStroke.getKeyStroke(
////                KeyEvent.VK_2, ActionEvent.ALT_MASK));
////
////
//////Build second menu in the menu bar.
////        menu = new JMenu("Another Menu");
////        menu.setMnemonic(KeyEvent.VK_N);
////        menu.getAccessibleContext().setAccessibleDescription(
////                "This menu does nothing");
////        menuBar.add(menu);
//
//
//        frame.setJMenuBar(menuBar);
//
//
//
//        frame.setVisible(true);
    }





}
