# UI-

##1.利用SimpleAdapter实现如下界面效果：
</br>
![exp4_01](https://github.com/Xiaohui-Song/UI-/blob/main/pic/exp1.png)<br>
(1)利用SimpleAdapter创建ListView实现整体布局，大体思路如下：<br>
a.设定一个布局文件添加对应控件并赋ID，创建一个用嵌套Map集合的List集合（注意Map的键要求为Strnig）<br>
b.通过循环将数据放到HashMap中，再将HashMap添加到List集合中<br>
c.创建一个SimpleAdapter（要理解SimpleAdapter5个参数的含义）<br>
	-> 第一个参数:上下文(当前的Activity)<br>
  ->第二个参数:一个嵌套Map集合类型的list集合数据源（刚才放数据的List集合）<br>
  ->第三个参数:这个是你设定用于接收Map-Object类型的Activity,这个布局中必须包括了to中定义的控件id<br>
  ->第四个参数:第四个参数是一个键值的字符串数组（循环中，数据放入HashMap中自己定义的键值）<br>
  ->第五个参数:第五个参数是一个与K值匹配的的控件对象（int resource布局中组件的id，要与第四个参数一一对应）<br>
d.实例化Listview，通过setAdapter装配数据到布局页面。<br>
(2)通过setOnItemClickListener设置响应<br>
a.使用Toast显示提示框<br>
b.利用position和自己定义一个int型属性，判断当前点击位置和上一个点击位置，通过setBackgroundColor改变当前点击item颜色和恢复上一个点击item的颜色<br>
最后效果如下图所示：<br>
![1](https://github.com/Xiaohui-Song/UI-/blob/main/pic/1.png)<br>

##2.创建如图所示的自定义对话框
</br>
![exp4_02](https://github.com/Xiaohui-Song/UI-/blob/main/pic/exp2.png)<br>
(1)实现自定义对话框，先将自定义对话框的图片，输入框写到一个布局中<br>
(2)activity中调用编写一个函数，函数中实例化AlertDialog.Builder对象，对象调用setView方法，接受自己编写的布局，作为对话框的内容，
setPositiveBuuton和setNegativeButton为对话框设置一个Cancel和Sign in按钮<br>
(3)setContentView显示一个按钮界面，按钮绑定编写的函数，实现点击后显示自定义的对话框<br>
最后效果如下图所示：<br>
![2.1](https://github.com/Xiaohui-Song/UI-/blob/main/pic/2.1.png)<br>
![2.2](https://github.com/Xiaohui-Song/UI-/blob/main/pic/2.2.png)<br>

##3.使用XML定义菜单
</br>
![exp4_02](https://github.com/Xiaohui-Song/UI-/blob/main/pic/exp3.png)<br>
(1)创建自定义菜单,定义菜单项标识<br>
(2)重写Activity的onCreateOptionsMenu(Menu menu)方法，方法中调用Menu对象的add方法添加菜单项和子菜单项(注意其中的4个参数）<br>
	->第一个参数为:主id<br>
	->第二个参数为:菜单id（自己定义的菜单项标识）<br>
	->第三个参数为:顺序，都为0则按先后顺序显示<br>
	->第四个参数为:菜单项内容<br>
(3)重写Activity中的onOptionsItemSelected(MenuItem mi)方法，响应菜单点击事件，利用getItemId()获取点击的菜单id以及Switch case判断所点击的菜单以及所做出的响应<br>
最后效果如下图所示：<br>
菜单项<br>
![3.1](https://github.com/Xiaohui-Song/UI-/blob/main/pic/3.1.png)<br>
字体大小子菜单<br>
![3.2](https://github.com/Xiaohui-Song/UI-/blob/main/pic/3.2.png)<br>
改变字体大小<br>
![3.3](https://github.com/Xiaohui-Song/UI-/blob/main/pic/3.3.png)<br>
改变文字颜色<br>
![3.4](https://github.com/Xiaohui-Song/UI-/blob/main/pic/3.4.png)<br>
显示提示框<br>
![3.5](https://github.com/Xiaohui-Song/UI-/blob/main/pic/3.5.png)<br>

##4.创建如图模式的上下文菜单
</br>
！[exp4_04](https://github.com/Xiaohui-Song/UI-/blob/main/pic/exp4.png)<br>
(1)界面同理第一个实验，利用SimpleAdapter创建ListView实现整体布局<br>
(2)setOnItemClickListener实现点击一个按钮变色，再次点击后恢复原色<br>
(3)在ListView中启动批处理上下文操作，实现 AbsListView.MultiChoiceModeListener 接口，并使用 setMultiChoiceModeListener() 为视图组设置该接口。
在侦听器的回调方法中，实现在上下文中显示选中的item个数<br>
最后效果如下图所示：<br>
![4](https://github.com/Xiaohui-Song/UI-/blob/main/pic/4.png)<br>

##问题及解决
</br>
(1)如何启动另一个activity:创建新的activity后会在AndroidManifest自动生成相关代码，在其中添加android:supportsRtl="true"后，右键目标activity点击run<br>
(2)启动虚拟机标题栏消失:在AndroidManifest对应的activity中添Androidandroid:theme="@style/AppTheme"保持系统默认<br>
