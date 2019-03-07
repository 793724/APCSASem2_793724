/**
 * Test CodeWordChecker (2018 FRQ)
 *
 * @ Emma Chiu
 * @ 3/7/19
 */

public class CodeWordChecker {
    private int min;
    private int max;
    private String code;
    
    public CodeWordChecker(int numOne, int numTwo, String word){
        min = numOne;
        max = numTwo;
        code = word;
    }
    
    public CodeWordChecker(String word){
        min = 6;
        max = 20;
        code = word;
    }
    
    public static void main(){
        CodeWordChecker codeWord = new CodeWordChecker("hi");
        System.out.println(codeWord.isValid("lkshfoiwekd"));
    }
    
    public boolean isValid(String str){
        if(str.length() < min || str.length() > max){
            return false;
        }
        
        for(int i = 0; i < str.length() - code.length() - 1; i++){
            if(str.substring(i, i + code.length()).equals(code)){
                return false;
            }
        }
        
        if(str.substring(str.length() - 1).equals(code)){
            return false;
        }
        
        return true;
    }
}
