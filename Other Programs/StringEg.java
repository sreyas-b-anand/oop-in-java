class Operations {
    static void stringEncrypter(StringBuffer str){
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            
            char code = (char)(c+2);
            if(str.charAt(i) == 'Y' || str.charAt(i) == 'y'  ){
                str.replace(i, i+1, "a");
                continue;
            }
            if( str.charAt(i) == 'z' || str.charAt(i) == 'Z'){
                str.replace(i, i+1, "b");
                continue;
            }
            str.replace(i, i+1, String.valueOf(code));
            
            
        }
        System.out.println(str);
    }
}

public class StringEg {
    public static void main(String args[]){
        Operations.stringEncrypter(new StringBuffer("Sreyas"));
    }
}
