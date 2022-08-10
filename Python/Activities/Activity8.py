number = list(input("enter the list of number with comma:").split(","))

first = number[0]
last = number[-1]

if first == last:
    print("the first and last are same numbers")
else:   
    print("the first and last numbers are not same")