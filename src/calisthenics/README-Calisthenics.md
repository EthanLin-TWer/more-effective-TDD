# 对象健身操

写一个新的Job Application domain，要求如下：

domain中包含5个实体：

- `Jobs`
- `Jobseekers`
- `Employers`
- `Resumes`
- `Job Applications`

实体交互如下：

- Employers能够发布jobs
- Employers也应能看见他们所发布的jobs清单
- Jobseekers能够保存jobs清单以便后续查看
- Jobseekers可以申请employers发布的jobs
- employers可以发布两类Jobs: JReq and ATS
- JReq类型的jobs需要resume才能申请它们
- ATS类型的jobs无需resume
- Jobseekers不能以他人的resume申请job
- Jobseekers能够以不同的resumes申请不同的jobs
- Jobseekers能够查看已申请的jobs清单
- Employers能够通过job查看申请job的jobseekers
- Employers能够通过day查看申请job的jobseekers
- Employers可以联合job和day来查看申请job的jobseekers
- 能够获取任一jobseekers在给定day的jobs申请情况
- 能够以csv或html格式获取job申请报告
- 能够从job申请报告中确定jobseeker，job，employer和job申请日期
- 通过job和employer应该能够看到有总job申请数量
- 通过job和employer应该能够看到有多少job申请失败，以及有多少job累计成功
- Jobseekers在显示时应以他们的名字
- Employers在显示时应以他们的名字
- Jobs显示时应显示一个title和发布它的employer的名字
- 系统能够处理具有相同title的多个jobs
- 系统能够处理同名的多个Jobseekers
- 系统能够处理同名的多个employer

> Credit by [Kaelzhang81 - 对象健身操详解](http://kaelzhang81.github.io/2018/06/10/对象健身操详解/)

