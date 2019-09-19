
import java.util.*;

public class ConversionApp {
    
    private Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        ConversionApp instance = new ConversionApp();
        while(true){
            instance.cli();
        }
    }
    
    public String cli(){
        ConversionApp instance = new ConversionApp();
        System.out.println("Please select a conversion (Input the corresponding letter):\n" +
        "A) Int to Binary\n" +
        "B) Binary to Int\n" +    
        "C) Int to Hex\n" +
        "D) Hex to Int\n" +
        "E) Hex to Binary\n" +
        "F) Binary to Hex\n" );
        String conv = in.next();
        if (null != conv)switch (conv) {
            case "A":
                System.out.println(instance.longToBinary(instance.intInput()) + "\n");
                return "passA";
            case "B":
                System.out.println(instance.binaryToLong(instance.binaryInput()) + "\n");
                return "passB";
            case "C":
                System.out.println(instance.longToHex(instance.intInput()) + "\n");
                return "passC";
            case "D":
                System.out.println(instance.hexToLong(instance.hexInput()) + "\n");
                return "passD";
            case "E":
                System.out.println(instance.hexToBinary(instance.hexInput()) + "\n");
                return "passA";
            case "F":
                System.out.println(instance.binaryToHex(instance.binaryInput()) + "\n");
                return "passA";
            default:
                System.out.println("Invalid selection");
                return "failX";
        }
        return "";
    }
    
    public String longToBinary(long conv){
        String x = "";
        while(conv > 0)
        {
            long a = conv % 2;
            x = a + x;
            conv = conv / 2;
        }
        if ("".equals(x)){
            return "0";
        }
        return x;
    }
    
    public long binaryToLong(String conv){
        long decimalNumber = 0, j = 1, remainder;
        long x = Long.parseLong(conv);
        while (x != 0) 
        {
        remainder = x % 10;
        decimalNumber = decimalNumber + remainder * j;
        j = j * 2;
        x = x / 10;
        }
        return decimalNumber;
    }
    
    public String longToHex(long conv){
        return Long.toHexString(conv);
    }
    
    public long hexToLong(String conv){
        return Long.parseLong(conv,16);
    }
    
    public String hexToBinary(String conv){
        return longToBinary(hexToLong(conv));
    }
    
    public String binaryToHex(String conv) {
        return longToHex(binaryToLong(conv));
    }
    
    public long intInput() {
        System.out.println("Enter an integer value from 0 to 524287, inclusive");
        try{
            String value = in.next();
            if(Integer.parseInt(value) > 524287 || Integer.parseInt(value) < 0){
                System.out.println("Invalid input. Please follow given parameters for input");
                return 0;
            }
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a positive integer value within the given parameters");
        }
        return 0;
    }
    
    public String binaryInput()  {
        System.out.println("Enter an binary value from 0 to 1111111111111111111, inclusive");
        String value = in.next();
        if(Long.parseLong(value) > Long.parseLong("1111111111111111111") || Long.parseLong(value) < 0){
            System.out.println("Invalid input. Please follow given parameters for input");
            return "0";
        }
        for(int i = 0; i < value.length(); i++ ){
            if(!"1".equals(value.substring(i, i+1)) && !"0".equals(value.substring(i, i+1))){
            System.out.println("Invalid input. Please enter a binary value");
            return "0";
            }
        }
        return value;
    }
    
     public String hexInput() {
        System.out.println("Enter an hexedecimal value from 0 to 7ffff, inclusive");
        Character[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        ArrayList<Character> hexs = new ArrayList<>(Arrays.asList(hex));
        String value = in.next();
        for(int i = 0; i < value.length(); i++ ){
            if(!(hexs.contains(value.charAt(i)))){
                System.out.println("Invalid input. Please enter a hexedecimal value");
                return "0";
            }
        }
        if(Long.parseLong(value, 16) > 524287 || Long.parseLong(value, 16) < 0){
            System.out.println("Invalid input. Please follow given parameters for input");
            return "0";
        }
        return String.valueOf(value);
    }
     
     public String cliShell() {
        System.out.println("Please select a conversion (Input the corresponding letter):\n" +
        "A) Int to Binary\n" +
        "B) Binary to Int\n" +    
        "C) Int to Hex\n" +
        "D) Hex to Int\n" +
        "E) Hex to Binary\n" +
        "F) Binary to Hex\n" );
        Scanner c = new Scanner(System.in);
        String conv = c.next();
        if (null != conv)switch (conv) {
            case "A":
                return "passA";
            case "B":
                return "passB";
            case "C":
                return "passC";
            case "D":
                return "passD";
            case "E":
                return "passE";
            case "F":
                return "passF";
            default:
                return "failX";
        }
        return "";
    }
}

