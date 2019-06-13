# SelenJA  

# 简介
基于selenium+testng 的UI自动化测试框架，使用Jenkins来跑自动化用例，并在Jenkins中使用了Allure插件来显示测试报告

# 技术栈
  - Java
  - maven
  - selenium
  - testng
  - allure
  - Jenkins

# 优点
- 封装selenium对元素、浏览器的操作，使用起来更简单
- 使用PageObject模式对页面元素和公共操作进行封装
- 环境信息通过读取配置文件获取
- 失败用例重跑
- 使用allure显示测试报告，提供失败截图、操作步骤、期望结果
