import javafx.scene.control.ToggleGroup;

import javax.swing.*;
import java.awt.*;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormatSymbols;
import java.util.Scanner;
import java.util.ArrayList;

public class DrawGui extends JFrame{

    public DrawGui(){
        super("Itunes Store Album");
        initUI();

    }

    public void initUI(){
        XMLDownloadTask XMLstuff = new XMLDownloadTask();

        JFrame frame = new JFrame("iTunes Store Album");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        frame.setBounds(100, 100, 950, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Create the menu bar.
        JMenuBar menuBar = new JMenuBar();
        JMenu typeMenu = new JMenu("Type");
        JRadioButtonMenuItem new_music_MenuItem = new JRadioButtonMenuItem("New Music");
        JRadioButtonMenuItem recent_releases_MenuItem = new JRadioButtonMenuItem("Recent Releases");
        JRadioButtonMenuItem top_albums_MenuItem = new JRadioButtonMenuItem("Top Albums");
            ButtonGroup typeButtonGroup = new ButtonGroup();
            typeButtonGroup.add(new_music_MenuItem);
            typeButtonGroup.add(recent_releases_MenuItem);
            typeButtonGroup.add(top_albums_MenuItem);

        JMenu limitMenu = new JMenu("Limit");
        JRadioButtonMenuItem menuItem10 = new JRadioButtonMenuItem("10");
        JRadioButtonMenuItem menuItem25 = new JRadioButtonMenuItem("25");
        JRadioButtonMenuItem menuItem50 = new JRadioButtonMenuItem("50");
        JRadioButtonMenuItem menuItem100 = new JRadioButtonMenuItem("100");
            ButtonGroup itemsButtonGroup = new ButtonGroup();
            itemsButtonGroup.add(menuItem10);
            itemsButtonGroup.add(menuItem25);
            itemsButtonGroup.add(menuItem50);
            itemsButtonGroup.add(menuItem100);

        JMenu explicitMenu = new JMenu("Explicit");
        JCheckBoxMenuItem yes_menuItem = new JCheckBoxMenuItem("Yes");
        JCheckBoxMenuItem no_menuItem = new JCheckBoxMenuItem("No");
            ButtonGroup explicitGroup = new ButtonGroup();
            explicitGroup.add(yes_menuItem);
            explicitGroup.add(no_menuItem);

        JButton getAlbums = new JButton("Get Albums");
        getAlbums.setPreferredSize(new Dimension(100,20));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel resultsPane = new JPanel(new FlowLayout());
            resultsPane.setPreferredSize(new Dimension(950, 500));
            resultsPane.setBackground(Color.WHITE);
            Border grayline = BorderFactory.createLineBorder(Color.gray);
            resultsPane.setBorder(grayline);
//        JScrollPane resultsPaneScroll = new JScrollPane(LIST OF ALBUM RESULTS);
//            resultsPaneScroll.setPreferredSize(new Dimension(950,500));

//Build the first menu.
        // menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(typeMenu);
        typeMenu.add(new_music_MenuItem);
        typeMenu.add(recent_releases_MenuItem);
        typeMenu.add(top_albums_MenuItem);
        menuBar.add(limitMenu);
        limitMenu.add(menuItem10);
        limitMenu.add(menuItem25);
        limitMenu.add(menuItem50);
        limitMenu.add(menuItem100);
        menuBar.add(explicitMenu);
        explicitMenu.add(yes_menuItem);
        explicitMenu.add(no_menuItem);



        content.add(buttonPanel, BorderLayout.PAGE_START);
        content.add(resultsPane, BorderLayout.CENTER);
        buttonPanel.add(getAlbums);

        getAlbums.addActionListener((ActionEvent e) -> {
            String typeSelection;
            String itemsNum;
            String explicitYN;

            if (new_music_MenuItem.isSelected()) {
                typeSelection = "new-music";
            }
            else if (recent_releases_MenuItem.isSelected()) {
                typeSelection="recent-releases";
            }
            else  if (top_albums_MenuItem.isSelected()) {
                typeSelection="top-albums";
            }
            else {
                typeSelection=null;
            }
            System.out.println(typeSelection);

            if (menuItem10.isSelected()) {
                itemsNum="10";
            }
            else if (menuItem25.isSelected()) {
                itemsNum="25";
            }
            else if (menuItem50.isSelected()) {
                itemsNum="50";
            }
            else if (menuItem100.isSelected()) {
                itemsNum="100";
            }
            else {
                itemsNum=null;
            }
            
            System.out.println(itemsNum);
            
            if (yes_menuItem.isSelected()) {
                explicitYN="explicit";
            }
            else if (no_menuItem.isSelected()) {
                explicitYN="nonexplicit";
            }
            else {
                explicitYN=null;
            }
            System.out.println(explicitYN);

            XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/"+typeSelection+"/all/"+itemsNum+"/"+explicitYN+".atom");
            System.out.println(XMLstuff.getURL());


            if (itemsNum==null || typeSelection==null || explicitYN==null) {
                JOptionPane.showMessageDialog(null, "Please select a type, limit, and explicit content preference","Error",JOptionPane.ERROR_MESSAGE);

            }


            // TODO: 4/1/18 ADD THE ALBUM LIST TO THE RESULTSPANE 
        });


////a group of JMenuItems
//        JMenuItem menuItem = new JMenuItem("A text-only menu item",
//                KeyEvent.VK_T);
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_1, ActionEvent.ALT_MASK));
//        menuItem.getAccessibleContext().setAccessibleDescription(
//                "This doesn't really do anything");
//        menu.add(menuItem);
//
//        menuItem = new JMenuItem("Both text and icon",
//                new ImageIcon("images/middle.gif"));
//        menuItem.setMnemonic(KeyEvent.VK_B);
//        menu.add(menuItem);
//
//        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
//        menuItem.setMnemonic(KeyEvent.VK_D);
//        menu.add(menuItem);
//
////a group of radio button menu items
//        menu.addSeparator();
//        ButtonGroup group = new ButtonGroup();
//
////a group of check box menu items
//        menu.addSeparator();
//        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
//        cbMenuItem.setMnemonic(KeyEvent.VK_C);
//        menu.add(cbMenuItem);
//
//        cbMenuItem = new JCheckBoxMenuItem("Another one");
//        cbMenuItem.setMnemonic(KeyEvent.VK_H);
//        menu.add(cbMenuItem);
//
////a submenu
//        menu.addSeparator();
//
//        menuItem = new JMenuItem("An item in the submenu");
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_2, ActionEvent.ALT_MASK));
//
//
////Build second menu in the menu bar.
//        menu = new JMenu("Another Menu");
//        menu.setMnemonic(KeyEvent.VK_N);
//        menu.getAccessibleContext().setAccessibleDescription(
//                "This menu does nothing");
//        menuBar.add(menu);


        frame.setJMenuBar(menuBar);



        frame.setVisible(true);

    }

}
