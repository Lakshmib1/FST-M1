num = int(input("how many terms"))
count = 0
n1 = 0
n2=1
n3=0
if num<=0:
    print("enter positive number")
elif num ==1:
    print("the fibonacci series of", num)
    print(n1)
else:
    while count<num:
        print(n1)
        n3=n1+n2
        n1=n2
        n2=n3
        count=count+1
