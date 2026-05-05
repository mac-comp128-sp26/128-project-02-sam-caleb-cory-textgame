package basementCrawl;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main class for the Basement Crawler game.
 * 
 * @author Caleb Hatlevig, Sam Kennedy, Cory Li
 */
public class Game {
    Player player;
    Scanner sc;
    AdjacencyListGraph<Event> graph;
    Event[] events;

    public Game() {
        sc = new Scanner(System.in);

        initPlayer();
        initStory();

        sc.close();
    }

    public static void main(String[] args) {
        new Game();
    }

    /**
     * Initializes the player setup. At this time is it choosing your name.
     */
    private void initPlayer() {
        System.out.println("What's your name?: ");

        String name = sc.nextLine();
        player = new Player(name);
    }

    /**
     * Initiaalizes the story setup. Builds all events from the adjacency list graph and runs the first one.
     */
    private void initStory() {
        try {
            graph = EventBuilder.getMainEventsGraph();
            events = graph.getVertices();

            runEvent(0);
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("Story file does not exist");
            e.printStackTrace();
        }
    }

    /**
     * Runs an event based on it's event ID.
     * 
     * @param eventID
     */
    private void runEvent(int eventID) {
        int currentID = eventID;

        while(true) {
            Event currentEvent = events[currentID];
            if (currentEvent.getItem() != null){
                player.getInventory().addItem(currentEvent.getItem().toString());
            }

            if (currentEvent.getID() == 3){ // SHAW FIELD
                if(player.getInventory().getItems().containsKey("key")){
                    if(player.getInventory().getItems().containsKey("id")){
                        if(player.getInventory().getItems().containsKey("backpack")){
                            currentEvent = events[24];
                            currentID = 24;
                        } else {
                            currentEvent = events[25];
                            currentID = 25;
                        }
                    }
                }
            }

            System.out.println("Inventory: " + player.getInventory().toString());

            System.out.println();
            System.out.println("=================================================================================================================================");
            System.out.println(currentEvent.getDescription());
            System.out.println("=================================================================================================================================");


            ArrayList<Integer> nextEvents = getNextEvents(currentID);

            if(nextEvents.size() == 0) {
                System.out.println("END");
                break;
            }

            String[] options = currentEvent.getOptions();

            for(int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.println("=================================================================================================================================");


            int choice = getValidInput(options.length);
            currentID = nextEvents.get(choice - 1);
        }
    }

    /**
     * Gets the next events that could occur after the current event.
     * 
     * @param eventID
     * @return Events linked to the current event.
     */
    private ArrayList<Integer> getNextEvents(int eventID) {
        ArrayList<Integer> nextEvents = new ArrayList<>();

        for(int nextID : graph.adj(eventID)) {
            nextEvents.add(nextID);
        }

        Collections.reverse(nextEvents);

        return nextEvents;
    }

    /**
     * Validates input, allowing the player to only choose the given options.
     * 
     * @param maxOptions
     * @return
     */
    private Integer getValidInput(int maxOptions) {
        while(true) {
            if(maxOptions == 0) {
                System.out.println("========== GAME OVER ==========");
                return null;
            } else {
                System.out.println("What do you choose? (Number): ");

                if(sc.hasNextInt()) {
                    int input = sc.nextInt();

                    if(input >= 1 && input <= maxOptions) {
                        return input;
                    }
                } else {
                    sc.next();
                }

                System.out.println("That's not an option!");
            }
        }
    }
    
}
