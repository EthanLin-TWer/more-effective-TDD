# bravo-tdd-test-driven-development [![][Badges: Travis CI]][Links: Travis CI]

我终于顿悟了，TDD 其实只是一种管理代码的方法论，犹如 GTD 之于时间管理，犹如 PKM 之于知识管理，而非决定代码质量的具体设计指导。

Github 里所有关于 TDD 的代码最后都会迁移到这个仓库来。既然 TDD 只是一个方法论，那么它的作用域就是帮你更快速、高效地写出好的代码。而具体如何写出好的代码，实不是 TDD 所能管辖的范围。

## 技术栈（Tech Stack）

* Java 8 & Lambda
* JUnit 5 with Mockito
* Gradle

## 运行项目

* 安装：`git clone git@github.com:linesh-simplicity/bravo-tdd-test-driven-development.git`
* 依赖安装：`./gradlew clean build --refresh-dependencies`
* 运行所有测试：`./gradlew clean junitPlatformTest`

## JUnit 5 配置参考

* [Junit 5 Gradle 插件示例代码](https://github.com/junit-team/junit5-samples/tree/master/junit5-gradle-consumer)
* [JUnit 5 官方文档](http://junit.org/junit5/docs/current/user-guide/)
* [Junit 5 With Mockito](https://github.com/junit-team/junit5-samples/tree/master/junit5-mockito-extension)



[Badges: Travis CI]: https://img.shields.io/travis/linesh-simplicity/bravo-tdd-test-driven-development.svg?maxAge=2592000
[Links: Travis CI]: https://travis-ci.org/linesh-simplicity/bravo-tdd-test-driven-development