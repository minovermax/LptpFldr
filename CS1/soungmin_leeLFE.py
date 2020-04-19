
### Final Exam
### Author: Soungmin Lee
### Date: July 29th, 2019


## importing modules
import random


# filling recycle bin function
def fillRecycleBin ():

    # making new blank list
    rcyclNumList = []

    # using for loop to add 5 random numbers between 1 and 9
    for _ in range(5):
        randNum = random.randint(1, 9)
        rcyclNumList.append(randNum)
    
    # returning list with 5 random numbers between 1 and 9
    return rcyclNumList


# printing current recycle bin status function
def printRecycleBin (rcyclNumList, rcyclItemList):

    # using for loop and index to print out everything evenly
    for upTo5 in range(5):
        print(rcyclNumList[upTo5], rcyclItemList[upTo5])



# printing main menu function
def printMainMenu ():
    print("")
    print("Here are your options:")
    print("Enter 1 to get a new recycle bin")
    print("Enter 2 to print your current recycle bin")
    print("Enter 3 to add an item to your recycle bin")
    print("Enter 4 to remove an item from your recycle bin")
    print("Enter 5 to quit")
    print("")


# printing item menu function
def printItemMenu ():

    print("Enter 1 for a plastic bottle")
    print("Enter 2 for a glass bottle")
    print("Enter 3 for an aluminum can")
    print("Enter 4 for a cardboard box")
    print("Enter 5 for an other recyclable")
    print("")



## main function that sums everything up
def main ():
    # welcome message
    print("Welcome to the random recycle bin program!")

    # presets
    userCond = True
    userAtmp = "first recycle bin:"
    rcyclItemList = ["plastic bottles", "glass bottles", "aluminum cans", "cardboard boxes", "other recyclables"]
    rcyclNumList = fillRecycleBin()

    print("Here is your", userAtmp)
    printRecycleBin(rcyclNumList, rcyclItemList)
    

    # user while loop that breaks when 5 is entered for main menu
    while userCond == True:
        
        # printing main menu
        printMainMenu()

        # user main input
        userMainInput = input("Please enter your choice: ")

        # choice 1, making a new recycle bin
        if userMainInput == "1":
            # reassigning rcyclNumList with the fillREcycleBin function
            rcyclNumList = fillRecycleBin()
            # making the 'first recycle bin:' to 'new treasure chest since it is not the first bin
            userAtmp = "new treasure chest:"

            print("Here is your", userAtmp)
            printRecycleBin(rcyclNumList, rcyclItemList)


        # choice 2, printing current recycle bin
        elif userMainInput == "2":
            print("Here is your", userAtmp)

            printRecycleBin(rcyclNumList, rcyclItemList)


        # choice 3, adding item to recycle bin
        elif userMainInput == "3":
            print("What would you like to add?: ")
            printItemMenu()

            # user input to add
            userAddInput = input("Please enter your choice: ")

            if userAddInput == "1":
                rcyclNumList[0] += 1
            
            elif userAddInput == "2":
                rcyclNumList[1] += 1
            
            elif userAddInput == "3":
                rcyclNumList[2] += 1
            
            elif userAddInput == "4":
                rcyclNumList[3] += 1
            
            elif userAddInput == "5":
                rcyclNumList[4] += 1
            
            else:
                print("Invalid input!")
            
            print("Here is your", userAtmp)
            printRecycleBin(rcyclNumList, rcyclItemList)


        # choice 4, removing item from recycle bin
        elif userMainInput == "4":
            print("What would you like to remove?:")
            printItemMenu()

            # user input to remove
            userRmvInput = input("Please enter your choice: ")

            if userRmvInput == "1":
                rcyclNumList[0] -= 1
            
            elif userRmvInput == "2":
                rcyclNumList[1] -= 1
            
            elif userRmvInput == "3":
                rcyclNumList[2] -= 1
            
            elif userRmvInput == "4":
                rcyclNumList[3] -= 1
            
            elif userRmvInput == "5":
                rcyclNumList[4] -= 1
            
            else:
                print("Invalid input!")
            
            print("Here is your", userAtmp)
            printRecycleBin(rcyclNumList, rcyclItemList)


        # choice 5, exiting program
        elif userMainInput == "5":
            # making userCond False to end the loop
            userCond = False
            # double checking to end the loop
            break


        # else statement to catch any other userMainInput than 1 ~ 5
        else:
            print("Invalid input. Please try again.")


# goodbye message that i just added for a better interface
    print("")
    print("Goodbye! Have a great day!")



## main fuction execution
main()




### end of code! i'm sorry that i only used 5 functions :(