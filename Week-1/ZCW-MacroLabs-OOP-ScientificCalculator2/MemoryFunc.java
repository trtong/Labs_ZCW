
/**

 */
public class MemoryFunc {
    public Double memory;
    public Boolean memoryChanged;
    public static final Double DEFAULT_MEMORY_VALUE = new Double(0);

    public MemoryFunc() {
        this.memory = DEFAULT_MEMORY_VALUE;
        this.memoryChanged = false;
    }
    
    /**
     * Menu
     * Clear
     * Print
     * Update
     */
    
    public void memoryMenu() {
        
        Console.println("Memory Menu"
                         + "\n1: M+ - Update stored memory value"
                         + "\n2: MC - Clear to default memory value"
                         + "\n3: MCR - Display stored memory value"
                         + "\n4: Cancel - Returns to Main Menu");
                         
        String memoryOpt = "";
        
        while (!memoryOpt.equals("4")) {
            
            memoryOpt = Console.getStringInput("Select option by typing the key. (ie. 1 for M+)");
            
            if (memoryOpt.equals("1")) {
                
                Double newMemory = Console.getDoubleInput("Enter the value to store");
                this.memory = updateMemory(newMemory);
                this.memoryChanged = true;
                break;
                
            } else if (memoryOpt.equals("2")) {
                
                clearMemory();
                Console.println("Memory cleared.");
                this.memoryChanged = false;
                break;
                
            } else if (memoryOpt.equals("3")) {
                
                Console.println("Stored Value: " + displayMemory());
                break;
                
            } else {
                
                Console.println("Invalid Option");
                
            }
        }
    }
    
    public Double updateMemory(Double memoryInput) {
        return this.memory = memoryInput;
    }
    
    public Double clearMemory() {
        return this.memory = DEFAULT_MEMORY_VALUE;
    }
    
    public Double displayMemory() {
        return this.memory;
    }
    
}
