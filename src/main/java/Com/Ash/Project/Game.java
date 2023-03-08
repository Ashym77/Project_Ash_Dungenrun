package Com.Ash.Project;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

  Scanner sc = new Scanner(System.in);
  Player player = new Player("");

  // When the game starts this happens
  public void startOfGame() {

    System.out.println("What is you name hero");
    player.setName(sc.next());
    System.out.println("Welcome " + player + " here starts your journey ");
    System.out.println("Lots of challanges are ahead of you ");

  }





  //First menu
  public void initialMenu() {
    boolean isPlaying = true;
    String choice;
    String select;

    System.out.println("Main Menu");
    System.out.println("-------------------------");
    System.out.println("1.Play");
    System.out.println("2.Game objectives");
    System.out.println("3.Exit game");
    System.out.println("What  would u like to do ");
    System.out.println("---------------------------");


    choice = sc.next();
    do {

      switch (choice) {

        case "1":
          select = "1. Play";
          playerCombatAction();  // activating the fight menu
          System.out.println("Let us head into the challanges");
          System.out.println("-------------------------------");
          break;
        case "2":
          select = "2. Game objectives";
          System.out.println("Hello "+Col.GREEN+player+Col.RESET+ " Your objective is to defeat foe´s such as " +
                  "Diablo and Warden. \n in order to do so you have to grind the lower mobs such as imp infernal" +
                  " and Butcher. \n To gain enought levels and power to defeat the big bad´s.");
          System.out.println("During combat you have options to either fight or run  from battle. " +
                  "\n You can either run from start of the fight aka if monster is to strong " +
                  "then new random monster will appear" +
                  "\n or can u choice to fight the encounter and get heavely wounded you can either fight to death." +
                  "\n or run and rest restore hp to full ");
          System.out.println(" Monsters maximum damage is basedage + strenght");
          System.out.println(" Player maxmimum damage is strengt + level+ agility/2.");
          System.out.println("----------------------------------------------------------");

          System.out.println("\nEnter 4 to return to Main menu");

          break;
        case "3":
          select = "3. Exist game";
          System.out.println("maybe another time then");
          System.out.println("press 3 to end game");
          System.out.println("Press 4 if u wish to return to Main menu");

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
  public void playerCombatAction() {

    Random rand = new Random();
    String  pick;
    boolean isGaming = true;


    //Creating  array list type of monster
    List<Monster> monsterList = new ArrayList<>();

    //adding monsters to the monsterlist
    //read in game objective in game to understand the reason of all the mobs and what to do
    monsterList.add(new Butcher("Butcher", 100, 9, 9, 20));
    monsterList.add(new Infernal("Infernal", 75, 7, 7, 20));
    monsterList.add(new Imp("Imp", 55, 5, 5, 20));
    monsterList.add(new Diablo("Diablo", 325, 20, 20, 20));
    monsterList.add(new Warden("Warden", 400, 30, 20, 20));


    do {

      System.out.println("-----------------------------------------------");
      Monster monster = monsterList.get(rand.nextInt(monsterList.size())); //Generating random monster trought monsterlist
      System.out.println("\t" + monster.getName() + " appeared! \n");
      System.out.println("\t  Stats for " + monster);
      System.out.println("------------------------------------------------");


      while (monster.getMonsterMaxHp() > 0) {
        System.out.println("\t" + Col.GREEN + player + Col.RESET + " HP: " + player.getHp());
        System.out.println("\t" + Col.PURPLE + monster.getName() + Col.RESET + " HP: " + monster.getMonsterMaxHp());
        System.out.println("\n\tYou would like to");
        System.out.println("\t1. Attack the enemy.");
        System.out.println("\t2. Run from the enemy");
        System.out.print("\tEnter Your choice: ");

        pick = sc.next();


        if (pick.equals("1")) {
          int damageDealt = rand.nextInt(1, player.fight());
          if (damageDealt == player.getIntelligence())  {
            monster.setMonsterMaxHp(monster.getMonsterMaxHp() - damageDealt);
            System.out.println(
                    "\n\t>" + Col.GREEN + player.getName() + Col.RESET + Col.RED +
                            " Critical hit  " + Col.RESET + monster.getName() +
                            " for " + Col.RED + damageDealt * 2 + Col.RESET + " Damage ");


          } else {
            System.out.println("\n\t> " + Col.GREEN + player + Col.RESET + " " +
                    "strike the " + monster.getName() + " for " + damageDealt + " damage.");
          }
          int damageTaken = rand.nextInt(1, monster.fight());


          System.out.println(
                  "\t> " + Col.GREEN + player + Col.RESET + " receives " + damageTaken +
                          " damage in retaliation from " + monster.getName() + "");


          monster.setMonsterMaxHp(monster.getMonsterMaxHp() - damageDealt);
            player.setHp(player.getHp() - damageTaken);


          if (player.getHp() < 1) {
            System.out.println(
                    "\n\t> " + Col.GREEN + player + Col.RESET + " has taken too much damage,"
                            + Col.GREEN + player + Col.RESET +
                            " is too weak to go on!");
            System.out.println("\t> " + Col.GREEN + player + Col.RESET + " limp out of the dungeon, weak from battle.");
            System.out.println("\t*------------------------------*");
            System.out.println("\t*-Your deeds and valor will be rememberd " + Col.GREEN + player + Col.RESET + "!-*");
            System.out.println("\t*------------------------------*");
            isGaming = false;


            break;

          }
        }
        // if monster is to strong  u can flee and regain hp to live another day if u wish to
        if (pick.equals("2")) {

          System.out.println("\n\t" + Col.GREEN + player + Col.RESET + " ran away from the " + monster.getName() + "!");
          System.out.println("\t" + monster.getName() + " was to strong");
          player.setHp(100);
          System.out.println("\tYou rested while fleeing from battle" + player.getHp());
          playerCombatAction(); //  to continue the game
        }
      }

      if (monster.getMonsterMaxHp() <= 0)
      {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\t" + monster.getName() + " was defeated by " + Col.GREEN + player + ".");
        System.out.println("\t" + Col.GREEN + player + Col.RESET + " has " + Col.YELLOW + player.getHp() + Col.RESET
                + " HP's left.");
        System.out.println("\t" + Col.GREEN + player + Col.RESET + " Gained "
                + monster.getExp() + "xp  from " + monster.getName());
        player.setExp(player.getExp() + monster.getExp());
        System.out.println("\t"
                + Col.GREEN + player + Col.RESET + " has " + Col.YELLOW + player.getHp() + Col.RESET +
                " HP's left." + " current xp " + player.getExp());

        if (player.getExp() >= 40) {

          player.playerLevelUpp();

        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\n\tWhat would you like to do now?");
        System.out.println("\t1. Continue fighting");
        System.out.println("\t2. Get status");
        System.out.println("\t3. Exit dungeon");

        System.out.print("\tEnter Your Choice: ");

        pick = sc.next();

        while (!(pick.equals("1")) && !(pick.equals("2")) && !(pick.equals("3"))) {
          System.out.println("\tInvalid command");
          System.out.print("\tEnter Your Choice: ");
          pick = sc.next();
        }


        if (pick.equals("1")) {
          System.out.println("\n\t" + Col.GREEN + player + Col.RESET + " continued his adventure!");
          playerCombatAction();
          break;


        } else if (pick.equals("2")) {

          player.playerStatus();
          playerCombatAction();
          break;

        } else if (pick.equals("3")) {


          System.out.println("\n\t" + Col.PURPLE + player + Col.RESET + " exit the dungeon.");


          break;
        }

        System.out.println("press 3 for quiting game");
        int select = sc.nextInt();
        if (select == 3) {
          isGaming = false;
        }


      }

    } while (isGaming);
    System.out.println("\t*------------------------------*");
    System.out.println("\t*-Thanks you for playing " + Col.GREEN + player + Col.RESET + "!-*");
    System.out.println("\t*------------------------------*");
    System.exit(0);


  }
// this method is created to aid whit the Junit test player can be deafeated
// and is not part of the game
  public boolean gameOver() {

    boolean isGaming=true;
    player.setName("Ash");
    player.setHp(0);

     if (player.getHp() < 1) {
       System.out.println(
               "\n\t> " + Col.GREEN + player + Col.RESET + " has taken too much damage,"
                       + Col.GREEN + player + Col.RESET +
                       " is too weak to go on!");
       System.out.println("\t> " + Col.GREEN + player + Col.RESET + " limp out of the dungeon, weak from battle.");
       System.out.println("\t*------------------------------*");
       System.out.println("\t*-Your deeds and valor will be rememberd " + Col.GREEN + player + Col.RESET + "!-*");
       System.out.println("\t*------------------------------*");

       System.out.println("\t*------------------------------*");
       System.out.println("\t*-Thanks you for playing " + Col.GREEN + player + Col.RESET + "!-*");
       System.out.println("\t*------------------------------*");


       isGaming=false;
     }else {

       System.out.println("you are alive");
     }

   return isGaming;
  }

  }
















