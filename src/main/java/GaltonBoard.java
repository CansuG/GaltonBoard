import java.util.Random;

public class GaltonBoard implements Runnable {

    public int numberOfCell;

    public GaltonBoard(int numOfCell) {
        this.numberOfCell = numOfCell;
    }
    @Override
    public void run() {

        synchronized (this){

            int cell = 0;

            Random random = new Random();

            for (int i = 0; i < numberOfCell - 1 ; i++) {
                int rand_int = random.nextInt(10);
                cell += rand_int % 2;
            }

            Main.array[cell]++;

        }


    }
}
