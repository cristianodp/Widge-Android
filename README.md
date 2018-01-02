# Widge-Android

[![](https://jitpack.io/v/cristianodp/Widge-Android.svg)](https://jitpack.io/#cristianodp/Widge-Android)

### Widge for Android
- SimpleItemView

![](https://raw.githubusercontent.com/cristianodp/Widge-Android/master/images/SimpleItemView.PNG)

#### How to Install
----
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file in your root build.gradle at the end of repositories:
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency in our gradle file

```groovy
compile 'com.github.cristianodp:Widge-Android:0.1.0'
```

#### How to Use
----
In or xml layout add the simpleItemView as the code bellow
```xml
<br.com.cristianodp.widge.SimpleItemView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:icon="@drawable/ic_ball"
        app:label="Incomes"
        app:value="$ 200.00" />
```

License
=======
MIT License

Copyright (c) 2018 Cristiano Diniz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
