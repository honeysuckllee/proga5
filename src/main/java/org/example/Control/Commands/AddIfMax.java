package org.example.Control.Commands;

import org.example.Control.Command;
import org.example.Model.Coordinates;
import org.example.Model.Deque;
import org.example.Model.Location;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.Service.Utilites.*;

/**
 * Класс `AddIfMax` реализует команду добавления нового элемента `Route` в коллекцию `Deque`,
 * только если его `id` больше, чем текущий максимальный `id` в коллекции.
 */
public class AddIfMax implements Command {
    /**
     * Имя маршрута. Поле не может быть null, строка не может быть пустой.
     */
    private String name;
    /**
     * Координаты маршрута. Поле не может быть null.
     */
    private Coordinates coordinates;
    /**
     * Дата создания маршрута. Поле не может быть null, значение этого поля должно генерироваться автоматически.
     */
    private java.time.LocalDate creationDate;
    /**
     * Начальная локация маршрута. Поле может быть null.
     */
    private Location from;
    /**
     * Конечная локация маршрута. Поле может быть null.
     */
    private Location to;
    /**
     * Дистанция маршрута.
     */
    private Float distance;
    /**
     * Коллекция `Deque`, в которую добавляется маршрут.
     */
    private Deque deque;
    /**
     * Идентификатор маршрута.
     */
    private int id;
    /**
     * Объект `Scanner` для чтения ввода пользователя.
     */
    private Scanner scanner;

    /**
     * Конструктор класса `AddIfMax`.
     *
     * @param scanner Объект `Scanner` для чтения ввода пользователя.
     * @param deque   Коллекция `Deque`, в которую добавляется маршрут.
     * @param id      Идентификатор маршрута.
     */
    public AddIfMax(Scanner scanner, Deque deque, int id) {
        this.deque = deque;
        this.id = id;
        this.scanner = scanner;
    }

    /**
     * Выполняет команду добавления нового элемента `Route` в коллекцию, если его `id` больше максимального.
     * Запрашивает у пользователя данные для создания объекта `Route` и добавляет его в коллекцию `Deque`,
     * только если `id` больше, чем `maxId` в коллекции.
     */
    @Override
    public void execute() {
        if (id == 0){
            id = getValidInt(scanner, "Введите id:");
        }
        if (id > deque.getMaxId()){
            System.out.println("Ввод name");
            name = getValidName(scanner);
            System.out.println("Ввод Coordinates");
            coordinates = getValidCoordinates(scanner);
            creationDate = LocalDate.now();
            System.out.println("Ввод from:");
            from = getValidLocation(scanner);
            System.out.println("Ввод to:");
            to = getValidLocation(scanner);
            System.out.println("Ввод Distance");
            distance = getValidFloatDistance(scanner);
            deque.addRoute(id, name, coordinates, creationDate, from, to, distance);
        }
        else {
            System.out.println("Введенное значение меньше максимального id коллекции ");
        }
    }
}
