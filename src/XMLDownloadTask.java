import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class XMLDownloadTask{
    /*
        XMLDownloadtask is a subclass of Swingworker.
        used to download xml data in the background thread.
        "Needs to add the published album objects to the text area
        in the parent class one at a time, and/or add them to an arraylist
        and return the list when the task is complete so that they can be
        displayed all at once

     */
    String xmlString; // holds the url string passed to the constructor
    // prompt says something about a delegate variable to hold the object refence
    // passed to the constructor
    ArrayList<Album> albumList; // assignment says 'optional'?

    //default constructor
    public XMLDownloadTask(){
        xmlString = "";
    }

    //string constructor
    public XMLDownloadTask(String url){
        xmlString = "https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/explicit.atom\n";
        doInBackground();

    }

    public void doInBackground(){
        HttpURLConnection connection = null;
        try{
            //create a url object from a String that contains a valid URL
            URL url = new URL("https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/explicit.atom\n"
);
            //open an http connection for the url
            connection = (HttpURLConnection) url.openConnection();

            //set http request method
            connection.setRequestMethod("GET");

            //if the http status code is 200, we have succesfully connected
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //use a mutable String builder to store the downloaded text
                StringBuilder xmlResponse = new StringBuilder();

                //create a buffered reader to read the lines of xml from the
                // connection's input stream
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                // read lines of xml and append them to the string builder
                // object until the end of the stream is reached
                String strLine;
                while((strLine = input.readLine()) != null){
                    xmlResponse.append(strLine);
                }

                //convert the stringbuilder object to a string
                xmlString = xmlResponse.toString();

                /*
                    do something to process the xml in xmlstring
                 */
                //close the input stream
                input.close();
            }


        }catch (MalformedURLException e) {
            // Handle MalformedURLException
        } catch (IOException e) {
            // Handle IOException
        } catch (Exception e) {
            // Handle any other exceptions thrown by the code that
            // processes xmlString
        } finally {
            // close connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

//    public String XMLBuilder(String s){
//
//
//
//        xmlString = s;
//    }

    public static void main(String[] args){
        String testString = "https://rss.itunes.apple.com/api/v1/us/itunes-music/new-music/all/10/explicit.atom\n";
        XMLDownloadTask xml = new XMLDownloadTask(testString);
       // xml.doInBackground();

    }
}

