# PART A
# Purpose: This program calculates and displays the body 
# mass index for given weight and height and classifies a 
# person based on the inputs
# Author: Soungmin Lee
# Date: July 19th, 2019


def calculateBMI(userWeight, userHeight):
    

    # converting values
    userWeightK = userWeight * 0.45359237
    userHeightM = userHeight * 0.0254

    # calculating bmi
    bmi = userWeightK / (userHeightM ** 2)

    return bmi




## function that executes the BMI process
def processBMI():

    # default condition
    userCon = True

    # while loop to continue when the condition is true
    while userCon == True:

        userWeight = float(input("Enter your weight in pounds: "))
        userHeight = float(input("Enter you height in inches: "))
        
        bmi = calculateBMI(userWeight, userHeight)

        print("BMI: ", round(bmi,2))

        # depends the user's status
        if bmi <= 20:
            print("UNDR")

        elif 20 < bmi <= 25:
            print("NORM")
        
        elif 25 < bmi <= 30:
            print("OVER")
        
        elif 30 < bmi:
            print("OBES")
        
        # just spacing for better interface
        print("")

        # user inputs if user is going to continue
        userInput = input("Run again? (y/n): ")
        print()

        # loop to prompt user to enter y or n
        while userInput != "y" and userInput!= "n":
            print("Invalid input. Please try again.")

            userInput = input("Run again? (y/n): ")
            print()
        
        # changes condition based on the user's input
        if userInput == "y":
            userCon = True
        
        elif userInput == "n":
            userCon = False
        
        




    # exit message
    print("Program quitting...")

processBMI()