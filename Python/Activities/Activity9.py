list1 = [10,20,30,40,50]
list2 = [5,15,25,35,45]
list3 = []

len1 = len(list1)
len2 = len(list2)

for i in range(0,len1,2):
   list3.append(list1[i])

for j in range(1,len1,2):
   list3.append(list2[j])


print("first list", list1)
print("second list", list2)
print("thrid list", list3)