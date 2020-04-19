# Lab 4 Exercise

# Information Input
userName = input("Enter your name:")
userWeight = float(input("Enter your weight in pounds:"))
userHeight = float(input("Enter you height in inches:"))

# Converting
userWeightK = userWeight * 0.45359237
userHeightM = userHeight * 0.0254

# Calculating BMI
bmi = userWeightK / (userHeightM ** 2)

# Informing user
print(userName+",", "your BMI is", str(round(bmi,4))+".")

# Converting str(bmi) to float
float(bmi)

# Advice
if bmi < 18.5:
  print("You are underweight. Eat more.")
if 18.5 <= bmi <= 25:
  print("You are normal. All good.")
if 25 < bmi < 30:
  print("You are overweight. Exercise a bit more.")
if 30 < bmi:
  print("You are obese. You must exercise and cut down high calorie foods.")
