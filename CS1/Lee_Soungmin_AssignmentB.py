# PART B
# Purpose: This program calculates the BMI and displ1s a
# matrix for given weight and height limits
# Author: Soungmin Lee
# Date: July 19th, 2019




def calculateBMI(userWeight, userHeight):

    # converting values
    userWeightK = userWeight * 0.45359237
    userHeightM = userHeight * 0.0254

    # calculating bmi
    bmi = userWeightK / (userHeightM ** 2)



    if bmi <= 20:
        print("UNDR")

    elif 20 < bmi <= 25:
        print("NORM")

    elif 25 < bmi <= 30:
        print("OVER")

    elif 30 < bmi:
        print("OBES")






def matrixBMI ():

    userCon = True


    while userCon == True: 

        # prompts user to input min, max, step values for weight and height
        userMinWeight = int(input("Enter minimum weight in pounds: "))
        userMaxWeight = int(input("Enter maximum weight in pounds: "))
        userStepWeight = int(input("Enter weight step in pounds: "))
        userMinHeight = int(input("Enter minimum height in inches: "))
        userMaxHeight = int(input("Enter maximum height in inches: "))
        userStepHeight = int(input("Enter height step in inches: "))

        # spacing for interface
        print()
        print()

        # couldn't find it out :(
        for i in range(userMinWeight, userMaxWeight, userStepWeight):
            print("Weight", i)
        
        for u in range(userMinHeight, userMaxHeight, userStepHeight):
            print("Height", u)
        

        # user inputs if user wants to continue
        userInput = input("Run again? (y/n): ")
        print()

        # loop to prompt user to enter a value of y or n
        while userInput != "y" and userInput!= "n":
            print("Invalid input. Please try again.")

            userInput = input("Run again? (y/n): ")
            print()
        
        # changes condition based on the user's input
        if userInput == "y":
            userCon = True
        
        elif userInput == "n":
            userCon = False

matrixBMI()