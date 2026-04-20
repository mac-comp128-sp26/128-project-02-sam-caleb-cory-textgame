package basementCrawl;

import java.util.Scanner;

public class Game {
    Player player;
    Scanner sc;

    public Game() {
        sc = new Scanner(System.in);

        initPlayer();
        // initStory();

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

    private int getValidInput() {
        return 0;
    }
    
}
