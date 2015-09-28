[![Android Gems](http://www.android-gems.com/badge/Diveno/NoticeLayout.svg?branch=master)](http://www.android-gems.com/lib/Diveno/NoticeLayout)

# NoticeLayout
Library for notice 
#Usage

Add a NoticeLayout in your layout

```xml
<com.dive.notice.NoticeLayout
        android:id="@+id/noticeLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        notice:acceptBackground="@color/green"
        notice:acceptText="@string/accept"
        notice:cancelBackground="@color/red"
        notice:cancelText="@string/cancel"
        notice:contentText="@string/textLorem"
        notice:tittleColor="@color/white"
        notice:animIn="slideBottom"
        notice:animOut="slideTop"
        notice:tittleText="@string/tittleLorem"/>
```
        
```java
NoticeLayout noticeLayout = (NoticeLayout)findViewById(R.id.noticeLayout);
noticeLayout.show(true);

License
--------

    Copyright 2015 Diego Bravo.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
