import random as rd


def make_lotto():
    lotto = []

    while len(lotto) < 6:
        num = rd.randint(1, 45)
        if num not in lotto:
            lotto.append(num)
    lotto.sort()
    return lotto


class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def hello(self):
        print("안녕하세요 " + self.name + "입니다.")
