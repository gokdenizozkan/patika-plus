const menu = [{
    id: 1,
    title: "Tteokbokki",
    category: "Korea",
    price: 10.99,
    img: "https://twoplaidaprons.com/wp-content/uploads/2020/09/tteokbokki-top-down-view-of-tteokbokki-in-a-bowl-500x500.jpg",
    desc: `Spicy rice cakes, serving with fish cake.`,
}, {
    id: 2,
    title: "Chicken Ramen",
    category: "Japan",
    price: 7.99,
    img: "https://www.forkknifeswoon.com/wp-content/uploads/2014/10/simple-homemade-chicken-ramen-fork-knife-swoon-01.jpg",
    desc: `Chicken noodle soup, serving with vegetables such as soy bean, green onion. In an optional you can ask for egg. `,
}, {
    id: 3,
    title: "Bibimbap",
    category: "Korea",
    price: 8.99,
    img: "https://dwellbymichelle.com/wp-content/uploads/2020/05/DWELL-bibimbap.jpg",
    desc: `Boiling vegetables, serving with special hot sauce`,
}, {
    id: 4,
    title: "Dan Dan Mian",
    category: "China",
    price: 5.99,
    img: "https://www.savingdessert.com/wp-content/uploads/2019/02/Dan-Dan-Noodles-10.jpg",
    desc: `Dan dan noodle, serving with green onion `,
}, {
    id: 5,
    title: "Yangzhou Fried Rice",
    category: "China",
    price: 12.99,
    img: "https://salu-salo.com/wp-content/uploads/2013/02/Yangzhou-Fried-Rice1.jpg",
    desc: `Yangzhou style fried rice, serving with bean and pickles `,
}, {
    id: 6,
    title: "Onigiri",
    category: "Japan",
    price: 9.99,
    img: "https://www.manusmenu.com/wp-content/uploads/2017/08/Onigiri-3-1-of-1.jpg",
    desc: `Rice Sandwich, serving with soy sauce`,
}, {
    id: 7,
    title: "Jajangmyeon",
    category: "Korea",
    price: 15.99,
    img: "https://www.curiouscuisiniere.com/wp-content/uploads/2020/04/Jajangmyeon-Korean-Noodles-in-Black-Bean-Sauce5.1200H-720x540.jpg",
    desc: `Black bean sauce noodle, serving with green onion `,
}, {
    id: 8,
    title: "Ma Yi Shang Shu",
    category: "China",
    price: 12.99,
    img: "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/F688C2F6-86EC-46C4-B9C7-A6BA01DF7437/Derivates/32E3E72A-F786-406D-AF7F-B30980A9AC6C.jpg",
    desc: `Hot pepper sauce noodle, serving with soy bean and onion`,
}, {
    id: 9,
    title: "Doroyaki",
    category: "Japan",
    price: 3.99,
    img: "https://www.justonecookbook.com/wp-content/uploads/2011/10/Dorayaki-New-500x400.jpg",
    desc: `Red bean paste dessert, serving with honey.`,
},];
//
// Sitedeki içerik JavaScript'te menu şeklinde bir dizi içinde objeler olarak tanımlanacak. +
// Id, title, category, price, img ve desc bölümleri olacak. +
// İçeriği istediğiniz gibi değiştirebilirsiniz yalnız değiştirirken kategori isimlerine ekstra dikkat edin. +
// Butonlar da js dosyasından gelecek.
// Site içerisinde map, reduce gibi methodları kullanmanız gerekecek. Hatırlamıyorsanız Map ile Array İçerisideki Yapının Değiştirilerek Yeni Liste Oluşturulması #38 isimli videoya dönebilirsiniz.

window.onload = () => {
    var filterDiv = document.getElementById("filter");
    var menuDiv = document.getElementById("elements");
    var filterButtons = ["All"];
    menu.forEach((item) => {
        if (!filterButtons.includes(item.category)) {
            filterButtons.push(item.category);
        }
    });

    filterButtons.forEach((item) => {
        var button = document.createElement("button");
        button.innerHTML = item;
        button.onclick = () => {
            menuDiv.innerHTML = "";
            if (item === "All") {
                menu.forEach((item) => {
                    createMenuItem(item);
                });
            } else {
                menu.forEach((item2) => {
                    if (item2.category === item) {
                        createMenuItem(item2);
                    }
                });
            }
        };
        filterDiv.appendChild(button);
    });

    menu.forEach((item) => {
        createMenuItem(item);
    });

    function createMenuItem(item) {
        var menuItem = document.createElement("div");
        menuItem.setAttribute("class", "menu-item")
        menuItem.setAttribute("id", item.id);

        var menuItemImg = document.createElement("img");
        menuItemImg.setAttribute("class", "menu-photo")
        menuItemImg.setAttribute("src", item.img);

        var menuItemTitle = document.createElement("h5");
        menuItemTitle.setAttribute("class", "menu-title");
        menuItemTitle.innerHTML = item.title;

        var menuItemDesc = document.createElement("p");
        menuItemDesc.setAttribute("class", "menu-text");
        menuItemDesc.innerHTML = item.desc;

        var menuItemPrice = document.createElement("p");
        menuItemPrice.setAttribute("class", "menu-text");
        menuItemPrice.innerHTML = item.price;

        var menuItemInfo = document.createElement("div");
        menuItemInfo.setAttribute("class", "menu-info");
        menuItemInfo.appendChild(menuItemTitle);
        menuItemInfo.appendChild(menuItemDesc);
        menuItemInfo.appendChild(menuItemPrice);

        menuItem.appendChild(menuItemImg);
        menuItem.appendChild(menuItemInfo);
        menuDiv.appendChild(menuItem);
    }
}