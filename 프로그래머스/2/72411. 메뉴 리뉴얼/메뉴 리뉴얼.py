from itertools import combinations
def solution(orders, course):
    answer = []
    max_course = dict((c, 0) for c in course)
    menu = dict()
    # course별로 조합 구하기
    for menu_cnt in course:         
        for order in orders:            
            if len(order) < menu_cnt:
                continue
            menu_list = list(order)
            menu_list.sort()
            for comb in combinations(menu_list, menu_cnt):                
                menu_str = "".join(comb)
                if menu_str not in menu:
                    menu.setdefault(menu_str, 0)
                menu[menu_str] += 1
                max_course[menu_cnt] = max(max_course[menu_cnt], menu[menu_str])
    
    course_menu = list(k for k, v in menu.items() if v >= 2 and max_course[len(k)] == v)    
    course_menu.sort()
    
    return course_menu