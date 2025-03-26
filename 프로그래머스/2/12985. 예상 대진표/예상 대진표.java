class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int s = Math.min(a, b);
        int e = Math.max(a, b);
        
        while (true) {
            
            if (e % 2 == 0 && Math.sqrt(e) == Math.sqrt(s + 1)) {
                break; 
            } else if (e % 2 == 1 && Math.sqrt(e + 1) == Math.sqrt(s)) {
                break;
            }
            
            s = s % 2 == 0 ? s/2 : s/2 + 1;
            e = e % 2 == 0 ? e/2 : e/2 + 1;
            answer++;
            
        }

        return answer;
    }
}