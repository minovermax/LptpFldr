### 7 / 1 Lab Exercise


def helperMenu ():
    print("Welcome to the CSU Taco Shop!")

    print()

    print("Menu:")
    print("Beef Taco $2.90")
    print("Shrimp Taco $3.00")
    print("Fish Taco $3.25")
    print("Chicken Taco $2.75")
    print("Lentil Taco $2.50")

    print()


def beefTaco(numBeef):
    totBeef = numBeef * 2.90
    return totBeef
  
def shrimpTaco(numShrimp):
    totShrimp = numShrimp * 3.00
    return totShrimp
  
def fishTaco(numFish):
    totFish = numFish * 3.25
    return totFish
  
def chickenTaco(numChicken):
    totChicken = numChicken * 2.75
    return totChicken
  
def lentilTaco(numLintel):
    totLentil = numLintel * 2.50
    return totLentil
  


def main ():
    helperMenu()
        
    userBeef = int(input("How many barbeque beef tacos would you like? "))
    userShrimp = int(input("How many shrimp and grits tacos would you like? "))
    userFish = int(input("How many cajun fish grits tacos would you like? "))
    userChicken = int(input("How many chicken guacamole tacos would you like? "))
    userLentil = int(input("How many caramelized onion lentil tacos would you like? "))

    print()

    print("Your order is:")
    print(userBeef, "Yummy Korean barbeque beef tacos")
    print(userShrimp, "Awesome shrimp and grits tacos")
    print(userFish, "Super cajun fish tacos")
    print(userChicken, "Delicious chicken guacamole tacos")
    print(userLentil, "Life extending caramelized onion lentil tacos")

    print()

    priceBefTax = beefTaco(userBeef) + shrimpTaco(userShrimp) + fishTaco(userFish) + chickenTaco(userChicken) + lentilTaco(userLentil)
    priceAftTax = priceBefTax * 1.08

    print("Your total before tax is", round(priceBefTax, 2))
    print("Your total with tax is", round(priceAftTax, 2))


main()