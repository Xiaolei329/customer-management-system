# 客户管理系统（NewSSMBOOT）

基于 **Spring MVC + Spring + MyBatis（SSM）** 的简易客户管理系统，支持登录鉴权、客户信息增删改查、分页与条件筛选，以及字典数据（客户来源/行业/级别）查询。

## 1. 项目功能

- 管理员登录（含验证码）
- 客户列表分页查询
- 按客户名称、来源、行业、级别筛选
- 客户新增、编辑、删除
- 字典数据查询（来源/行业/级别）
- 登录拦截（未登录跳转登录页）

## 2. 技术栈

- Java 8
- Maven（WAR 打包）
- Spring Framework（Context/JDBC/TX）
- Spring MVC
- MyBatis + MyBatis-Spring
- MySQL
- JSP + Layui + jQuery

## 3. 目录结构

```text
customer-management-system
├── pom.xml
└── src
    └── main
        ├── java/com
        │   ├── controller      # 控制层（登录/客户/字典）
        │   ├── service         # 业务层
        │   ├── mapper          # Mapper 接口
        │   ├── entity          # 实体类
        │   ├── interceptor     # 登录拦截器
        │   ├── util            # 工具类（验证码）
        │   └── vo              # 返回对象/视图对象
        ├── resources
        │   ├── spring-mvc.xml
        │   ├── mybatis-config.xml
        │   ├── db.properties
        │   └── mapper/*.xml
        └── webapp
            ├── WEB-INF
            │   ├── web.xml
            │   └── view/*.jsp
            ├── html/*.html
            ├── css
            ├── js
            └── layui
```

## 4. 运行环境

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+ / 8.0+
- Tomcat 8+（推荐 9+）

## 5. 快速启动

### 5.1 配置数据库

修改文件：`src/main/resources/db.properties`

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm_boot?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
jdbc.username=root
jdbc.password=your_password
```

请确保数据库中存在以下表：

- `user_t`
- `custom_t`
- `dictionary_t`

> 说明：上述连接串适用于本地开发示例，生产环境请启用数据库 SSL 连接（建议 `useSSL=true`）并结合证书配置。
>
> 凭据安全建议：`db.properties` 不要提交真实账号密码；生产环境建议通过环境变量或密钥管理系统注入数据库凭据。

### 5.2 构建项目

在项目根目录执行：

```bash
mvn clean package
```

构建成功后生成：

- `target/NewSSMBOOT.war`

### 5.3 部署运行

将 `target/NewSSMBOOT.war` 部署到 Tomcat 的 `webapps` 目录，启动 Tomcat 后访问：

```text
http://localhost:8080/NewSSMBOOT/login
```

## 6. 主要接口

### 登录模块（`LoginController`）

- `GET /getVerifyCode`：获取验证码
- `POST /login`：登录（参数：`userName`、`password`、`verifyCode`）
- `GET /logout`：退出登录
- `GET /index`：进入首页

### 客户模块（`CustomController`）

- `GET /custom/list`：分页查询客户（参数：`page`、`limit`、筛选条件）
- `POST /custom/add`：新增客户
- `POST /custom/update`：更新客户
- `GET /custom/delete?cust_id=xx`：删除客户

### 字典模块（`DictionaryController`）

- `GET /dictionary/CustomSourceAndIndustryAndLevel`：查询来源/行业/级别字典

## 7. 默认页面说明

- 登录页：`/WEB-INF/view/login.jsp`
- 首页：`/WEB-INF/view/index.jsp`
- 客户页面：`/html/customList.html`、`/html/customAdd.html`、`/html/customEdit.html`

## 8. 测试

项目当前未包含业务测试用例，可使用以下命令验证构建与测试生命周期：

```bash
mvn test
```
