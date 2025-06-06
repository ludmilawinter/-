// Верхний уровень: Абстрактный класс Instrument
abstract class Instrument {
    protected String brand;
    protected String material;

    public Instrument(String brand, String material) {
        this.brand = brand;
        this.material = material;
    }

    public void play() {
        System.out.println(getInstrumentType() + " играет.");
    }

    // Абстрактный метод, который реализуют подклассы
    public abstract void tune();

    // Абстрактный метод для получения типа инструмента
    public abstract String getInstrumentType();
}

// Средний уровень: Струнные, Духовые, Ударные — подклассы
abstract class StringInstrument extends Instrument {
    protected int numberOfStrings;

    public StringInstrument(String brand, String material, int numberOfStrings) {
        super(brand, material);
        this.numberOfStrings = numberOfStrings;
    }

    public void pluckString() {
        System.out.println("Игрок тянет струну.");
    }

    @Override
    public abstract void tune();
    @Override
    public abstract String getInstrumentType();
}

abstract class WindInstrument extends Instrument {
    protected String key; // например, "До", "Ре" и т.п.

    public WindInstrument(String brand, String material, String key) {
        super(brand, material);
        this.key = key;
    }

    public void blow() {
        System.out.println("Игрок дует в инструмент.");
    }

    @Override
    public abstract void tune();
    @Override
    public abstract String getInstrumentType();
}

abstract class PercussionInstrument extends Instrument {
    protected String percussionType; // например, "барабан", "каспий"

    public PercussionInstrument(String brand, String material, String percussionType) {
        super(brand, material);
        this.percussionType = percussionType;
    }

    public void strike() {
        System.out.println("Игрок ударяет по инструменту.");
    }

    @Override
    public abstract void tune();
    @Override
    public abstract String getInstrumentType();
}

// Низкий уровень: Конкретные инструменты, реализующие абстрактные методы
class Guitar extends StringInstrument {
    public Guitar(String brand, String material, int numberOfStrings) {
        super(brand, material, numberOfStrings);
    }

    @Override
    public void tune() {
        System.out.println("Настраиваю гитару, натяжение струн.");
    }

    @Override
    public String getInstrumentType() {
        return "Гитара";
    }
}

class Flute extends WindInstrument {
    public Flute(String brand, String material, String key) {
        super(brand, material, key);
    }

    @Override
    public void tune() {
        System.out.println("Настраиваю флейту, регулируя отверстия.");
    }

    @Override
    public String getInstrumentType() {
        return "Флейта";
    }
}

class Drum extends PercussionInstrument {
    public Drum(String brand, String material, String percussionType) {
        super(brand, material, percussionType);
    }

    @Override
    public void tune() {
        System.out.println("Настраиваю барабан, натяжением мембраны.");
    }

    @Override
    public String getInstrumentType() {
        return "Барабан";
    }
}

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Создаем объекты конкретных инструментов
        Guitar guitar = new Guitar("Fender", "Дерево", 6);
        Flute flute = new Flute("Yamaha", "Металл", "До");
        Drum drum = new Drum("Yamaha", "Дерево", "Барабан");

        // Используем методы
        guitar.play();

        guitar.tune();
        guitar.pluckString();
        System.out.println();

        flute.play();
        flute.tune();
        flute.blow();
        System.out.println();

        drum.play();
        drum.tune();
        drum.strike();
    }
}
