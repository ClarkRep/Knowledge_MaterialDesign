# Material Design
@(Material Design)

***
## 什么是Material Design?

Android一开始充满着旧Google时代的风格：自由、放任。开发者可以任意上传自己的应用，而不必通过审核；开发者可以随意按照自己的想法设计应用，Google方面不予任何限制。可以说，Android一开始就是一片Google开辟的荒地，他允许每个人都可以随意使用，结果是所有人都各行其是，让这块荒地乱糟糟的。直到Android 4.0，从Palm跳槽到Google担任Android用户体验副总裁的马蒂亚斯·杜瓦迪（Matias Duarte）上任后，才真正提出设计指导。  
在Google I/O 2014大会上，Google非常高调的宣布了Material Design(原质化设计)这一设计语言。杜瓦迪说，“不应该为不同的屏幕规格创建不同的产品，而是使用一种统一的设计方法开发一款可以跨多种屏幕的产品：桌面、智能手机、车载解决方案、智能手表。当人们整天都在所有这些不同的屏幕之间切换时，他们应该能够继续使用一个特定的程序。这点不仅适用于产品的视觉外观，也适用于其功能集。如果一个人开发了一个打车应用程序，而它能在7英寸的屏幕上运行，但不能在2英寸的屏幕上运行，这是不行的。”

### 目标
* 希望创造一种新的视觉设计语言，能够遵循优秀设计的经典定则，同时还伴有创新理念和新的科技。
* 希望创造一种独一无二的底层系统，在这个系统的基础之上，构建跨平台和超越设备尺寸的统一体验。遵循基本的移动设计定则，同时支持触摸、语音、鼠标、键盘等输入方式。

### 设计原则
* 实体感
Material Design不再让像素处于同一个平面，而是让它们按照规则处于空间当中，具备不同的维度。按照Wired的话来说，那就是让像素具备海拔高度，这样子的话，系统的不同层面的元素，都是有原则、可预测的，不让用户感到无所适从，也避免开发者担心因为不同的视觉风格而产生冲突。
* 鲜明、形象、深思熟虑
对于现实世界中的隐喻，Material Design更加倾向于用色彩来提示。我们按下屏幕当中的按钮时，可以看到按钮颜色迅速发生变化，向石头投入湖面一样，产生了一波涟漪。杜瓦迪这样设计是因为Material Design中的按钮都处于一个平面，不再突起，因此它必须采用和以往不同的表示方法，以表明自己已经被按下。
* 有意义的动画效果
动效应当在独立的场景呈现。通过动效，让物体的变化以更连续、更平滑的方式呈现给用户，让用户能够充分知晓所发生的变化。
Material Design规范了Android的运动元素，让按钮的弹入弹出，卡片的滑入滑出以及从一个界面变化成另一个界面的方法（比如从介绍一首歌的界面到控制播放的界面），都是秩序的、深思熟虑过的。Material Design中只有在高亮动作以及改变交互状态时，才会使用运动元素来表示。

## Material Design在Android上的应用
通过上面的简单介绍，可以知道Material Design是一套设计语言，这套设计语言可以应用在手机、PC、穿戴设备等等上面。当然也可以在IOS上面使用这种设计方案，当然IOS有他自己的一套设计方案，所以现在Materail Design最大的应用场景就是Android系统。
所以在Android5.0系统的发布的同时，Android也更新了一个support库：

> com.android.support:design:x.x.x   

里面提供了一些搭配Material Design设计方案来使用的控件，我们可以打开一下扩展包来看看提供了哪些控件：

![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/MaterialDesign.png)

可以看到design扩展包为我们提供了一些搭配Material Design模式使用的控件，当然这些控件也不是强制要求符合Material Design设计模式，也可根据特定的需求自己搭配，下面将会介绍这些控件的使用方式和效果。

### 1.CoordinatorLayout
> 官方描述
> CoordinatorLayout is a super-poweredFrameLayout.
> CoordinatorLayout is intended for two primary use cases:
> 1. As a top-level application decor or chrome layout
> 2. As a container for a specific interaction with one or more child views

从这里我们可以知道：CoordinatorLayout是一个增强版的FrameLayout，它可以协调一个或多个子View的交互，控制手势的滚动技巧，通常作为顶级View来使用。
这个控件非常强大，可以配合design扩展库的很多控件实现联动效果：比如配合AppbarLayout实现标题栏的收缩；配合SnackBar实现Snackbar的滚动消除；Snackbar和FloatingActionButton的联动效果；自定义behavior实现自定义的联动效果等等。
* 来看一下顶级布局是FrameLayout的效果：

![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/Snackbar1.gif)

* 再看看顶级布局是CoordinatorLayout的效果：

![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/Snackbar2.gif)

### 2.FloatingActionButton
顾名思义，FloatingActionButton就是一个浮动的按钮，它是一个带有阴影效果的圆形按钮，下面介绍一下它的一些属性：
* app:backgroundTint： 默认FloatingActionButton 的背景色是应用主题的 colorAccent，通过这个属性可以改变FloatingActionButton的背景颜色。
* app:fabSize：用来改变FloatingActionButton的大小。
* android:src：用来改变drawable。
* app:rippleColor：点击FloatingActionButton的时候，FloatingActionButton的变换效果。
* app:borderWidth：FloatingActionButton的变宽宽度。
* app:elevation：**普通状态**FloatingActionButton的阴影深度。
* app:pressedTranslationZ：**点击状态**FloatingActionButton的阴影深度。

### 3.Snackbar
Snackbar是通过在屏幕底部展示的简洁信息（有些Android手机屏蔽了Toast，可以通过Snackbar来替代Toast的提示）。
Snackbar是的对象是通过两个静态方法来生成的：
```
public static Snackbar make(@NonNull View view, @NonNull CharSequence text,@Duration int duration)

public static Snackbar make(@NonNull View view, @StringRes int resId, @Duration int duration)
```
通过它的生成方法，可以看到Snackbar的生成必须依赖一个View，这个View是该布局内的任何一个View，因为它会通过findSuitableParent(View view)方法来找到该界面的CoordinatorLayout，如果没有找到CoordinatorLayout，则会找到id为android.R.id.content（这个View也就是顶级DecorView -> LinearLayout -> content）。  
Snackbar在界面上只能存在一个，如果出现新的Snackbar，则会将上一个Snackbar顶掉，不会同时存在两个或两个以上的Snackbar。

![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/Snackbar3.gif)

Snackbar有个消失的回调监听Snackbar.Callback，在该监听的onDismissed( )方法中有个event参数，它对应Snackbar五种消失状态：
```
@Override
        public void onDismissed(Snackbar transientBottomBar, int event) {
            super.onDismissed(transientBottomBar, event);
            /*
            0 - via a swipe：如果父布局是CoordinatorLayout，Snackbar右滑可以消失。
            1 - via an action click：Snackbar点击事件，可以消失。
            2 - via a timeout：Snackbar时间到了消失。
            3 - via a call to {@link #dismiss()}：Snackbar触发了dismiss消失，如：Activity销毁。
            4 - a new Snackbar being shown：当一个新的Snackbar显示的时候，导致这个Snackbar消失。
             */
        }
```

### 4.AppbarLayout
AppbarLayout继承自LinearLayout，使用AppbarLayout可以让包含在其中的子控件能够响应被标记了ScrollingViewBehavior的View的滚动事件（需要配合CoordinatorLayout来实现效果）。
AppbarLayout提供了5种滚动标识给子View使用（子View使用app:layout_scrollFlags对应的属性参数）。
* scroll：将此布局和滚动事件关联（注意：这个标识要在其他标识之前，没有这个标识则布局不会滚动，并且其他标识设置无效）；
* enterAlways：这个标识通常被称为"快速返回"模式，其实就是向下滚动时Scrolling View和Child View之间滚动优先级问题 （对比scroll和scroll|enterAlways设置 - 向下滚动时：前者Scrolling View优先于Child View滚动；后者Child View优先于Scrolling View滚动）；
* enterAlwaysCollapsed：enterAlways的附加值。这里涉及到Child View的高度和最小高度，向下滚动时，Child View先向下滚动最小高度值，然后Scrolling View开始滚动，当Scrolling View滚动到界时，Child View再向下滚动，直至显示完全。
* exitUntilCollapsed：这里也涉及到最小高度。向上发生滚动事件的时候，Child View向上滚动退出直至最小高度，然后Scrolling View开始滚动。也就是说，Child View不会完全退出屏幕；
* snap：简单理解，就是Child View滚动比例的一个吸附效果。也就是说，Child View不会存在局部显示的情况，要么完全显示，要么完全隐藏。

参考以下布局结构
```
<CoordinatorLayout>
	<AppBarLayout
		android:minHeight="50dp"
		app:layout_scrollFlags="对应以上5种模式"
	>
		<FrameLayout>
			<LinearLayout>
				<TextView android:text="Alpha更好更强大"/>
				<ImageView/>
				<!--注意这里的layout_height="50dp"是和AppBarLayout的minHeight="50dp"对应的-->
				<TextView android:layout_height="50dp"/>
			</LinearLayout>
		</FrameLayout>
	</AppBarLayout>
	<RecyclerView
		app:layout_behavior="@string/appbar_scrolling_view_behavior"
	/>
</CoordinatorLayout>				
```
来看一下5中模式都有什么样的效果
1. scroll  
![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/AppBarLayout_scroll.gif)

2. enterAlways  
![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/AppBarLayout_enterAlways.gif)

3. enterAlwaysCollapsed  
![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/AppBarLayout_enterAlwaysCollapsed.gif)

4. exitUntilCollapsed  
![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/AppBarLayout_exitUntilCollapsed.gif)

5. snap  
![](https://github.com/zdy793410600/Knowledge_MaterialDesign/blob/master/AppBarLayout_snap.gif)

通过以上的gif图可以看出来AppBarLayout的5模式态分别有对应的效果，所以你可以根据具体要实现什么样的效果选择对应的模式。

## 总结
Material Design是Google为了统一不同设备的交互效果，提高用户体验的所推出的一套设计语言，它对于界面的设计有非常严格的要求，但是目前国内还没有多少款App严格按照Material Design的设计规范，甚至有很多模仿的不伦不类。所以这篇文章仅仅为大家提供一些参考。当然design库所提供的控件在Android工程师的日常工作中使用的概率还是非常大的，以上暂且介绍了design扩展库的一部分常用控件以及各种效果，希望能为你提供一些灵感和帮助。

## 参考资料
* [Material Design 中文版](http://wiki.jikexueyuan.com/project/material-design/)
