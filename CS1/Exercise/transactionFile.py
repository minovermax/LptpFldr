def readTransactions ():

    exerciseFile = open("./transactions.txt", "r")

    lineToRead = exerciseFile.readline().strip()

    name = lineToRead
    #print(numLines)

    numLines = sum(1 for line in exerciseFile)
    #print(numLines)

    money = 0
    for _ in range(numLines):

        if lineToRead == "Deposit":
            _ = lineToRead
            money += lineToRead
    
        elif lineToRead == "Withdraw":
            _ = lineToRead
            money -= lineToRead
    

    money = str(money)
    print(name+":", "$"+money)

    exerciseFile.close()

readTransactions()

