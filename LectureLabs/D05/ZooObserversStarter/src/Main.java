public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("BC Zoo");
        EmailSubscriber ali = new EmailSubscriber("Ali");
        EmailSubscriber elisa = new EmailSubscriber("Elisa");
        EmailSubscriber mike = new EmailSubscriber("Mike");
        Organization animalWelfareOrg = new Organization();
        Animal cecil = new Animal("Cecil the lion");
        Animal zoey = new Animal("Zoey the giraffe");

        //TODO uncomment the next three lines when you have implemented Task 1
        //zoo.addObserver(ali);
        //zoo.addObserver(elisa);
        //zoo.addObserver(mike);

        // TODO uncomment the following line when you have implemented Task 2
        //zoo.addObserver(animalWelfareOrg);

        System.out.println("Welcome to " + zoo.getName() + "\n");
        zoo.addAnimal(cecil);
        System.out.println();
        zoo.addAnimal(zoey);
    }
}
