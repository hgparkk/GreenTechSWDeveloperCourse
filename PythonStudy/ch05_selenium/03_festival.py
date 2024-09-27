import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
import pandas as pd

# 크롬 가상 브라우저에 대한 옵션 추가
option = webdriver.ChromeOptions()
option.add_argument("--headless")  # 가상브라우저를 띄우지 않음

driver = webdriver.Chrome(options=option)

driver.get("https://korean.visitkorea.or.kr/kfes/list/wntyFstvlList.do")

# 셀렉트 옵션 선택
select = Select(driver.find_element(By.CSS_SELECTOR, "#searchDate"))
select.select_by_value("A")

before_height = driver.execute_script("return document.body.scrollHeight")

df = pd.DataFrame(columns=["img_src", "a_href", "fest_name", "fest_start", "fest_end", "fest_loc"])

while True:

    # body 의 높이
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight)")

    time.sleep(1)

    after_height = driver.execute_script("return document.body.scrollHeight")

    print(before_height, after_height)

    if after_height == before_height:
        print("끝")
        break

    before_height = after_height

df = pd.DataFrame(columns=["img_src", "a_href", "fest_name", "fest_start", "fest_end", "fest_loc"])

a_array = driver.find_elements(By.CSS_SELECTOR, "#fstvlList > li > a")

for a in a_array:
    a_href = a.get_attribute("href")
    img_src = a.find_element(By.CSS_SELECTOR, ".other_festival_img > img").get_attribute("src")
    fest_name = a.find_element(By.CSS_SELECTOR, ".other_festival_content > strong").get_attribute("innerHTML")
    fest_date = a.find_element(By.CSS_SELECTOR, ".other_festival_content > .date").get_attribute("innerHTML").split("~")
    fest_start = fest_date[0]
    fest_end = fest_date[1]
    fest_loc = a.find_element(By.CSS_SELECTOR, ".other_festival_content > .loc").get_attribute("innerHTML")

    current_fest = {"img_src": img_src, "a_href": a_href, "fest_name": fest_name, "fest_start": fest_start,
                    "fest_end": fest_end, "fest_loc": fest_loc}

    df.loc[len(df)] = current_fest

df.to_csv("fest_csv.csv", index=False)
