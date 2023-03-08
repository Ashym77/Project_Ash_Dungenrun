package Com.Ash.Project;


import Com.Ash.Project.ICombat;

public class Monster implements ICombat {



    private String name;
    private int monsterMaxHp;
    private int basedamage;
    private int strenght;
    private int exp;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasedamage(int basedamage) {
        this.basedamage = basedamage;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public Monster(String name, int monsterMaxHp, int basedamage, int strenght, int exp) {
        this.name = name;
        this.monsterMaxHp = monsterMaxHp;
        this.basedamage = basedamage;
        this.strenght = strenght;
        this.exp = exp;
    }

    public int getMonsterMaxHp() {
        return monsterMaxHp;
    }

    public void setMonsterMaxHp(int monsterMaxHp) {
        this.monsterMaxHp = monsterMaxHp;
    }

    public int getBasedamage() {
        return basedamage;
    }


    public int getStrenght() {
        return strenght;
    }


    @Override
    public int fight() {

        return calCulateDamage();

    }



    public int calCulateDamage() {

        int damage = (getStrenght() + getBasedamage());
        return damage;
    }


    @Override
    public String toString() {
        return
                 name + '\'' +
                ", Hp" + monsterMaxHp +
                ", basedamage=" + basedamage +
                ", strenght=" + strenght +
                ", exp=" + exp
                ;
    }
}







