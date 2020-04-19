### IP4 Assignment
### Email Parsing Program
### Author: Soungmin Lee
### Date: July 25, 2019



## email parser function
def emailParser(filename):

    # opening file, creating blank list
    emailFile = open(filename)
    nameList = []

    # counting total number of lines in the file
    numLines = 0
    with emailFile as f:
        for _ in f:
            numLines += 1
    
    # i don't know why, but the counting lines part closed the file, so reopening it
    emailFile = open(filename)

    # loop to split the line, extract the name, and append the name to the list
    for _ in range(numLines):

        # reading line
        logLine = emailFile.readline()

        # splitting line
        logLine = logLine.split()

        # re-splitting the ~~@asdfa.asd part again by '@'
        logNameSepr = logLine[1].split("@")

        # using the left part of the splitted string, which is the name of the sender
        logName = logNameSepr[0]

        # appending the sender's name to the list
        nameList.append(logName)

    # returning list
    return nameList



## testing
print(emailParser("logfile.txt"))