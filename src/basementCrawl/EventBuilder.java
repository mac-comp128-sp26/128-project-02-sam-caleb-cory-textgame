package basementCrawl;
/**
 * Build the Adjacency List object that houses all of the Event nodes which compose the game.
 * 
 */

public class EventBuilder {

    Event[] vertices = new Event[5];

    public static AdjacencyListGraph buildEvent(){
        return new AdjacencyListGraph(5);
    }

    private void fillVerticesArray(){
        
    }

}
