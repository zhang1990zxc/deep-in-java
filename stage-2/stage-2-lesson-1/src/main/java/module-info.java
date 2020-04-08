module lesson.one {
    //命名模块
    requires java.base;  //默认依赖
    requires java.sql;
    requires java.compiler;

    //非命名模块
    requires transitive spring.context;
    requires transitive commons.lang;
    requires transitive commons.collections;

    exports com.zhang.deep.in.java.modular;

    uses java.sql.Driver;
}