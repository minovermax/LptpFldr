

def printMenu ():

    print("")
    print("Menu:")
    print("List all (L)")
    print("Add (A)")
    print("Number of books (N)")
    print("Remove (R)")
    print("Insert (I)")
    print("Quit (Q)")



def printList (bookList):

    for i in bookList:
        print(i)



def main ():
    bookList = ["Catch 22", "Time Machine"]

    print("Welcome! This program evaluates a list of book titles.")
    printMenu()


    userCond = True

    while userCond == True:
        
        print("")
        userInput = input("Please select an option from the menu: ")

        if userInput == "L" or userInput == "l":

            printList(bookList)
        

        elif userInput == "A" or userInput == "a":

            userAInput = input("Enter the title of the book you wish to add to the book list: ")
            bookList.append(userAInput)
            print("Successfully added", userAInput, "to the book list!")
        

        elif userInput == "N" or userInput == "n":

            print("You currently have", len(bookList), "books in your book list!" )
        

        elif userInput == "R" or userInput == "r":

            userRInput = input("Enter the title of the book you wish to remove from the list: ")

            if userRInput in bookList:
                bookList.remove(userRInput)

            elif userRInput not in bookList:
                print("The given book title is not in the book list!")
        

        elif userInput == "I" or userInput == "i":

            userICond = True

            while userICond == True:

                userIInput = input("Enter the the title of the book you wish to insert to the list: ")
                userI2Input = int(input("Enter the index you wish to insert the title at: "))

                if userI2Input < 0 or userI2Input > len(bookList):
                    print("Invalid index. Enter the index again!")
                
                else:
                    bookList.insert(userI2Input, userIInput)
                    print("Successfully inserted", userIInput, "to the index", userI2Input, "of the book list!")

                    userICond = False


        elif userInput == "Q" or userInput == "q":
            print("Goodbye!")
            break

    print("")
    print("End of program ...")               



main()