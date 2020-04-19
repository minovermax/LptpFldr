### IP3 Assignment 
### July 18, 2019
### Soungmin Lee


## welcome message function
## prints the welcome message and the options (blank prints are just for breaking lines)
def printWelcome():

    print("Welcome! This program takes a plastic identification number from the user and")
    print("returns information about the type of plastic. Enter 'quit' if you wish to stop.")

    print("")

    print("Menu:")
    print("1) PETE")
    print("2) HDPE")
    print("3) PVC")
    print("4) LDPE")
    print("5) PP")
    print("6) PS")
    print("7) OTHER")

    print("")



## description function
## gives a description of the plastic type the user has selected based on an integer between 1 and 7
## the else statement is for prompting the user to select from 1 to 7 if they enter something else
def isValidUserInput (userInput):

    if userInput == "1":
        print("PET is intended for single use. Reusing increases the risk of carcinogen leaching and bacterial growth. PET is difficult to decontaminate. Recycle but don’t reuse.")

    elif userInput == "2":
        print("HDPE is one of the safest forms of plastic. Resistant to heat and cold. Can be reused and recycled.")

    elif userInput == "3":
        print("PVC is relatively impervious to sunlight and weather. It contains numerous toxins that can leach throughout the lifecycle of the plastic. Cannot be recycled. Can be reused.")

    elif userInput == "4":
        print("LDPE is relatively safe for use. Reusable but not always recyclable.")

    elif userInput == "5":
        print("PP is heat-resistant and acts as a barrier against moisture, grease, and chemicals. Can be reused and recycled.")

    elif userInput == "6":
        print("PS is inexpensive and lightweight. Leaches carcinogens and breaks up easily. Low market for recycling and difficult to reuse. Should be avoided.")

    elif userInput == "7":
        print("PC and “other” plastics. These vary which is confusing for consumers. Because of concerns with carcinogen leaching, avoid these unless it also contains the letters PLA or Compostable. These are made from bio-based polymers that can be composted.")

    else:
        print("Please enter a number between 1 to 7!")


## main function
## contains a while loop with an input function in order to keep asking the user
## sums everything up and also breaks gives a goodbye message when 'quit' is entered
def main():

    printWelcome()

    userInput = 0

    while userInput != "quit":
        userInput = input("Please pick one by its number for the description: ")
        
        if userInput == "quit":
            print("Goodbye! Come back when you want to know more!")
            break

        isValidUserInput(userInput)


## code execution
main()