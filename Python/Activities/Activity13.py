from xml.dom.expatbuilder import FilterVisibilityController


user_list = [10,20,30,40,50,90]

def calculate_sum(numbers):
    sum=0
    for number in numbers:
        sum = sum+number
    return sum
result = calculate_sum(user_list)

print("the sum of numbers ", result)