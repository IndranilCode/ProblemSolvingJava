package main.tutorial.AdvancedDSA.M6_BinarySearch;

public class Day55_SortingSearchingFollowUp {
    public void execute() {
        //CW1 > Nth Magical number of a,b
        System.out.println("CW1 > Nth Magical number of a,b [ a = 2, b = 3, n = 8 ] => " + this.nThMagicalNumberOfAB(2, 3, 8));
    }

    //NEED TA HELP

    /**
     * CW1 > Nth Magical number of a,b
     * Magical number = Nth multiple of a OR b
     * Eg: 8th multiple of 2, 3
     * 2 => 2, 4, 6, 8, 10, 12, 14 ...
     * 3 => 3, 6, 9, 12, 15, 18 ...
     * multiple of 2 OR 3 => 2, 3, 4, 6, 8, 9, 10, 12, 14, 15, 18... => 8th multiple = 12
     * @param a
     * @param b
     * @param n
     * @return
     */
    private int nThMagicalNumberOfAB(int a, int b, int n) {
        //is x nth multiple = x/a + x/b - x/LCM(a,b)
        int low = Math.min(a, b);
        int high = low * n;

        int answer = 0;
        int mid;
        double currentValNMid;

        while (low < high) {
            mid = (low + high) / 2;
            currentValNMid = ((double)mid / (double)a) + ((double) mid / (double) b) - ((double) mid / (double) lcm(a, b));
            if (currentValNMid > (double) n) {
                //go left
                high = mid - 1;
            } else if (currentValNMid < (double) n) {
                //go right
                low = mid + 1;
            } else {
                //Possible answer => go left for better answer
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    public int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

}
