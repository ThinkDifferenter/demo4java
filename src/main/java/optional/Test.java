package optional;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Description : 测试
 *
 * @author :   JunJiang
 * @date : 2020-04-23 18:29
 */
public class Test {

    /**
     * 你可以使用同名方法创建一个空的 Optional
     */
    @org.junit.Test
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    /**
     * 你可以使用  of() 和 ofNullable() 方法创建包含值的 Optional。
     * 两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException
     */
    @org.junit.Test
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = new User();
        Optional<User> opt = Optional.of(user);
        opt.get();

        //如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法：
        Optional<User> opt2 = Optional.ofNullable(user);
        opt2.get();
    }

    /**
     * 从 Optional 实例中取回实际值对象的方法之一是使用 get() 方法：
     */
    @org.junit.Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("John", opt.get());
    }

    /**
     * 要避免异常，你可以选择首先验证是否有值
     */
    @org.junit.Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        assertTrue(opt.isPresent());

        assertEquals(user.getName(), opt.get().getName());

        // 检查是否有值的另一个选择是 ifPresent() 方法。
        // 该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式
        opt.ifPresent( u -> assertEquals(user.getName(), u.getName()));
    }

    /**
     * 这里你可以使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值
     */
    @org.junit.Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals(user2.getName(), result.getName());

        User result2 = Optional.ofNullable(user).orElseGet( () -> user2);
    }


    /**
     * 有很多种方法可以转换 Optional  的值。我们从 map() 和 flatMap() 方法开始。
     *
     * 先来看一个使用 map() API 的例子：
     */
    @org.junit.Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(p -> p.getName()).orElse("default@gmail.com");

        assertEquals(email, user.getName());
    }
}
