


import java.util.*;

public class TriangleUtilities {
    /**
     * method getRow uses a for loop to create 1 row of stars with a given
     * number of stars as the parameter (numberOfStars)
     */
    public static String getRow(int numberOfStars) {
        // Use StringBuilder and a loop
        
        StringBuilder stars = new StringBuilder();
        
        for (int i = 0; i < numberOfStars; i++) {
            stars.append("*"); 
        }
        
        return stars.toString();
    }
    
    /**
     * method getTriangle uses a nested for loop to build the triangle of stars 
     * with StringBuilder. 
     * 
     * Since getSmallTriangle and getLargeTriangle are essentially fixed sizes of 
     * the star triangles, I call the getTriangle method with the parameter 
     * "numberOfRows"
     */ 
    public static String getTriangle(int numberOfRows) {
        StringBuilder stars = new StringBuilder();
        
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = i; j > 0; j--) {
                stars.append("*");
            }
            stars.append("\n");
        }
        
        return stars.toString();        
    }

    public static String getSmallTriangle() {
        return getTriangle(4);
        }

    public static String getLargeTriangle() {
        return getTriangle(9);
    }
}
