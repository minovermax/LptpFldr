def calculator():

    userSlct = 0

    print("Let's calculate!")
    print("1) Add")
    print("2) Subtract")
    print("3) Multiply")
    print("4) Divide")
    print("5) Exit")

    while userSlct != 5:

        userSlct = int(input("Please select one of the options above: "))


        if userSlct == 5:
            break


        userFirstNum = float(input("Enter the first number: "))
        userSecondNum = float(input("Enter the second number: "))

        if userSlct == 1:
            print("Answer: ", round(userFirstNum + userSecondNum, 1))
    
        elif userSlct == 2:
            print("Answer: ", round(userFirstNum - userSecondNum, 1))

        elif userSlct == 3:
            print("Answer: ", round(userFirstNum * userSecondNum, 1))
    
        elif userSlct == 4:
            print("Answer: ", round(userFirstNum / userSecondNum, 1))
        

    

    print("Have a good day!")

calculator()