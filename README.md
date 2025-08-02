# TrueLevel
"Easily level anything with this intuitive, digital bubble level app.
# 📏 Bubble Level Android App

A simple Android application that functions as a **digital bubble level**, using the device's **Rotation Vector Sensor** to calculate pitch and roll. It gives visual feedback on how level your phone is — perfect for DIY enthusiasts, engineers, and tech tinkerers!

---

## 🧭 Features

- 📐 Live tilt angle detection using **Rotation Vector Sensor**
- 🔄 Real-time **horizon line rotation**
- 🎨 **Visual feedback**:
  - ✅ Green background when the device is nearly level (within ±1°)
  - ⬛ Black background when tilted
- 📝 Angle display in degrees
- 🎯 Minimal, intuitive UI

---

## 📸 Screenshots
![WhatsApp Image 2025-08-03 at 00 12 07_6aedf7f8](https://github.com/user-attachments/assets/8bae704f-de5d-4624-9b49-b0fc7297d570)
![WhatsApp Image 2025-08-03 at 00 12 07_5e6b1796](https://github.com/user-attachments/assets/59bb78c4-915f-4217-bc18-7245f8a8dce4)
![WhatsApp Image 2025-08-03 at 00 12 09_d03e6305](https://github.com/user-attachments/assets/a9a7a487-2da0-4786-a77a-efccd8987f59)
![WhatsApp Image 2025-08-03 at 00 12 09_df16907b](https://github.com/user-attachments/assets/720066a6-556c-40cb-81e6-ba25be12594f)


---

## 🧠 How It Works

- **Sensor Used:** `Sensor.TYPE_ROTATION_VECTOR`
- Orientation values (pitch & roll) are extracted using:

  ```java
  SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
  SensorManager.getOrientation(rotationMatrix, orientations);
pitchDegrees and rollDegrees are used to:

🔄 Rotate a line (simulating a bubble level)

🎨 Change the background color based on tilt

📐 Display the tilt angle on screen

If the total tilt (based on both pitch and roll) is below 1.0°, the device is considered level and the screen turns green.
## 🛠️ Tech Stack

- Java  
- Android SDK  
- Android Sensors API  

---

## 📲 Installation

1. **Clone the repository**:
 
   Paste the repo link or use download the zip
2.Open in Android Studio

3.Connect a device or use a virtual device with sensor simulation

4.Run the app and observe the live tilt feedback!

✅ Requirements
Android device with rotation vector sensor

Android Studio (recommended: latest stable version)

Minimum SDK: API Level 16 (Android 4.1)

