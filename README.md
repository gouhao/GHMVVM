# GHMVVM
基于DataBinding的MVVM框架
ActivityView:界面布局，包含了标题栏，目前支持两种,一种是Android自带的Toolbar,一种是自定义的标题栏。子类添加的布局就是给这个View中添加
ActivityModel:界面的业务逻辑都要继承这个类
ActivityDataBinding:VM实体，这是由编译器自动生成的类