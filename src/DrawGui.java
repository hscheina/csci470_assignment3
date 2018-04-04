import javafx.scene.control.ToggleGroup;

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
import java.net.URLConnection;
import java.text.DateFormatSymbols;
import java.util.Scanner;
import java.util.ArrayList;

public class DrawGui extends JFrame implements ActionListener{
    // TODO: 4/3/2018 add comments defining structure of all these variable i.e. what they meant for
    private JButton getAlbumsBtn;
    private XMLDownloadTask XMLstuff;
    private JMenuBar menuBar;
    private JMenu typeMenu;

    //menu items from the toolbar
    private JRadioButtonMenuItem new_music_MenuItem;
    private JRadioButtonMenuItem recent_releases_MenuItem;
    private JRadioButtonMenuItem top_albums_MenuItem;

    //menu items from list items
    private JRadioButtonMenuItem menuItem10;
    private JRadioButtonMenuItem menuItem25;
    private JRadioButtonMenuItem menuItem50;
    private JRadioButtonMenuItem menuItem100;

    private JCheckBoxMenuItem yes_menuItem;
    private JCheckBoxMenuItem no_menuItem;

    private JPanel resultsPane;


    public DrawGui(){
        super("Itunes Store Album");
    }



    public void createAndShowGUI(){
        setLayout(new BorderLayout());
        setBounds(100, 100, 950, 550);
        setResizable(false);
        createMenu();// create the menu bar, menus, and menu items, and adds listeners for the menu items
        addListeners();

        XMLstuff = new XMLDownloadTask();

        setJMenuBar(menuBar);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    private void createMenu(){

        menuBar = new JMenuBar();
        typeMenu = new JMenu("Type");
        add(menuBar);
        add(typeMenu);

        new_music_MenuItem = new JRadioButtonMenuItem("New Music");
        new_music_MenuItem.setSelected(true);
        recent_releases_MenuItem = new JRadioButtonMenuItem("Recent Releases");
        top_albums_MenuItem = new JRadioButtonMenuItem("Top Albums");
        ButtonGroup typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(new_music_MenuItem);
        typeButtonGroup.add(recent_releases_MenuItem);
        typeButtonGroup.add(top_albums_MenuItem);
        JMenu limitMenu = new JMenu("Limit");

        menuItem10 = new JRadioButtonMenuItem("10");
        menuItem10.setSelected(true);
        menuItem25 = new JRadioButtonMenuItem("25");
        menuItem50 = new JRadioButtonMenuItem("50");
        menuItem100 = new JRadioButtonMenuItem("100");
        ButtonGroup itemsButtonGroup = new ButtonGroup();
        itemsButtonGroup.add(menuItem10);
        itemsButtonGroup.add(menuItem25);
        itemsButtonGroup.add(menuItem50);
        itemsButtonGroup.add(menuItem100);

        JMenu explicitMenu = new JMenu("Explicit");

        yes_menuItem = new JCheckBoxMenuItem("Yes");
        yes_menuItem.setSelected(true);

        no_menuItem = new JCheckBoxMenuItem("No");
        ButtonGroup explicitGroup = new ButtonGroup();
        explicitGroup.add(yes_menuItem);
        explicitGroup.add(no_menuItem);


        getAlbumsBtn = new JButton("Get Albums");
        getAlbumsBtn.setPreferredSize(new Dimension(100,20));
        JPanel buttonPanel = new JPanel(new FlowLayout());
<<<<<<< HEAD
        JPanel resultsPane = new JPanel(new FlowLayout());
            resultsPane.setPreferredSize(new Dimension(950, 500));
            resultsPane.setBackground(Color.WHITE);
            Border grayline = BorderFactory.createLineBorder(Color.gray);
            resultsPane.setBorder(grayline);
//        JScrollPane resultsPaneScroll = new JScrollPane(albumJList);
//            resultsPaneScroll.setPreferredSize(new Dimension(950,500));
//            resultsPane.add(resultsPaneScroll);

//Build the first menu.
=======
        resultsPane = new JPanel(new FlowLayout());
        resultsPane.setPreferredSize(new Dimension(950, 500));
        resultsPane.setBackground(Color.WHITE);
        Border grayline = BorderFactory.createLineBorder(Color.gray);
        resultsPane.setBorder(grayline);


        //Build the first menu.
>>>>>>> a69aa94cada5f3d13e5a87ba194361046432dfe1
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

        this.add(buttonPanel, BorderLayout.PAGE_START);
        this.add(resultsPane, BorderLayout.CENTER);
        buttonPanel.add(getAlbumsBtn);


    }

    private void addListeners(){
        getAlbumsBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Get Albums")) {

            String typeSelection;
            String itemsNum;
            String explicitYN;

            if (top_albums_MenuItem.isSelected()) {
                typeSelection = "top-albums";
            } else if (recent_releases_MenuItem.isSelected()) {
                typeSelection = "recent-releases";
            } else {
                //  new_music_MenuItem.setSelected(true);
                typeSelection = "new-music";
            }
            System.out.println(typeSelection);


            if (menuItem100.isSelected()) {
                itemsNum = "100";
            } else if (menuItem25.isSelected()) {
                itemsNum = "25";
            } else if (menuItem50.isSelected()) {
                itemsNum = "50";
            } else {
                //  menuItem10.setSelected(true);
                itemsNum = "10";
            }
            System.out.println(itemsNum);

//            JList albumJList = new JList<Album>((ListModel<Album>) XMLstuff.getAlbumList());

//            JList<Destination> destinationJList = new JList<>();
//            DefaultListModel<Destination> jmodel = new DefaultListModel<>();
//            destinationJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//            destinationJList.setLayoutOrientation(JList.VERTICAL);
//            destinationJList.setVisibleRowCount(9);
//            destinationJList.setFixedCellWidth(5);
//            //Populating JList
//            for(int i = 0; i < cities.length; i++) {
//                jmodel.addElement(redeemer.getDestinationArrayList().get(i));
//            }
//            destinationJList.setModel(jmodel);


            if (no_menuItem.isSelected()) {
                explicitYN = "nonexplicit";
            } else {
                //  yes_menuItem.setSelected(true);
                explicitYN = "explicit";
            }
            System.out.println(explicitYN);

//            this.XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/" + typeSelection + "/all/" + itemsNum + "/" + explicitYN + ".atom");
            XMLstuff.setURL("https://rss.itunes.apple.com/api/v1/us/itunes-music/" + typeSelection + "/all/" + itemsNum + "/" + explicitYN + ".atom");
            System.out.println(this.XMLstuff.getUrl());

            this.XMLstuff.getAlbumList();
            JList<Album> albumJList = new JList<>();
            DefaultListModel<Album> jmodel = new DefaultListModel<>();
            // albumJList.setSelectionModel(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            albumJList.setLayoutOrientation(JList.VERTICAL);
            for (int i = 0; i < this.XMLstuff.getAlbumList().size(); i++) {
                jmodel.addElement(this.XMLstuff.getAlbumList().get(i));
            }
            albumJList.setModel(jmodel);

            JScrollPane resultsPaneScroll = new JScrollPane(albumJList);
            resultsPaneScroll.setPreferredSize(new Dimension(950, 500));
            // resultsPaneScroll.add(albumJList);
            resultsPane.add(resultsPaneScroll);
            //TODO: display the albumList on the scroll pane
            resultsPane.revalidate();
            resultsPane.repaint();
            resultsPane.updateUI();

        }
    }


    private static void main(String[] args){
        EventQueue.invokeLater(() -> {
            DrawGui frame = new DrawGui();
            frame.createAndShowGUI();
        });
    }
}