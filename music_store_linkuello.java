import java.util.ArrayList;
import java.util.Scanner;

class Music {
    String title;
    String artist;
    double price;

    Music(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Price: $" + price);
    }
}

public class MusicStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Music> musicList = new ArrayList<>();

        // Пример предустановленных треков
        musicList.add(new Music("Shape of You", "Ed Sheeran", 1.99));
        musicList.add(new Music("Blinding Lights", "The Weeknd", 2.49));
        musicList.add(new Music("Stay", "Justin Bieber & Kid Laroi", 1.79));

        while (true) {
            System.out.println("\nWelcome to the Music Store!");
            System.out.println("1. Show all songs");
            System.out.println("2. Add a new song");
            System.out.println("3. Remove a song");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\nAvailable Songs:");
                for (int i = 0; i < musicList.size(); i++) {
                    System.out.println("\nSong #" + (i + 1));
                    musicList.get(i).display();
                }
            } else if (choice == 2) {
                System.out.print("Enter song title: ");
                String title = scanner.nextLine();
                System.out.print("Enter artist name: ");
                String artist = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                musicList.add(new Music(title, artist, price));
                System.out.println("Song added successfully!");
            } else if (choice == 3) {
                System.out.println("\nWhich song do you want to remove?");
                for (int i = 0; i < musicList.size(); i++) {
                    System.out.println((i + 1) + ". " + musicList.get(i).title);
                }
                System.out.print("Enter song number to remove: ");
                int removeIndex = scanner.nextInt() - 1;
                if (removeIndex >= 0 && removeIndex < musicList.size()) {
                    musicList.remove(removeIndex);
                    System.out.println("Song removed successfully!");
                } else {
                    System.out.println("Invalid song number.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting the Music Store. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
