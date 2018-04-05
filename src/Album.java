import javax.swing.*;

public class Album {
    // these variables hold the respective variables from Itunes library
    private String name; //album name
    private String artistName;
    private String genre;
    private ImageIcon icon;


    //default constructor. initializes all variables to an empty string
    public Album(){
        name = "";
        artistName = "";
        genre = "";
        icon = null;
    }

    public Album(String al, String ar, String ge, ImageIcon ic){
        setName(al);
        setArtistName(ar);
        setGenre(ge);
        setIcon(ic);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String toString(){
        return "Album: " + getName() + "; Artists name: "
                + getArtistName() + "; genre: " + getGenre() + "\n";
    }
}
