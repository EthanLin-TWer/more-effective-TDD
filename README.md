# TDD 练习心得 [![][Badges: Travis CI]][Links: Travis CI]

> Oct 5, 2017
> 
> 对 TDD 的认识走过几个阶段。先是狂热，后是小小愤青，再到现在的更加客观平和，这期间的分水岭其实是大量的练习。从前大而空的问题和疑惑不复存在~~没脸再看~~，其实是些急功近利，而最近从练习中逐渐感受到基本功的威力。果如仝校长所说，**大道至简，坚持者寡**。已渐感大道之精之简，仍在坚持之中。这里留下我认为精简的关节，以及值得坚持练习的要点所在。

## TDD（不）是什么

关于 TDD 是什么及不是什么的问题，文字之辩未免无力，将目前的结论总结如下，请放到实践的视角下来看它。TDD 需要其他设施的支撑，如任务分解、自动化测试、重构等，这里厘清下它们关系：

* **任务分解** 是一种思维方法，以符合人脑思考（一次一件事）的方式帮你高效地拆分、跟踪问题，回答了「你怎么知道你做完了」这个问题
* **自动化测试** 是代码质量、团队交流的唯一保障，否则重构、保留业务知识等都不可能进行
* **TDD** 本身 **是一种快速反馈的工具**。同样验证一个任务，你可以去浏览器看实际效果，你可以用 mock 数据，也可以用先行的自动化测试，其本质在于追求极致的反馈速度

上一阶段的论断：TDD 只是一种管理代码的方法论，其问题域在于「帮你在明确了需求的前提下，更快速高效地产出好的代码」。如今看来总体是对的。需求明确这个事情依赖任务分解、kick-off 和个人经验等过程来快速得到反馈；更快速高效则是一个目标。

另外则是 TDD 不是什么的问题。大熊说，非彼无我，非我无所取~~此乃强行引用~~。既然这个「我」是指「高效拆分问题、快速反馈、自动化验证」，那么「彼」自然是除此以外的所有东西，比如代码质量，比如设计质量。还是那句话，如果你不知道何谓好的代码，那你该去看书多撸码学习；如果你不知道什么是好的设计，自然别指望一种方法论能帮你学会设计本身。TDD 能做的是把你脑中之物更清晰地表现、更高效地实现出来，脑中若无物，正确方式应是赶紧补补。

## TDD Techniques 

### Tasking 任务分解

Tasking 是 TDD 的第一步，你拿到需求了，明确了，如何把任务分解？分解到什么粒度？这个 「stackoverflow的帖子」(http://stackoverflow.com/questions/34086509/should-we-give-concrete-examples-when-tasking-in-tdd) 非常有助于理解：即我究竟是仅分解到逻辑上独立的任务即可，还是需要尽可能详细的测试数据？

回答是，**分解到逻辑上自治的任务即可，确保它们就是且仅是完全需求所需的最少步骤，并且相互之间尽可能独立没有依赖**。把详细的用例分解留到测试驱动的阶段来做。

### Verifiable ACs 可验收的 AC

做完上面一步，我们可以进一步把每个 task 分解成一系列可以验收的测试数据。这样这些 AC 描述了被分解的任务，同时也可以提供 input/output，这样测试用例也就出来了。开始 TDD 就可以了。

分解得到的任务，何者先做？我之前也思考并在博客回答过这个问题：技术上，无所谓，因为有 mock 技术，任务之间是互不影响的；价值上，业务需求价值高的任务先做，自己想要做的先做。

### Tasking/Todolist as Code 任务分解即代码

借用了 CI/CD 的说法：基础设施即代码。使用 JUnit 5 的 `@Nested` 特性，你可以把代码外的 tasking/列todolist 直接映射到代码层来。你不必等到所有测试用例出来以后才开始写代码，相反在得到任务列表之后就已经可以开始使用代码 `@Todo` 来描述了；而正在进行中的任务可以使用 `@Tasking` 来注解，用于标识其下的所有测试用例都归属于这个任务。你可以参考 [这个](https://github.com/linesh-simplicity/tdd-methodology-and-deliberate-practice/blob/master/src/test/java/org/thoughtworks/linesh/fizzbuzzwhizz/StudentTest.java) 测试类。

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
* Checkstyle & Cobertura

## 运行项目

* 安装：`git clone git@github.com:linesh-simplicity/tdd-methodology-and-deliberate-practice.git`
* 依赖安装：`./gradlew clean build --refresh-dependencies`
* 运行 checkstyle：`./gradlew check`
* 运行所有测试：`./gradlew clean junitPlatformTest`
* 运行覆盖率检查：`./gradlew clean coberturaCheck test`

## 参考

### TDD 体系最精华资料

* [Kent Beck: Test Driven Development by Example](https://book.douban.com/subject/1230036/)
* [伍斌：驯服烂代码](https://book.douban.com/subject/26208707/)
* [GoF：设计模式-可复用面向对象软件的基础](https://book.douban.com/subject/1052241/)
* [Martin Fowler/Jeff Xiong：重构-改善既有代码的设计](https://book.douban.com/subject/4262627/)
* [Joshua Kerievsky：重构与模式](https://book.douban.com/subject/20393327/)
* [Robert C.Martin：代码整洁之道](https://book.douban.com/subject/4199741/)

### 论战

* [TDD 并不是看上去的那么美 - CoolShell](http://coolshell.cn/articles/3649.html)
* [虚拟座谈会：TDD 有多美 - infoq](http://www.infoq.com/cn/articles/virtual-panel-tdd)
* [Todd Wei: TDD 到底美不美 - cnblogs](http://www.cnblogs.com/weidagang2046/archive/2011/02/23/1963277.html)
* [逸言: 推行 TDD 的思考](http://agiledon.github.io/blog/2013/12/25/thought-about-applying-tdd/)
* Martin Fowler&Kent Beck&DHH: Is TDD Dead? Series
    * [Is TDD Dead? Part I](https://www.youtube.com/watch?v=z9quxZsLcfo)
    * [Is TDD Dead? Part II](https://www.youtube.com/watch?v=JoTB2mcjU7w)
    * [Is TDD Dead? Part III](https://www.youtube.com/watch?v=YNw4baDz6WA)
    * [Is TDD Dead? Part IV](https://www.youtube.com/watch?v=dGtasFJnUxI)
    * [Is TDD Dead? Part V & VI](https://www.youtube.com/watch?v=gWD6REVeKW4)

### JUnit 5

* [Junit 5 Gradle 插件示例代码](https://github.com/junit-team/junit5-samples/tree/master/junit5-gradle-consumer)
* [JUnit 5 官方文档](http://junit.org/junit5/docs/current/user-guide/)
* [Junit 5 With Mockito](https://github.com/junit-team/junit5-samples/tree/master/junit5-mockito-extension)
* [Intellij 2016.3.1 RC: Support for JUnit 5 M3](https://blog.jetbrains.com/idea/2016/12/intellij-idea-2016-3-1-is-out/)。JUnit 5 M3 是11月30号发布的版本，由于其包含了不向下兼容的 API 改变，同时间 Intellij 并不能支持运行 JUnit 5 M3 的测试。12月1号这个问题被加入[Issue Tracker](https://youtrack.jetbrains.com/issue/IDEA-164865)，12月2号在2016.3.1 2017.1版本中修复，12月13号在2016.3.1 RC 这个发布版中开始支持 JUnit 5 M3。即是说，2016.3.1 RC 以后的 Intellij 版本才能使用 JUnit 5 M3；若要使用 JUnit 5 M2 及之前版本，必须切回到 2016.3 或以前的 Intellij 版本。

### Misc

* [使用 shields.io 创建 Travis 图标](http://shields.io/)
* [如何使用 travis 提供的 badges 图标](https://docs.travis-ci.com/user/status-images/)


[Badges: Travis CI]: https://travis-ci.org/linesh-simplicity/TDD-methodology-and-deliberate-practice.svg?branch=master
[Links: Travis CI]: https://travis-ci.org/linesh-simplicity/TDD-methodology-and-deliberate-practice
