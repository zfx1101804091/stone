## 代码规范
### 1、包名统一为 org.stone



## 遇到的问题
### a.logback.xml配置问题
`生成的日志报错springAppName_IS_UNDEFINED，
 在spring环境的加载顺序是先bootstrap.yml(或bootstrap.properties),再加载application.yml。如果配过springCloud config的朋友应该能有体会，动态扩容、公共配置啊之类的，就是在bootstrap预先加载的
 logback-spring.xml（注意，有时文件名配不好也会报错，比如配成logback.xml）`