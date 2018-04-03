import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class AlbumHandler extends DefaultHandler{
    /* the defaulthandre should look for the following tags in the xml string
        "entry:" encloses all the information for an album.
        "im:name": this tag encloses the name of the album.
        "im:artist": encloses the name of the album's artists.
        "category": the genre of the album can be found as the 'label' attribute of the tag
     */


    private boolean bAlbumName;
    private boolean bArtist;
    private boolean bCategory;

    private XMLDownloadTask xmlDownloader;
    private String xmlResponse;
//    private String entryTag;
    private String albumName;
    private String artistName;
    private String genre;

    public AlbumHandler(){

    }

    public AlbumHandler(XMLDownloadTask passedxmldl){
        xmlDownloader = passedxmldl;
    }

    public AlbumHandler(String xmlString, XMLDownloadTask task){
        xmlDownloader = task;
        xmlResponse = xmlString;

    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes){
        /* example of a entry from the xml:
        <entry>
            <updated>2018-03-27T01:50:55-07:00</updated>
            <id im:id="1337879490">https://itunes.apple
            <title>Boarding House Reach - Jack White</title>
            <im:artist>Jack White</im:artist>
            <im:contentType term="album" label="album"/>
            <im:name>Boarding House Reach</im:name>
            <category im:id="20" term="Alternative" scheme="https://itunes.apple.com/us/genre/id20" label="Alternative"/>
            <category im:id="34" term="Music" scheme="https://itunes.apple.com/us/genre/id34" label="Music"/>
            <category im:id="21" term="Rock" scheme="https://itunes.apple.com/us/genre/id21" label="Rock"/>
            <im:image>http://is5.mzstatic.com/image/thumb/Music128/v4/09/77/b7/0977b797-ed55-edae-4c53-4dc76295d938/886446893808.jpg/200x200bb.png</im:image>
            <im:releaseDate>2018-03-23</im:releaseDate>    <link href="https://itunes.apple.com/us/album/boarding-house-reach/1337879490?app=itunes" type="text/html" rel="alternate"/>
            <rights>℗ 2018 Third Man Records under exclusive license to Columbia Records, a division of Sony Music Entertainment</rights>
            <content type="html">&lt;table border="0" width="100%"&gt; &lt;tr&gt; &lt;td&gt; &lt;table border="0" width="100%" cellspacing="0" cellpadding="0"&gt; &lt;tr valign="top"
                align="left"&gt;&lt;td align="center" width="166" valign="top"&gt;&lt;a href="https://itunes.apple.com/us/album/boarding-house-reach/1337879490?app=itunes"&gt;&lt;img border="0"
                alt="Jack White - Boarding House Reach artwork" src="http://is5.mzstatic.com/image/thumb/Music128/v4/09/77/b7/0977b797-ed55-edae-4c53-4dc76295d938/886446893808.jpg/200x200bb.png"
                /&gt;&lt;/a&gt; &lt;/td&gt;&lt;td width="10"&gt;&lt;img alt="" width="10" height="1" src="https://s.mzstatic.com/images/spacer.gif" /&gt;&lt;/td&gt;&lt;td width="95%"&gt;&lt;b&gt;&lt;
                a href="https://itunes.apple.com/us/album/boarding-house-reach/1337879490?app=itunes"&gt;Boarding House Reach&lt;/a&gt;&lt;/b&gt;&lt;br
                /&gt;&lt;a href="https://itunes.apple.com/us/artist/jack-white/826980?app=itunes"&gt;Jack White&lt;/a&gt;&lt;font size="2" face="Helvetica,Arial,Geneva,Swiss,SunSans-Regular"&gt;
                &lt;br/&gt;&lt;b&gt;Genre:&lt;/b&gt; &lt;a href="https://itunes.apple.com/us/genre/id20"&gt;Alternative&lt;/a&gt;&lt;a href="https://itunes.apple.com/us/genre/id34"&gt;Music&lt;/a&gt;&lt;
                a href="https://itunes.apple.com/us/genre/id21"&gt;Rock&lt;/a&gt; &lt;br/&gt;&lt;b&gt;Release Date: &lt;/b&gt;2018-03-23&lt;/font&gt; &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt; &lt;/td&gt;
                &lt;/tr&gt;&lt;tr&gt; &lt;td&gt; &lt;font size="2" face="Helvetica,Arial,Geneva,Swiss,SunSans-Regular"&gt; &amp;#169;
                 ℗ 2018 Third Man Records under exclusive license to Columbia Records, a division of Sony Music Entertainment&lt;/font&gt; &lt;/td&gt; &lt;/tr&gt; &lt;/table&gt;
            </content>
        </entry>

         */
//        if(qName.equalsIgnoreCase("entry")){
//
//        }

        if(qName.equalsIgnoreCase("im:name")){
           bAlbumName = true;
           albumName = "";
        }

        if(qName.equalsIgnoreCase("im:artist")){
            bArtist = true;
            artistName = "";
        }

        if(qName.equalsIgnoreCase("category")){
            bCategory = true;
            genre = "";
            genre = attributes.getValue("term");
        }
    }

    public void characters(char ch[], int start, int length){
        if(bAlbumName)
            albumName = albumName + new String(ch, start, length);

        if(bArtist)
            artistName = artistName + new String(ch, start, length);

       // if(genre.equals("") || genre.equals(null)) {
            if (bCategory)
                genre = genre + new String(ch, start, length);
      // }

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
        }

        if(qName.equalsIgnoreCase("entry")){
            Album album = new Album(albumName, artistName,genre);
            xmlDownloader.albumList.add(album);
        }
    }

}
