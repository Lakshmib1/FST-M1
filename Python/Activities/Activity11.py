fruit_price =	{
  "apple": 100,
  "banana": 50,
  "orange": 70
}

print(fruit_price)

if ("apple" in fruit_price):
    print("apple is available in the list")

fruit = input("which fruit do u want to searh").lower()

if (fruit in fruit_price):
    print("the fruit is available")
else:
    print("the fruit is not available")