'use strict';

const completeCategories = categories => {
    const shopDiv = document.querySelector(".shop"); //выбираем див с магазином, который будем заполнять
    const categoriesDiv = document.createElement('div'); //создаём незаполненный див, для заполнения его категориями
    categoriesDiv.classList.add('categories');

    for (let i = 0; i < categories.length; i++) {
        const tempCategoryDiv = categoryDiv(categories[i]);
        categoriesDiv.appendChild(tempCategoryDiv);
    }
    shopDiv.appendChild(categoriesDiv);
}

const categoryDiv = category => {
    const categoryDiv = document.createElement('div');
    categoryDiv.classList.add('category');
    categoryDiv.appendChild(imgDiv(category));
    categoryDiv.appendChild(captionDiv(category));
    return categoryDiv;
}

const imgDiv = category => {
    const imgDiv = document.createElement('div');
    imgDiv.classList.add('category_img');
    const img = document.createElement('img');
    img.src = "img/categories/" + category + ".jpg";
    imgDiv.appendChild(img);
    return imgDiv;
}

const captionDiv = category => {
    const captionDiv = document.createElement('div');
    captionDiv.classList.add('category_caption');
    captionDiv.innerHTML = category;
    return captionDiv;
}

fetch("/index", {
    method:'GET',
    headers:{
        "Content-type":'application/json; charset:=utf-8'
    }
}).then(response => response.json())
    .then(data => completeCategories(data));

