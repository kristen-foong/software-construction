public class School implements Learner{
    public static void main(String[] args) {
        School school = new School();
        Learner person = new Student();
        school.serveCoffee(person); //why is person not compiling?
        school.teach(person);
    }

    public void serveCoffee(Student student){
        student.drinkCoffee();
    }

    public void teach(Learner learner){
        learner.learn();
        learner.drinkCoffee(); //why can't we call this method?
    }
}
