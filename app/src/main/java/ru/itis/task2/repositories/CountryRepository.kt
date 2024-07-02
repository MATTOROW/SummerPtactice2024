package ru.itis.task2.repositories

import ru.itis.task2.dataClasses.Country

object CountryRepository {
    val countries: List<Country> = listOf(
        Country(0, "Russia", "Moscow",
            "https://wdorogu.ru/wp-content/uploads/2023/05/screenshot_26-kopiya-kopiya.jpg",
            "Росси́я, или Росси́йская Федера́ция (сокр. РФ]), — государство в Восточной Европе и Северной Азии. Россия — крупнейшее государство в мире, её территория в международно признанных границах составляет 17 098 246 км²."),
        Country(1, "USA", "Washington",
            "https://otvet.imgsmail.ru/download/263997461_b269619def69f5ee415e18dd296a77ad.jpg",
            "Соединённые Шта́ты Аме́рики (англ. The United States of America, сокращённо США (англ. USA, U.S.A.), или Соединённые Шта́ты (англ. United States, US или U.S., в просторечии — Аме́рика)) — государство в Северной Америке. Площадь — 9,8 млн км² (3-е место в мире)."),
        Country(2, "Germany", "Berlin",
            "https://crimeabusiness.ru/wp-content/uploads/2017/07/Germaniya1.jpg",
            "Государство в Центральной Европе. На северо-западе омывается Северным морем, на северо-востоке – Балтийским морем (длина береговой линии 2389 км). На западе Германия граничит с Францией (448 км), Люксембургом (136 км), Бельгией (204 км) и Нидерландами (576 км), на севере – с Данией (68 км), на востоке – с Польшей (467 км) и Чехией (817 км), на юге – с Австрией (817 км) и Швейцарией (333 км). "),
        Country(3, "Italy", "Rome",
            "https://hot-visa.ru/wp-content/uploads/2023/04/3.jpg",
            "Государство на юге Европы, в центральной части Средиземноморья. Территория включает материковую часть (Паданская равнина, обращённые к востоку и югу склоны Альп, Апеннинский полуостров), крупные острова Сицилия, Сардиния, ряд архипелагов и мелких островов. Около 20 % границы проходит по суше, в основном по Альпам."),
        Country(4, "Norway", "Oslo",
            "https://www.regent-holidays.co.uk/upload-files/product-tours-gallery/summer-voyage-in-the-fjords_2_norway-fjords.jpg",
            "Граничит на юго-востоке и востоке со Швецией (длина границы 1619 км), на северо-востоке – с Финляндией (736 км) и Россией (Мурманская область; 196 км); общая протяжённость сухопутных границ более 2,54 тыс. км (2021). Береговая линия сильно изрезана (свыше 50 тыс. островов); её длина превышает 25 тыс. км, что является одним из самых высоких показателей в мире. На севере страна омывается водами Баренцева моря, на западе – Норвежского и Северного морей, на юге – проливом Скагеррак."),
        Country(5, "China", "Peking",
            "https://anna-news.info/wp-content/uploads/2024/03/05/1700/1.jpg",
            "К. – государство в Вост. и Центр. Азии. На востоке и юго-востоке омывается водами Жёлтого, Восточно-Китайского и Южно-Китайского морей Тихого ок. (протяжённость береговой линии св. 18 тыс. км); у побережья многочисл. острова (крупнейшие – Тайвань и Хайнань). Длина сухопутных границ ок. 22,8 тыс. км. На северо-востоке граничит с КНДР и Россией, на севере – с Монголией, на северо-западе – с Россией, Казахстаном и Киргизией, на западе – с Таджикистаном и Афганистаном, а также с Пакистаном (по т. н. линии контроля в Кашмире), на юго-западе и юге – с Индией, Непалом и Бутаном; на юго-востоке – с Мьянмой, Лаосом и Вьетнамом."),
        Country(6, "Brazil", "Brasília",
            "https://avatars.dzeninfra.ru/get-zen_doc/271828/pub_65634ec6888ea253651c231f_656350b557f28e544aca0196/scale_1200",
            "Государство в Латинской Америке и центральной и восточной частях Южной Америки. На севере граничит с Французской Гвианой (протяжённость границы 730,4 км), Суринамом (593,0 км), Гайаной (1605,8 км), Венесуэлой (2199,0 км), на северо-западе – с Колумбией (1644,2 км), на западе – с Перу (2995,3 км) и Боливией (3423,2 км), на юго-западе – с Парагваем (1365,4 км) и Аргентиной (1261,3 км), на юге – с Уругваем (1068,1 км). Общая протяжённость сухопутных границ 16 885,7 км. На востоке омывается водами Атлантического океана. Общая протяжённость береговой линии 10 959 км, протяжённость морской границы 7491 км."),
    )
}