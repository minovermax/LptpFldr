### IP2 Assignment
### July 11th, 2019


## importing the random method
import random


## machine1 function, makes a list of random numbers between 1 and 100
def machine1(userInput1):
    list1 =[]

    # appending values to list1 as strings for the join() method
    for _ in range(userInput1):
        num1 = str(random.randint(1, 100))
        list1.append(num1)

    return list1


## machine2 function, makes a list of random numbers between 200 and 300
def machine2(userInput2):
    list2 = []

    # appending values to list2 as strings for the join() method
    for _ in range(userInput2):
        num2 = str(random.randint(200, 300))
        list2.append(num2)

    return list2


## generate function, prints the values returned from machine1 and machine2
def generate(howManyFromMachine1, howManyFromMachine2):

    # using the join() method in order to get rid of the []s surrounding the list
    print("Generated numbers from Machine1 and Machine2 are: ", ' '.join(machine1(howManyFromMachine1)), "and", ' '.join(machine2(howManyFromMachine2)))


## main function, prints welcome message and receives choices from the user
def main():

    # welcome message
    print("Welcome to the Random Generator Program!")
    userChoice = 0

    # loop in order to repeat itself until user inputs 'n'
    while userChoice != "n":

        userChoice = input("Generate numbers? (y/n): ")

        if userChoice == "y":
            userInput1 = int(input("How many numbers would you like to generate from Machine 1?: "))
            userInput2 = int(input("How many numbers would you like to generate from Machine 2?: "))

            generate(userInput1, userInput2)
    
        elif userChoice == "n":
            print("Goodbye! See you next time.")
    
        # an extra feature to prevent the user inputting values other than 'y' or 'n'
        else:
            print("Please choose from 'y' or 'n'.")


## executing the main() function
main()


