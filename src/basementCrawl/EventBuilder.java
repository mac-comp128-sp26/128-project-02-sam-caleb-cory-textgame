package basementCrawl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Build the Adjacency List object that houses all of the Event nodes which compose the game.
 * 
 */

public class EventBuilder {
    private static Event[] vertices;

    public static AdjacencyListGraph<Event> getMainEventsGraph() throws FileNotFoundException, URISyntaxException{
        URI uri = EventBuilder.class.getResource("/script.txt").toURI();
        String path = Paths.get(uri).toAbsolutePath().toString();
        return readFile(path);
    }

    public static AdjacencyListGraph<Event> readFile(String filename) throws FileNotFoundException{
        // Get the res file
        Scanner in = new Scanner(new File(filename));

        //First line is the number of events
        int V = Integer.parseInt(in.nextLine());
        vertices = new Event[V];
        AdjacencyListGraph<Event> adj = new AdjacencyListGraph<Event>(V);

        int count = 0;
        while (in.hasNext()) {
            String a = in.nextLine();
            int eventID = getIDFromLine(a);

            List<Integer> optionIDs = new ArrayList<Integer>();
            List<String> optionTexts = new ArrayList<String>();
            String blurb = null;
            while (true) {
                String b = in.nextLine();
                char indicator = b.toCharArray()[0];
                b = b.substring(1, b.length());

                if (indicator=='%') {
                    //Strip the % and add it to the blurb
                    blurb = addNewLines(b);
                } else if (indicator=='=') {
                    //Strip the =ID# and add it to the options
                    optionIDs.add(getIDFromLine(b));
                    optionTexts.add(b.substring(b.indexOf('#')+1, b.length()));
                } else if (indicator=='&') {
                    break;
                }
            }

            String[] options = new String[optionIDs.size()];
            for (int i = 0; i < optionIDs.size(); i++) {
                options[i] = optionTexts.get(i);
                adj.addEdge(eventID, optionIDs.get(i));
            }
            vertices[count] = new Event(blurb, options, count);
            count++;
        }

        in.close();
        adj.setVertices(vertices);

        return adj;
    }

    public static int getIDFromLine(String a) {
        char[] lineArray = a.toCharArray();
        String accum = "";
        for (int i = 0; i < lineArray.length; i++) {
            if (lineArray[i]=='#') {
                break;
            }
            accum += lineArray[i];
        }
        return(Integer.parseInt(accum));
    }

    public static String addNewLines(String a) {
        String[] lines = a.split("/");
        String accum = "";
        for (String line : lines) {
            accum += line + "\n";
        }
        return accum;
    }

    /**
     * Main method for testing purposes. Prints out all events and their connections.
     * @param args
     * @throws FileNotFoundException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException{
        
        AdjacencyListGraph<Event> mainGraph = EventBuilder.getMainEventsGraph();
        for (Event e : mainGraph.getVertices()) {
            System.out.println(e.toString());
        }

        for (int i = 0; i < mainGraph.V(); i++) {
            System.out.println(i + " is adjascent to " + mainGraph.adj(i).toString());
        }
    }

    public static Event[] getEvents() {
        return vertices;
    }
}
