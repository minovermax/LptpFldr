def gradeDef(student):
    if student >= 90:
        print("Your letter grade is A")
    elif student >= 80:
        print("Your letter grade is B")
    elif student >= 70:
        print("Your letter grade is C")
    elif student >= 60:
        print("Your letter grade is D")
    else:
        print("Your letter grade is F")

def main():
    userInput = 8424
    while not str(0) <= str(userInput) <= str(100):

        userInput = input("Please enter a grade (between 0 and 100): ")
        if not str(0) <= userInput[0] <= str(9):
            print("Sorry, this program only accepts values between 0 and 100.")
        elif not 0 <= int(userInput) <= 100:
            print("Sorry, this program only accepts values between 0 and 100.")
        else:
            userInput = int(userInput)
            gradeDef(userInput)
            break




main()