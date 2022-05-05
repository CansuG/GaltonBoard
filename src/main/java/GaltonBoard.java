import java.util.Random;

public class GaltonBoard implements Runnable {

    public int numberOfCell;
    public int theCellBallDrop = getGaltonBoardCell(numberOfCell);

    public GaltonBoard(int numOfCell) {
        this.numberOfCell = numOfCell;
    }

    public synchronized int getGaltonBoardCell(int numberOfCell) {
        int cell = 0;

        Random random = new Random();
        int rand_int = random.nextInt(10);

        for (int i = 0; i < numberOfCell - 1 ; i++) {
            cell += rand_int % 2;
        }

        return cell;
        // Cell is a number between 0 to number of cell. It represents the array cell which the ball will drop.
    }

    @Override
    public void run() {

        synchronized (this){

            Main.array[theCellBallDrop]++;

        }


    }
}
