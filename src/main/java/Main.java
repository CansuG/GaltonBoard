import org.kohsuke.args4j.Option;

public class Main {
    static int[] array;
    public static void main(String[] args) throws InterruptedException {

        int numThreads = Integer.parseInt(args[0]);
        int numBins = Integer.parseInt(args[1]);

        int galtonBoardsThread = 0;

        array = new int[numBins];

        GaltonBoard galtonBoard = new GaltonBoard(numBins);

        for (int i = 0; i < numThreads; i++) {

            Thread thread = new Thread(galtonBoard);
            thread.start();
            thread.join();
        }

        for (int i = 0; i < array.length; i++) {
            galtonBoardsThread += array[i];
            System.out.println((i + 1) + "      " + array[i]);
        }


        System.out.println("Number of requested thread: " + numThreads);
        System.out.println("Sum of bin values : " + galtonBoardsThread);

    }
}
