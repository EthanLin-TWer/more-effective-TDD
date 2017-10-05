# TODOLIST

## Kent's todolist 

* [x] $5 * 2 = $10
* [ ] multiplications is not used 
* [ ] directly settings the class fields 
* [ ] make amount private   
* [ ] $5 + 10CHF = $10 if rate is 2:1

## My todolist 

* [ ] should be able to calculate total price of only one type of currency
* [ ] should be able to specify a exchange rates 
* [ ] should be able to calculate total price of one type of currency to another 

## My takes 

Kent 是说，什么样的测试组通过了，我们就会有信心能展示出一个正确的报告？这里他的思路分开了展示和数据，展示部分是不测的，因为可能涉及 UI，我们要做的，就是数据计算这部分足够有信心，整个应用就对了。

可以看见，这里的测试是有策略的。那就是问题域的转化，以及什么测，什么不测，不测的部分由什么来保障，是否有信心。

另外，Kent 的这种套路其实回答了另一个问题，就是 Tasking 是否要一开始就全部做完？不是，可以边做边扩展。当然，我觉得国内的团队并不见得能提供这种时间上的支持和安全感。

Todo-list 的操作方法有三种：正在做的、已经做完的、做的过程又想到的。

说测试驱动开发其实是基于 API 的编程，我们希望我们的代码看起来怎样，如何被调用。虽然不总是维持到最后，可能要改，但从看起来最顺眼的开始概率也比较高。

让测试最快通过最可能要做的事情是什么？

* 创建不存在的类
* 创建不存在的方法
* 导入一些必要的包
* 直接返回或设值