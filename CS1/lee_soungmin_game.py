### Extra Credit Assignment
### Author: Soungmin Lee
### Date: 7/28/2019


## importing random method
import random


## rock paper scissors game function
def rockPaperScissors():
    
    # welcome message
    print("Welcome to the game of Rock Paper Scissors!")
    print("")

    # presetting values
    userRound = 1
    userPoint = 0
    compPoint = 0
    userCond = True

    # while loop to keep going until user enters 'exit'
    while userCond == True:

        # printing current round
        print("Round", userRound)

        # user's input
        userInput = input("Please enter either rock, paper, scissors or exit: ")

        # if user inputs 'exit', loop breaks
        if userInput == "exit":
            print("You entered", userInput)
            userCond = False
            break
        
        # if user inputs something else, prompts user to input a value that is valid
        elif userInput != "rock" and userInput != "paper" and userInput != "scissors":
            print("You entered", userInput)
            print("Invalid entry. Let's try again!")
            print("")
            continue

        # confirming user's input, using the compSelect function to get computer's value
        print("You entered", userInput)
        compInput = compSelect()
        print("The computer selected", compInput)

        # tie occasion
        if userInput == compInput:
            print("It's a tie!")
            userRound += 1

        # user winning by 'rock' occasion
        elif userInput == "rock" and compInput == "scissors":
            print("You won this round!")
            userPoint += 1
            userRound += 1

        # user winning by 'paper' occasion
        elif userInput == "paper" and compInput == "rock":
            print("You won this round!")
            userPoint += 1
            userRound += 1
        
        # user winning by 'scissors' occasion
        elif userInput == "scissors" and compInput == "paper":
            print("You won this round!")
            userPoint += 1
            userRound += 1

        # computer winning occasions
        else:
            print("Sorry, the computer won this round!")
            compPoint += 1
            userRound += 1
        
        # confirming user's and computer's scores
        print("")
        print("The score is:")
        print("You:", userPoint, "|", "Computer:", compPoint)
        print("")
    
    # goodbye message
    print("Thank you for playing!")



## function that uses the random method to get the computer's value of 'rock', 'paper' or 'scissors'
def compSelect():
    
    # getting random integer between 1 and 3
    compRPC = random.randint(1, 3)

    # if random number is 1, computer's value is 'rock'
    if compRPC == 1:
        return "rock"
    
    # if random number is 2, computer's value is 'paper'
    elif compRPC == 2:
        return "paper"
    
    # if random number is 3, computer's value is 'scissors'
    elif compRPC == 3:
        return "scissors"




## rock paper scissors function execution
rockPaperScissors()