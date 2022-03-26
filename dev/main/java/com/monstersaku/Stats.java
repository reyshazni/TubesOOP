public class Stats {
    // Atribut
    private double healtPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    // Konstruktor
    public Stats() {
        healtPoint = 0.0;
        attack = 0.0;
        defense = 0.0;
        specialAttack = 0.0;
        speed = 0.0;
    }

    // Getter
    public double getHealthPoint() {
        return healtPoint;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpecialAttack() {
        return specialAttack;
    }

    public double getSpecialDefense() {
        return specialDefense;
    }

    public double getSpeed() {
        return speed;
    }

    // Setter
    public void setHealthPoint(double healtPoint){
        this.healtPoint = healtPoint;
    }

    public void setAttack(double attack){
        this.Attack = attack;
    }

    public void setDefense(double defense){
        this.defense = defense;
    }

    public void setSpecialAttack(double specialAttack){
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(double specialDefense){
        this.specialDefense = specialDefense;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
}   
