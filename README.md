# More Effective TDD

## 本仓库有什么

本仓库主要提供两样东西：一系列可供刻意练习TDD的kata，以及一个布道者和实践者在真实软件项目中的实践心得。

<details>
  <summary>本仓库翻新中，进度18%。。。点我查看详情</summary>
  <ul>
    <li>✅ 更新导语</li>
    <li>🚧 翻新实践部分</li>
    <li>✅ 翻新资料引用部分</li>
    <li>🚧 修一下挂掉的测试</li>
    <li>🚧 编写TypeScript实践指引</li>
    <li>🚧 录制TypeScript FizzBuzz视频</li>
    <li>🚧 编写Java实践指引</li>
    <li>🚧 录制Java FizzBuzz视频</li>
    <li>🚧 翻新仓库里的TS项目配置</li>
    <li>🚧 思考一下，能不能把这个仓库做成所有要学习TDD人都可以用的一个入口？</li>
    <li>🚧 要不要做一个类似于Frontend Roadmap的一个TDD roadmap？</li>
  </ul>
</details>

## TDD是什么？为什么TDD很重要？

TDD是[极限编程](http://www.extremeprogramming.cn/content/xp/introduction.html)中的一项核心技术实践。不做TDD，就不能产出高质量的自动化测试集，就不能避免越来越繁重的手工回归测试流程，也不能做安全的不破坏功能的重构。简单讲，[不做TDD，就不能产生真正意义上的高质量的可工作软件](https://ethan.thoughtworkers.me/#/post/2022-05-22-why-tdd-is-still-mandatory-in-current-era)。

TDD是一种先写测试、后写代码的工作方法，它有别于更为本能、但从软件开发角度讲更为低效的先写代码、再做调试的工作方法。TDD非常简单，基本方法30分钟就能学会，但在我生涯过程中，我觉得有很多同学因为听到它是一项“极限”编程实践，就产生了敬而远之的想法。这是一种误解。

如果你是非常新的初学者，我建议你从[FizzBuzz](src/fizzbuzz)这个例子开始：我编写了一份[细致到代码行级的实践指引](src/fizzbuzz/Tutorial-TypeScript.md)（用的TypeScript，[Java版本的请看这里](src/fizzbuzz/Tutorial-Java.md)），同时也录了一个[5分钟的操练视频]()（用的TypeScript，[Java版本的请看这里]()）。请你上手敲一敲代码，最直观地体会一下TDD这个过程是什么样子。在这个过程中，你也可以参考下[TDD的基本过程](#TDD的基本过程)这个章节，把我们所说的TDD循环对应到指引和视频中的实践中去。

## 练习题

好的，让我们开始愉快地撸代码吧！

```shell
git clone git@github.com:EthanLin-TWer/more-effective-TDD.git
npm install
npm test
```

你可以选你喜欢的题目开始练习。题目前的星级表示难度，⭐越多，难度越高，对实践的理解和熟练程度要求越高。

* [🌟 FizzBuzz](src/fizzbuzz/README-FizzBuzz.md)
* [🌟 Length](src/length/README-Length.md)
* [🌟🌟 Dialects](src/dialects/README-Dialects.md)
* [🌟🌟 Locker](src/locker/README-Locker.md)
* [🌟🌟🌟 Args](src/args/README-Args.md)
* [🌟🌟🌟 Bowling](src/bowling/README-Bowling.md)
* [🌟🌟🌟🌟 Calisthenics](src/calisthenics/README-Calisthenics.md)
* [🌟🌟🌟🌟🌟 Black Jack](src/blackjack/README-BlackJack.md)
* [🌟🌟🌟🌟🌟 Weapon Evolutions](src/weapon-evolutions/README-weapon-evolutions.md)

## TDD的基本过程：

* 红-绿循环
* Tasking / 任务分解：TDD的任务从哪里来
* 进程间架构与软件设计：Tasking的拆分依据是设计
* 测试策略
* 什么是好的测试

### Tasking / 任务分解

任务分解是 TDD 的前置条件，TDD 需要的测试用例要从这里来。所以说一上来不做任务分解就红绿循环是错的。新人刚拿到一个编程任务时，很容易陷入细节不知所止，或者觉得心里没底不知道怎么做，不知道要做多久。其本质上是对工作任务（及自己状态）的混沌、不可见。通过任务分解的方式，强迫你去将大的任务**完全穷尽**地分解成**独立**的子问题，最后所得列表即唯一确定地描述了工作任务本身，帮助你将内在混沌的思路可视化出来。

因此，如上所述，分解出来的任务需要符合这两个条件：

- 完全穷尽
- 彼此独立

只有（尽力地）保证你分解的任务列表完全、穷尽地描述了原问题域，你才能放心地将任务列表作为「工作是否完成」的**唯一标准**。这种信心将是这个工具发挥威力的保障，相信实践越多的同学体会越深；而彼此独立这个事情，才不会导致任务之间互相依赖、递归完成，反而增加复杂度。

在具体的分解方式上，主要有两种：模块化、基于接口（契约）的分解法，以及场景化的分解法。前者得到的列表类似函数式编程，后者可能适用更抽象、更模式化的场景应用。有时也会混用，具体关节只有实践之后具体问题具体交流。总之，无论采用什么方法，最终都是为了得到一个完全穷尽、相互独立的任务列表，请牢记此主旨。

在分解这个事情上，没有统一的做法，并且分解出来的任务也很依赖现有技术栈及规范等的实现，可以说它是一种游走于接口与实现之间的尺度。因此无唯一答案的特性，仝老师称其为一项艺术，而非科学。我则觉得这给个人发挥留下了空间，是其变化多端的魅力所在。类似下棋。

以下是我最近做的一个任务分解列表。里面有一些计时信息，这个我们后面「刻意练习」的部分再聊。

```markdown
- [ ]「订单记录」入口 - 30min:49min
  - [ ] 普通会员成功登陆后，应该看不到「我行产品」和「第三方产品」入口及「订单记录」标题 :34min
  - [ ] 会员用户（审批岗和经办岗）成功登陆后，应能看到「我行产品」和「第三方产品」入口及「订单记录」标题
    - [ ] 两个入口均是可点击的 :9min 虚拟机挂球了运行不起来
    - [ ] 点击后将跳转到「预留订单」页
  - [ ] 行内会员成功登陆后，应该看不到「我行产品」和「第三方产品」入口及「订单记录」标题
  - [ ] - 重构一下 `Entry` 和 `Section`，至少搬个地方吧，把 styles 也都弄出去 :6min
- [ ] 「预留订单」页：对于能够查看到「我行产品」和「第三方产品」的会员用户来说： 340min
  - [ ] header 的部分应显示标题「预留订单」- 2min 0min
  - [ ] header 部分应显示一个「返回」按钮，点击后应该返回「我的」页面 - 2min 0min 框架自动完成
  - [ ] 用户进入「预留订单」页时，应默认获取所有今日订单 - 15min
  - [ ] 「今日订单」 50min
    - [ ] 如果 API 返回的数据中有今日的订单，那么 45min
      - [ ] 所有订单应显示成一个订单列表 - 10min
      - [ ] 订单列表应该有一个标题：「今日订单」 - 10min
      - [ ] 订单列表的每项应该包含如下信息：订单标题、预留额度、剩余时间、订单状态 - 5min
      - [ ] 订单列表的每一项应该可以点击，点击后将跳转到该订单的「订单详情」页面 - 5min
      - [ ] 如果今日订单中有「预留成功」状态的订单，那么应该显示如下的 banner：「您有 \${n} 个待处理订单\n 请"会员经办岗"尽快登录招赢通网站发起购买」 - 10min
      - [ ] 如果今日订单中没有「预留成功」状态的订单，那么不显示上面的 banner - 5min
    - [ ] 如果 API 返回的数据中没有今日的订单，那么不显示订单列表，也不显示列表标题：「今日订单」 - 5min
  - [ ] 「最近七日订单」 120min
    - [ ] 在「今日订单」列表下面，应该显示一个「最近七日订单」按钮 - 5min
      - [ ] 点击按钮，应该获取最近七日订单，默认获取 20 条订单数据 - 10min
      - [ ] 若有最近七日的订单，则订单列表应显示一行标题：近 7 日的订单 - 5min
      - [ ] 若有最近七日的订单，应以订单列表的形式展现，每条订单项展示的信息内容为：订单标题、预留额度、剩余时间、订单状态 - 10min
      - [ ] 若有最近七日的订单，则订单列表的每一项都应是可以点击的，点击后跳转到该订单的「订单详情」页面 - 5min
      - [ ] 若无最近七日的订单，则不展示任何订单列表，也不展示标题：近 7 日的订单 - 5min
    - [ ] 点击「最近七日订单」按钮后： 25min
      - [ ] 若还有更多订单，则按钮依然显示，并且文字变为「加载更多订单」 - 20min
      - [ ] 若已没有更多订单，则按钮不显示 - 5min
    - [ ] 在「最近七日订单」按钮下面，应始终显示一行文字："如需查看全部订单，请登录招赢通网站"【待确认】，无论「最近七日订单」按钮是否显示 - 5min
    - [ ] 若点击了「加载更多订单」获取到更多的订单，应追加在原来列表的后面 - 25min
    - [ ] 若点击了「加载更多订单」获取到更多的订单，并且获取到原来重复的订单，则应进行去重，仅显示一条订单 - 25min
  - [ ] 订单加载效果： 25min
    - [ ] 无论刚进入页面正在获取「今日订单」时，还是点击了「最近七日订单」在获取最近订单时，页面均应显示 loading 效果 - 20min
    - [ ] 加载结束后，应该取消显示效果 - 5min
  - [ ] 预留额度处时钟效果： 125min
    - [ ] 时钟应该能实时变化 - 90min
    - [ ] 如果用户停留在界面期间订单剩余时间走完了，此时「预留成功」状态不会实时改变，可以仍然是「预留成功」，样式也不需发生变化 - 5min
    - [ ] 基于上一小条的情况下，如果用户点击了该订单，跳转到了「订单详情」页并从详情页点击「返回」再次回到「预留订单」页面，此时应看到这条订单状态已经变为「已实效」，同时剩余时间与订单状态的样式均有改变 - 30min
- [ ] 「订单详情」页 42min
  - [ ] 用户进入「订单详情」页时，应获取该订单的详情 - 20min
  - [ ] header 部分应显示标题「订单详情」 - 2min
  - [ ] header 部分应显示一个「返回」按钮，点击后应该返回「预留订单」页面 - 5min
  - [ ] 订单详情页应该显示该订单的如下信息：订单标题、额度预留剩余时间、产品代码、产品简称、预留额度、付款账户、状态、经办人、产品类型、开户行、户名、发起时间 - 15min
  - [ ] 订单详情页处处不可点击 - 0min
- [ ] 以上「订单记录」、「预留订单」及「订单详情」任务列表对于「我行产品」和「第三方产品」均一致 - 120min 重构
- [ ] 样式 - 120min
  - [ ] 「我行产品」、「第三方产品」入口样式
  - [ ] 「预留订单」页样式
  - [ ] 「订单详情」页样式
```

### The key of design 设计之道

那么，如何减少变化发生时带来的变更成本呢？目前软件工程普遍认可的一种方式是：**每次修改只改动与变化相关的地方**。这就必然要求软件模块之间高内聚、低耦合，基于这种认知，目前的 5 条 [SOLID](<https://www.wikiwand.com/en/SOLID_(object-oriented_design)>) 原则可以认为是整个设计模式体系的提纲挈领：

- Single Responsibility Principle: 单一职责原则。
- Open-Closed Principle: 开闭原则。
- Dependency Inversion Principle: 依赖倒转原则。
- Interface Segregation Principle: 接口隔离原则。
- Liskov Substitution Principle: 里氏替换原则。

## Reference 参考

好像不错的一个系列，可以看看：http://randycoulman.com/blog/2015/07/21/getting-testy-anti-patterns/

## 其他Q&A

> 什么是极限编程？什么是敏捷？极限编程与敏捷的关系是什么？

> 为什么不做TDD就没法写出好的测试？

> 不做TDD，但我们在用敏捷，在用Scrum呀，难道不用TDD敏捷就都是白做吗？

### Best Materials 最精华资料

- [ ] [Kent Beck: Test Driven Development by Example](https://book.douban.com/subject/1230036/)
- [李小波：深度解读测试驱动开发](http://gitbook.cn/books/58c2ac77306e988f12697f16/index.html)

#### Tasking

- [x] [仝健：编程的精进之法](https://www.zybuluo.com/jtong/note/504192)
- [x] [仝健：像机器一样思考（系列）](https://www.zybuluo.com/jtong/note/403738)
  - [x] [像机器一样思考（一）—— 宏观的基础](https://www.zybuluo.com/jtong/note/403738)
  - [x] [像机器一样思考（二）—— 数据的细节](https://www.zybuluo.com/jtong/note/471501)
  - [x] [像机器一样思考（三）—— 穷尽就是力量](https://www.zybuluo.com/jtong/note/473123)
  - [ ] [像机器一样思考（四）—— 一图抵千言](https://www.zybuluo.com/jtong/note/774931)
  - [ ] [像机器一样思考（五）—— 第一个应用](https://www.zybuluo.com/jtong/note/640178)
  - [ ] [像机器一样思考（六）—— 脑中的重构](https://www.zybuluo.com/jtong/note/641148)
  - [ ] [像机器一样思考（七）—— 跨应用思考](https://www.zybuluo.com/jtong/note/480426)

#### 整洁代码

- [ ] [伍斌：驯服烂代码](https://book.douban.com/subject/26208707/)
- [ ] [Robert C.Martin：代码整洁之道](https://book.douban.com/subject/4199741/)

#### 重构

- [ ] [Martin Fowler：重构2-改善既有代码的设计](https://book.douban.com/subject/30468597/)
- [ ] [Joshua Kerievsky：重构与模式](https://book.douban.com/subject/20393327/)

#### 设计

- [ ] [GoF：设计模式-可复用面向对象软件的基础](https://book.douban.com/subject/1052241/)
- [ ] [Freeman：Growing Object-Oriented Software, Guided by Tests](https://book.douban.com/subject/4156589/)

#### Argues 论战

- [ ] Martin Fowler & Kent Beck & DHH: Is TDD Dead? Series
  - [ ] [Is TDD Dead? Part I](https://www.youtube.com/watch?v=z9quxZsLcfo)
  - [ ] [Is TDD Dead? Part II](https://www.youtube.com/watch?v=JoTB2mcjU7w)
  - [ ] [Is TDD Dead? Part III](https://www.youtube.com/watch?v=YNw4baDz6WA)
  - [ ] [Is TDD Dead? Part IV](https://www.youtube.com/watch?v=dGtasFJnUxI)
  - [ ] [Is TDD Dead? Part V & VI](https://www.youtube.com/watch?v=gWD6REVeKW4)
- [x] [TDD 并不是看上去的那么美 - CoolShell](http://coolshell.cn/articles/3649.html)
- [x] [虚拟座谈会：TDD 有多美 - infoq](http://www.infoq.com/cn/articles/virtual-panel-tdd)
- [x] [Todd Wei: TDD 到底美不美 - cnblogs](http://www.cnblogs.com/weidagang2046/archive/2011/02/23/1963277.html)
- [x] [逸言: 推行 TDD 的思考](http://agiledon.github.io/blog/2013/12/25/thought-about-applying-tdd/)

### Inspirations 其他

- https://github.com/tws-practice/dojo
- https://github.com/gamontal/awesome-katas
- http://codekata.com/
- http://codingdojo.org/kata/
- http://coding-is-like-cooking.info/tag/code-kata/page/5/
