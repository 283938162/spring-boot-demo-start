# SpringBoot入门

## 切换配置
在idea中的resources文件中
3个配置文件：
核心配置文件：application.properties
开发环境用的配置文件：application-dev.properties
生产环境用的配置文件：application-pro.properties
这样就可以通过application.properties里的spring.profiles.active 灵活地来切换使用哪个环境了


## 热部署


crtl+shift+f9 手动刷新idea控制台