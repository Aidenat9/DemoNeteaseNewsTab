# DemoNeteaseNewsTab
viewPagerIndicator的使用demo,one simple sample
  *写完最后记得在清单文件里配置activity的主题和label,或者修改application的主题样式,
   * 默认的主题样式PageIndicatorDefaults
   
   viewPager.setAdapter(adapter);
        //实例化TabPageIndicator然后设置ViewPager与之关联
        indicator.setViewPager(viewPager);
        //如果我们要对ViewPager设置监听，用indicator设置就行了
        indicator.setOnPageChangeListener(pageListener);
