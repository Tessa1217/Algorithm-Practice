import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 가장 작은 수를 구하는 방법: 최대한 큰 수를 빼기
        // -를 기준으로 수식 가름
        String[] formula = br.readLine().split("-");
        
        br.close();
             
        int[] numArr = new int[formula.length];
        
        for (int i = 0; i < formula.length; i++) {
            
            String formulaStr = formula[i];
            String[] f = formulaStr.split("\\+");
            for (int j = 0; j < f.length; j++) {
                numArr[i] += Integer.parseInt(f[j]);
            }
        }        
        
        int num = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            num -= numArr[i];
        }
        System.out.println(num);           



    }
}