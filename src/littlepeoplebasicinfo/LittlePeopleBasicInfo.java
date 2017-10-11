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

        //----------------------------------------------------------- OPEN FILE
        File theFile = new File("LittlePeopleData.csv");
        Scanner inputFile = new Scanner(theFile);
        //------------------------------------------- DECLARE 4 PARALLEL ARRAYS



        //-------------------------------------- VARIABLES FOR SPLITTING A LINE
        String oneLine;
        String[] field = new String[4];
        String name;
        String picture;
        int age;
        double income;
        //*************************************************** 1) READ FILE DATA
        //                                               & STORE IT IN 4 ARRAYS
        // HELP:  Algorithm for ONE record (long version)
        //      - read in one csv line
        //      - split it into fields
        //      - move each field to the appropriately named data variable
        //              (converting to the numeric fields as needed)
        //      - store those 4 data variables into appropriate array location
        //              based on current index value
        //     When that works, put a loop around the code to read/store the
        //          whole file of data.







        //---------------------------------------------------------- CLOSE FILE
        inputFile.close();
        //*************************************************** 2) USE ARRAY DATA
        //                                                 FOR PROCESSING BELOW
        //--------------------------------------------------- FIND TOTAL SALARY





        //----------------------------------------- FIND OLDEST & YOUNGEST AGES






        //********************************************* WRITE REPORT TO CONSOLE
        // COLUMN HEADER LINE:
        System.out.printf("NAME     AGE   PIC       SALARY\n");

        // DETAIL LINES:  use the parallel arrays as streams
        //                (using one of the array's length, not a hardcoded 7).
        //      Here's a format string for printf  "%-7s  %3d   %-5s %,10.2f\n"
        //              to use with name, age, pic, salary (in that order).










        // ENDING LINES
//        System.out.printf("\n%-7s  %3s  %-5s  %,10.2f\n",
//                "TOTAL", "", "", total);
//        System.out.printf("\nAGE RANGE is from %d to %d\n",tempMin, tempMax);
    }
}