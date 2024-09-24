import numpy as np

# numpy의 배열
v_array = np.array([])
v_array = np.array([1, 2, 3])

print(v_array)
print(type(v_array))

# 클래스 정보 조회
print(dir(v_array))

# 객체에 대한 도움말 보기
help(v_array)

# 배열에 담는 타입이 일치해야한다. 이를 위해 요소를 강제 형변환 한다.
v_array = np.array([1, 2, "호빵맨"])  # 숫자를 문자열로 담는다
v_array = np.array([1, 2, 3.14])  # 정수를 실수로 담는다
print(v_array)

v_array = np.array([])

# 배열에 값 추가

v_array = np.append(v_array, 1)
v_array = np.append(v_array, 2)
v_array = np.append(v_array, 3)

print(v_array)

# 배열 내 요소 타입 확인
print(v_array.dtype)

# 배열 내 요소 타입 변경
v_array = v_array.astype(int)

print(v_array.dtype)

# 인덱싱
print(v_array[0])

# 마지막 인덱스 접근
print(v_array[-1])

# 슬라이스
print(v_array[0:2])

# 1부터 10까지 담기
v_array = np.arange(1,11)
print(v_array)

# 1부터 20까지 2 간격씩 담기
v_array = np.arange(1,21,2)
print(v_array)

# 슬라이싱
print(v_array[0:5:2])
print(v_array[::-1]) # 배열 반대로 리턴

# 값 수정
v_array[0] = 99
print(v_array)

# 배열 요소 내부 값 연산
v_array = v_array * 3
print(v_array)

# 배열 요소 삭제
v_array = np.delete(v_array, 1)
print(v_array)

# 값의 인덱스 번호 찾기
print(np.where(v_array == 9))
print(np.where(v_array >= 3))

v_reverse_array = np.arange(10, -1, -1)

print(v_reverse_array)

print("====================")

v_array = np.array([])

import random as rd

# 랜덤 숫자 10개 넣기
for i in range(10):
    v_array = np.append(v_array, rd.randint(10, 20))
v_array = v_array.astype(int)

print(v_array)

# 중복 제거 반복문
for i in range(0, len(v_array)):
    for k in range(len(v_array) - 1, i, -1):
        if v_array[i] == v_array[k]:
            v_array = np.delete(v_array, k)

print(v_array)

for i in range(10):
    v_array = np.append(v_array, rd.randint(10, 20))
v_array = v_array.astype(int)

# 중복 제거 메소드 활용 방법
v_array = np.unique(v_array)

print(v_array)

# 정렬
v_array = np.sort(v_array)
print(v_array)

v_array = np.sort(v_array)[::-1] # 정렬 후 반대로 슬라이싱
print(v_array)

print("====================")

v_array = np.array([1,2,3,4,5,6,7,8,9])

print(v_array.shape)

v_array = v_array.reshape(1,-1)

print(v_array.shape)
print(v_array)

v_array = v_array.reshape(-1,1)

print(v_array.shape)
print(v_array)

v_array = v_array.reshape(3,-1)

print(v_array.shape)
print(v_array)

v_array = v_array.reshape(-1,3)

print(v_array.shape)
print(v_array)

# 다차원 배열의 인덱싱
print(v_array[2])
print(v_array[2][1])

# 1 부터 10 까지 동일한 간격의 5개의 값을 담는다.
v_array = np.linspace(1,10,5)

print(v_array)
