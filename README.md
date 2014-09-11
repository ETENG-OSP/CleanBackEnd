1. 简介
=========

CleanBackEnd 是用编写 Restful 服务的一个框架。包含数据库操作等便利功能。


2. 具体说明
=========

2.1 依赖环境搭建
---------

### 2.1.1 安装node.js


Singularity开发平台依赖 node.js 运行环境，在使用之前确保已经有可用的 node.js 运行环境。

node.js 下载地址：http://nodejs.org/dist/v0.10.28/node-v0.10.28-x86.msi

### 2.1.2 安装 git

Singularity 开发平台bower使用git进行网页依赖库的下载，在使用之前确保已经有可用的 git。

Git 官网：http://git-scm.com/

### 2.1.3 安装 bower(前台包管理器)

```
npm install -g bower
```

### 2.1.4 安装 grunt-cli(构建编译工具)

```
npm install -g grunt-cli
```

### 2.1.5 安装 jmeter

下载地址: http://jmeter.apache.org/download_jmeter.cgi

解压缩,进入 bin 文件夹,执行jmeter.bat.

2.2 前台开发环境搭建
---------

### 2.2.1 前台开发环境安装

安装之前确保已经有 git 和 node.js 环境。node.js 需要 bower 与 grunt-cli。

执行以下命令：

```
git clone https://github.com/ETENG-OSP/Demo.git
cd Demo
```

以下命令安装的文件Demo已经含有，不需要再次执行。

```
npm install
bower install
```

### 2.2.2 前台开发环境目录结构说明

目录结构：

- bower_components：通过bower安装的前台依赖包（禁止修改）
- node_modules：通过npm安装的node依赖包，主要用于页面编译（禁止修改）
- config: 对编译任务的配置文件（禁止修改）
- framework: 前台开发环境框架（禁止修改）
- dist: 生产环境部署文件
- app：开发人员工作目录（可修改）
- less: 存放css样式文件的地方,根据项目情况开发
- views: 放静态页面的地方，根据项目情况开发
- js: 项目所用的js文件都在此进行开发

文件：

- bower.json：bower索引文件，记录需要下载的包和版本（禁止修改）
- Gruntfile.js：编译脚本（谨慎修改）
- package.json：node索引文件，记录编译器所依赖的包和版本（禁止修改）
- README.md：说明文件

### 2.2.3 安装前台开发环境编辑器 Sublime Text 2

下载地址：

### 2.2.4 启动前台开发服务器

```
grunt //启动服务器
```

访问 http://localhost:9000/

2.3 前台开发流程
---------

### 2.3.1 开发新页面流程

1. 在app/views/新增XXX.html
2. 修改app/js/routes/root.js中增加URL与XXX.html文件的映射关系

### 2.3.2 页面加入控制层流程

1. 在app/js/controllers新增XXX.js,XXX.js自动注册允许使用,无需人工干预
2. 在XXX.html中引用控制层,如<div ng-controller="UserController">

### 2.3.3 页面内部加入数据模型绑定

1. 初始化数据模型

```
<div ng-controller="UserController" ng-init="UserVO={username:'主席'};vos=[]">
```

2. 在输入项中使用ng-model方式绑定录入数据，使用VO.属性名的方式，如：

```
<input ng-model="UserVO.username" type="text" >
```

3. 使用{{变量名}}方式进行数据绑定读取，如：`{{UserVO.username}}`

### 2.3.4 控制层数据模型操作

定义：数据模型——$scope,网络服务——$http

1. 在控制层，由数据模型获得数据,如：var name = $scope.UserVO.username
2. 在控制层，向数据模型提交数据,如：$scope.UserVO.username ='国家主席';
3. 在控制层进行http网络接口调用，如：$http.post('//localhost:8080/api/user', UserVO)

### 2.3.5 服务层与控制层分离

1. 控制层处理的是数据模型的变化，服务层处理与数据模型无关的操作；
2. 我们使用服务层将http请求与控制层分离，控制层无需关心服务的结果是从何处得到的，同时服务层也不关心处理的结果应该被如何使用；

3. 我们使用 Javascript Promise API 处理服务中的异步操作，这样能够保证正确处理

多个异步操作的失败处理流程；

4. 新建的服务放在 app/js/services 中，供控制层调用。例如XXXAPI.js,XXX.js自动注册允许使用,无需人工干预.

2.4 Restful开发规范
---------

1. 所有符合restful规范的url,都以/api为前缀,代表restful接口服务。

例如: http://localhost/api/user

2. 代码规范：

在java项目中，专门有api包，类定义以API结尾，用来提供restful接口。

URL中的第一个资源定位关键字（/api后的单词），为Restful接口的类名前缀。

类名尽量使用名词进行定义。如：UserAPI.class

在类定义时，指定MIME：@Produces("application/json;charset=UTF-8")

跨域访问通过过滤器控制：

```
res.addHeader("Access-Control-Allow-Origin","*");
res.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
```

3. 参数传递规范：

POST、PUT、DELETE下，参数以JSON的格式

针对GET设计规范(查询),url的path部分是针对资源的定位.资源定位的类型有两

种.一种是针对于全部 资源的定位,一种是针对于特定资源的定位.

1. 针对全部资源的定位可以使用查询条件.查询条件以QueryString的形

式在path之后.GET /user?offset=1&limit=99

2. 针对单个资源的定位,使用url参数.如GET /user/1 

4. 返回值规范：

成功返回状态码为200，失败状态码为500

返回值以JSON的格式

2.5 后台开发环境CleanBackEnd搭建
---------

CleanBackEnd环境要求：

不包含平台java源码

不包含任何前台页面内容，如：HTML、CSS、JS、JSP

通过Jar包及配置文件齐全

含DEMO场景代码及Jmeter测试案例

执行以下命令：

```
git clone https://github.com/ETENG-OSP/CleanBackEnd.git
```

2.6 后台开发环境CleanBackEnd平台升级流程 
---------

2.7 后台开发环境CleanBackEnd打补丁流程(待完善)
---------

Windows系统打补丁流程比较简单，略过；下面着重描述Centos打补丁流程：

2.8 部署环境搭建
---------

### 2.8.1 部署环境

### 2.8.2 端口规范

1. 端口号分配

n1:10000 n2:10010 n3:10020

 t1:10030 t2:10040

2. 说明

n1连接服务器:n2,n3

n2连接服务器:t1,t2

n1连接n2的条件以/api开头.

n1连接n3的条件以不是/api以外的url.

n2随机向t1,t2转发请求

2.9 应用开发过程
---------

### 2.9.1 应用场景设计

人员的增删改查:此部分采用restful的标准资源方式

人员的离职:部分采用restful非标准的动作调用方式,一律采用POST方式

此应用不做权限处理.均允许匿名访问.

### 2.9.2 应用接口设计

1. 插入一个用户

```
POST /api/user

[params]

{

 "username":String,//用户名 

 "flag":int //0代表在职 1代表离职 

}

[return]

{

 "message":String,

 "id":String

}
```

2. 将用户进行离职操作：有此用户进行正常离职操作，返回状态码 200，message离职成功。 如果用户不存在,返回码500,message用户不存在.

```
POST /api/user/resign

[params]

{

 "id":String,//用户ID 

}

[return]

{

 "message":String

}
```

### 2.9.3 测试案例设计

使用jmeter测试

2.9.3.1 新建线程组.

2.9.3.2 增加HTTP请求

2.9.3.3 增加响应断言

2.9.3.4 增加察看结果树（功能测试使用）

2.9.3.5 增加生成概要结果（压力测试使用）

3. 平台更新步骤
=========

3.1 CleanBackEnd的更新步骤
---------

1. 下载整套CleanBackEnd,将WebContent/WEB-INF/lib中的
2. 将ETFrameWorkV2.0.1.jar粘贴到原有项目的 WebContent/WEB-INF/lib
3. 修改原有项目的Build Path.移除原有对 ETFrameWorkV2.0.jar的引用.
4. 增加对新的 ETFrameWorkV2.0.1.jar的引用.
5. 删除在项目当中 ETFrameWorkV2.0.jar.
6. 在conf/common_config.xml中的<common>标签内部添加

ETFrameWorkV2.0.1.jar复制出来中。

```
<defaultSystemAccount>etframework</defaultSystemAccount>
```

### 3.1.2 Static-html-builder的更新步骤

Demo 分为源码部分与开发环境。

源码部分为项目团队进行开发的部分；源码部分为 app 文件夹

开发环境由平台统一升级:；除app外的所有其他文件

升级方法为：

下载最新开发环境 git clone 

https://github.com/ETENG-OSP/Demo.git

将源码部分从原来的项目中复制到最新的开发环境

附录
=========

版本历史
---------

2014.09.10 ETFrameWorkV2.0.1

此次版本修正了默认帐套信息的读取方案
