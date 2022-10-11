package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;

import java.sql.SQLException;


public class Sql extends MySqlDbExecutor {
    public static void main(String[] args) throws SQLException {
        IDbExecutor iDbExecutor = new MySqlDbExecutor();
        //Создать таблицу Student
        iDbExecutor.execute("CREATE TABLE Student (id int, fio varchar(255), sex varchar(255), id_group int);");
        //Создать таблицу Group
        iDbExecutor.execute("CREATE TABLE Group (id int, name varchar(255), id_curator int);");
        //Создать таблицу Curator
        iDbExecutor.execute("CREATE TABLE Curator (id int, fio varchar(255));");
        //Заполнить таблицы данными
        iDbExecutor.execute("INSERT Student (id, fio, sex, id_group))" +
                "VALUES (101, Перов Андрей Николаевич, male, 1)," +
                " (111, Борщ Сметан Николаевич, male, 1), " +
                "(202, Пепега Валентин Петрович, male, 1), " +
                "(222, Макарова Татьяна Алексеевна, female, 1), " +
                "(303, Пирогов Макар Константинович, male, 1), " +
                "(333, Арбузова Елена Васильевна, female, 2), " +
                "(404, Бодров Александр Алексеевич, male, 2),  " +
                "(444, Китаев Михаил Николаевич, male, 2), " +
                "(505, Алексаднров Андрей Николаевич, male, 2), " +
                "(555, Перова Надежда Николаевна, female, 3), " +
                "(606, Надеждина Елизавета Николаевна, female, 3), " +
                "(607, Простова Анастасия Андреевна, female, 3), " +
                "(707, Даркина Дарья Дмитриевна, female, 3), " +
                "(777, Дробинкина Анастасия Дмитриевна, female, 3), " +
                "(808, Валик Андрей Николаевич, male, 3)");

        iDbExecutor.execute("INSERT Group (id,name, id_curator)" +
                "VALUES (1, первая, 22)," +
                "(2, вторая, 33)," +
                " (3, третья,44)");

        iDbExecutor.execute("INSERT Curator (id, fio) " +
                "VALUES (22, Погодин Михаил Алексеевич), " +
                "(33, Маринина Наталья Петровна), " +
                "(44, Ковалевский Анатолий Васильевич), " +
                "(15, Бравин Владлен Васильевич)");
        //Вывести на экран информацию о всех студентах включая название группы и имя куратора
        iDbExecutor.execute("select st.id, st.fio, st.sex, st.id_group, gr.id, cr.fio\n" +
                "from Student as st\n" +
                "JOIN Groupp as gr\n" +
                "ON st.id_group = gr.id\n" +
                "JOIN Curator as cr\n" +
                "ON gr.id_curator = cr.id");
        // Вывести на экран количество студентов
        iDbExecutor.execute("SELECT COUNT(fio) FROM Student");
        //Вывести студенток
        iDbExecutor.execute("SELECT *\n" +
                "from Student\n" +
                "where sex = 'female'");
        //Обновить данные по группе сменив куратора
        iDbExecutor.execute("UPDATE Groupp\n" +
                "set id_curator = 15\n" +
                "WHERE id = 1");
        //Вывести список групп с их кураторами
        iDbExecutor.execute("select gr.id, gr.name, gr.id_curator, cr.fio\n" +
                "FROM Groupp as gr\n" +
                "JOIN Curator as cr\n" +
                "ON gr.id_curator = cr.id");

    }
}
