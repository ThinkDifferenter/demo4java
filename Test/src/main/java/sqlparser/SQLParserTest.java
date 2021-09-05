package sqlparser;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: SQL词法分析器+语法分析器
 *
 * @author junjiang
 * @create 2019-08-08 16:55
 */
public class SQLParserTest {

    public static void main(String[] args) {
        String sql = "select id,name,gender from user where user.id = 1920154944";

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

//        System.out.println(System.identityHashCode(parser));

        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement statement = parser.parseStatement();

        // 使用visitor来访问AST
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);

        // 从visitor中拿出你所关注的信息
        System.out.println(visitor.getColumns());
//        System.out.println(visitor.getOrderByColumns());

        int[] a = new int[3];
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(a[0]));
        System.out.println(System.identityHashCode(a[1]));
        System.out.println(System.identityHashCode(a[2]));

    }
}