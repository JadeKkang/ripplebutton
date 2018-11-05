# 说明
这是Kotlin代码，初次自定义view代码
# 效果展示
![](https://github.com/JadeKkang/ripplebutton/blob/master/image/ripple.gif)
# 使用
1.在项目gradle中添加<br>  
allprojects {<br> 
repositories {<br> 
...<br> 
maven { url 'https://jitpack.io' }<br> 
}<br> 
}<br> 
2.添加依赖<br> 
 {implementation 'com.github.JadeKkang:ripplebutton:v1.0'}<br> 
3.xml中使用<br>  
<com.example.ripples.ripplebt<br> 
        android:id="@+id/bt"<br> 
        android:layout_width="match_parent"<br> 
        android:background="@color/colorAccent"<br> 
        android:gravity="center"<br> 
        android:text="点我呀"<br> 
        android:textSize="18sp"<br> 
        android:textColor="#ffffff"<br> 
        android:layout_marginLeft="20dp"<br> 
        android:layout_marginRight="20dp"<br> 
        android:layout_marginTop="20dp"<br> 
        android:layout_height="50dp" /><br> 
# 自定义属性
| 属性 | 值 | 描述 | 
| ------------- |:-------------:| -----:| 
| circleColor |#26000000| 点击之后涟漪背景颜色 |  
# 点击回调

	1.setOnclick(click: OnClick)设按钮点击监听回调方法
