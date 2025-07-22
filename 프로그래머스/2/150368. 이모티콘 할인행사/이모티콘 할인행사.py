from itertools import product
# 이모티콘 행사의 목적:
# 1. 이모티콘 플러스 서비스 가입자를 최대한으로 늘리는 것
# 2. 이모티콘 판매액을 최대한으로 늘리는 것 (이모티콘 가입자 수가 같다면 판매액이 더 높은 할인율이 우선)
# 이모티콘 할인율: 10, 20, 30, 40
# 1차 시도:
# 각 할인율 별로 사용자의 구매 비용과 이모티콘 서비스 가입 여부를 구한다
# 최종적으로 이모티콘 플러스 서비스 가입자가 최대, 판매액이 최대인 순으로 고른다
def solution(users, emoticons):
    discounts = [10, 20, 30, 40]        
    answer = [0, 0]
    
    discount_price_comb = generate_discount_combinations(emoticons)
    
    for comb in discount_price_comb:
        total_price = 0
        join_cnt = 0
        for user_discount, join_price in users:
            user_total_price = 0
            for emo_discount, emo_price in comb:
                # 이모티콘 할인율이 유저의 사는 할인율보다 낮으면 스킵
                if emo_discount < user_discount:
                    continue
                user_total_price += emo_price
                # 만약 산 이모티콘 가격이 플러스 가입 금액보다 높다면
                if user_total_price >= join_price:
                    user_total_price = 0
                    join_cnt += 1
                    break
            if user_total_price > 0:
                total_price += user_total_price
        if join_cnt >= answer[0]:            
            if join_cnt > answer[0]:
                answer[0], answer[1] = join_cnt, total_price
            else:
                answer[0], answer[1] = join_cnt, max(total_price, answer[1])
        # print("조합: ", comb, "전체 가격: ", total_price, "플러스 가입자 수: ", join_cnt)
    return answer

def generate_discount_combinations(emoticons):
    discounts = [10, 20, 30, 40]
    
    discount_combinations = product(discounts, repeat=len(emoticons))
        
    result = []
    for discount_set in discount_combinations:
        row = []
        for price, rate in zip(emoticons, discount_set):
            discounted_price = int(price * (100 - rate) / 100)            
            row.append((rate, discounted_price))            
        result.append(row)        
    
    return result            