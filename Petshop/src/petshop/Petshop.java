// good start, to improve - give options of what animals the user wants to buy instead of making them but all of them
//finish toys object
//finish food object
package petshop;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {

    private static ArrayList<dog> dogs = new ArrayList<dog>();
    private static ArrayList<Cat> Cats = new ArrayList<Cat>();
    private static ArrayList<toys> toys = new ArrayList<toys>();
    private static ArrayList<food> food = new ArrayList<food>();
    private static Scanner input = new Scanner(System.in);
    public static String fullDir;
    public static int basket = 0;

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Welcome to the PetShop");
        System.out.println("Please select your Reason for Logging on to Olivers Pet shop");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        int schoice = 1;
        schoice = input.nextInt();

        if (schoice == 1) {
            admin();
        } else {
            newDog();
            newCats();
            toys();
            writeFile();
        }

    }

    public static void admin() {
        System.out.println("Welcome to the Administrators page");
        System.out.println("Please enter your password and username: ");
        String Username = input.next();
        String Password = input.next();
        if (Username.equals("Admin") && Password.equals("Petshop")) {
            System.out.println("Welcome to the Admin page");
            System.out.println("We have a list of option for you:");
            System.out.println("1. Add new pets to the Collection");
            System.out.println("2. show the current selection of the animals ");
            int Achoice = input.nextInt();
            
            if (Achoice == 1) {
                System.out.println("What type of aminal would you like to add:");
                String newanimal = input.next();
                System.out.println("What is the name that this new creature has:");
                String animaltype = input.next();
                System.out.println("What is the age of the animal:");
                int animalage = input.nextInt();
                if (Achoice == 2) {
                System.out.println("Here is the list of the animals that we currently have in stock");
                System.out.println("Cats");
                System.out.println("Dogs");
                System.out.println(newanimal);
            }
            }
            
            
        } else {
            System.out.println("This is the incorrect password or username");
            System.out.println("We will now redicrect you.....");

        }
        

    }

    public static void getDir() {
        fullDir = System.getProperty("user.dir") + "\\myText.txt";
    }

    public static void writeFile() {

        try {
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(basket);
            printToFile.close();
            writeToFile.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static void toys() {
        for (int i = 0; i < 4; i++) {

            int doghouse = 40;
            int cathouse = 40;
            int wigglestick = 7;
            System.out.println("The price for the toys will include:");
            System.out.println("1. Doghouse: £40");
            System.out.println("2. Catshouse: £40");
            System.out.println("3. Wiggle stick for cat: £7");
            System.out.println("What toy would you like for your pet: 1, 2 ,3");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("You have chosen the dog house");
                basket = basket + doghouse;
            }
            if (choice == 2) {
                System.out.println("You have chosen the Cathouse");
                basket = basket + cathouse;
            }
            if (choice == 3) {
                System.out.println("You have chosen the wigglestick");
                basket = basket + wigglestick;

            }

        }
        getDir();
    }

    public static void newDog() {

        System.out.println("These are the names of the dogs that we have to offer you:");
        dog a = new dog("Ralfie who is age 2", 2);
        System.out.println(a.getName());
        dogs.add(a);

        dog b = new dog("Snowie who is aged 14", 14);
        System.out.println(b.getName());
        dogs.add(b);

        System.out.println("Please enter in a name and age");
        String dogname = input.next();
        int dogage = input.nextInt();
        for (int i = 0; i < dogs.size(); i++) {
            if ((dogage == (dogs.get(i).getAge()) && dogname.equals(dogs.get(i).getName()))) {
                System.out.println("The dog that you have chosen is called " + dogname);
            } else {

            }
        }

        System.out.println("The age of the dog that you have chosen is " + dogage);
        System.out.println("The dog that you have chosen is called " + dogname);
        System.out.println("");
    }

    public static void newCats() {
        System.out.println("The cats will cost £50");
        System.out.println("dogs will cost £70");
        System.out.println("Here are the names and ages of our cats");
        Cat c = new Cat("Betsy", 14);
        System.out.println("Who is aged 14");
        System.out.println(c.getName());
        Cats.add(c);

        Cat d = new Cat("Lucky", 12);
        System.out.println("Who is aged 12");
        System.out.println(d.getName());

        System.out.println("Please enter in a name and age of a Cat");
        String catname = input.next();
        int catage = input.nextInt();
        for (int i = 0; i < Cats.size(); i++) {
            if ((catname.equals(Cats.get(i).getName()) && (catage == (Cats.get(i).getAge())))) {
                System.out.println("The dog that you have chosen is called " + catname);
                System.out.println("Who is aged " + catage);
            }
            System.out.println("The dog that you have chosen is called " + catname);
            System.out.println("Who is aged " + catage);
            System.out.println("Would you like to buy a cat? ");
            String choice = "Yes";
            if (choice.equals("Yes")) {
                basket = basket + 50;
            } else {
                System.out.println("You have not chosen a valid choice");

            }

        }

    }
}
