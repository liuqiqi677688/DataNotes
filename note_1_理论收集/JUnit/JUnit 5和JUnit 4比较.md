# JUnit 5和JUnit 4比较



JUnit 5旨在调整java 8样式的编码，并且比JUnit 4更强大和灵活。在这篇文章中，**JUnit 5 vs JUnit 4**，我们将关注junit 4和junit 5之间的一些主要差异。

## 1. JUnit 5 vs JUnit 4 - 注释

两个版本中的大多数注释都是相同的，但很少有区别。这是一个快速比较。

| 特征                             | JUNIT 4        | JUNIT 5        |
| :------------------------------- | :------------- | :------------- |
| 声明一种测试方法                 | `@Test`        | `@Test`        |
| 在当前类中的所有测试方法之前执行 | `@BeforeClass` | `@BeforeAll`   |
| 在当前类中的所有测试方法之后执行 | `@AfterClass`  | `@AfterAll`    |
| 在每个测试方法之前执行           | `@Before`      | `@BeforeEach`  |
| 每种测试方法后执行               | `@After`       | `@AfterEach`   |
| 禁用测试方法/类                  | `@Ignore`      | `@Disabled`    |
| 测试工厂进行动态测试             | NA             | `@TestFactory` |
| 嵌套测试                         | NA             | `@Nested`      |
| 标记和过滤                       | `@Category`    | `@Tag`         |
| 注册自定义扩展                   | NA             | `@ExtendWith`  |

## 2. JUnit 5和JUnit 4之间的其他差异

2.1。建筑

JUnit 4将所有内容捆绑到单个jar文件中。

Junit 5由3个子项目组成，即JUnit Platform，JUnit Jupiter和JUnit Vintage。

1. JUnit平台

	它定义了`TestEngine`用于开发在平台上运行的新测试框架的API。

2. JUnit Jupiter

	它具有所有新的junit注释和`TestEngine`实现，以运行使用这些注释编写的测试。

3. JUnit Vintage

	支持在JUnit 5平台上运行JUnit 3和JUnit 4编写的测试。

2.2。必需的JDK版本

Junit 4需要Java 5或更高版本。

Junit 5需要Java 8或更高版本。

2.3。断言

在Junit 4中，[org.junit.Assert](http://junit.org/junit4/javadoc/4.12/org/junit/Assert.html)具有所有断言方法来验证预期结果和结果。
它们接受错误消息的额外参数作为方法签名中的FIRST参数。例如

```
public` `static` `void` `assertEquals(``long` `expected, ``long` `actual)``public` `static` `void` `assertEquals(String message, ``long` `expected, ``long` `actual)
```

在JUnit 5中，[org.junit.jupiter.Assertions](http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html)包含大多数断言方法，包括附加`assertThrows()`和`assertAll()`方法。`assertAll()`到目前为止处于实验状态，并用于分组断言。
JUnit 5断言方法也有重载方法，以支持在测试失败时传递错误消息，例如

```
public` `static` `void` `assertEquals(``long` `expected, ``long` `actual)``public` `static` `void` `assertEquals(``long` `expected, ``long` `actual, String message)``public` `static` `void` `assertEquals(``long` `expected, ``long` `actual, Supplier messageSupplier)
```

2.4。假设

在Junit 4中，[org.junit.Assume](http://junit.org/junit4/javadoc/4.12/org/junit/Assume.html)包含用于说明测试有意义的条件的假设的方法。它有以下五种方法：

1. assumeFalse（）
2. assumeNoException（）
3. assumeNotNull（）
4. 假使，假设（）
5. assumeTrue（）

在Junit 5中，[org.junit.jupiter.api.Assumptions](http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assumptions.html)包含用于说明测试有意义的条件的假设的方法。它有以下三种方法：

1. assumeFalse（）
2. 假使，假设（）
3. assumeTrue（）

2.5。标记和过滤

在Junit 4中，使用了`@category`注释。

在Junit 5中，使用了`@tag`注释。

2.6。测试套房

在JUnit 4，`@RunWith`和`@Suite`注释。例如

```
import` `org.junit.runner.RunWith;``import` `org.junit.runners.Suite;` `@RunWith``(Suite.``class``)``@Suite``.SuiteClasses({``    ``ExceptionTest.``class``,``    ``TimeoutTest.``class``})``public` `class` `JUnit4Example``{``}
```

在JUnit 5 `@RunWith`，`@SelectPackages`和`@SelectClasses`如

```
import` `org.junit.platform.runner.JUnitPlatform;``import` `org.junit.platform.suite.api.SelectPackages;``import` `org.junit.runner.RunWith;` `@RunWith``(JUnitPlatform.``class``)``@SelectPackages``(``"com.howtodoinjava.junit5.examples"``)``public` `class` `JUnit5Example``{``}
```

2.7。第三方整合

在Junit 4中，没有对第三方插件和IDE的集成支持。他们必须依靠反射。

JUnit 5为此专门设立了子项目，即JUnit平台。它定义了`TestEngine`用于开发在平台上运行的测试框架的API。

请在评论部分中关注**junit 5和junit 4之间的比较**。