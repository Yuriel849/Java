package common;

/**
 * The Facility interface
 *
 * @author Yuriel & Mo
 * @date 01.06.2020
 */
public interface Facility
{
    // Static String to hold formatted table header
    public static String tableHeader = String.format("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            "Name", "Country", "Capacity", "No. of Turbines", "Year commissioned", "Construction Start", "Planned Connection", "Land Size");;
    // Static integer to hold table width
    public static int tableWidth = tableHeader.length() - 1;
    
    /**
     * Print the header of the table.
     * 
     * @param tableTitle The title of the table.
     */
    public static void printHeader(String tableTitle) {
        dashedLine();
        printCentred(tableTitle);
        dashedLine();
        
        System.out.print(tableHeader);
        dashedLine();
    }
    
    /**
     * Print a horizontal dashed line ("-") the width of the table.
     */
    public static void dashedLine() {
        for(int i = 0; i < tableWidth; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");
    }
    
    /**
     * Print the information 
     */
    public static void printCentred(String str) {
        int left = ((tableWidth-4) - str.length()) / 2;
        int right = (tableWidth-4) - left - str.length();
        String repeatedChar = " ";
        StringBuffer buff = new StringBuffer();
        
        buff.append("|");
        for (int i = 0; i < left; i++) {
            buff.append(repeatedChar);
        }
        buff.append("<");
        buff.append(str);
        buff.append(">");
        
        for (int i = 0; i < right; i++) {
            buff.append(repeatedChar);
        }
        buff.append("|");
       
        System.out.println(buff.toString());
    }
    
    // Abstract methods implemented in the Facility class and its subclasses
    public void print();
    public double getCapacity();
}