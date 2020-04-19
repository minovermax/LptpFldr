### turtle simulation
'''
import turtle
window = turtle.Screen()
timmy = turtle.Turtle()
timmy.shape("turtle")



for repeat in range (4):
    timmy.forward(50)
    timmy.right(90)


for repeat in range (3):
    timmy.forward(150)
    timmy.right(120)

window.exitonclick()
'''

### countdown exercise
startNum = 10
for num in range (startNum, 0, -1):
    print(num, "...")
print(num, "!")

### hobby exercise
hobby = ["football", "basketball", "soccer"]
for hob in hobby:
    print(hob)

### another solution for the hobby exercise
for hobby in ["football", "basketball", "soccer"]:
    print(hobby)
