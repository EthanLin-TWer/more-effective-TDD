# More Effective TDD

最近还从项目中总结积累了一些实战项目比较常用的业务需求/模式需求，先放这有空做些题来做更加接近实战的练习。

* 权限类问题：权限可以跟人走、跟物走、跟具体操作走等
* 状态机问题：涉及一个穷尽的状态表、变迁控制及校验、每个状态的处理方法等问题
  * 比如订单状态：created - submitted - validated - payment - shipping - cancelled等闭环状态
  * 比如金融买卖：submitted - validated - accepted(auto-accepted) - pending - executed/rejected等状态
* 校验类问题：涉及多种类型校验、校验逻辑实现、结果报告方式等问题
* 流程类问题：涉及流程状态变更、流程时间节点及时间线、时区、交易日等问题，常见例子是保单、金融资产调仓等
* 发布-订阅类问题：涉及调度系统如拉取/推送机制、任务状态、重试机制等问题实现，系统可以是通用的，也可以与特殊业务耦合，常见例子是队列、定时作业系统等
* 项目通用问题：比如上传/下载文件、解析csv、监听/订阅等

## Key & Methods of design 设计的道与术

怎么样算是好的设计呢？首先要问，为什么要设计，它旨在解决/应对什么问题？回答是，**变化**。其实整个 TDD 的核心理念基础，也是认定变化必然、频繁存在。因此我们通过**减少无效未来需求**和**减少变化发生时带来的变更成本**两种方式来应对。TDD 顺便解决了第一个问题，而设计则是为了要解决第二个问题。

## My Takes 中间一些杂杂的思考过程

- [TDD 回炉重造 #157](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/157)
- [TDD 二回炉 #176](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/176)
- [TDD 周报三「作为个人工具和团队实践的 TDD」 #177](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/177)
- [TDD 周报四「TDD 是一门艺术，不是科学」 #178](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/178)
- [TDD 周报五「TDD 是敏捷实践的灵魂」 #179](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/179)
- [TDD 周报六「结语 - 我们为什么不用 TDD」 #181](https://github.com/linesh-simplicity/linesh-simplicity.github.io/issues/181)
