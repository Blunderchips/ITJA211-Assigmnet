package question3;

/**
 * Write a method called ‘reverse’ that returns an array which is the reverse of
 * the one it receives and then write the main method that uses your ‘reverse’
 * method to print the reverse of the number array below.
 *
 * @author Matthew Van der Bijl - XQ9X3WV31
 */
public class Question3 {

    /**
     * Default constructor.
     */
    public Question3() {
    }

    /**
     * Method that returns an array which is the reverse of the one it receives.
     *
     * @param arr the array to be reversed
     * @return the reversed array
     */
    public int[] reverse(int[] arr) {
        int[] tmp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tmp[arr.length - i - 1] = arr[i];
        }

        return tmp;
    }

    /**
     * The stating point of the program.
     *
     * @param args arguments from the command line
     */
    public static void main(String[] args) {
        // input
        int[] numbers = {34, 78, 2, 4, 5};
        Question3 obj = new Question3();

        // procesing
        int[] reverse = obj.reverse(numbers);

        // output
        for (int i = 0; i < reverse.length; i++) {
            System.out.println(reverse[i]);
        }
    }
}
