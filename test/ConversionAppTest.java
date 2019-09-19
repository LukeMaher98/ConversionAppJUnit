import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ConversionAppTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCLIshell(){
        String[] in = {"A","B","C","D","E","F","X"};
        String[] exp = {"passA","passB","passC","passD","passE","passF","failX"};
        String[] res = new String[7];
        ConversionApp instance = new ConversionApp();
        for(int i = 0; i < 7; i++){
            String input = in[i];
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            res[i] = instance.cliShell();
        }
        assertArrayEquals(exp, res);
    }

    @Test
    public void testLongToBinary() {
        long[] nums = {524287, 1, 0};
        String[] exp = {"1111111111111111111", "1", "0"};
        String[] res = new String[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < nums.length; i++){
            res[i] = instance.longToBinary(nums[i]);
        }
        assertArrayEquals(exp, res);
    }

    @Test
    public void testBinaryToLong() {
        String[] bins = {"1111111111111111111", "1", "0"};
        long[] exp = {524287, 1, 0};
        long[] res = new long[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < bins.length; i++){
            res[i] = instance.binaryToLong(bins[i]);
        }
        assertArrayEquals(exp, res);
    }

    @Test
    public void testLongToHex() {
        long[] nums = {524287, 1, 0};
        String[] exp = {"7ffff", "1", "0"};
        String[] res = new String[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < nums.length; i++){
            res[i] = instance.longToHex(nums[i]);
        }
        assertArrayEquals(exp, res);
    }
    
    @Test
    public void testHexToLong() {
        String[] hexs = {"7ffff", "1", "0"};
        long[] exp = {524287, 1, 0};
        long[] res = new long[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < hexs.length; i++){
            res[i] = instance.hexToLong(hexs[i]);
        }
        assertArrayEquals(exp, res);
    }
    
    @Test
    public void testHexToBinary() {
        String[] hexs = {"7ffff", "1", "0"};
        String[] exp = {"1111111111111111111", "1", "0"};
        String[] res = new String[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < hexs.length; i++){
            res[i] = instance.hexToBinary(hexs[i]);
        }
        assertArrayEquals(exp, res);
    }

    @Test
    public void testBinaryToHex() {
        String[] bins = {"1111111111111111111", "1", "0"};
        String[] exp = {"7ffff", "1", "0"};
        String[] res = new String[3];
        ConversionApp instance = new ConversionApp();
        for (int i = 0; i < bins.length; i++){
            res[i] = instance.binaryToHex(bins[i]);
        }
        assertArrayEquals(exp, res);
    }
    
}
