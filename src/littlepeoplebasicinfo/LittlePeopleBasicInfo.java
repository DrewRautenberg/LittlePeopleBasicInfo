/* PROJECT:  LittlePeopleBasicInfo
 * AUTHOR:   Drew Rautenberg        DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  This project sets up 4 parallel arrays for the data to be read
 *      into from a file, LittlePeopleData.csv.  It then prints out a nicely
 *      aligned "report" (in Console window) showing all the data.  It also
 *      prints:
 *          - a TOTAL salary line
 *          - a line containing oldest and youngest
 *      ages at the bottom.
 * INPUT:  LittlePeopleData.csv
 * OUTPUT:  report goes to Console window
 * IMPORTANT NOTE:  Unlike the previous LittlePeople project which
 *          1) wrote the report file and
 *          2) calculated the stats and printed them out
 *      FROM the input FILE AS A DATA STREAM. . .
 *      But this CURRENT PROJECT MUST:
 *          1st) read the input data from the FILE into the ARRAYS
 *                  (WITHOUT writing the report or calculating the stats)
 *          2nd) use the data from the ARRAYS, to
 *                  1) write the report file and
 *                  2) calculate the stats (and print them out).
 *      WHY?  To get practice filling and using arrays.  In practical terms, it
 *          really would be more efficient (in terms of time and space) to
 *          handle the data directly from an input stream for this task.
 *****************************************************************************/
package littlepeoplebasicinfo;

import java.io.*;
import java.util.Scanner;

public class LittlePeopleBasicInfo {

    public static void main(String[] args) throws IOException {

        //OPEN FILE
        File theFile = new File("LittlePeopleData.csv");
        Scanner inputFile = new Scanner(theFile);
        //DECLARE 4 PARALLEL ARRAYS
        String names[] = new String[7];
        String pictures[] = new String[7];
        int ages[] = new int[7];
        double incomes[] = new double[7];

        //VARIABLES FOR SPLITTING A LINE
        String oneLine;
        String[] field;
        String name;
        String picture;
        int age;
        double income;

        //calculation variables
        double totalIncome = 0;
        int tempMaxAge = Integer.MIN_VALUE;
        int tempMinAge = Integer.MAX_VALUE;

        //READ FILE DATA & STORE IT IN 4 ARRAYS
        for (int i = 0; i < names.length; i++) {
            oneLine = inputFile.nextLine();
            field = oneLine.split(",");
            name = field[0];
            picture = field[1];
            age = Integer.parseInt(field[2]);
            income = Double.parseDouble(field[3]);

            names[i] = name;
            pictures[i] = picture;
            ages[i] = age;
            incomes[i] = income;
        }

        //System.out.println(names[0]);
        //System.out.println(pictures[0]);
        //System.out.println(ages[0]);
        //System.out.println(incomes[0]);

        inputFile.close();
        //FIND TOTAL SALARY
        for (int i = 0; i < names.length; i++) {
            totalIncome += incomes[i];
        }

        //find oldest
        for (int i = 0; i < names.length; i++) {
            if (ages[i] > tempMaxAge) {
                tempMaxAge = ages[i];
            }
        }

        //find youngest
        for (int i = 0; i < names.length; i++) {
            if (ages[i] < tempMinAge) {
                tempMinAge = ages[i];
            }
        }
        //WRITE REPORT TO CONSOLE

        // COLUMN HEADER LINE:
        System.out.printf("NAME     AGE   PIC        SALARY\n");

        // DETAIL LINES:  use the parallel arrays as streams
        //                (using one of the array's length, not a hardcoded 7).
        //      Here's a format string for printf  "%-7s  %3d   %-5s %,10.2f\n"
        //              to use with name, age, pic, salary (in that order).

        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-7s  %3d   %-5s $%,10.2f\n", names[i], ages[i], pictures[i], incomes[i]);
        }
        // ENDING LINES
        System.out.printf("\n%-7s  %3s  %-5s  $%,10.2f\n", "TOTAL", "", "", totalIncome);
        System.out.printf("\nAGE RANGE is from %d to %d\n", tempMinAge, tempMaxAge);
    }
}