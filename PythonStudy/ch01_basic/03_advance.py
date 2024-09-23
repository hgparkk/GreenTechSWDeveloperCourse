# 조건문
id_back = '1234567'

id_first = id_back[0]
id_first = int(id_first)
if id_first % 2 == 1:
    print("남성")
else:
    print("여성")

age = 24
if 10 <= age < 20:
    print("빨간색")
elif 20 <= age < 30:
    print("파란색")
elif 30 <= age < 40:
    print("초록색")
else:
    print("흰색")

print("====================")

for i in range(1, 11):
    print(i)

v_array = list(range(1, 11))

print(v_array)

students = ["삼장", "오공", "저팔계", "사오정"]

# 배열의 값 접근
for i in students:
    print(i)

# 배열의 인덱스 접근
for i in range(len(students)):
    print(students[i])

intArray = [3, 5, 7, 9, 2, 4]

for i in range(len(intArray)):
    intArray[i] *= 2

print(intArray)

intArray = [3, 5, 7, 9, 2, 4]

# intArray 배열 내 홀수 개수 세기
intOddArray = [x for x in range(len(intArray)) if x % 2 == 1]
print(len(intOddArray))

# intArray 배열 내 짝수 모두 더하기
intEvenArray = [x for x in range(len(intArray)) if x % 2 == 0]
print(sum(intEvenArray))