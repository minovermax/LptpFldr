

import random


def someFunction ():
    numOfElements = 20
    numOfSurprises = 10

    someList = []
    someList = someList.extend(['*'] * numOfSurprises)

    for _ in range(len(numOfSurprises)):
        
        someList[random.randint(0, len(someList))]



someFunction() 