public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    
    private static String species = "Rare Pepe";
    final static private double DEFAULT_AGE = 0.45;
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

        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        }
        else {
            this.isFroglet = false;
        }
    }

    public String getSpecies() {
        return Frog.species;
    }

    public void setSpecies(String species) {
        Frog.species = species;
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
        if (this.age > 1 && this.age < 7) {
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
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
        return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
    }

    public static void main(String[] args) {
        System.out.println("");
        Frog frank = new Frog("frank");
        Frog forrest = new Frog("forrest", 10.32, 5.32);
        System.out.println("TEST: toString");
        System.out.println(frank.toString());
        System.out.println(forrest.toString());

        System.out.println("");
        System.out.println("TEST: getter/setter for species sets for all instances.");
        System.out.println(frank.getSpecies());
        System.out.println(forrest.getSpecies());
        frank.setSpecies("Frogerinno");
        System.out.println(frank.getSpecies());
        System.out.println(forrest.getSpecies());

        System.out.println("");
        System.out.println("TEST: #grow with parameters");
        Frog fred = new Frog("fred", 0, 0);
        System.out.println(fred.toString());
        fred.grow(29);
        System.out.println("Should be a 29 month old frog with 11 tongueSpeed.");
        System.out.println(fred.toString());
        System.out.println("Should be a 33 month old frog with 7 tongueSpeed.");
        fred.grow(4);
        System.out.println(fred.toString());
        System.out.println("Should be a 50 month old frog with 5 tongueSpeed.");
        fred.grow(17);
        System.out.println(fred.toString());

        System.out.println("");
        System.out.println("TEST: #grow without parameters");
        Frog fanny = new Frog("fanny", 0, 0);
        System.out.println(fanny.toString());
        System.out.println("Should be a 1 month old froglet with 1 tongueSpeed.");
        fanny.grow();
        System.out.println(fanny.toString());

        System.out.println("");
        System.out.println("TEST: #eat fly it cannot catch");
        System.out.println("Should not catch a fly that has greater speed than the tongueSpeed of the frog");
        Frog franz = new Frog("franz", 0, 0);
        Fly gerry = new Fly(10, 10);
        franz.eat(gerry);
        System.out.println("Fly should have mass of 11 and speed of 11");
        System.out.println(gerry.toString());

        System.out.println("");
        System.out.println("TEST: #eat fly it can catch");
        System.out.println("Should catch a fly that has lesser speed than the tongueSpeed of the frog");
        Frog fung = new Frog("fung", 20, 20);
        Fly gary = new Fly(1, 10);
        System.out.printf("Frog: %s\n", fung.toString());
        System.out.printf("Fly: %s\n", gary.toString());
        fung.eat(gary);
        System.out.println("Fly should have mass of 0 and speed of 10");
        System.out.printf("Fly: %s\n", gary.toString());
        System.out.println("Frog should have same age/speed as above.");
        System.out.printf("Frog: %s\n", fung.toString());
        Fly gunther = new Fly(800, 10);
        fung.eat(gunther);
        System.out.println("Fly should have mass of 0 and speed of 10");
        System.out.printf("Fly: %s\n", gary.toString());
        System.out.println("Frog should be 241 months old and have a tongueSpeed of 19.");
        System.out.printf("Frog: %s\n", fung.toString());
    }
}