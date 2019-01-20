import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringUtilitiesTest {

    private StringUtilities utilities;

    @Before
    public void setUp() {
        utilities = new StringUtilities();
    }
    
    @Test
    public void testGetMiddleCharacter_ForOddWord(){
        //Given
        String word = "bokeh";
        char expected = 'k';
        
        //When
        char actual = utilities.getMiddleCharacter(word);
        
        //Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetMiddleCharacter_ForLongOddWord(){
        //Given
        String word = "disinformations";
        char expected = 'r';
        
        //When
        char actual = utilities.getMiddleCharacter(word);
        
        //Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetMiddleCharacter_ForEvenWord(){
        //Given
        String word = "dogs";
        char expected = 'g';
        
        //When
        char actual = utilities.getMiddleCharacter(word);
        
        //Then
        assertEquals(expected, actual);
    }

    
    @Test
    public void testRemoveCharacter(){
        // Given
        String word = "taradiddle";
        String expected = "taraile";
        
        //When
        String actual = utilities.removeCharacter(word, 'd');
        
        //Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRemoveCharacter_atTheEnd(){
        // Given
        String word = "taradiddle";
        String expected = "taradiddl";
        
        //When
        String actual = utilities.removeCharacter(word, 'e');
        
        //Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRemoveCharacter_thatIsNotInTheString(){
        // Given
        String word = "taradiddle";
        String expected = "taradiddle";
        
        //When
        String actual = utilities.removeCharacter(word, 'x');
        
        //Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetLastWord(){
        // Given
        String sentence = "I'm sorry for what I said when I was hungry";
        String expected = "hungry";
        
        // When
        String actual = utilities.getLastWord(sentence);
        
        // Then
        assertEquals(expected, actual);
    }
    
}
