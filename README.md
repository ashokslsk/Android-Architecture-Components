# Android Architecture Components & its Nuances 

Well story is clear! If you are an Android developer you got less chances of ignoring Android Architecture Components. 

Like the above story taunts you to read this write up, the content of the whole project is straight-forward. Helping readers to comprehend the AAC and its digged deep anatomy. Well for starters i will be introducing you all for the dependencies that you are suppose to use before you jump in to the pool of coding. So what are you looking at? spit on your supervisor and take an hour break and have code-gasms. 



## Index

- [ ] What, Why, and How's of AAC 
- [ ] Data Binding Library - So you can go for an ice-cream break with your crush.
- [ ] Application Lifecycles are easier than you have assumed when you use ViewModel and LiveData.
- [ ] Let's Fly with a JetPack
- [ ] Navigation Architecture Components and Paging library
- [ ] Room Database 
- [ ] Scheduling Tasks with WorkManager. 

#### Well don't you just sit there just fire up your Android Studio Buddy! (Android Studio 3.3 or later would be great)

------

![pic1](https://github.com/ashokslsk/Android-Architecture-components/blob/master/Pics/pic1.png)

## What, Why, and How's of AAC

AAC is a powerful and prominent release by Google which encomposes popular libraries that was performing a variety of tasks. Primary idea is to help developers to have a maintainable, testable and robust application with less code.

Google calls it Android JETPACK which includes popular support libraries like Android Architecture components, Navigation architecture and so forth.

So So what is **Jetpack** ?

Could it be a collection of Android software components! Well you guessed it right. JetPack is Divided in to four category and each category has its own responsibility. 

- **Architecture**
  - Data binding
  - Lifecycles 
  - LiveData 
  - Navigation …  
- **UI**
  - Animations & Transitions
  - Auto, TV & Wear
  - Emoji...
- **Foundation**
  - AppCompat
  - Android KTX
  - Test & MultiDex and so on. 
- **Behavior**
  - Download Manager
  - Media Playback
  - Permissions...

In this article i will be writing the code in kotlin. Each topic i will try to make as immersive as possible through my words. 

## Data Binding 

Am i talking anything new here? Yes and No. The concept introduced in Google IO 2015 so close to 4 years of strong and growing idea. But whats new is Data Binding has created its remarkable place in JetPack family. It is generous for google to include this library in to JetPack support. 
Google has forseen the use cases and continous future need of this concept and they did what they are suppose to. 

> If you are still using Eclipse with ADT plugin to develop android applications you are doomed and you need to do telekenesis to add gradle support and a lot more. I would recommend go and do download Latest way to write code with Android studio

From the Gradle plugin 1.3 version or later You just need to enable the data binding library like shown below. 

```groovy
android {
  .
  .
  .
  dataBinding {
      enabled = true
   }
}
```

And allow your android studio to sync the project and re-index the files with databinding enabled to it. 

The following example is super duper straight forward. You need to create a model class if it was Java code i would have asked you all to write a pojo class but since its a kotlin code please do write simple model class as shown below. 

```kotlin
class CounterViewModel{
    var counter = 0
    var clicked = ObservableField("Clicked "+counter+" Times")
    fun CounterClicked(){
        counter++
        clicked.set("Clicked "+counter+" Times")
    }
}
```

And in your MainActivity's oncreate method you need to set the layout and the Binding model like shown below. 

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = CounterViewModel()
    }
```

Next step is super straight forward in layout at the root add layout tag and data tags as shown below. 

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
                name="viewModel"
                type="com.androidabcd.ashokslsk.aac.CounterViewModel"/>
    </data>
  <android.support.constraint.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".MainActivity">
    
    <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{viewModel.clicked}"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"/>

        <Button
                android:id="@+id/button"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:text="Click"
                android:onClick="@{() -> viewModel.CounterClicked()}"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView"/>
    
  </android.support.constraint.ConstraintLayout>
    </layout>
```

![pic2](https://github.com/ashokslsk/Android-Architecture-components/blob/master/Pics/pic2.png)

The above view is directly being updated by the data binding framework and with clean code and no pain. Hows that inspiring you ?

For further understanding you may also refer to the following link : 

[Data Binding ]: https://github.com/ashokslsk/Android-Architecture-Components/tree/f7780d8dea7f06fa4c6ac3dabcc207854f6a10b7/app/src

Anyway moving on i will be talking about some key concepts in the Index. 

