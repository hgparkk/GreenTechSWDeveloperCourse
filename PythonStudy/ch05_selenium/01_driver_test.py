from selenium import webdriver
from selenium.webdriver.common.by import By

# selenium을 실행할 브라우저로 크롬 브라우저를 설정한다
driver = webdriver.Chrome()

# url 열기
driver.get("https://www.10000recipe.com/ranking/home_new.html?dtype=d&rtype=r")

# document 찾기
li_array = driver.find_elements(By.CSS_SELECTOR, ".common_sp_list_li")

import pandas as pd

df = pd.DataFrame(columns=["recipe_title", "recipe_link", "img_src"])

for li in li_array:
    recipe_title = li.find_element(By.CSS_SELECTOR, ".common_sp_caption_tit").get_attribute("innerHTML")

    recipe_link = li.find_element(By.CSS_SELECTOR, ".common_sp_link").get_attribute("href")

    img_src = li.find_element(By.CSS_SELECTOR, ".common_sp_link > img").get_attribute("src")

    current_recipe = {"recipe_title": recipe_title, "recipe_link": recipe_link, "img_src": img_src}

    df.loc[len(df)] = current_recipe

print(df)
