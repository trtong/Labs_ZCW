public class StringUtilities {
   public Character getMiddleCharacter(String word){
        int middleVal = (word.length() / 2);
        return word.charAt(middleVal);
   }
   
   public String removeCharacter(String value, char charToRemove){
     // remove the characters in the string using replace with ""
     
     String newString = value.replace(Character.toString(charToRemove), "");
     
     return newString;  
   }
   
   public String getLastWord(String value) {
       // return the last word of the string
       // use split and return the last word of the array
       String words = "";
       String[] famousLastWords = value.split(" ");
       
       return famousLastWords[famousLastWords.length -1];
   }
}
