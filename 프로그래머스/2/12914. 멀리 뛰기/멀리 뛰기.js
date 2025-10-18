function solution(n) {
    return fibonacci(n);
}

const fibonacci = (n) => {
  const dp = new Array(n+1).fill(0);
  
  dp[0] = 1; 
  dp[1] = 1;
  
  for(let i = 2; i <= n; i++)
    dp[i] = (dp[i-1] + dp[i-2]) % 1234567; // 1234567 나누기!
  
  return dp[n];
}