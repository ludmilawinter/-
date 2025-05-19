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
    protected String stringMaterial; // Добавленное поле

    public StringInstrument(String brand, String material, int numberOfStrings, String stringMaterial) {
        super(brand, material);
        this.numberOfStrings = numberOfStrings;
        this.stringMaterial = stringMaterial;
    }

    public void pluckString() {
        System.out.println("Игрок тянет струну из материала: " + stringMaterial);
    }

    @Override
    public abstract void tune();
    @Override
    public abstract String getInstrumentType();
}

abstract class WindInstrument extends Instrument {
    protected String key;

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
    protected String percussionType;

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

// Низкий уровень: Конкретные инструменты
class Guitar extends StringInstrument {
    public Guitar(String brand, String material, int numberOfStrings, String stringMaterial) {
        super(brand, material, numberOfStrings, stringMaterial);
    }

    @Override
    public void tune() {
        System.out.println("Настраиваю гитару, натяжение струн из " + stringMaterial + ".");
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

public class Main {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Guitar("Fender", "Дерево", 6, "Нейлон");
        instruments[1] = new Flute("Yamaha", "Металл", "До");
        instruments[2] = new Drum("Yamaha", "Дерево", "Барабан");

        for (Instrument instrument : instruments) {
            instrument.play();
            instrument.tune();

            if (instrument instanceof StringInstrument) {
                ((StringInstrument) instrument).pluckString();
            } else if (instrument instanceof WindInstrument) {
                ((WindInstrument) instrument).blow();
            } else if (instrument instanceof PercussionInstrument) {
                ((PercussionInstrument) instrument).strike();
            }

            System.out.println();
        }
    }
}
