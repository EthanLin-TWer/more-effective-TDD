# bravo-tdd-test-driven-development [![][Badges: Travis CI]][Links: Travis CI]

## TDD 是什么 及其 核心

我终于顿悟了，TDD 其实只是一种管理代码的方法论，犹如 GTD 之于时间管理，犹如 PKM 之于知识管理，而非决定代码质量的具体设计指导。

Github 里所有关于 TDD 的代码最后都会迁移到这个仓库来。既然 TDD 只是一个方法论，那么它的问题域就是**帮你在明确了需求的前提下，更快速、高效地写出好的代码**。其核心是**快速反馈**、**无用代码一行都不多写**，通过减少无效代码（非需求代码）及长反馈周期带来的时间浪费，以此提升撸码过程的效率。

## TDD 不是什么

因此，TDD 不能帮你明确需求（如果你不知道如何明确需求），也不能帮你写出好的代码（如果你本来就不知道如何写好代码、不知道设计）；TDD 能做的，是在你的需求基本明确的情况下，通过 tasking 的辅助方式，让你更专注地完成有效任务；而关于代码质量和设计，TDD 无法也本来就不是这方面的工具。

TDD 中产出的测试确实能作为重构的基础保障，但这只是附加价值，并非采用 TDD 的核心动机。代码质量，需要通过整洁代码、设计模式等来长期维护。

## TDD Techniques 

### Tasking 任务分解

Tasking 是 TDD 的第一步，你拿到需求了，明确了，如何把任务分解？分解到什么粒度？这个 「stackoverflow的帖子」(http://stackoverflow.com/questions/34086509/should-we-give-concrete-examples-when-tasking-in-tdd) 非常有助于理解：即我究竟是仅分解到逻辑上独立的任务即可，还是需要尽可能详细的测试数据？

回答是，**分解到逻辑上自治的任务即可，确保它们就是且仅是完全需求所需的最少步骤，并且相互之间尽可能独立没有依赖**。把详细的用例分解留到测试驱动的阶段来做。

### Verifiable ACs 可验收的 AC

做完上面一步，我们可以进一步把每个 task 分解成一系列可以验收的测试数据。这样这些 AC 描述了被分解的任务，同时也可以提供 input/output，这样测试用例也就出来了。开始 TDD 就可以了。

分解得到的任务，何者先做？我之前也思考并在博客回答过这个问题：技术上，无所谓，因为有 mock 技术，任务之间是互不影响的；价值上，业务需求价值高的任务先做，自己想要做的先做。

### Tasking/Todolist as Code 任务分解即代码

借用了 CI/CD 的说法：基础设施即代码。使用 JUnit 5 的 `@Nested` 特性，你可以把代码外的 tasking/列todolist 直接映射到代码层来。你不必等到所有测试用例出来以后才开始写代码，相反在得到任务列表之后就已经可以开始使用代码 `@Todo` 来描述了；而正在进行中的任务可以使用 `@Tasking` 来注解，用于标识其下的所有测试用例都归属于这个任务。你可以参考 [这个](https://github.com/linesh-simplicity/bravo-tdd-test-driven-development/blob/master/src/test/java/org/thoughtworks/linesh/fizzbuzzwhizz/StudentTest.java) 测试类。

### Refactor: Todo system with Intellij 重构：巧用 Intellij TODO 系统

## Key&Methods of design 设计的道与术

怎么样算是好的设计呢？首先要问，为什么要设计，它旨在解决/应对什么问题？回答是，**变化**。其实整个 TDD 的核心理念基础，也是认定变化必然、频繁存在。因此我们通过**减少无效未来需求**和**减少变化发生时带来的变更成本**两种方式来应对。TDD 顺便解决了第一个问题，而设计则是为了要解决第二个问题。

### The key of design 设计之道

那么，如何减少变化发生时带来的变更成本呢？目前软件工程普遍认可的一种方式是：**每次修改只改动与变化相关的地方**。这就必然要求软件模块之间高内聚、低耦合，基于这种认知，目前的5条 [SOLID](https://www.wikiwand.com/en/SOLID_(object-oriented_design)) 原则可以认为是整个设计模式体系的提纲挈领：

* Single Responsibility Principle: 单一职责原则。 
* Open-Closed Principle: 开闭原则。
* Dependency Inversion Principle: 依赖倒转原则。
* Interface Segregation Principle: 接口隔离原则。
* Liskov Substitution Principle: 里氏替换原则。

其要义均是隔离变化，尽量使每个模块（单元/类/方法）职责单一、相互独立，只有一个改变的理由。

### The method of design 设计之术

* 重构
* 设计模式

## Confusion

* TDD 只是个人的方法论工具吗？对项目来说有无其价值？
* 何时查看 Todolist？
* 是否需要做到 每次实现刚好实现测试代码？意义？这是否意味着清晰知道测试的边界？

## 技术栈（Tech Stack）

* Java 8 & Lambda
* JUnit 5 with Mockito
* Gradle 3.2.1(With gradle daemon enabled by default)

## 运行项目

* 安装：`git clone git@github.com:linesh-simplicity/bravo-tdd-test-driven-development.git`
* 依赖安装：`./gradlew clean build --refresh-dependencies`
* 运行 checkstyle：`./gradlew check`
* 运行所有测试：`./gradlew clean junitPlatformTest`

## 参考

### TDD 体系最精华资料

* [Kent Beck: Test Driven Development by Example](https://book.douban.com/subject/1230036/)
* [伍斌：驯服烂代码](https://book.douban.com/subject/26208707/)
* [Martin Fowler/Jeff Xiong：重构-改善既有代码的设计](https://book.douban.com/subject/4262627/)
* [GoF：设计模式-可复用面向对象软件的基础](https://book.douban.com/subject/1052241/)

### 论战

* [TDD 并不是看上去的那么美 - CoolShell](http://coolshell.cn/articles/3649.html)
* [虚拟座谈会：TDD 有多美 - infoq](http://www.infoq.com/cn/articles/virtual-panel-tdd)
* [Todd Wei: TDD 到底美不美 - cnblogs](http://www.cnblogs.com/weidagang2046/archive/2011/02/23/1963277.html)
* [逸言: 推行 TDD 的思考](http://agiledon.github.io/blog/2013/12/25/thought-about-applying-tdd/)
* [Martin Fowler&Kent Beck&DHH: Is TDD Dead?](https://www.youtube.com/watch?v=z9quxZsLcfo)

### JUnit 5

* [Junit 5 Gradle 插件示例代码](https://github.com/junit-team/junit5-samples/tree/master/junit5-gradle-consumer)
* [JUnit 5 官方文档](http://junit.org/junit5/docs/current/user-guide/)
* [Junit 5 With Mockito](https://github.com/junit-team/junit5-samples/tree/master/junit5-mockito-extension)
* [Intellij Support for JUnit 5 M3](https://youtrack.jetbrains.com/issue/IDEA-164865)。JUnit 5 M3是两天前刚出来的版本（11月30号），上面这个 issue 是12月1号在 Intellij tracker 上被提出的，12月2号在2016.3.1 2017.1版本中修复。现在还未能使用到修复版，只有静待下一版发布

### Misc

* [使用 shields.io 创建 Travis 图标](http://shields.io/)
* [如何使用 travis 提供的 badges 图标](https://docs.travis-ci.com/user/status-images/)



[Badges: Travis CI]: https://travis-ci.org/linesh-simplicity/bravo-tdd-test-driven-development.svg?branch=master
[Links: Travis CI]: https://travis-ci.org/linesh-simplicity/bravo-tdd-test-driven-development
