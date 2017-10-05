# TODOLIST

## Kent's todolist 

* [ ] how to get normal node working with TypeScript - no idea, don't worry this for now  
* [ ] money rounding 
* [ ] $5 + 10CHF = $10 if rate is 2:1
* [ ] `hashCode()` - for Java version only
* [ ] money object comparison with different currency
* [ ] a risk? that multiplication function uses - thus relied on - the equality check functionality to make itself more expressive 
* [ ] how to get eslint working with TypeScript
  * should I commit generated `.js` files?
  * where should I locate the generated `.js` files? 
  * are those generated `.js` files part of the committed changes to git? 
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
 