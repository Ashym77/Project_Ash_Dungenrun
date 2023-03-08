package Com.Ash.Project;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gamebuildupp {

  Scanner sc = new Scanner(System.in);
  Player player = new Player("");

  // When the game starts
  public void startOfGame() {

    System.out.println("What is you name hero");
    player.setName(sc.next());
    System.out.println("Welcome " + player + " here starts your journey ");
    System.out.println("Lots of challanges are ahead of you ");

  }

  // activating  gaming logic Menu
  public void playerCombat() {
   theGame();
  }

  //First menu
  public void initialMenu() {
    boolean isPlaying = true;
    String choice;
    String select;

    System.out.println("Menu");
    System.out.println("-------------------------");
    System.out.println("1.Play");
    System.out.println("2.Check Status");
    System.out.println("3.Exit game");
    System.out.println("What  would u like to do ");
    System.out.println("--------------------------");


    choice = sc.next();
    do {

      switch (choice) {

        case "1":
          select = "1. Play";
          playerCombat();
          System.out.println("Let us head into the challanges");
          System.out.println("-------------------------------");
          break;
        case "2":
          select = "2. Check status";
          player.playerStatus();
          System.out.println("Enter 4 to return to Mainmenu");

          break;
        case "3":
          select = "3. Exist game";
          System.out.println("maybe another time then");
          System.out.println("press 3 to end game");

          break;

        default:
          select = "4 Return to main menu";
          initialMenu();
          isPlaying = false;

      }
      System.out.println("You selected " + select);

      int play = sc.nextInt();

      if (play == 4) {
        isPlaying = false;
        initialMenu();
      }
      if (play == 3) {
        isPlaying = false;
      }

    } while (isPlaying);
  }



// the game logic
  public void theGame() {

    Random rand = new Random();

    int choice;
    boolean isGaming = true;


    //Creating  array list type of monster
    List<Monster>monsterList=new ArrayList<>();

    //adding monsters to the monsterlist
    monsterList.add(new Butcher("Butcher",100,9,9,20));
    monsterList.add(new Infernal("Infernal",75,7,7,20));
    monsterList.add(new Imp("Imp",55,5,5,20));
    monsterList.add(new Diablo("Diablo",400,20,20,40));


    do {

      System.out.println("-----------------------------------------------");
      Monster monster=monsterList.get(rand.nextInt(monsterList.size())); //Generating random monster trought monsterlist
      System.out.println("\t" + monster.getName() + " appeared! \n");
      System.out.println("\t  Stats for " +monster );
      System.out.println("------------------------------------------------");


      while (monster.getMonsterMaxHp() > 0) {
        System.out.println("\t" + player + "'s HP: " + player.getHp());
        System.out.println("\t" + monster.getName() + "'s HP: " + monster.getMonsterMaxHp());
        System.out.println("\n\tYou would like to");
        System.out.println("\t1. Attack the enemy.");
        System.out.println("\t2. Run from the enemy");
        System.out.print("\tEnter Your choice: ");

        choice = sc.nextInt();


        if (choice == 1) {
          int damageDealt = rand.nextInt(1, player.fight());
          if (damageDealt == player.getIntelligence()) {
            monster.setMonsterMaxHp(monster.getMonsterMaxHp() - damageDealt);
            System.out.println(
                    "\n\t>" + player.getName() + " Critical hit monster " + monster.getName() +
                            "for " + damageDealt * 2 + " Damage ");


          } else {
            System.out.println("\n\t> " + player + " strike the " + monster.getName() + " for " + damageDealt + " damage.");
          }
          int damageTaken = rand.nextInt(1, monster.fight());


          System.out.println(
                  "\t> " + player + " receives " + damageTaken + " damage in retaliation from " + monster.getName() + "");


          monster.setMonsterMaxHp(monster.getMonsterMaxHp() - damageDealt);
          player.setHp(player.getHp() - damageTaken);


          if (player.getHp() <= 0) {
            System.out.println(
                    "\n\t> " + player + " has taken too much damage," + player + " is too weak to go on!");
            System.out.println("\t> " + player + " limp out of the dungeon, weak from battle.");
            System.out.println("\t*------------------------------*");
            System.out.println("\t*-Your deeds and valor will be rememberd " + player + "!-*");
            System.out.println("\t*------------------------------*");
            isGaming = false;


            break;

          }
        }
        // if monster is to strong  u can flee and regain hp to live another day if u wish to
        if (choice == 2) {
          System.out.println("\n\t" + player + " ran away from the " + monster.getName() + "!");
          System.out.println("\t" + monster.getName() + " was to strong");
          player.setHp(100);
          System.out.println("\tYou rested while fleeing from battle" + player.getHp());
          playerCombat(); //  to continue the game

        }
      }

        if (monster.getMonsterMaxHp() <= 0) {
          System.out.println("--------------------------------------------------------------------------");
          System.out.println("\t" + monster.getName() + " was defeated by " + player + ".");
          System.out.println("\t" + player + " has " + player.getHp() + " HP's left.");
          System.out.println("\t" + player + " Gained " + monster.getExp() + "xp  from " + monster.getName());
          player.setExp(player.getExp() + monster.getExp());
          System.out.println("\t"
                  + player + " has " + player.getHp() + " HP's left." + " current xp " + player.getExp());

          if (player.getExp() == 40) {

            player.playerLevelUpp();

          }

          System.out.println("--------------------------------------------------------------------------");
          System.out.println("\n\tWhat would you like to do now?");
          System.out.println("\t1. Continue fighting");
          System.out.println("\t2. Get status");
          System.out.println("\t3. Exit dungeon");

          System.out.print("\tEnter Your Choice: ");

          choice=sc.nextInt();


          if (choice==1) {
            System.out.println("\n\t" + player + " continued his adventure!");
            playerCombat();
            break;


          } else if (choice==2) {

            player.playerStatus();
            return;

          } else if (choice==3) {


            System.out.println("\n\t" + player + " exit the dungeon.");
            isGaming=false;

            break;
          }

          System.out.println("press 3 for quiting game");
          int pick = sc.nextInt();
          if (pick == 3) {
            isGaming = false;
          }


        }

        }while (isGaming) ;
      System.out.println("\t*------------------------------*");
      System.out.println("\t*-Thanks you for playing " + player + "!-*");
      System.out.println("\t*------------------------------*");
      System.exit(0);
    }



    }








