public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    
    private String species = "Rare Pepe";
    final static private int DEFAULT_AGE = 5;
    final static private double DEFAULT_TONGUE_SPEED = 5.0;

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
    }

    public Frog(String name, double ageInYears) {
        this(name, ageInYears, DEFAULT_TONGUE_SPEED);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this.name = name;
        this.age = (int) (ageInYears * 12);
        this.tongueSpeed = tongueSpeed;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void grow(int months) {
        for (int month = 0; month < months; month++) {
            this.age++;
            if (this.age < 12) {
                this.tongueSpeed++;
            }
            else if (this.age >= 30 && this.tongueSpeed > 5) {
                this.tongueSpeed--;
            }
        }
        if (this.age >= 1 || this.age < 7) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public void grow() {
        this.age++;
        if (this.age < 12) {
            this.tongueSpeed++;
        }
        else if (this.age >= 30 && this.tongueSpeed > 5) {
            this.tongueSpeed--;
        }

        if (this.age >= 1 || this.age < 7) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        if (this.tongueSpeed > fly.getSpeed()) {
            if ((fly.getMass() * 0.5) >= this.age) {
                this.grow();
            }
            fly.setMass(0);
        }
        else {
            fly.grow(1);
        }
    }

    public String toString() {
        if (this.isFroglet) {
            return String.format("My name is %s and I'm a rare froglet! I'm %n months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
        return String.format("My name is %s and I'm a rare frog. I'm %n months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
    }

    public static void main(String[] args) {
    }
}