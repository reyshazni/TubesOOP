public class StatsBuff {
    // Atribut
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    // Konstruktor
    public StatsBuff() {
        healtPoint = 0;
        attack = 0;
        defense = 0;
        specialAttack = 0;
        speed = 0;
    }

    // Getter
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    // Setter
    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack){
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense){
        this.specialDefense = specialDefense;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
}   
