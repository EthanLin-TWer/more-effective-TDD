# TDD 练习心得 [![][Badges: Travis CI]][Links: Travis CI]

> 对 TDD 的认识走过几个阶段。先是狂热，后是小小愤青，再到现在的更加客观平和，这期间的分水岭其实是大量的练习。从前大而空的问题和疑惑不复存在~~没脸再看~~，其实是些急功近利，而最近从练习中逐渐感受到基本功的威力。果如仝校长所说，**大道至简，坚持者寡**。已渐感大道之精之简，仍在坚持之中。这里留下我认为精简的关节，以及值得坚持练习的要点所在。
> 
> Oct 5, 2017

## TDD（不）是什么

关于 TDD 是什么及不是什么的问题，文字之辩未免无力，将目前的结论总结如下，请放到实践的视角下来看它。TDD 需要其他设施的支撑，如任务分解、自动化测试、重构等，这里厘清下它们关系：

* **任务分解** 是一种思维方法，以符合人脑思考（一次一件事）的方式帮你高效地拆分、跟踪问题，回答了「你怎么知道你做完了」这个问题
* **自动化测试** 是代码质量、团队交流的唯一保障，否则重构、保留业务知识等都不可能进行
* **TDD** 本身 **是一种快速反馈的工具**。同样验证一个任务，你可以去浏览器看实际效果，你可以用 mock 数据，也可以用先行的自动化测试，其本质在于追求极致的反馈速度

上一阶段的论断：TDD 只是一种管理代码的方法论，其问题域在于「帮你在明确了需求的前提下，更快速高效地产出好的代码」。如今看来总体是对的。需求明确这个事情依赖任务分解、kick-off 和个人经验等过程来快速得到反馈；更快速高效则是一个目标。

另外则是 TDD 不是什么的问题。大熊说，非彼无我，非我无所取。既然这个「我」是指「高效拆分问题、快速反馈、自动化验证」，那么「彼」自然是除此以外的所有东西，比如代码质量，比如设计质量。还是那句话，如果你不知道何谓好的代码，那你该去看书多撸码学习；如果你不知道什么是好的设计，自然别指望一种方法论能帮你学会设计本身。TDD 能做的是把你脑中之物更清晰地表达、更高效地实现出来，脑中若无物，正确方式应是赶紧补补。

## TDD 的关节 

我认为 TDD 其内涵不是也远广于类似「红绿循环」此类口诀，但关节要点却十分明快，无非两样技术：**任务分解** 与 **快速反馈**，其中每样技术都可辅以刻意练习的方式来提高。

### 任务分解

任务分解是 TDD 的前置条件，TDD 需要的测试用例要从这里来。新人刚拿到一个编程任务时，很容易陷入细节不知所止，或者觉得心里没底不知道怎么做，不知道要做多久。其本质上是对工作任务（及自己状态）的混沌、不可见。通过任务分解的方式，强迫你去将大的任务**完全穷尽**地分解成**独立**的子问题，最后所得列表即唯一确定地描述了工作任务本身，帮助你将内在混沌的思路可视化出来。

因此，如上所述，分解出来的任务需要符合这两个条件：

* 完全穷尽
* 彼此独立

只有（尽力地）保证你分解的任务列表完全、穷尽地描述了原问题域，你才能放心地将任务列表作为「工作是否完成」的**唯一标准**。这种信心将是这个工具发挥威力的保障，相信实践越多的同学体会越深；而彼此独立这个事情，才不会导致任务之间互相依赖、递归完成，反而增加复杂度。

在具体的分解方式上，主要有两种：模块化、基于接口（契约）的分解法，以及场景化的分解法。前者得到的列表类似函数式编程，后者可能适用更抽象、更模式化的场景应用。有时也会混用，具体关节只有实践之后具体问题具体交流。总之，无论采用什么方法，最终都是为了得到一个完全穷尽、相互独立的任务列表，请牢记此主旨。

在分解这个事情上，没有统一的做法，并且分解出来的任务也很依赖现有技术栈及规范等的实现，可以说它是一种游走于接口与实现之间的尺度。因此无唯一答案的特性，仝老师称其为一项艺术，而非科学。我则觉得这给个人发挥留下了空间，是其变化多端的魅力所在。类似下棋。

以下是我最近做的一个任务分解列表。里面有一些计时信息，这个我们后面「刻意练习」的部分再聊。

```markdown
* [ ]「订单记录」入口 - 30min:49min
  * [ ] 普通会员成功登陆后，应该看不到「招行产品」和「第三方产品」入口及「订单记录」标题 :34min 
  * [ ] 会员用户（审批岗和经办岗）成功登陆后，应能看到「招行产品」和「第三方产品」入口及「订单记录」标题
    * [ ] 两个入口均是可点击的 :9min 虚拟机挂球了运行不起来
    * [ ] 点击后将跳转到「预留订单」页
  * [ ] 行内会员成功登陆后，应该看不到「招行产品」和「第三方产品」入口及「订单记录」标题
  * [ ] + 重构一下 `Entry` 和 `Section`，至少搬个地方吧，把 styles 也都弄出去 :6min
* [ ] 「预留订单」页：对于能够查看到「招行产品」和「第三方产品」的会员用户来说： 340min 
  * [ ] header 的部分应显示标题「预留订单」- 2min 0min 
  * [ ] header 部分应显示一个「返回」按钮，点击后应该返回「我的」页面 - 2min 0min 框架自动完成 
  * [ ] 用户进入「预留订单」页时，应默认获取所有今日订单 - 15min
  * [ ] 「今日订单」 50min
    * [ ] 如果 API 返回的数据中有今日的订单，那么 45min 
      * [ ] 所有订单应显示成一个订单列表 - 10min
      * [ ] 订单列表应该有一个标题：「今日订单」 - 10min
      * [ ] 订单列表的每项应该包含如下信息：订单标题、预留额度、剩余时间、订单状态 - 5min 
      * [ ] 订单列表的每一项应该可以点击，点击后将跳转到该订单的「订单详情」页面 - 5min
      * [ ] 如果今日订单中有「预留成功」状态的订单，那么应该显示如下的 banner：「您有 ${n} 个待处理订单\n 请"会员经办岗"尽快登录招赢通网站发起购买」 - 10min
      * [ ] 如果今日订单中没有「预留成功」状态的订单，那么不显示上面的 banner - 5min
    * [ ] 如果 API 返回的数据中没有今日的订单，那么不显示订单列表，也不显示列表标题：「今日订单」 - 5min
  * [ ] 「最近七日订单」 120min
    * [ ] 在「今日订单」列表下面，应该显示一个「最近七日订单」按钮 - 5min
      * [ ] 点击按钮，应该获取最近七日订单，默认获取20条订单数据 - 10min
      * [ ] 若有最近七日的订单，则订单列表应显示一行标题：近7日的订单 - 5min
      * [ ] 若有最近七日的订单，应以订单列表的形式展现，每条订单项展示的信息内容为：订单标题、预留额度、剩余时间、订单状态 - 10min
      * [ ] 若有最近七日的订单，则订单列表的每一项都应是可以点击的，点击后跳转到该订单的「订单详情」页面 - 5min
      * [ ] 若无最近七日的订单，则不展示任何订单列表，也不展示标题：近7日的订单 - 5min
    * [ ] 点击「最近七日订单」按钮后： 25min
      * [ ] 若还有更多订单，则按钮依然显示，并且文字变为「加载更多订单」 - 20min
      * [ ] 若已没有更多订单，则按钮不显示 - 5min
    * [ ] 在「最近七日订单」按钮下面，应始终显示一行文字："如需查看全部订单，请登录招赢通网站"【待确认】，无论「最近七日订单」按钮是否显示 - 5min
    * [ ] 若点击了「加载更多订单」获取到更多的订单，应追加在原来列表的后面 - 25min
    * [ ] 若点击了「加载更多订单」获取到更多的订单，并且获取到原来重复的订单，则应进行去重，仅显示一条订单 - 25min
  * [ ] 订单加载效果： 25min
    * [ ] 无论刚进入页面正在获取「今日订单」时，还是点击了「最近七日订单」在获取最近订单时，页面均应显示 loading 效果 - 20min
    * [ ] 加载结束后，应该取消显示效果 - 5min
  * [ ] 预留额度处时钟效果： 125min
    * [ ] 时钟应该能实时变化 - 90min
    * [ ] 如果用户停留在界面期间订单剩余时间走完了，此时「预留成功」状态不会实时改变，可以仍然是「预留成功」，样式也不需发生变化 - 5min
    * [ ] 基于上一小条的情况下，如果用户点击了该订单，跳转到了「订单详情」页并从详情页点击「返回」再次回到「预留订单」页面，此时应看到这条订单状态已经变为「已实效」，同时剩余时间与订单状态的样式均有改变 - 30min
* [ ] 「订单详情」页 42min
  * [ ] 用户进入「订单详情」页时，应获取该订单的详情 - 20min
  * [ ] header 部分应显示标题「订单详情」 - 2min 
  * [ ] header 部分应显示一个「返回」按钮，点击后应该返回「预留订单」页面 - 5min
  * [ ] 订单详情页应该显示该订单的如下信息：订单标题、额度预留剩余时间、产品代码、产品简称、预留额度、付款账户、状态、经办人、产品类型、开户行、户名、发起时间 - 15min
  * [ ] 订单详情页处处不可点击 - 0min
* [ ] 以上「订单记录」、「预留订单」及「订单详情」任务列表对于「招行产品」和「第三方产品」均一致 - 120min 重构
* [ ] 样式 - 120min
  * [ ] 「招行产品」、「第三方产品」入口样式
  * [ ] 「预留订单」页样式
  * [ ] 「订单详情」页样式
```

## 快速反馈

待写。

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


[Badges: Travis CI]: https://travis-ci.org/linesh-simplicity/elegant-TDD.svg?branch=master
[Links: Travis CI]: https://travis-ci.org/linesh-simplicity/elegant-TDD
