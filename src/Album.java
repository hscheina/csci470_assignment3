public class Album {
    // these variables hold the respective variables from Itunes library
    private String name, //album name
            artistName,
            genre;

    //default constructor. initializes all variables to an empty string
    public Album(){
        name = "";
        artistName = "";
        genre = "";
    }

    public Album(String al, String ar, String ge){
        setName(al);
        setArtistName(ar);
        setGenre(ge);
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
        artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        genre = genre;
    }

    public String toString(){
        return "Album: " + getName() + "; Artists name: "
                + getArtistName() + "; genre: " + getGenre() + "\n";
    }
}
