//Hangman Mid Term CPT by Ben Coombes
/*Write a program where you have listed 20 words in an array of String. The program will randomly select
one of the words. The program will start of with blank letters “ _ _ _ _ _ _” (Canada). And each turn will
randomly expose a letter. Each turn the user will take a guess what the word is. If the guess is incorrect,
add a piece to the hanging man drawing. Once all pieces are drawn... GAME OVER. A typical hangman
drawing has: Head, neck, body, arms, legs, rope, horizontal pole, vertical pole. Therefore, your puzzle
should have at least 7- 9 letters in it. Each “piece” of the drawing could/should be done as separate
drawings, called in different if/elseif blocks.*/
import arc.*;
import java.util.List;
import java.util.*;
import java.awt.*;
public class Hangman {
  //Starts up console, loads up the fonts used in the game
  public static Console con = new Console("Hangman", 1024, 576);
  public static Font GugiMenu = con.loadFont("Gugi.ttf",25);
  public static Font GugiGame = con.loadFont("Gugi.ttf",40);
  public static Font GugiLength = con.loadFont("Gugi.ttf",20);
  //Main method that takes you to the menu method
  public static void main(String[] args) {
    Hangman.menu();
  }
  //Method that runs the menu UI
  public static void menu() {
    //UI setup
    con.setDrawFont(GugiMenu);
    con.setDrawColor(new Color(100,149,237));
    con.fillRect(0, 0, 1024, 576);
    con.setDrawColor(Color.RED);
    //prints buttons to menu screen
    con.fillRect(425, 188, 175, 40);
    con.fillRect(425, 258, 175, 40);
    con.fillRect(425, 328, 175, 40);
    con.setDrawColor(Color.WHITE);
    con.drawString("Play", 490, 185);
    con.drawString("Instructions", 440, 255);
    con.drawString("Quit", 490, 325);
    con.repaint();
    con.clear();
    //Checks if the user has clicked the buttons on the menu
    while (true) {
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 188 && con.currentMouseY() <= 228) {
        Hangman.game();
      }
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 258 && con.currentMouseY() <= 298) {
        Hangman.instructions();
      }
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 328 && con.currentMouseY() <= 368) {
        con.closeConsole();
      }
    }
  }
  //prints the instructions of the game to the screen when the user presses the instructions button
  public static void instructions() {
    con.setDrawColor(Color.GRAY);
    con.fillRect(0, 0, 1024, 576);
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("");
    con.println("  The point of Hangman is for the user to guess the word that the program generates.");
    con.println("      You do this by guessing one letter at a time. If the letter is in the word");
    con.println("                       it will replace the blank space. If the ");
    con.println("                 letter is not in the word you will lose a life.");
    con.println("           If you lose all your lives before you guess the word you lose.");
    con.setDrawColor(Color.RED);
    con.fillRect(425, 400, 175, 40);
    con.setDrawColor(Color.WHITE);
    con.drawString("Menu", 490, 402);
    //checks if the user presses the button if they do takes them back to the menu method
    while (true) {
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 400 && con.currentMouseY() <= 440) {
        Hangman.menu();
      }
    }
  }
  //method that runs the main game after they click the play button
  public static void game() {
    //UI
    con.setDrawFont(GugiMenu);
    String strRandomWord = "", strMysteryWord, strGuessedWord,strLetter;
    int intRand, intGuessesLeft = 6;
    con.setDrawColor(new Color(100,149,237));
    con.fillRect(0, 0, 1024, 576);
    con.setDrawColor(Color.RED);
    //prints category choices to the screen
    con.fillRect(425, 188, 175, 40);
    con.fillRect(425, 258, 175, 40);
    con.fillRect(425, 328, 175, 40);
    con.setDrawColor(Color.WHITE);
    con.drawString("Pick a Category", 418, 147);
    con.drawString("Animals", 465, 185);
    con.drawString("Food", 483, 255);
    con.drawString("Countries", 455, 325);
    con.repaint();
    con.sleep(100);
    //checks if the user presses any of the category buttons once they do an array is setup with all the different words and then a word is randomly selected from inside the array
    while (strRandomWord.equals("")) {
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 188 && con.currentMouseY() <= 228) {
        String[] arrAnimals = {"cheetah", "armadillo", "bulldog", "caterpillar", "elephant", "squirrel", "giraffe", "anaconda", "seahorse", "butterfly", "lobster", "alligator", "chipmunk", "flamingo", "gorilla", "grasshopper", "hippopotamus", "raccoon","panther","dolphin","tortoise","opossum","ostrich"};
        strRandomWord = arrAnimals[(int) (Math.random() * 24)];
      }
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 258 && con.currentMouseY() <= 298) {
        String[] arrFood = {"eggplant", "hamburger", "blackberry", "avocado", "broccoli", "lollipop", "chicken", "sandwich", "zucchini", "watermelon", "spaghetti", "oatmeal", "pineapple", "asparagus", "chocolate", "guacamole", "hummus", "lasagna", "pancakes", "spinach", "pepperoni", "waffles", };
        strRandomWord = arrFood[(int) (Math.random() * 22)];
      }
      if (con.currentMouseButton() == 1 && con.currentMouseX() >= 425 && con.currentMouseX() <= 600 && con.currentMouseY() >= 328 && con.currentMouseY() <= 368) {
        String[] arrCountries = {"argentina", "belgium", "lithuania", "ethiopia", "netherlands", "afghanistan", "singapore", "philippines", "australia", "finland", "england", "ireland", "germany", "colombia", "denmark", "indonesia", "jamaica", "malaysia", "madagascar", "nigeria", "portugal", "switzerland", "thailand", "zimbabwe", "vietnam",};
        strRandomWord = arrCountries[(int) (Math.random() * 25)];
      }
    }
    con.sleep(100);
    //sets up the array of past numbers generated so a different letter is exposed every time they guess wrong also gets the length of the word generated for used later
    int intLength = strRandomWord.length();
    int[] arrPastNums = new int[intLength];
    //creates a new string with all underscores the same length as the random word
    strMysteryWord = strRandomWord.replaceAll("[a-zA-Z]", "_");
    con.println("Enter your Guess");
    //loop that runs the main functions of the game
    for (int intCount = 0; intCount < 6; intCount++) {
      //prints the main UI of the game
      con.setDrawColor(new Color(100,149,237));
      con.fillRect(0, 0, 1024, 576);
      con.setDrawColor(Color.RED);
      con.fillRect(300, 30, 190, 50);
      con.setDrawColor(Color.WHITE);
      con.drawString("Mystery Word", 310, 32);
      con.setDrawFont(GugiGame);
      con.drawString(strMysteryWord, 300, 70);
      con.setDrawFont(GugiLength);
      con.drawString("Word Length: " + intLength, 300, 150);
      con.setDrawFont(GugiMenu);
      //checks how many guesses are left and prints the correct hangman picture
      if(intGuessesLeft == 6) {
        con.drawImage(con.loadImage("Hangman.png"), 700, 20);
      }else if(intGuessesLeft == 5) {
        con.drawImage(con.loadImage("Hangman2.png"), 700, 20);
      }else if(intGuessesLeft == 4) {
        con.drawImage(con.loadImage("Hangman3.png"), 700, 20);
      }else if(intGuessesLeft == 3) {
        con.drawImage(con.loadImage("Hangman4.png"), 700, 20);
      }else if(intGuessesLeft == 2) {
        con.drawImage(con.loadImage("Hangman5.png"), 700, 20);
      }else if(intGuessesLeft == 1) {
        con.drawImage(con.loadImage("Hangman6.png"), 700, 20);
      }
      con.drawString("Guesses Left:" + intGuessesLeft, 700, 300);
      //gets users input of the word they want to guess
      strGuessedWord = con.readLine();
      //checks if they guess the word right if they the console is cleared and the win screen is shown
      if (strGuessedWord.equalsIgnoreCase(strRandomWord)) {
        con.clear();
        con.setDrawColor(new Color(100,149,237));
        con.fillRect(0, 0, 1024, 576);
        con.setDrawColor(Color.RED);
        con.setDrawFont(GugiGame);
        con.drawString("YOU WIN!!!!", 370, 200);
        con.drawString("The Word Was: " + strRandomWord, 330,265);
        con.repaint();
        con.sleep(2000);
        //takes you back to the main menu so you can play again
        Hangman.menu();
      }
      //subtracts a guess everytime the code loops
      intGuessesLeft = intGuessesLeft - 1;
      //generates a random number so the program can expose a random letter for the user
      intRand = (int) (Math.random() * intLength) + 0;
      //turns the array of the past numbers into a list so the program can use .contains to check if the the number generated is the same as one of the past numbers
      List<Integer> intList = new ArrayList<Integer>();
      for (int intCount2 : arrPastNums) {
        intList.add(intCount2);
      }
      //checks if the list of past numbers contains the number generated if it does it will keep generating a new one until it isnt in the list
      while (intList.contains(intRand) && intCount < strRandomWord.length()) {
        intRand = (int) (Math.random() * intLength) + 0;
      }
      //uses substring to take one letter and puts it into the mystery word at the correct place
      strLetter = strRandomWord.substring(intRand,intRand+1);
      strMysteryWord = strMysteryWord.substring(0,intRand) + strLetter + strMysteryWord.substring(intRand+1,intLength);
      //adds the random number to the array
      arrPastNums[intCount] = intRand;
    }
    //once the user runs out of guesses the loop will exit and the losing screen will show
    con.clear();
    con.setDrawColor(new Color(100,149,237));
    con.fillRect(0, 0, 1024, 576);
    con.setDrawColor(Color.RED);
    con.setDrawFont(GugiGame);
    con.drawString("YOU LOSE!!!!", 370, 200);
    con.drawString("The Word Was: " + strRandomWord, 330,265);
    con.repaint();
    con.sleep(2000);
    //the game then takes you back to the menu so you can try again
    Hangman.menu();
  }
}
