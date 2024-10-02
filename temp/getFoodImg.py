import time

import requests
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()

driver.get("https://www.google.com/imghp?hl=ko&ogbl")

# 검색창 불러오기
search_bar = driver.find_element(By.CSS_SELECTOR, "textarea[name=q]")

# 검색창에 검색어 입력
search_bar.send_keys("순대")

search_bar.send_keys(Keys.RETURN)

time.sleep(3)

tag_gimg = driver.find_elements(By.CSS_SELECTOR, ".mNsIhb")

tag_div = driver.find_elements(By.CSS_SELECTOR, ".H8Rx8c")

import datetime
import os

now = datetime.datetime.now()

time_name = now.strftime("%y%m%d%H%M")

v_path = "순대" + time_name
try:
    os.mkdir(v_path)
except:
    pass

count = 1
for div in tag_div:
    driver.execute_script("arguments[0].click()", div)

    time.sleep(1)

    try:
        v_img = driver.find_element(By.CSS_SELECTOR, ".sFlh5c.FyHeAf.iPVvYb")

        print(v_img.get_attribute("src"))

        response = requests.get(v_img.get_attribute("src"))

        with open(v_path + "/" + "순대" + str(count) + ".png", "wb") as file:
            file.write(response.content)
        count += 1
    except:
        pass
