public class Main {
    static int[] array;
    public static void main(String[] args) throws InterruptedException {

        int numThreads = Integer.parseInt(args[0]); // int numThreads = 30000;
        int numBins = Integer.parseInt(args[1]);    // int numBins = 20;
        /**
        * When arguments aren't used, my code runs correctly. I couldn't solve "Error: Unable to access jarfile GaltonBoard.jar"
        ***/
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
