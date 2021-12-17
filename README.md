# Plantr

![plantr](https://user-images.githubusercontent.com/81345503/143834283-e5c80482-59f7-4030-8e12-3cfb2a1bf6b7.png)

# Links 
  <code>
    <a href="https://play.google.com/store/apps/details?id=com.applicationPantr.plantr" title="Playstore Profile"><img height="140" width="412" src="https://user-images.githubusercontent.com/81345503/143836980-d80acce1-1a5b-4d74-bd27-f479b3de0bd5.png"></a></code>

# 🔗Open-Source Library

* [MVVM-Architecture](https://developer.android.com/jetpack/guide)
* [Camerax](https://developer.android.com/training/camerax)
* [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging)
* [Room Database](https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase)
* [Dependency Injection-Hilt](https://developer.android.com/training/dependency-injection)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](https://square.github.io/retrofit/)
* [Firebase](https://firebase.google.com/docs/auth)
* [Coroutines](https://developer.android.com/kotlin/coroutines)
* [Jetpack](https://developer.android.com/jetpack)


# Things we used while making this application
* MVVM-Architecture
* Room Database
* Camerax for for Scanning Plants 
* Firebase Cloud Messaging
* GitHub
* Firebase
* Recycler View
* Retrofit Library

# Tech Stack ✨

* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)
* [MVVM-Architecture](https://developer.android.com/jetpack/guide)

# Clone this Repo To Your System Using Android Studio✨

* Step 1: Open your Android Studio then go to the File > New > Project from Version Control as shown in the below image.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise like below. In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.

# Clone this Repo To Your System Using GitBash✨

* Open Git Bash

* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.

* Go to the current directory where you want the cloned directory to be added.

* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.

* Go to the page of the repository that you want to clone

* Click on “Clone or download” and copy the URL.

* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/chekeAditya/Amazon-Prime.git

* Press Enter. $ git clone https://github.com/chekeAditya/Amazon-Prime.git Cloning into Git … remote: Counting objects: 13, done. remote: Compressing objects: 100% (13/13), done. remove: Total 13 (delta 1), reused 0 (delta 1) Unpacking objects: 100% (13/13), done.

Congratulations, you have created your first local clone from your remote Github repository.

Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.

# Dependencies 

       //firebase
    implementation platform('com.google.firebase:firebase-bom:29.0.0')
    implementation 'com.google.firebase:firebase-analytics-ktx'
    implementation 'com.google.firebase:firebase-database:20.0.2'
    implementation 'com.google.firebase:firebase-core:20.0.0'
    implementation 'com.google.firebase:firebase-auth:21.0.1'
    implementation 'com.google.firebase:firebase-storage:20.0.0'

    viewPager
    implementation platform('com.google.firebase:firebase-bom:29.0.0')
    //ViewPager 2
    implementation 'androidx.viewpager2:viewpager2:1.0.0'
    //Material design
    implementation 'com.google.android.material:material:1.5.0-alpha05'
    //facebook
    implementation 'com.facebook.android:facebook-android-sdk:latest.release'
    // google
    implementation 'com.google.android.gms:play-services-auth:19.2.0'
    //Lottie
    implementation("com.airbnb.android:lottie:4.2.0")

    //camerax
    def camerax_version = "1.0.2"
    // CameraX core library using camera2 implementation
    implementation "androidx.camera:camera-camera2:$camerax_version"
    // CameraX Lifecycle Library
    implementation "androidx.camera:camera-lifecycle:$camerax_version"
    // CameraX View class
    implementation "androidx.camera:camera-view:1.0.0-alpha30"

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    //range seekbar
    implementation 'com.github.MohammedAlaaMorsi:RangeSeekBar:1.0.6'

    //gif
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.22'

    //circularImage
    implementation 'de.hdodenhof:circleimageview:3.1.0'

    //gif
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.23'

    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"


    //Room
    implementation 'androidx.room:room-ktx:2.3.0'
    kapt 'androidx.room:room-compiler:2.3.0'

    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"

    //material design library
    implementation 'com.google.android.material:material:1.4.0'

    // FCM
    implementation 'com.google.firebase:firebase-messaging:23.0.0'

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'
