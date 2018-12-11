# 说明
这是Kotlin代码，初次自定义view代码
# 效果展示
![](https://github.com/JadeKkang/ripplebutton/blob/master/image/ripple.gif)
# 使用
    1.在项目gradle中添加
    allprojects {
        repositories {
             ...
           maven { url 'https://jitpack.io' } 
        } 
    }
    2.添加依赖
     {
       implementation 'com.github.JadeKkang:ripplebutton:v1.0.1'
     }
    3.xml中使用<br>  
       <com.example.ripples.ripplebt
        android:id="@+id/bt"
        android:layout_width="match_parent"
        android:background="@color/colorAccent" 
        android:gravity="center"
        android:text="点我呀"
        android:textSize="18sp"
        android:textColor="#ffffff"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_height="50dp" />
# 自定义属性
| 属性 | 值 | 描述 | 
| circleColor |#26000000| 点击之后涟漪背景颜色 |  
# 点击回调

	1.setOnclick(click: OnClick)设按钮点击监听回调方法
