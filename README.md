# Movies List (Kotlin - MVVM - Hilt - Retrofit - Room - Work Manager)

The app is composed of 2 screens, first is the movies List vertical with categories horizontal , second screen is movie details screen
with (Kotlin - MVVM - Hilt - Retrofit - Room - Work Manager)

For more references :
- **Kotlin** - https://kotlinlang.org/
- **Retrofit** - https://www.raywenderlich.com/6994782-android-networking-with-kotlin-tutorial-getting-started
- **MVVM** - https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture
- **Hilt** - https://developer.android.com/training/dependency-injection/hilt-android
- **Coroutines** - https://developer.android.com/kotlin/coroutines
- **WorkManager** - https://developer.android.com/topic/libraries/architecture/workmanager
- **UI layer** -https://developer.android.com/topic/architecture/ui-layer
- **Flow** -https://kotlinlang.org/docs/flow.html
- **Room** -https://developer.android.com/training/data-storage/room

## Application Guide
- **BaseStructure** Consider structure of the Application Layers of Clean Architecture
  Presentation: A layer that interacts with the UI.
  Use cases: Sometimes called interactors. Defines actions the user can trigger.
  Domain: Contains the business logic of the app.
  Data: Abstract definition of all the data sources.
  Framework: Implements interaction with the Android SDK and provides concrete implementations for the data layer.
- **remote-categories** Call Genres Api with Update Data in UI view
- **remote-movies-list** Call Movies List Api with Update Data in UI view
- **remote-movie-details** make parcelable model with sending list to movie details page
- **room-structure** making room layer (Dao - AppDatabase - Entity)
- **work-manager** caching data in room and create work manager every 4 hour call api
- **main** master of application
- **work-manager** caching data in room and create work manager every 4 hour call api
- **main** master of application
