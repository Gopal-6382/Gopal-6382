// File: EnumExamples.java
package OOPS;

// 1️⃣ Enum declared outside class (Common use)
enum Direction {
    NORTH, EAST, SOUTH, WEST;
}

// 2️⃣ Enum declared inside class (Nested)
class StatusWrapper {
    enum Status {
        STARTED, IN_PROGRESS, COMPLETED, FAILED
    }
}

// 3️⃣ Enum with constructor, fields, and methods
enum GameLevel {
    LOW(1), MEDIUM(2), HIGH(3);

    private int levelCode;

    // Constructor
    GameLevel(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return levelCode;
    }
}

public class EnumExamples {
    public static void main(String[] args) {

        // ✅ Basic usage
        Direction dir = Direction.NORTH;
        System.out.println("Direction: " + dir);

        // ✅ Access nested enum
        StatusWrapper.Status s = StatusWrapper.Status.IN_PROGRESS;
        System.out.println("Status: " + s);

        // ✅ Enum with fields
        GameLevel level = GameLevel.MEDIUM;
        System.out.println("Game Level: " + level);
        System.out.println("Level Code: " + level.getLevelCode());

        // ✅ Switch-case with enum
        switch (level) {
            case LOW -> System.out.println("Easy level");
            case MEDIUM -> System.out.println("Medium level");
            case HIGH -> System.out.println("Hard level");
        }

        // ✅ Iterating over enums
        for (Direction d : Direction.values()) {
            System.out.println("Available Direction: " + d);
        }

        // ✅ Comparing enums
        if (level == GameLevel.HIGH) {
            System.out.println("You're at the highest level!");
        } else {
            System.out.println("Keep going!");
        }
    }
}
