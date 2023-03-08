package Com.Ash.Project;



public class Player implements ICombat{

    private String name="";

   public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){

return name;
   }

   private int maxhp=100;



    private int level=1;

    private  int strenght=14;
    private   int intelligence=10;
    private int agility=10;


   private int hp=100;
    private int exp=0;

  private int damage=calCulatedamage(getStrenght(),getLevel(), getAgility());


  public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;

    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void playerStatus(){


        System.out.println(" This is you current status" );
        setLevel(level);
        System.out.println("Yor are level  "+Col.PURPLE+getLevel()+Col.RESET);
        setStrenght(strenght);
        System.out.println("Current strenght is "+Col.RED+getStrenght()+Col.RESET);
        setIntelligence(intelligence);
        System.out.println("Current int is "+Col.BLUE+getIntelligence()+Col.RESET);
        setAgility(agility);
        System.out.println("Current Agility is "+Col.GREEN+ getAgility()+Col.RESET);
        setHp(hp);
        System.out.println(" your max health "+ Col.YELLOW+getHp()+Col.RESET);
        setDamage(calCulatedamage(getStrenght(),getLevel(), getAgility()));
        System.out.println("Current damage is " +Col.PURPLE+getDamage()+Col.RESET);
        System.out.println("Current Experience is "+getExp());
        System.out.println("----------------------------------------");
    }
    public int playerLevelUpp(){

        if (getExp()>=40){

            System.out.println("*---------------------------------------*");
            System.out.println("You have gained a level");
            setLevel(getLevel()+1);
            System.out.println("You are now level "+ getLevel());


            System.out.println("\t All your attributes has been increased by 2 " );
            setStrenght(strenght+2);
            System.out.println("\t Strenght increased to "+Col.RED+getStrenght()+Col.RESET);
            setIntelligence(intelligence+2);
            System.out.println("\t Intelligence increased to "+Col.BLUE+ getIntelligence()+Col.RESET);
            setAgility(agility+2);
            System.out.println(" \t Agillity increased to "+Col.GREEN +getAgility()+Col.RESET);
            setDamage(fight());
            System.out.println("\t Your maximum damage output is "+ Col.PURPLE+getDamage()+Col.RESET);
            setHp(100);
            System.out.println("\t Your hp is restored to full "+Col.YELLOW+getHp()+Col.RESET);
            setExp(0);
            System.out.println("\t Your exp is now rested to "+getExp());


        }
        else {
            System.out.println("You still need more exp to level");
        }return level;

    }

    @Override
    public int fight() {

      return calCulatedamage(getStrenght(),getLevel(),getAgility());

    }

   public int calCulatedamage(int strenght, int level,int agility){


        int damage=getStrenght()+getLevel()+getAgility()/2;
                return damage;
    }



}


