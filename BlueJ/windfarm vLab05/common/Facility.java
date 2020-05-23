package common;

/**
 * The Facility interface
 *
 * @author Yuriel & Mo
 * @date 23.05.2020
 */
public interface Facility
{
    // Static String to hold formatted table header
    static String tableHeader = String.format("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            "Name", "Country", "Capacity", "No. of Turbines", "Year commissioned",
            "Construction Start", "Planned Connection", "Land Size");;
    // Static integer to hold table width
    static int tableWidth = tableHeader.length() - 1;
    
    public static void printHeader(String tableTitle) {
        straightLine();
        printCentred(tableTitle);
        dashedLine();
        
        System.out.print(tableHeader);
        dashedLine();
    }
    
    public static void dashedLine() {
        for(int i = 0; i < tableWidth; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");
    }
    
    public static void straightLine() {
        for(int i = 0; i < tableWidth; i++) {
            System.out.printf("_");
        }
        System.out.printf("\n");
    }
    
    private static void printCentred(String str) {
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
    
    // Abstract methods called in the WindFarmTable class
    void print();
    double getCapacity();
}