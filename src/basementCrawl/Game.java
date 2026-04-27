package basementCrawl;

import java.util.Scanner;

public class Game {
    Player player;
    Scanner sc;

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

    }

    private int getValidInput() {
        System.out.println("What do you choose? (Number): ");

        int input = sc.nextInt();
        return 0;
    }
    
}
