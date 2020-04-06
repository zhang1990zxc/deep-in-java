module lesson {
    requires java.base; //默认依赖 java.base
    requires java.sql;
    requires java.desktop;
    exports com.zhang.deep.in.java;
    exports com.zhang.deep.in;
}