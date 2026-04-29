package basementCrawl;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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

    private void initPlayer() {
        System.out.println("What's your name?: ");

        String name = sc.nextLine();
        player = new Player(name);
    }

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

    private void runEvent(int eventID) {
        int currentID = eventID;

        while(true) {
            Event currentEvent = events[currentID];
            if (currentEvent.getItem() != null){
                player.getInventory().addItem(currentEvent.getItem());
            }
            
            if (currentEvent.getID() == 3){ // SHAW FIELD
                boolean hasKey = false;
                boolean hasId = false;
                boolean hasBackpack = false;

                Item[] items = player.getInventory().getItems();
                for (int i = 0; i < items.length; i++){
                    if(items[i].toString() == "key"){
                        System.out.println("Player has key");
                        hasKey = true;
                    }
                    if(items[i].toString() == "id"){
                        System.out.println("Player has id");
                        hasId = true;
                    }
                    if(items[i].toString() == "backpack"){
                        System.out.println("Player has backpack");
                        hasBackpack = true;
                    }
                if(hasKey && hasBackpack && hasId){
                    // GO TO TRUE END
                }
                else if(hasKey && hasId){
                    // GO TO BAD END
                }
                }
            }

            System.out.println(player.getInventory().toString());

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

    private ArrayList<Integer> getNextEvents(int eventID) {
        ArrayList<Integer> nextEvents = new ArrayList<>();

        for(int nextID : graph.adj(eventID)) {
            nextEvents.add(nextID);
        }

        Collections.reverse(nextEvents);

        return nextEvents;
    }

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
