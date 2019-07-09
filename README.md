"# hello-fan-backend"

api文档：https://www.showdoc.cc/414427986690528

大致流程：
- 客户端通过*getUpdateTime*获取用户的最后一次更新的时间（初始化为null）,
并判断是否需要上传数据；这个机制不知道有没问题...直接全部上传吧
- 如果需要上传，通过*updateAllPlan*上传所有待同步的数据，此时，服务器除了会更新studyplan表，还会更新用户的updatetime为这堆数据的updatetime里的最新的一个；

....