import java.util.ArrayList;
import java.util.List;

public class LinkGeneration {
    static List<Character> symbols = new ArrayList<>();
    private byte[] pointers = {0, 0, 0, 0, 0};//счетчик битов
    private static int symbolsValue;
    private int changingBit = pointers.length-1;

    public String generateLink() { //Метод грубой силы
        var sb = new StringBuilder();
        for (byte pointer : pointers) {
            var b = symbols.get(pointer);
            if ((int) b > 10) sb.append((char) b);
            else sb.append((char) b);
        }
        pointers[changingBit] += 1;
        if (pointers[changingBit] == symbolsValue) {
            pointers[changingBit] = 0;
            pointers[changingBit-1]+=1;
            if (pointers[changingBit-1]==symbolsValue){
                pointers[changingBit-1]=0;
                pointers[changingBit-2]+=1;
                if (pointers[changingBit-2]==symbolsValue){
                    pointers[changingBit-2]=0;
                    pointers[changingBit-3]+=1;
                    if (pointers[changingBit-3]==symbolsValue){
                        pointers[changingBit-3]=0;
                        pointers[changingBit-4]+=1;
                        if (pointers[changingBit-4]==symbolsValue){
                            System.exit(0);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public  void generateSymbols(){
        int cnt=0;
        for (char c='0'; c<='9'; c++) {
            symbols.add(c);
            cnt++;
        }
        for (char c='A'; c<='Z'; c++) {
            symbols.add(c);
            cnt++;
        }
        for (char c='a'; c<='z'; c++) {
            symbols.add(c);
            cnt++;
        }
        symbolsValue = cnt;
    }


}
