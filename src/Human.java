import java.util.*;

class Human implements Comparable<Human> {
    String firstName;
    String lastName;
    int age;
    
    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public int compareTo(Human other) {
        int lastNameCompare = this.lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) return lastNameCompare;
        int firstNameCompare = this.firstName.compareTo(other.firstName);
        if (firstNameCompare != 0) return firstNameCompare;
        return Integer.compare(this.age, other.age);
    }
    
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return age == human.age && 
               Objects.equals(firstName, human.firstName) && 
               Objects.equals(lastName, human.lastName);
    }
    
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    public int compare(Human h1, Human h2) {
        return h1.lastName.compareTo(h2.lastName);
    }
}

class HumanTest {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
            new Human("Иван", "Петров", 25),
            new Human("Мария", "Иванова", 30),
            new Human("Алексей", "Сидоров", 20),
            new Human("Иван", "Петров", 25)
        );
        
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);
        
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);
        
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet по фамилии: " + treeSetByLastName);
        
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.age, h2.age);
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet по возрасту: " + treeSetByAge);
    }
}