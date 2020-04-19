### part 1
'''
foreground = "red"
background = "blue"
x = foreground

foreground = background
background = x


print("Foreground: " + foreground)
print("Background: " + background)
'''

### part 2

# input
length = float(input("What is the length of room in feet?:"))
width = float(input("What is the width of room in feet?:"))
height = float(input("What is the height of room in feet?:"))
door = float(input("How many doors are there?:"))
window = float(input("How many windows are there?:"))

# calculation
squareFeet = 2*(width*height) + 2*(length*height)
finSquareFeet = squareFeet - 20*door - 15*window
paintGallon = finSquareFeet / 350

# break lines
print("\n")

# output
print("The length of the room is", length, "feet.")
print("The width of the room is", width, "feet.")
print("The height of the room is", height, "feet.")
print("The amount of paint needed to paint the walls of the room is", round(paintGallon, 2), "gallons.")
