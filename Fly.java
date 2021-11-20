public class Fly {
    private double mass;
    private double speed;

    private static final double DEFAULT_MASS = 5.0;
    private static final double DEFAULT_SPEED = 10.0;

    public static void main(String[] args) {
        Fly frank = new Fly();
        System.out.println("Default fly values");
        System.out.println(frank.toString());
        System.out.printf("Fly is dead? %b\n", frank.isDead());
        System.out.println("Getters");
        System.out.println(frank.getMass());
        System.out.println(frank.getSpeed());
        System.out.println("Setters");
        System.out.println(frank.getMass());
        System.out.println(frank.getSpeed());
        frank.setMass(9.99);
        frank.setSpeed(20.99);
        System.out.println(frank.getMass());
        System.out.println(frank.getSpeed());


        Fly deadFly = new Fly(0);
        System.out.println("Dead fly");
        System.out.println(deadFly.toString());
        System.out.printf("Fly is dead? %b\n", deadFly.isDead());
        System.out.println("#grow");
        System.out.printf("Default fly stats before: %s\n", frank.toString());
        frank.grow(1);
        System.out.printf("Default fly stats after: %s\n", frank.toString());
        System.out.printf("Dead fly stats before: %s\n", deadFly.toString());
        deadFly.grow(1);
        System.out.printf("Dead fly stats after: %s\n", deadFly.toString());
    }

    public double getMass() {
        return this.mass;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public boolean isDead() {
        return this.mass == 0;
    }

    public void grow(int mass) {
        for (int i = 0; i < mass; i++) {
            this.mass++;
            if (this.mass < 20) {
                this.speed++;
            }
            else {
                this.speed -= 0.5;
            }
        }
    }

    public String toString() {
        if (this.mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f", this.speed);
        }
        return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
    }
}