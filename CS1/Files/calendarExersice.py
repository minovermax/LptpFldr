### how to make a calendar

import calendar

y = int(input("Please enter a year:"))
m = int(input("Please enter a month:"))

calendar.setfirstweekday(6)

print(calendar.month(y, m))
