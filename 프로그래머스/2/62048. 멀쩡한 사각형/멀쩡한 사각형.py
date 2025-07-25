import math 
def solution(w,h):        
    def gcd(a, b):
        if b == 0:
            return a
        return gcd(b, a % b)
    
    return (w * h) - (w + h - gcd(w, h))