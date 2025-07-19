# 주차 요금은 00:00 부터 23:59까지의 입/출차 내역을 바탕으로 누적 주차 시간을 계산 및 일괄 정산한다.
# 입차 이후 출차된 내역이 없다면 23:59에 출차된 것으로 간주한다
# ex) 0000 => 06:00 (입차) -> 06:34 (출차) 총 34분 주차
#          => 18:59 (입차) -> 23:59 (출차 - 출차 이력 없으므로) 총 300분 주차
#          => 34 + 300분 = 334분 기준으로 누적 주차 시간 일괄 정산
# 주차 계산법: 
#   1. 누적 주차 시간이 기본 시간 이하면 기본 요금만 청구
#   2. 누적 주차 시간이 기본 시간 초과라면 기본 요금 + 초과한 시간에 대해서 단위 시간 마다 단위 요금 청구 (올림)
# 제한사항: 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return

import math 
def solution(fees, records):
    
    # 입차 출차 레코드 관리를 위한 dict 선언
    park_record = {}
    # 누적 시간 레코드 관리를 위한 dict 선언
    time_record = {}
    
    # 주차 시간 세팅
    def set_parking_time(car_number, parking_time):
        if car_number in time_record:
            time_record[car_number] += parking_time
        else:
            time_record.setdefault(car_number, parking_time)    
    
    # 입출차 내역을 통해서 주차 시간 계산
    for record in records:
        time, car_number, status = record.split(" ")
        if status == "IN":
            park_record[car_number] = time
        elif status == "OUT":
            in_time = park_record[car_number]
            parking_time = calc_park_time(in_time, time)
            set_parking_time(car_number, parking_time)
            del park_record[car_number]
    
    # 출차 기록이 없는 차에 대한 계산
    if park_record:
        for car_number, in_time in park_record.items():
            set_parking_time(car_number, calc_park_time(in_time, '23:59'))
    
    answer = []
    
    # 차량 번호 기준으로 sort
    for key, value in sorted(time_record.items(), key = lambda item : item[0]):
        total_fee = fees[1] # 기본 요금
        left_time = value - fees[0] # 기본 요금 초과 여부
        if left_time > 0:
            total_fee += math.ceil(left_time / fees[2]) * fees[3]
        answer.append(total_fee)
    
    return answer


# 입차와 출차 시간 기준으로 주차 시간 계산
def calc_park_time(in_time_str, out_time_str):
    in_time, out_time = convert_time_str_to_min(in_time_str), convert_time_str_to_min(out_time_str)
    return out_time - in_time
    
def convert_time_str_to_min(time_str):
    arr = list(map(int, time_str.split(":")))
    return arr[0] * 60 + arr[1]