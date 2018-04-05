/***************************************************
 * Haley Scheina & Alonso Arteaga
 * CSCI 470
 * Assignment 2
 **************************************************/

import javax.swing.*;
import java.util.ArrayList;

public class AlbumTable extends JTable{
    private String[] columnNames;
    private Object[][] tData;

    public AlbumTable(){}

    public AlbumTable(ArrayList<Album> albums, String[] colName){
        tData = new Object[albums.size()][3];
        albums.toArray();
        int index = 0;
        for (Album a: albums) {
            tData[index][0] = a.getName(); // column1 = album name
            tData[index][1] = a.getArtistName(); //column2 = artist name
            tData[index][2] = a.getGenre(); //column3 genre
            //future feature: album art would be added here
            ++index;
        }

        columnNames = colName;
    }
    public int getRowCount(){
        return tData.length;
    }

    public int getColumnCount(){
        return columnNames.length;
    }

    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    public Object getValueAt(int row, int col) {
        return tData[row][col];
    }


}
