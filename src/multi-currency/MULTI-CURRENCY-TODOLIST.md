# TODOLIST

## Kent's todolist 

* [ ] `Dollar`/`France` duplications
* [ ] common `times` 
* [ ] $5 + 10CHF = $10 if rate is 2:1 
* [ ] money rounding 
* [ ] `hashCode()` - for Java version only
* [ ] currency? to remove rely on JavaScript reflection features 
* [ ] money object comparison with different currency
* [ ] a risk? that multiplication function uses - thus relied on - the equality check functionality to make itself more expressive 
* [ ] how to get normal node working with TypeScript - no idea, don't worry this for now  
* [ ] how to get eslint working with TypeScript
  * can eslint support both `.js(x)` and `.ts(x)` files? what are the recommended tools to use in either cases? 
  * should I commit generated `.js` files?
  * where should I locate the generated `.js` files? 
  * are those generated `.js` files part of the committed changes to git? 
* [x] common `equals` 
* [x] 5CHF + 10CHF = 15CHF
* [x] introduce tslint for typed js linting   
* [x] make tests speak - can only be done in Java through the built-in `equal()` hook for equality comparison, wonderful Java  
* [x] null money object comparison
* [x] `equals()` immutability for money - hard for JavaScript objects cause they don't have the `equal()` and `hashCode()` methods..
* [x] $5 * 2 = $10
* [x] multiplications is not used 
* [x] make amount private - not possible or even necessary in JavaScript  
* [x] directly settings the class fields
* [x] dollar side effects
* [x] design issue - immutable could bring benefits in this case: money don't need to be identically equal, they just need to have value equality
  * [x] in order for that, we will need a typing system and in this case, TypeScript
    * [x] what libraries are required to use TypeScript
      * [x] typescript
      * [x] ts-node
      * [x] definitions for mocha `npm i -D @types/mocha`
      * [x] definitions for assert? `npm i -D @types/node` 
    * [x] what configurations are required to use TypeScript
      * [x] `tsconfig.json` - `target: es6` & `allowSyntheticDefaultImports` 这些是要小步前进才能试出来的
      * [x] `package.json` `npm test mocha` configuration
      * [x] power-assert configuration `npm i -D espower-typescript` `mocha --require espower-typescript/guess`    
    * [x] how to get mocha running with TypeScript - see above

## My todolist 

* [ ] should be able to calculate total price of only one type of currency
* [ ] should be able to specify a exchange rates 
* [ ] should be able to calculate total price of one type of currency to another 

## My takes 

Kent 是说，什么样的测试组通过了，我们就会有信心能展示出一个正确的报告？这里他的思路分开了展示和数据，展示部分是不测的，因为可能涉及 UI，我们要做的，就是数据计算这部分足够有信心，整个应用就对了。

可以看见，这里的测试是有策略的。那就是问题域的转化，以及什么测，什么不测，不测的部分由什么来保障，是否有信心。

另外，Kent 的这种套路其实回答了另一个问题，就是 Tasking 是否要一开始就全部做完？不是，可以边做边扩展。当然，我觉得国内的团队并不见得能提供这种时间上的支持和安全感。

Todo-list 的操作方法有三种：正在做的、已经做完的、做的过程又想到的。做的过程又想到，加到列表里而不是马上做。这点是很重要的。

说测试驱动开发其实是基于 API 的编程，我们希望我们的代码看起来怎样，如何被调用。虽然不总是维持到最后，可能要改，但从看起来最顺眼的开始概率也比较高。

让测试最快通过最可能要做的事情是什么？

* 创建不存在的类(IDE)
* 创建不存在的方法(IDE)
* 创建不存在的字段(manually)
* 导入一些必要的包(IDE)
* 快速实现(implementation)，主要有两种方法，这两种方法步子大小有所不同，实际中可以视信心和经验替换着用。当你的节奏感和信心较好时，可以大步一点使用已经成为你的「解决方案」的 obvious implementation；当这种明显的解决方案让测试挂球时，马上切换成常量数据，一次一个重复变量地移除，重新回到小步提交的步骤。前提是，进行每一步时，工作区都是干净的，测试都是通过的
  * **Fake It**。先返回常量，再逐渐把重复的常量替换成变量
  * **Use Obvious Implementation**。过于明显的实现直接写

TDD 的每一个小步骤，每个步骤都专注于一件事：

1. 按照 tasking 列表写一个测试用例（专注于输入输出）
2. 运行测试，让它挂掉（专注于验证测试可运行，仅仅是结果的错误）
3. 做最小的修改（专注于输出 测试所需结果，不专注于实现）
4. 运行测试，让它通过（专注于验证刚刚修改的结果）
5. 重构（专注于更好的实现，不专注于修改测试（也即修改功能））

If dependency is the problem, duplication is the symptom.

Duplication 在哪里？

* 测试与实现之间 hard-code 的常量
* 

TDD 的一般步骤，教主原话：

1. 写一个测试。其实是在写一个 API，是在表达你的想法，有你的设计和思想在内，你是在写一个「故事 story」。输入部分，给出所有你需要的数据
2. 运行测试。让测试快速通过，这一步专注于让测试通过，而非让实现完美。可以给自己设定一个目标，测试写出来后，15秒内必须让它通过。「Quick green excuses all sins. But only for a moment.」
3. 重构代码。去除重复、保证测试依然通过，这一步专注于让代码变得好看、可维护

> The goal is clean code that works. - Ron Jeffries & Kent Beck

其要义在于，一次只做一件事。为什么这个事情重要？因为人脑天然的限制吧。既然你没法一次写出能工作的好代码，那么就分而治之，先让它能工作，再重构成好代码。

项目配置也要小步前进。学习了。

做最小的修改让测试通过，其实不仅限于说写最少的代码，而是以最快的速度。我可能抄了很多代码，但从速度上来说依然是快的。没问题，那就抄嘛，然后再来消除重复就好了。看我们抄 `France` 类的例子。

另外，TDD 的五个步骤中，第二步第三步有可能做熟了直接可以省掉，但要知道自己在哪里。

> Write the tests you wish you had. If you don't, you will eventually break something while refactoring. Then you'll get bad feelings about refactoring and stop doing it so much. Then your design will deteriorate. You'll be fired. Your dog will leave you. You will stop paying attention to your nutrition. Your teeth will go bad. So, to keep your teeth healthy, retroactively test before refactoring. 

```ts
import Money from './Money'

export default class Dollar extends Money {
  constructor(amount: number) {
    super(amount)
  }

  public times(multiplications: number): Money {
    return new Dollar(this.amount * multiplications)
  }
}
```

当两个 类变成上面这种结构的时候，不仅 `times` 方法非常相像，Kent 表示他觉得这两个子类没必要了。但要挪除，怎么挪除呢？一下抛出解决方案又很不 TDD，怎么办呢？先一点点来，按照重构的思路：先尽可能移除引用点，或至少集中到一个地方。因此，工厂方法就这么自然而然地诞生了。

另外，JS 写越多越怀念 Java 的一些特性：完全的 OO、抽象类、面向接口编程。当然 JS 的长处是函数式、弱类型。

### Part III: Patterns for Test-Driven Development

Kent 说，讨论测试前，有几个问题要先弄清楚：

* 当我们谈论测试时，我们在谈论什么？
* 什么时候需要进行测试？
* 什么逻辑需要进行测试？
* 什么数据需要进行测试？

测试（动词）并不意味着拥有测试（having tests）。测试同时还是一个名词，为什么说手动的测试（动词）不等同于自动化的测试（名词）呢？

然后举了一个例子，'no time for testing' death spiral。就是说，压力越大，你越少手动测试（动词），于是可能的错误会变多，你会感受到更大的压力。以此死循环。但如果是自动化的测试，这个成本就变低。当你压力变大，不知软件是否工作时，你就运行一下测试，辅以小步前进的工作方法。成本很低，但你会发现一切都没挂，于是压力不会再继续变大。

问题是，小步前进、自动化测试，这个是需要练习的。练习不够，又面临压力的时候，只能采用本能的人肉测试来应对。

测试是否应该互相影响？不应该。互相影响的测试，意味着系统是有状态的，你无法根据一个模块来推测它的工作状态，而必须结合整个系统当时的状态，甚至执行次序。这是体力活，也是人类编程史上一直在控制的复杂度。谁让人就这么一点处理能力呢。要做到这样，我们可能首先想到，在 `beforeEach` 和 `afterEach` 之间重置状态，但如果系统大，这会花很多的时间。因此，同时又需要我们降低测试的规模，让它们更小，才能跑得更快。为了把原来的大测试变小，这就要求你隔离、模块化、面向对象编程。是有因果的。

测试运行时间应该多长？越快越好。快到你自己可以跑，并且可以随时跑，这样你才可以得到最快速的反馈。否则，跑一天的测试，要第二天才能得到反馈，你自己也不能操控。

**测试列表**。

两种方法：人脑记忆、Todolist。前者有个循环：越有经验，越清楚更多可能的细节和坑点，因此除去记忆外用于实现的精力就变少，实现的工作量就越少，发现要做的事情就越多。

有了 Todolist，你再也不会忘事了，只需要少量精力去决定「现在做哪件事而忽略哪些事」，于是有更多的精力来实现功能。

**一次实现一个测试并重构**。

一次实现十个测试，重构的工作量可能变大，大到可能给你压力。另外你获得反馈的时间要变长，比如因为重构改了参数，十个测试全飘红了，那你不知道如何去改，这个反馈就如同没有。我们希望，一个测试挂了，反应的就是一个问题。为如此，我们需要一个测试一个测试地前进。否则，十个测试挂了，意味着十个问题，或至少五六个问题，如何小步前进？



