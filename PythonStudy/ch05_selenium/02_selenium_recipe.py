from selenium import webdriver
from selenium.webdriver.common.by import By
import pandas as pd

df = pd.DataFrame(columns=["recipe_title", "recipe_link", "img_src"])

driver = webdriver.Chrome()

driver_url = "https://www.10000recipe.com/recipe/list.html?order=reco&page="

for i in range(15):
    driver.get("https://www.10000recipe.com/recipe/list.html?order=reco&page=" + str(i + 1))

    li_array = driver.find_elements(By.CSS_SELECTOR, ".common_sp_list_li")

    for li in li_array:
        recipe_title = li.find_element(By.CSS_SELECTOR, ".common_sp_caption_tit").get_attribute("innerHTML")

        recipe_link = li.find_element(By.CSS_SELECTOR, ".common_sp_link").get_attribute("href")

        img_src = li.find_element(By.CSS_SELECTOR, ".common_sp_link > img").get_attribute("src")

        current_recipe = {"recipe_title": recipe_title, "recipe_link": recipe_link, "img_src": img_src}

        df.loc[len(df)] = current_recipe

print(df)
