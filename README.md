# Brain Trainer App
Brain Trainer app is an Android Application for a quick exercise to your brain's short term memory, concentration, focus , speed & accuracy.<br>
Basically, it is an app, which gives you random mathematical questions, which you have to solve in a given period of time, say 30s. <br>
It would generate a score based on your answers, and you have an option to **Play Again.**

## Functionalities
1. It starts the application as soon as you press ***"GO!"***. <br>
2. There is random generation for: <br>
  a. The questions <br>
  b. The answers <br>
  c. The location of the correct answer <br>
3. There is a countdown timer, within which you have to answer the questions.
4. After the timer runs out, you get the *final score*, and an option to **Play Again**.

# Install Pre-requisites

1. Download the Android IDE: Android Studio (you may need to install java by following the prompts)
  a. Optional: Install the Android SDK: ``` brew install android-sdk ``` , Select the SDK that ```brew``` logged out back in the previous command
2. Open this project with in Android Studio IDE
3. The IDE will complain about *"Gradle sync failed".* Just follow what it says.
4. Once the IDE stops giving suggestions go to **Tools -> Android -> SDK Manager** and do what the SDK Manager says.
5. Once the SDK Manager stops giving suggestions, use it to install the Google Repository and the Android Support Repository.

# How do you use this repository?
Clone or download this repo<br>
```
https://github.com/anjalisi/Brain-Trainer-App 
```
After that you can simply take the files and paste it in the required folders. Et Voila !

# Setup Virtual Device
## Running on a virtual device
1. Open the AVD Manager (***Tools -> Android -> AVD Manager***).
2. Create a new Virtual Device. The size/model doesn't matter that much
3. Select a system image that has both a _x86_64 ABI and Google Play Services_.
4. Finish and Click Play!
