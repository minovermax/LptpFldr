def main():
    print("Welcome to my inches to feet converter!")

    userInput = "X"

    while userInput != 0:
        userInput = int(input("Please enter a number of inches: "))
        if userInput > 0:
            inches = round(userInput / 12, 1)
            print(inches)
        elif userInput < 0:
            print("Please enter a positive number!")
    
        elif userInput == 0:
            print("Have a nice day!")
            break

main()