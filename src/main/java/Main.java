
import persist.ToDo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        Scanner scan = new Scanner(System.in);
        List<ToDo> ToDoList = new ArrayList<ToDo>();
        String command = " ";

        while (command != "quit") {

            System.out.println("Введите команду: ");
            command = scan.nextLine();
            switch (command) {

                case ("add"):
                    ToDo toDo = new ToDo();
                    System.out.println("Введите задачу: ");
                    String task = scan.nextLine();
                    toDo.setTask(task);
                    toDo.setId(n++);
                    toDo.setStatus(" ");
                    ToDoList.add(toDo);
                    break;


                case ("print"):
                    if (ToDoList.isEmpty()) {
                        System.out.println("На данный момент задач нет. Внесите задачу коммадой add.");
                    } else {
                        System.out.println("Ваши невыполненные задачи: ");
                        List<ToDo> filtered = ToDoList.stream()
                                .filter(string -> string.getStatus().contains(" "))
                                .collect(Collectors.toList());
                        for (int i = 0; i < filtered.size(); i++)
                            System.out.println(filtered.get(i));
                    }
                    break;

                case ("print [all]"):
                    if (ToDoList.isEmpty()) {
                        System.out.println("На данный момент задач нет. Внесите задачу коммадой add.");
                    } else {
                        System.out.println("Ваши задачи: ");
                        for (int i = 0; i < ToDoList.size(); i++)
                            System.out.println(ToDoList.get(i));
                    }
                    break;

                case ("toggle"):
                    if (ToDoList.isEmpty()) {
                        System.out.println("На данный момент список задач пуст. Внесите задачу коммадой add, а после измените её статус.");
                    } else {
                        System.out.println("Введите индекс: ");
                        String index = scan.nextLine();
                        int foo = Integer.parseInt(index);
                        if (ToDoList.get(foo).getStatus().equals(" ")) {
                            ToDoList.get(foo).setStatus("x");
                        } else {
                            ToDoList.get(foo).setStatus(" ");
                        }
                    }
                    break;

                case ("quit"):
                    command = "quit";
                    break;


                default:
                    System.out.println(
                            "Вы ввели несуществующую команду.\n" +
                                    "Список команд:\n" +
                                    "add - добавить команду в список\n" +
                                    "print [all] - вывести все задачи\n" +
                                    "print - вывести только невыполненные задачи\n" +
                                    "toggle <номер задачи> - Переключает состояние задачи\n" +
                                    "quit - выход");
                    break;

            }
        }
    }
}
