### Assignment2

## Purpose: This program encrypts and decrypts data
## Author: Soungmin Lee
## Date: 07.04.2019



# Encrypt function
def encrypt(data):

    # converting data to single digits
    # counting from the left for clarity, since it does not affect the result
    # example: 2543 -> 2 is the first digit in the code
    firDig = data // 1000
    secDig = (data % 1000) // 100
    thrDig = ((data % 1000) % 100) // 10
    forDig = (((data % 1000) % 100) % 10) // 1

    # (digit + 7) % 10 process
    firDigMod = (firDig + 7) % 10
    secDigMod = (secDig + 7) % 10
    thrDigMod = (thrDig + 7) % 10
    forDigMod = (forDig + 7) % 10

    # mixing numbers
    firDigModEnc = forDigMod
    secDigModEnc = thrDigMod
    thrDigModEnc = secDigMod
    forDigModEnc = firDigMod


    # converting to a 4 digit number & return
    valEnc = (firDigModEnc * 1000) + (secDigModEnc * 100) + (thrDigModEnc * 10) + forDigModEnc
    return valEnc



# Decrypt function
def decrypt(data):

    # converting data to single digits, also counts from the left
    firDig2 = data // 1000
    secDig2 = (data % 1000) // 100
    thrDig2 = ((data % 1000) % 100) // 10
    forDig2 = (((data % 1000) % 100) % 10) // 1


    # reversing the (digit + 7) % 10 process
    firDig2Rev = (firDig2 + 3) % 10
    secDig2Rev = (secDig2 + 3) % 10
    thrDig2Rev = (thrDig2 + 3) % 10
    forDig2Rev = (forDig2 + 3) % 10

    # unmixing numbers
    firDigOg = forDig2Rev
    secDigOg = thrDig2Rev
    thrDigOg = secDig2Rev
    forDigOg = firDig2Rev

    # converting to a 4 digit number & return
    ogNum = (1000 * firDigOg) + (100 * secDigOg) + (10 * thrDigOg) + forDigOg

    return ogNum


def main():
    userInput = int(input("Enter Number: "))

    print("The encrypted number is: ", encrypt(userInput))
    print("The decrypted number is: ", decrypt(encrypt(userInput)))


main()