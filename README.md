Overview:Using Kotlin in Android Studio, create a native Android app that aids users in studying with flashcards.  
The application will ask questions, go over each flashcard in turn, and assign a score according to the user's responses.  Five questions must be asked.  Use GitHub and GitHub Actions, just like in Assignment 1.

---

Features:

- Five True/False flashcard questions
- Instant feedback after each answer
- Score screen with motivational feedback
- Replay quiz functionality
- Review screen with detailed explanations
- Clean, commented Kotlin code
- GitHub Actions setup for CI

---

Project Structure:

MainActivity.kt
- Displays the **Start Quiz** button
- Navigates to `QuestionScreen.kt`

QuestionScreen.kt
- Displays questions and True/False buttons
- Tracks score and handles question progression
- Navigates to `ScoreScreen.kt` after all questions

ScoreScreen.kt
- Shows the final score and feedback
- Buttons to **Play Again**, **Review Answers**, or **Exit**

ReviewScreen.kt
- Allows users to review correct answers using radio buttons
- Displays detailed explanations upon selection

---

Sample Questions:

1. Nelson Mandela was the president in 1994. 
2. The capital of France is Berlin.
3. The human body has four lungs.
4. Kotlin is used for Android development.
5. Water freezes at 0°C. 

---

How It Works:

- Questions are loaded from an array.
- Users select True/False; answers are checked.
- Score is calculated and passed to the next screen.
- Review allows optional recap with explanations.

---

Installation:

Prerequisites:

- Android Studio (2020.3.1 or later)
- Kotlin plugin installed
- Android Emulator or device running API 23+

### Steps

1. Clone the repository:

   ```bash
   https://github.com/SonavNaidoo16/FlashCards

GitHub Actions:
name: Android CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
  
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v3

    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        distribution: 'temurin'
        java-version: 11

    - name: Build with Gradle
      run: ./gradlew build

Technologies Used:
-Kotlin
-Android SDK
-Android Studio
-Git & GitHub
-GitHub Actions (CI)

Screenshots:
Start quiz:
![image](https://github.com/user-attachments/assets/a6f4409c-c691-4a47-b5d8-15308044f2c1)
![image](https://github.com/user-attachments/assets/b3c741f0-6186-40c2-a81e-b9c79a5c5262)

Question Screen: 
![image](https://github.com/user-attachments/assets/154e406a-9665-4af1-b7db-c259c335fba9)
![image](https://github.com/user-attachments/assets/a644045b-c976-4ae6-b24d-767eec7f56b5)
![image](https://github.com/user-attachments/assets/58038c2a-8e9d-48d1-a9d2-9076c017cc97)

Score Screen: 
![image](https://github.com/user-attachments/assets/b719ebda-abfe-431d-89f4-d3e9b6e126f9)
![image](https://github.com/user-attachments/assets/eb9f74a6-2651-4313-8c62-9ba8369ecf15)
![image](https://github.com/user-attachments/assets/0ec50039-f235-46af-8819-11d177ab3eca)

Review Screen: 
![image](https://github.com/user-attachments/assets/4f9b8b5e-fafd-413a-ad35-9ae5adc5e3cb)
![image](https://github.com/user-attachments/assets/09ab2de7-6c79-4f5d-b978-f7cb01e44744)
![image](https://github.com/user-attachments/assets/3101c5eb-bebe-4b9f-af1e-86299ed9b7fb)

IN APP SCREENSHOTS:
![image](https://github.com/user-attachments/assets/5202a1d5-1573-4438-a2d3-827b3a5bef3a)
![image](https://github.com/user-attachments/assets/ff02b1e5-230a-4d8c-ae03-3d032054a473)
![image](https://github.com/user-attachments/assets/2fcc5164-71e6-42b6-921a-69df8a0fbb70)
![image](https://github.com/user-attachments/assets/e00eba74-9f31-41d5-8bbf-1231c09e75d2)

Walkthrough of the app:
https://youtu.be/x8zFBWbxDy8 
