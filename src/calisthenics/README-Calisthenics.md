# 对象健身操

写一个新的 Job Application domain，要求如下：

domain 中包含 5 个实体：

- `Jobs`
- `Jobseekers`
- `Employers`
- `Resumes`
- `Job Applications`

实体交互如下：

- Employers 能够发布 jobs
- Employers 也应能看见他们所发布的 jobs 清单
- Jobseekers 能够保存 jobs 以便以后查看
- Jobseekers 可以申请 employers 发布的 jobs
- employers 可以发布两类 Jobs: JReq and ATS
- JReq 类型的 jobs 需要 resume 才能申请它们
- ATS 类型的 jobs 无需 resume
- Jobseekers 不能以他人的 resume 申请 job
- Jobseekers 能够以不同的 resumes 申请不同的 jobs
- Jobseekers 能够保存 jobs 清单以便后续查看 - same with AC3
- Jobseekers 能够查看已申请的 jobs 清单 - implemented
- Employers 能够通过 job 查看申请 job 的 jobseekers
- Employers 能够通过 day 查看申请 job 的 jobseekers
- Employers 可以联合 job 和 day 来查看申请 job 的 jobseekers
- 能够获取任一 jobseekers 在给定 day 的 jobs 申请情况
- 能够以 csv 或 html 格式获取 job 申请报告
- 能够从 job 申请报告中确定 jobseeker，job，employer 和 job 申请日期
- 通过 job 和 employer 应该能够看到有总 job 申请数量
- 通过 job 和 employer 应该能够看到有多少 job 申请失败，以及有多少 job 累计成功
- Jobseekers 在显示时应以他们的名字
- Employers 在显示时应以他们的名字
- Jobs 显示时应显示一个 title 和发布它的 employer 的名字
- 系统能够处理具有相同 title 的多个 jobs
- 系统能够处理同名的多个 Jobseekers
- 系统能够处理同名的多个 employer

> Credit by [Kaelzhang81 - 对象健身操详解](http://kaelzhang81.github.io/2018/06/10/对象健身操详解/)
