package ru.build.database;




import ru.build.tools.Column;
import ru.build.tools.Id;
import ru.build.tools.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
    private Connection connection;
    private Class<?> clazz;
    private String url;
    private String username;
    private String password;


    public DatabaseProvider(Class<?> clazz, String url, String username, String password) {
        this.clazz = clazz;
        this.url = url;
        this.username = username;
        this.password = password;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createTable() {
        String tableName = parseTableName(clazz);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("CREATE TABLE ")
                .append(tableName)
                .append("(");
        for (Field i : clazz.getDeclaredFields()) {
            if (i.isAnnotationPresent(Id.class)) {
                stringBuilder
                        .append(i.getName() + " ")
                        .append(i.getAnnotation(Column.class).type().name() + " ")
                        .append("PRIMARY KEY")
                        .append(", ");
            }
            stringBuilder
                    .append(i.getName() + " ")
                    .append(i.getAnnotation(Column.class).type().name())
                    .append(", ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2) + ");";
    }


    public String parseFields(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Field i : clazz.getDeclaredFields()) {
            stringBuilder.append(i.getName()).append(", ");
        }
        return stringBuilder
                .toString()
                .substring(0,
                        stringBuilder
                                .toString()
                                .length() - 2)
                + ")";
    }

    public String parseTableName(Class<?> clazz) {
        return clazz.getAnnotation(Table.class).name();
    }


}
