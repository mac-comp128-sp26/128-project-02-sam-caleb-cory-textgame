package basementCrawl;

import java.util.Scanner;

public class Game {
    Player player;

    public Game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your name?: ");

        String name = sc.nextLine();
        player = new Player(name);

        sc.close();
    }

    public static void main(String[] args) {
        new Game();
    }
    
}
