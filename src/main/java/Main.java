
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

            command = scan.nextLine().trim();
            switch (command) {

                case ("add"):
                    ToDo toDo = new ToDo();
                    String task = scan.next().trim();
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

                case ("print all"):
                    if (ToDoList.isEmpty()) {
                        System.err.println("На данный момент задач нет. Внесите задачу коммадой add.");
                    } else {
                        System.out.println("Ваши задачи: ");
                        for (int i = 0; i < ToDoList.size(); i++)
                            System.out.println(ToDoList.get(i));
                    }
                    break;

                case ("toggle"):
                    if (ToDoList.isEmpty()) {
                        System.err.println("На данный момент список задач пуст.");
                    } else {
                        String index = scan.nextLine().trim();
                        int foo = Integer.parseInt(index);
                        if (foo >= ToDoList.size()) {
                            System.err.println("Задачи с таким идентификатором не существует");
                        } else {
                            if (ToDoList.get(foo).getStatus().equals(" ")) {
                                ToDoList.get(foo).setStatus("x");
                            } else {
                                ToDoList.get(foo).setStatus(" ");
                            }

                        }
                    }
                    break;

                case ("delete"):
                    if (ToDoList.isEmpty()) {
                        System.err.println("На данный момент список задач пуст.");
                    }
                    //System.out.println("Индекс");
                    String index = scan.nextLine().trim();
                    int foo = Integer.parseInt(index);
                    if (foo >= ToDoList.size()) {
                        System.err.println("Задачи с таким идентификатором не существует");
                    } else {
                        ToDoList.remove(foo); //Пока что индексы у уже сущ. задач не смещаются

                    }

                    break;

                case ("edit"):
                    if (ToDoList.isEmpty()) {
                        System.err.println("На данный момент список задач пуст.");
                    }
                    String newTask = scan.nextLine().trim();
                    String id = scan.nextLine().trim();
                    int changeIndex = Integer.parseInt(id);

                    if (changeIndex >= ToDoList.size()) {
                        System.err.println("Задачи с таким идентификатором не существует");
                    } else {
                        ToDo toDoList = ToDoList.get(changeIndex);
                        toDoList.setTask(newTask);
                    }

                    break;

                case ("search"):
                    if (ToDoList.isEmpty()) {
                        System.err.println("На данный момент список задач пуст.");
                    }

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
