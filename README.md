# Shopping List App / To-Do List

## Overview
This is an Android application developed using Jetpack Compose and integrates with Google Maps to allow users to select locations. The app features a shopping list and to-do list functionalities, with location selection integrated to set and view locations on Google Maps.

## Features
- **Google Maps Integration:** View and select locations on a Google Map.
- **Location Tracking:** Retrieve and display the user’s current location.
- **Geocoding API Integration:** Convert coordinates into human-readable addresses.
- **Compose UI:** Modern UI built using Jetpack Compose.

## Requirements
- Android Studio with support for Jetpack Compose.
- Google Maps API Key.
- Android device or emulator with Google Play services.

## Getting Started

### Prerequisites
- **Google Maps API Key:** You need to enable Google Maps SDK for Android and obtain an API key from the Google Cloud Console.

- **Permissions:** Ensure your app has permissions for location access in `AndroidManifest.xml`:
    ```xml
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    ```

### Installation
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/FATEH02/ShoppingListApp-ToDoList.git
    cd ShoppingListApp-ToDoList
    ```

2. **Open the Project:** Open the project in Android Studio.

3. **Add Google Maps API Key:**
    Place your API key in `res/values/strings.xml`:
    ```xml
    <string name="google_maps_key">YOUR_API_KEY_HERE</string>
    ```

4. **Sync Project:** Sync your project with Gradle files.

## Usage
- **Run the App:** Build and run the app on a physical device or emulator.

### Main Features:
- **Shopping List Screen:** View and manage your shopping list.
- **Location Selection Screen:** Choose a location on Google Maps and set it.

### Location Services:
- Location services will be requested to get the user's current location.
- You can update and fetch the address from the coordinates on the map.

## Code Structure
- **LocationSelectionScreen.kt:** Composable function for selecting a location on Google Maps.
- **GeocodingApiService.kt:** Interface for interacting with the Geocoding API.
- **LocationViewModel.kt:** ViewModel for managing location data and interacting with the Geocoding API.
- **LocationUtils.kt:** Utility class for handling location services and permissions.
- **MainActivity.kt:** Main activity which sets up navigation and themes.
- **LocationData.kt:** Data classes for handling location and geocoding responses.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request with improvements, bug fixes, or features.

1. **Fork the repository.**
2. **Create a new branch** (`git checkout -b feature/YourFeature`).
3. **Commit your changes** (`git commit -am 'Add new feature'`).
4. **Push to the branch** (`git push origin feature/YourFeature`).
5. **Open a pull request.**


## Contact
For any inquiries or issues, please contact FATEH02.
