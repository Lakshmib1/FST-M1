number = list(input("enter the series of number with comma: ").split(","))
sum=0

for num in number:
    sum = sum + int(num)

print(sum)