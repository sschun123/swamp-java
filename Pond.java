public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 0.9, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog foo = new Frog("Foo");

        Fly f1 = new Fly(1, 3);
        Fly f2 = new Fly(6);
        Fly f3 = new Fly();

        foo.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(f2);
        System.out.println(f2.toString());
        peepo.grow(8);
        peepo.eat(f2);
        System.out.println(f2.toString());
        System.out.println(peepo.toString());
        System.out.println(foo.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}