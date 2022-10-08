# Clean-MVVM-DictionaryApp

> An Android application built using Clean + MVVM architecture.

## Components used in the app.
- [Kotlin](https://kotlinlang.org/) - As a programming language.
- [Material You](https://material.io/blog/start-building-with-material-you) - To make UI.
- [Flow](https://kotlinlang.org/docs/flow.html) - A suspending function asynchronously returns a single value, but how can we return multiple asynchronously computed values? This is where Kotlin Flows come in.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - To manage the UI-related data
- [Retrofit](https://square.github.io/retrofit/) - For making network calls.
- [Hilt](https://dagger.dev/hilt/) - For dependency injection.
- [Room database](https://developer.android.com/topic/libraries/architecture/room) - To cache the response for offline access.

## Description
This is a Interview application which made by me in interview task what it do? that will give you the result from api and also save data in the cache using RoomDb so that we can access it offline.

## Given Task 
Url : https://jsonplaceholder.typicode.com/posts

1. Use Single Activity and multiple Fragment.
2. Fetch post from provided url [use retrofit] and store them inside your local database.[use room db.]
3. Display your local database posts in a list using RecyclerView.
4. In Your recyclerView layout display only title of the post.
5. Clicking on a post It should display whole post contents in a separate fragment.
6. Now Create a accessibility service and display a toast "WhatsApp Launched." , when user open whatsApp.
6a. Optionally You can add a button somewhere in your Activity Layout for accessibility permission.



## Architecture
[Clean MVVM Architecture](https://proandroiddev.com/android-clean-architecture-kotlin-flow-hilt-simplest-way-415d7e0f41b)

## Steps to build the app
- Clone or Download the zip.
- Simply import into Android Studio.
- Build and run the app.

Thank you!
