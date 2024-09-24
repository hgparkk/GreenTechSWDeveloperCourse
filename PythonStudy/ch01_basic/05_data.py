# 1. 리스트
v_array = [1, 2, 3]

# 2. set
v_set = {1, 2, 3}

# 3. tuple
# 리스트와 유사하지만 값을 바꿀 수 없음
v_tuple = (1, 2, 3)

# 4. dictionary
v_dictionary = {"name": "아이유"}

print(v_dictionary)
print(v_dictionary["name"])

v_dictionary["age"] = 30
print(v_dictionary)

v_dictionary["songs"] = ["분홍신","좋은날","블루밍"]

str_dict = str(v_dictionary)
# 이런 경우도 있다 JSON String 으로 변경
str_dict = str_dict.replace("'",'"')

print(str_dict)

import json

v_jsonstr = json.dumps(v_dictionary)

print(v_jsonstr)

v_jsondict = json.loads(v_jsonstr)

print(v_jsondict)