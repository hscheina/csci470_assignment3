import javax.swing.*;
import java.awt.*;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        JCheckBoxMenuItem new_music_MenuItem = new JCheckBoxMenuItem("New Music");
        JCheckBoxMenuItem recent_releases_MenuItem = new JCheckBoxMenuItem("Recent Releases");
        JCheckBoxMenuItem top_albums_MenuItem = new JCheckBoxMenuItem("Top Albums");
            typeMenu.addActionListener(actionEvent -> {
                if (new_music_MenuItem.isSelected()) {
                    recent_releases_MenuItem.setSelected(false);
                    top_albums_MenuItem.setSelected(false);
                }
                if (recent_releases_MenuItem.isSelected()) {
                    new_music_MenuItem.setSelected(false);
                    top_albums_MenuItem.setSelected(false);
                }
                if (top_albums_MenuItem.isSelected()) {
                    new_music_MenuItem.setSelected(false);
                    recent_releases_MenuItem.setSelected(false);
                }
            });

        JMenu limitMenu = new JMenu("Limit");
        JCheckBoxMenuItem menuItem10 = new JCheckBoxMenuItem("10");
        JCheckBoxMenuItem menuItem25 = new JCheckBoxMenuItem("25");
        JCheckBoxMenuItem menuItem50 = new JCheckBoxMenuItem("50");
        JCheckBoxMenuItem menuItem100 = new JCheckBoxMenuItem("100");
            limitMenu.addActionListener(actionEvent -> {
                if (menuItem10.isSelected()) {
                    menuItem25.setSelected(false);
                    menuItem50.setSelected(false);
                    menuItem100.setSelected(false);
                }
                if (menuItem25.isSelected()) {
                    menuItem10.setSelected(false);
                    menuItem50.setSelected(false);
                    menuItem100.setSelected(false);
                }
                if (menuItem50.isSelected()) {
                    menuItem10.setSelected(false);
                    menuItem25.setSelected(false);
                    menuItem100.setSelected(false);
                }
                if (menuItem100.isSelected()) {
                    menuItem10.setSelected(false);
                    menuItem25.setSelected(false);
                    menuItem50.setSelected(false);
                }
            });
        JMenu explicitMenu = new JMenu("Explicit");
        JCheckBoxMenuItem yes_menuItem = new JCheckBoxMenuItem("Yes");
        JCheckBoxMenuItem no_menuItem = new JCheckBoxMenuItem("No");
            explicitMenu.addActionListener(actionEvent -> {
                if (yes_menuItem.isSelected()) {
                    no_menuItem.setSelected(false);
                }
                if (no_menuItem.isSelected()) {
                    yes_menuItem.setSelected(false);
                }
            });
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
            if (menuItem10.isSelected()) {
                itemsNum = menuItem10.getText();
            }
            else if (menuItem25.isSelected()) {
                itemsNum = menuItem25.getText();
            }
            else if (menuItem50.isSelected()) {
                itemsNum = menuItem50.getText();
            }
            else {
                itemsNum = menuItem100.getText();
            }
            System.out.println(itemsNum);

            if (new_music_MenuItem.isSelected()) {
                typeSelection = new_music_MenuItem.getText();
            }
            else if (recent_releases_MenuItem.isSelected()) {
                typeSelection = recent_releases_MenuItem.getText();
            }
            else {
                typeSelection = top_albums_MenuItem.getText();

            }
            System.out.println(typeSelection);

            if (yes_menuItem.isSelected()) {
                explicitYN = yes_menuItem.getText();
            }
            else {
                explicitYN = no_menuItem.getText();
            }
            System.out.println(explicitYN);

            if (itemsNum=="10") {
                if (typeSelection=="New Music") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Recent Releases") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/10/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/10/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Top Albums") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/10/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/10/nonexplicit.atom");
                    }
                }
            }

            if (itemsNum=="25") {
                if (typeSelection=="New Music") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/25/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/25/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Recent Releases") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/25/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/25/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Top Albums") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/25/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/25/nonexplicit.atom");
                    }
                }
            }

            if (itemsNum=="50") {
                if (typeSelection=="New Music") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/50/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/50/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Recent Releases") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/50/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/50/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Top Albums") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/50/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/50/nonexplicit.atom");
                    }
                }
            }

            if (itemsNum=="100") {
                if (typeSelection=="New Music") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/100/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/100/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Recent Releases") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/100/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/recent-releases/all/100/nonexplicit.atom");
                    }
                }
                if (typeSelection=="Top Albums") {
                    if (explicitYN=="Yes") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/100/explicit.atom");
                    }
                    if (explicitYN=="No") {
                        //send THIS url to XML method
                        XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/top-albums/all/100/nonexplicit.atom");
                    }
                }
            }
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
