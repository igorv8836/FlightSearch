# Android приложение Flight Search
Тестовое приложение

Приложение изначально разрабатывалось с помощью XML согласно ТЗ, но позже я уточнил условия и начал использовать Jetpack Compose
Один фрагмент построен с помощью XML, поэтому, навигация построена с Navigation на базе XML, поэтому фрагменты как основа для Compose были оставлены

## Функционал
* Загрузка рекомендаций
* Сохранение последнего введенного названия города с помощью DataStore
* Выбор города из рекомендаций
* Выбор даты для билета
* Просмотр всех билетов
* Кеширование данных в Room

## Скриншоты приложения
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/93799076-731a-4bb3-9027-b0495ce512ec)
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/84cb9161-4ce8-4576-b383-f49a4ff1002b)
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/0847c8ae-892d-4cb7-9707-b986e9ef3f0f)
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/0b13e9ec-0686-45d5-95b0-9fdb66b61c42)
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/a15209d2-b7a6-4d1a-b5b9-a539322c33a0)
![image](https://github.com/igorv8836/FlightSearch/assets/113043399/5c0f173a-e7c2-4660-95e9-3ac575aec09a)


## Требования к самостоятельной сборке проекта
* Android Studio
* SDK > 24 (на Android 9, 11, 14)

## Требования для работоспособности приложения
* SDK > 24
* Работающий сервис API

## Используемые технологии
* Kotlin
* Flow and Coroutines
* MVVM, многомодульность, Clean Architecture
* Jetpack Compose
* XML верстка
* Android Jetpack
* Coil
* Retrofit + Moshi
* Room
* Koin
* ﻿﻿AdapterDelegates
