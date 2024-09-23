# 변수 선언 숫자
a = 10

# 변수 선언 문자열
b = "hello"
b = 'hello World'

# 콘솔에 출력
print(a)
print(b)

# 변수의 타입
a = 10  # 정수
b = 'Hi'  # 문자열
c = 3.14  # 실수
d = True  # boolean

# type() 메소드로 변수의 타입 알 수 있음
print(type(a))
print(type(b))
print(type(c))
print(type(d))

# 타입 변환
# int -> str
a = 10
e = str(a)
print(type(e))

# str -> int
b = "10"
f = int(b)
print(type(f))

# 문자열과 숫자를 함께 출력하는 경우
print("a의 값 : " + str(a))
print("a의 값 :", a)

# """를 이용한 멀티 주석
"""
int = 20
"""

print("====================")

a = 10
b = 3

# 증감연산자 없음
# a++

# 대입 연산자
a += 2
print(a)  # 12

# 산술 연산자
a = a - 2
print(a)  # 10

# 사칙 연산
print(a + b)
print(a - b)
print(a * b)
print(a / b)
print(a % b)

# 거듭제곱
print(a ** 2)
print(a ** 3)

# 조건 연산자
print(a == b)
print(a != b)
print(a > b)
print(a < b)
print(a >= b)
print(a <= b)

# 논리 연산자
print(a > b and a == b)
print(a > b or a == b)

print("====================")

# 파이썬에서 기본 배열
v_array = []
print(v_array)

v_array = [2, 4, 5]
print(v_array)

# 배열 끝에 값 추가
v_array.append(1)
print(v_array)

# 배열 내 인덱스 제거
v_array.pop(1)
print(v_array)

# 배열 내 값 수정
v_array[1] = 3
print(v_array)

# 인덱싱
print(v_array[0])

# 슬라이스
print(v_array[0:2])  # 0 ~ 2
print(v_array[1:])  # 1 ~ 끝
print(v_array[:2])  # 처음 ~ 2
print(v_array[:])  # 모든 인덱스

# 배열의 길이
print(len(v_array))

# 배열 정렬
v_array.sort() # 오름차순
print(v_array)

v_array.sort(reverse=True) # 내림차순
print(v_array)

# 최소, 최대값 구하기
print(min(v_array))
print(max(v_array))

# 반올림
print(round(3.141592,4))