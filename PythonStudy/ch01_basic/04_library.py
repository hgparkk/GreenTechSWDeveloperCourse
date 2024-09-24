import random as rd
import myutil

num = rd.randint(1, 5)

print(num)

lotto = []

while len(lotto) < 6:
    num = rd.randint(1, 45)
    if num not in lotto:
        lotto.append(num)
lotto.sort()
print(lotto)

lotto2 = myutil.make_lotto()

print(lotto2)

from myutil import Student

stu = Student("호빵맨",20)
stu.hello()
print(stu)
print(stu.name)
print(stu.age)