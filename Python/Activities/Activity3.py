user1 = input("enter the first player name")
user2 = input ("enter the second player name")

input1 = input("enter the first player choice")
input2 = input("enter the second player choice")

if input1 == input2:
     print("the options are same..its a tie")
elif input1 == 'rock':
     if input2 == 'scissors':
        print ("Rock wins")
     else:
        print("paper wins")
elif input1 == 'paper':
     if input2 == 'rock':
        print ("paper wins")
     else:
        print("scissors wins")
elif input1 == 'scissors':
     if input2 == 'paper':
        print ("scissors wins")
     else:
        print("rock wins")       
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")
 