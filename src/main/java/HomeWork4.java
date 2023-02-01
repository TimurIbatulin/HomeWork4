import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeWork4 {
    public static void main(String[] args) throws IOException {
//        1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
        FileWriter fileWriter = null;
        FileReader fileReader = null;

        try {
            fileWriter = new FileWriter("HomeWork.sql");
            fileWriter.append("Я сделал это!");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String text = "";
        try {
            fileReader = new FileReader("HomeWork.sql");
            while (fileReader.ready()) {
                text += (char) fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(text);

//        2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
        String fileText = "";
        try {
            fileReader = new FileReader("ForProgam.sql");
            while (fileReader.ready()) {
                fileText += (char) fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(fileText);
        }

        List<String> stringList = List.of(fileText.split("\n"));

        System.out.println(stringList);
//        3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
        String[] tempString = new String[5];

        LinkedList<String> surname = new LinkedList<>();
        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> secName = new LinkedList<>();
        LinkedList<Integer> age = new LinkedList<>();
        LinkedList<String> sex = new LinkedList<>();

        for (int i = 0; i < stringList.size(); i++) {
            tempString = stringList.get(i).split(" ");
            surname.add(tempString[0]);
            name.add(tempString[1]);
            secName.add(tempString[2]);
            int ageInt = Integer.parseInt(tempString[3]);
            age.add(ageInt);
            sex.add(tempString[4]);
        }

        System.out.println(surname);
        System.out.println(name);
        System.out.println(secName);
        System.out.println(age);
        System.out.println(sex);

//        4.Отсортировать по возрасту используя дополнительный список индексов.
        List index = new ArrayList();

        int count = 0;
        for (int q = 0; q < age.size(); q++){
            int minAge = 100;
            for (int i = 0; i < age.size(); i++ ) {
                if (minAge > age.get(i)) {
                    minAge = age.get(i);
                    count = i;
                    }
            }
            index.add(count);
            int r = minAge + 100;
            age.set(count, r);
            }
        System.out.println(index);
        }


    }
