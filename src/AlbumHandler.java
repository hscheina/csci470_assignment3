/***************************************************
 * Haley Scheina & Alonso Arteaga
 * CSCI 470
 * Assignment 2
 **************************************************/

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.net.URL;

public class AlbumHandler extends DefaultHandler{

    private boolean bAlbumName;
    private boolean bArtist;
    private boolean bCategory;
    private boolean bImage;
    private XMLDownloadTask xmlDownloader;
    private String xmlResponse;
    private String albumName;
    private String artistName;
    private String genre;
    private String finalGenre = "";
    private String albumIconUrl;
    private ImageIcon albumIcon;
    int counter=0;

    public AlbumHandler(){

    }

    public AlbumHandler(XMLDownloadTask passedxmldl){
        xmlDownloader = passedxmldl;
    }

    public AlbumHandler(String xmlString, XMLDownloadTask task){
        xmlDownloader = task;
        xmlResponse = xmlString;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException{
        if(qName.equalsIgnoreCase("entry"))
            counter=1;

        if(qName.equalsIgnoreCase("im:name")){
           bAlbumName = true;
           albumName = "";
        }

        if(qName.equalsIgnoreCase("im:artist")){
            bArtist = true;
            artistName = "";
        }

        if (qName.equalsIgnoreCase("category")) {
            bCategory = true;

            // genre = ""
            genre = attributes.getValue("label");



        }else if(qName.equalsIgnoreCase("im:image")){
            bImage = true;
            albumIconUrl = "";
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bAlbumName) {
            albumName = albumName + new String(ch, start, length);

        } else if (bArtist) {
            artistName = artistName + new String(ch, start, length);
        } else if (bImage) {
                albumIconUrl = albumIconUrl + new String(ch, start, length);

        }
    }

   public void endElement(String uri, String localName, String qName){
        if(qName.equalsIgnoreCase("im:name")){
            bAlbumName = false;
        }

        if(qName.equalsIgnoreCase("im:artist")){
            bArtist = false;
        }

        if(qName.equalsIgnoreCase("category")) {
            bCategory = false;
            if(finalGenre.equals(""))
                finalGenre = genre;
        }

        if(qName.equalsIgnoreCase("im:image")) {
            bImage = false;
            try {
                //generate album icon from URL
                URL url = new URL(albumIconUrl);
                BufferedImage bufferedImage = ImageIO.read(url);
                ImageIO.write(bufferedImage, "png", new FileOutputStream("../out/"));
                albumIcon = new ImageIcon(bufferedImage);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(qName.equalsIgnoreCase("entry")){
            Album album = new Album(albumName, artistName,finalGenre, albumIcon);
            this.xmlDownloader.albumList.add(album);
            finalGenre="";
        }
    }
}
