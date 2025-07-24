def solution(arrayA, arrayB):
    
    a_gcd = gcd_array(arrayA)
    b_gcd = gcd_array(arrayB)
    
    return max(get_max_non_divisor(a_gcd, arrayB), get_max_non_divisor(b_gcd, arrayA))

def get_max_non_divisor(gcd, array):
    if gcd == 1:
        return 0
    for num in array:
        if num % gcd == 0:
            return 0
    return gcd

def gcd_array(array):
    cur_gcd = array[0]
    for i in range(1, len(array)):
        cur_gcd = gcd(cur_gcd, array[i])
    return cur_gcd

def gcd(a, b):    
    if b == 0:
        return a    
    return gcd(b, a % b)
    
    