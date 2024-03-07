import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class ToyRaffle {
    private PriorityQueue<Toys> toys;

    public ToyRaffle() {
         this.toys = new PriorityQueue<>(Comparator.comparingInt(Toys::getWeight).reversed());
        }
    
        public void addToy(Toys toy) {
            toys.add(toy);
        }
       
    public Toys getToy() {
        return toys.poll();
    }

    public static void main(String[] args) {
        ToyRaffle store = new ToyRaffle();
        Toys[] arr1 = new Toys[]{
                new Toys(1, "Doll", 5),
                new Toys(2, "Car", 3),
                new Toys(3, "Bear", 10),
                new Toys(4, "ReailWay", 6)
        };
        Toys[] arr2 = new Toys[]{
                new Toys(5, "BamblBee", 4),
                new Toys(6, "Lego", 8),
                new Toys(7, "Tank", 12),
                new Toys(8, "Solder", 11)
        };
        Toys[] arr3 = new Toys[]{
                new Toys(9, "Tetris", 5),
                new Toys(10, "Doll", 9),
                new Toys(11, "Drum", 2),
                new Toys(12, "Barbie", 7)
        };
        for (int i = 0; i < arr1.length; i++) {
            store.addToy(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            store.addToy(arr2[i]);
        }
        for (int i = 0; i < arr3.length; i++) {
            store.addToy(arr3[i]);
        }
         try (FileWriter writer = new FileWriter("winners.txt")) {
            for (int i = 0; i < 10; i++) {
                Toys toy = store.getToy();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}